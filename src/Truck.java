public class Truck extends Vehicle {
    public Truck(String name) {
        super(name);
    }

    @Override
    public int getFixTime() {
        return 10; // זמן תיקון למשאית
    }

    @Override
    public void fixed() {
        System.out.println("The truck '" + getName() + "' has been fixed.");
    }
}
