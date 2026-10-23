package test;

import myphone.MyPhone;
import smarthome.app.SmartHomeApp;
import smarthome.core.SmartHome;
import smarthome.model.Light;
import smarthome.model.Thermostat;
import smarthome.model.MotionSensor;

/*
 * Testklasse for Oppgave 4.
 * Viser hvordan MyPhone bruker SmartHomeApp til å styre smarthuset.
 */
public class SmartHomeTask4Test {

    public static void main(String[] args) {

        // Opprett smarthuset
        SmartHome home = new SmartHome();

        // Opprett enheter
        Light l1 = new Light("Stue-lampe", 40);
        Thermostat t1 = new Thermostat("Gang-termostat", 19.0);
        MotionSensor m1 = new MotionSensor("Inngangssensor");

        // Registrer enhetene
        home.registerDevice(l1);
        home.registerDevice(t1);
        home.registerDevice(m1);

        // Opprett telefonen
        MyPhone phone = new MyPhone();

        // Installer appen på telefonen
        SmartHomeApp app = new SmartHomeApp(home);
        phone.installApp(app);

        System.out.println("Oversikt via appen:");
        phone.getApp().showHomeOverview();

        // Slå på en enhet via appen
        phone.getApp().turnOn("Stue-lampe");

        System.out.println("\nEtter å ha slått på Stue-lampe via appen:");
        phone.getApp().showHomeOverview();

        // Velg en enhet via appen
        System.out.println("\nVelger en enhet via appen:");
        System.out.println(phone.getApp().selectDevice("Gang-termostat"));
    }
}
