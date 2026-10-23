package test;

import smarthome.core.SmartHome;
import smarthome.model.Light;
import smarthome.model.Thermostat;
import smarthome.model.MotionSensor;

public class SmartHomeTask2Test {

    public static void main(String[] args) {

        SmartHome home = new SmartHome();

        // Registrer enheter
        home.registerDevice(new Light("Stue-lampe", 40));
        home.registerDevice(new Thermostat("Gang-termostat", 19.0));
        home.registerDevice(new MotionSensor("Inngangssensor"));

        System.out.println("Oversikt etter registrering:");
        home.showOverview();

        // Slå på enheter
        home.turnOnDevice("Stue-lampe");
        home.turnOnDevice("Gang-termostat");

        System.out.println("\nEtter å ha slått på to enheter:");
        home.showOverview();

        // Slå av én enhet
        home.turnOffDevice("Stue-lampe");

        System.out.println("\nEtter å ha slått av Stue-lampe:");
        home.showOverview();

        // Slå av alle
        home.turnOffAll();

        System.out.println("\nEtter å ha slått av alle:");
        home.showOverview();
    }
}
