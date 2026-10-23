package test;

import smarthome.core.SmartHome;
import smarthome.model.Light;
import smarthome.model.MotionSensor;
import smarthome.model.Thermostat;

public class SmartHomeTask3Test {

    public static void main(String[] args) {

        SmartHome home = new SmartHome();

        // Registrer enheter
        home.registerDevice(new Light("Stue-lampe", 40));
        home.registerDevice(new Thermostat("Gang-termostat", 19.0));
        home.registerDevice(new MotionSensor("Inngangssensor"));

        System.out.println("Startstatus:");
        home.showOverview();

        // Registrer bevegelse
        MotionSensor sensor = (MotionSensor) home.findDevice("Inngangssensor");
        sensor.setMotionDetected(true);

        System.out.println("\nEtter bevegelse:");
        home.showOverview();

        // Kjør planlagte handlinger
        home.runScheduledActions();

        System.out.println("\nEtter planlagte handlinger:");
        home.showOverview();
    }
}
