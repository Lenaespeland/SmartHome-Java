package smarthome.model;

/*
 * MotionSensor er en smart enhet som registrerer bevegelse.
 * Den arver felles funksjonalitet fra SmartDevice.
 */
public class MotionSensor extends SmartDevice {

    private boolean motionDetected; // true hvis bevegelse er registrert

    public MotionSensor(String name) {
        super(name);
        motionDetected = false;
    }

    // Setter status for bevegelse
    public void setMotionDetected(boolean detected) {
        motionDetected = detected;
    }

    // Returnerer om bevegelse er registrert
    public boolean isMotionDetected() {
        return motionDetected;
    }


     // Overstyrer toString for å vise sensorens status.     
    @Override
    public String toString() {
        return "MotionSensor: " + getName() +
               " | On: " + isOn() +
               " | Motion detected: " + motionDetected;
    }
}
