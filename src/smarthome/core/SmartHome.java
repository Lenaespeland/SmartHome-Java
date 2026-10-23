package smarthome.core;

import java.util.ArrayList;
import java.util.List;

import smarthome.model.Schedulable;
import smarthome.model.SmartDevice;

/*
 * SmartHome representerer selve smarthuset.
 * Klassen har ansvar for å holde oversikt over alle registrerte enheter
 * og koordinere handlinger på tvers av dem.
 * Enhetene beholder sin egen oppførsel og tilstand.
 */
public class SmartHome {

    // Samling av alle enheter i hjemmet
    private final List<SmartDevice> devices;

    // Oppretter et tomt hjem
    public SmartHome() {
        devices = new ArrayList<>();
    }

    // Registrerer en ny enhet i hjemmet
    public void registerDevice(SmartDevice device) {
        if (device == null) {
            throw new IllegalArgumentException("Device cannot be null");
        }
        if (device.getName() == null || device.getName().isBlank()) {
            throw new IllegalArgumentException("Device name cannot be blank");
        }
        if (findDevice(device.getName()) != null) {
            throw new IllegalArgumentException("A device with this name is already registered");
        }
        devices.add(device);
    }

    /*
     * Viser en samlet oversikt over alle enheter.
     * Hjemmet ber hver enhet om sin egen status,
     * i stedet for å bygge utskriften selv.
     */
    public void showOverview() {
        for (SmartDevice device : devices) {
            System.out.println(device);
        }
    }

    /*
     * Søker etter en enhet basert på navn.
     * Returnerer enheten hvis den finnes, ellers null.
     * Enkel og tydelig håndtering på nivå med OBJ2000.
     */
    public SmartDevice findDevice(String name) {
        if (name == null || name.isBlank()) {
            return null;
        }
        for (SmartDevice device : devices) {
            if (device.getName().equalsIgnoreCase(name)) {
                return device;
            }
        }
        return null;
    }

    // Slår på en valgt enhet hvis den finnes
    public void turnOnDevice(String name) {
        SmartDevice device = findDevice(name);

        if (device != null) {
            device.turnOn();
        } else {
            System.out.println("Device not found: " + name);
        }
    }

    // Slår av en valgt enhet hvis den finnes
    public void turnOffDevice(String name) {
        SmartDevice device = findDevice(name);

        if (device != null) {
            device.turnOff();
        } else {
            System.out.println("Device not found: " + name);
        }
    }

    /*
     * Slår av alle enheter i hjemmet.
     * Hjemmet koordinerer handlingen, men enhetene utfører den selv.
     */
    public void turnOffAll() {
        for (SmartDevice device : devices) {
            device.turnOff();
        }
    }

    /*
     * Utfører planlagte handlinger for alle enheter som støtter Schedulable.
     */
    public void runScheduledActions() {
        for (SmartDevice device : devices) {
            if (device instanceof Schedulable) {
                Schedulable schedulable = (Schedulable) device;
                schedulable.performScheduledAction();
            }
        }
    }
}
