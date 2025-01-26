import java.util.Scanner;

public class Main implements ProtocolGarage {
    private DB db = new DB();

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Garage garage = new Garage(this);

        System.out.println("Welcome to the Garage!");
        System.out.println("Enter 1 for Motorcycle, 2 for Car, 3 for Truck.");
        System.out.println("Type exit to finish and start repairs.");

        while (true) {
            System.out.print("Enter vehicle type: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter vehicle name: ");
            String name = scanner.nextLine();

            Vehicle vehicle = null;

            switch (input) {
                case "1":
                    vehicle = new Motorcycle(name);
                    break;
                case "2":
                    vehicle = new Car(name);
                    break;
                case "3":
                    vehicle = new Truck(name);
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    continue;
            }

            db.addVehicle(vehicle);
            garage.addVehicle(vehicle);
        }

        System.out.println("Starting the repair cycle...");
        garage.startRepairCycle();
        scanner.close();
    }

    @Override
    public void fixed(Vehicle vehicle) {
        System.out.println("Protocol: The vehicle '" + vehicle.getName() + "' has been repaired.");
    }
}
