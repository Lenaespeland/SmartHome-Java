package smarthome.app;

import smarthome.core.SmartHome;
import smarthome.model.SmartDevice;

/*
 * SmartHomeApp representerer appen som kjører på MyPhone.
 * Appen kommuniserer med SmartHome og lar brukeren styre enheter.
 */
public class SmartHomeApp {

    private final SmartHome home; // referanse til smarthuset

    // Appen må få et SmartHome å styre
    public SmartHomeApp(SmartHome home) {
        this.home = home;
    }

    // Viser oversikt over alle enheter
    public void showHomeOverview() {
        home.showOverview();
    }

    // Slår på en valgt enhet
    public void turnOn(String deviceName) {
        home.turnOnDevice(deviceName);
    }

    // Slår av en valgt enhet
    public void turnOff(String deviceName) {
        home.turnOffDevice(deviceName);
    }

    /*
     * Velger en enhet basert på navn.
     * Returnerer enheten hvis den finnes, ellers null.
     */
    public SmartDevice selectDevice(String name) {
        return home.findDevice(name);
    }

/*
 * Utfører en enkel morgenrutine:
 * Slår på lys, øker temperaturen og viser status.
 */
public void morningRoutine() {

    System.out.println("Starter morgenrutine...");

    // Slå på lys
    home.turnOnDevice("Stue-lampe");
    home.turnOnDevice("Kjøkken-lampe");

    // Øk temperaturen (Thermostat implementerer Schedulable)
    home.runScheduledActions();

    // Vis status etter rutinen
    System.out.println("Status etter morgenrutine:");
    home.showOverview();
  }

}
