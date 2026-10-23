package smarthome.model;

/**
 * A thermostat that supports a simple scheduled temperature adjustment.
 */
public class Thermostat extends SmartDevice implements Schedulable {
    private double temperature;

    public Thermostat(String name, double temperature) {
        super(name);
        setTemperature(temperature);
    }

    public void setTemperature(double value) {
        if (!Double.isFinite(value) || value < 5.0 || value > 35.0) {
            throw new IllegalArgumentException("Temperature must be between 5 and 35 degrees Celsius");
        }
        this.temperature = value;
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public void performScheduledAction() {
        if (isOn() && temperature < 35.0) {
            setTemperature(Math.min(35.0, temperature + 1.0));
        }
    }

    @Override
    public String toString() {
        return "Thermostat: " + getName()
                + " | On: " + isOn()
                + " | Temperature: " + temperature;
    }
}
