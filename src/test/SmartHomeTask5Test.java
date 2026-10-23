package test;

import myphone.MyPhone;
import smarthome.app.SmartHomeApp;
import smarthome.core.SmartHome;
import smarthome.model.Light;
import smarthome.model.Thermostat;
import smarthome.model.MotionSensor;

/*
 * Testklasse for Oppgave 5.
 * Demonstrerer morgenrutinen via MyPhone og SmartHomeApp.
 */
public class SmartHomeTask5Test {

    public static void main(String[] args) {

        // Opprett smarthuset
        SmartHome home = new SmartHome();

        // Opprett enheter
        Light l1 = new Light("Stue-lampe", 40);
        Light l2 = new Light("Kjøkken-lampe", 70);
        Thermostat t1 = new Thermostat("Gang-termostat", 19.0);
        MotionSensor m1 = new MotionSensor("Inngangssensor");

        // Registrer enhetene
        home.registerDevice(l1);
        home.registerDevice(l2);
        home.registerDevice(t1);
        home.registerDevice(m1);

        // Opprett telefonen og installer appen
        MyPhone phone = new MyPhone();
        SmartHomeApp app = new SmartHomeApp(home);
        phone.installApp(app);

        // Kjør morgenrutinen via telefonen
        phone.getApp().morningRoutine();
    }
}
