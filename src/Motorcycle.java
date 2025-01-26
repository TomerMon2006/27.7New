public class Motorcycle extends Vehicle {
    public Motorcycle(String name) {
        super(name);
    }

    @Override
    public int getFixTime() {
        return 3; // זמן תיקון לאופנוע
    }

    @Override
    public void fixed() {
        System.out.println("The motorcycle '" + getName() + "' has been fixed.");
    }
}
