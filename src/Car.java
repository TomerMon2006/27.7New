public class Car extends Vehicle {
    public Car(String name) {
        super(name);
    }

    @Override
    public int getFixTime() {
        return 5; // זמן תיקון לרכב
    }

    @Override
    public void fixed() {
        System.out.println("The car '" + getName() + "' has been fixed.");
    }
}
