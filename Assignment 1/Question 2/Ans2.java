class Ship {
    private String name;
    private String yearBuilt;

    public Ship(String name, String yearBuilt) {
        this.name = name;
        this.yearBuilt = yearBuilt;
    }

    // Accessors (getters) and mutators (setters)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(String yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public void print() {
        System.out.println("Ship Name: " + name + ", Year Built: " + yearBuilt);
    }
}

class CruiseShip extends Ship {
    private int maxPassengers;

    public CruiseShip(String name, int maxPassengers) {
        super(name, null); // Year built is not displayed for CruiseShip, hence not stored
        this.maxPassengers = maxPassengers;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public void print() {
        System.out.println("Cruise Ship Name: " + getName() + ", Maximum Passengers: " + maxPassengers);
    }
}

class CargoShip extends Ship {
    private int cargoCapacity;

    public CargoShip(String name, int cargoCapacity) {
        super(name, null); // Year built is not displayed for CargoShip, hence not stored
        this.cargoCapacity = cargoCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public void print() {
        System.out.println("Cargo Ship Name: " + getName() + ", Cargo Capacity: " + cargoCapacity + " tonnage");
    }
}

public class Ans2 {
    public static void main(String[] args) {
        Ship[] ships = new Ship[3];
        
        // Initialize the array with one type each of Ship, CruiseShip, and CargoShip
        ships[0] = new Ship("Lusitania", "1906");
        ships[1] = new CruiseShip("Harmony of the Seas", 6780);
        ships[2] = new CargoShip("Emma Maersk", 156907);

        // Loop through the array and call the print method for each ship
        for (Ship ship : ships) {
            ship.print();
        }
    }
}


