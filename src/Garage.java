import java.util.LinkedList;
import java.util.Queue;

public class Garage {
    private Queue<Vehicle> vehicles = new LinkedList<>();
    private ProtocolGarage protocol;

    public Garage(ProtocolGarage protocol) {
        this.protocol = protocol;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void startRepairCycle() {
        while (!vehicles.isEmpty()) {
            Vehicle vehicle = vehicles.poll();
            try {
                Thread.sleep(vehicle.getFixTime() * 1000); // זמן תיקון לכל רכב
                vehicle.fixed();
                protocol.fixed(vehicle); // הודעה לפרוטוקול
            } catch (InterruptedException e) {
                System.out.println("Error during repair cycle: " + e.getMessage());
            }
        }
        System.out.println("All vehicles have been repaired.");
    }
}
