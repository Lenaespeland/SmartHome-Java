package smarthome.model;

/**
 * SmartDevice er en abstrakt superklasse som inneholder
 * felles tilstand og oppførsel for alle smarte enheter.
 * Den kan ikke opprettes direkte.
 */
public abstract class SmartDevice {

    // Felles tilstand for alle enheter
    private final String name;
    private boolean isOn;

    
     // Konstruktør som setter navn og startstatus.
    public SmartDevice(String name) {
        this.name = name;
        this.isOn = false; // Enheter starter som av
    }


     // Slår enheten på.
     
    public void turnOn() {
        isOn = true;
    }

    
     // Slår enheten av.
    public void turnOff() {
        isOn = false;
    }

    
     // Henter navnet på enheten. 
    public String getName() {
        return name;
    }

    
     // Sjekker om enheten er på. 
    public boolean isOn() {
        return isOn;
    }

    /**
     * toString skal overstyres i subklassene,
     * fordi hver enhetstype viser sin egen status.
     */
    @Override
    public abstract String toString();
}
