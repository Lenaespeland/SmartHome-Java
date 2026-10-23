package test;

import smarthome.core.SmartHome;
import smarthome.model.Light;
import smarthome.model.Thermostat;

/**
 * Self-checking tests runnable with Java 21 and no external test framework.
 */
public class SmartHomeValidationTest {
    public static void main(String[] args) {
        testLightBrightness();
        testDeviceSwitching();
        testDeviceRegistration();
        testScheduledThermostat();
        System.out.println("All SmartHome validation tests passed.");
    }

    private static void testLightBrightness() {
        Light light = new Light("Desk", 50);
        light.setBrightness(100);
        check(light.getBrightness() == 100, "Brightness should update");
        expectInvalid(() -> light.setBrightness(-1));
        expectInvalid(() -> new Light("Invalid", 101));
    }

    private static void testDeviceSwitching() {
        SmartHome home = new SmartHome();
        Light light = new Light("Hallway", 40);
        home.registerDevice(light);
        home.turnOnDevice("hallway");
        check(light.isOn(), "Device should be on");
        home.turnOffAll();
        check(!light.isOn(), "All devices should be off");
    }

    private static void testDeviceRegistration() {
        SmartHome home = new SmartHome();
        home.registerDevice(new Light("Kitchen", 30));
        expectInvalid(() -> home.registerDevice(new Light("kitchen", 70)));
        expectInvalid(() -> home.registerDevice(null));
        check(home.findDevice(null) == null, "Null lookup should return null");
    }

    private static void testScheduledThermostat() {
        SmartHome home = new SmartHome();
        Thermostat thermostat = new Thermostat("Heating", 20.0);
        home.registerDevice(thermostat);
        home.runScheduledActions();
        check(thermostat.getTemperature() == 20.0, "Off thermostat should not change");
        thermostat.turnOn();
        home.runScheduledActions();
        check(thermostat.getTemperature() == 21.0, "Scheduled action should increase temperature");
        thermostat.setTemperature(35.0);
        home.runScheduledActions();
        check(thermostat.getTemperature() == 35.0, "Temperature should not exceed limit");
        expectInvalid(() -> thermostat.setTemperature(Double.NaN));
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void expectInvalid(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException expected) {
            return;
        }
        throw new AssertionError("Expected IllegalArgumentException");
    }
}
