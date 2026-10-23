package smarthome.model;

/*
 * Schedulable er et interface som lar en enhet planlegge en handling.
 * Dette er nyttig for enheter som kan utføre handlinger på bestemte tidspunkter, 
 * som for eksempel å slå seg av eller på automatisk. 
 */
public interface Schedulable {

    // Utfører en planlagt handling
    void performScheduledAction();
}
