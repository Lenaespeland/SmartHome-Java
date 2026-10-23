package myphone;

import smarthome.app.SmartHomeApp;

/*
 * MyPhone representerer telefonen som kan kjøre SmartHomeApp.
 * Telefonen har ansvar for å starte appen og gi brukeren tilgang til den.
 */
public class MyPhone {

    private SmartHomeApp app; // appen som kjører på telefonen

    // Installerer appen på telefonen
    public void installApp(SmartHomeApp app) {
        this.app = app;
    }

    // Returnerer appen slik at brukeren kan bruke den
    public SmartHomeApp getApp() {
        return app;
    }
}
