package smarthome.model;

/**
 * A smart light with brightness between 0 and 100.
 */
public class Light extends SmartDevice {
    private int brightness;

    public Light(String name, int brightness) {
        super(name);
        setBrightness(brightness);
    }

    public void setBrightness(int level) {
        if (level < 0 || level > 100) {
            throw new IllegalArgumentException("Brightness must be between 0 and 100");
        }
        this.brightness = level;
    }

    public int getBrightness() {
        return brightness;
    }

    @Override
    public String toString() {
        return "Light: " + getName()
                + " | On: " + isOn()
                + " | Brightness: " + brightness;
    }
}
