package test;

import smarthome.model.Light;
import smarthome.model.Thermostat;
import smarthome.model.MotionSensor;

public class SmartHomeTask1Test {

    public static void main(String[] args) {

        // Opprett enheter
        Light l = new Light("Test-lampe", 50);
        Thermostat t = new Thermostat("Test-termostat", 20.0);
        MotionSensor m = new MotionSensor("Test-sensor");

        System.out.println("Startstatus:");
        System.out.println(l);
        System.out.println(t);
        System.out.println(m);

        // Slå på enheter
        l.turnOn();
        t.turnOn();
        m.turnOn();

        // Endre spesifikke verdier
        l.setBrightness(80);
        t.setTemperature(22.5);
        m.setMotionDetected(true);

        System.out.println("\nEtter endringer:");
        System.out.println(l);
        System.out.println(t);
        System.out.println(m);

        // Polymorfisme-test
        System.out.println("\nPolymorfisme-test:");
        System.out.println(((Object) l).toString());
        System.out.println(((Object) t).toString());
        System.out.println(((Object) m).toString());
    }
}
