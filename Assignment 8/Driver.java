import java.util.HashMap;
import java.util.Map;

// Class to represent each snack item
class Snack {
    private String name;
    private double price;
    private int quantity;

    public Snack(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

// State interface representing different states of the vending machine
interface State {
    void selectSnack(VendingMachine vendingMachine, String snackName);

    void insertMoney(VendingMachine vendingMachine, double amount);

    void dispenseSnack(VendingMachine vendingMachine);
}

// Idle state when the machine is waiting for user input
class IdleState implements State {
    public void selectSnack(VendingMachine vendingMachine, String snackName) {
        Snack selected = vendingMachine.getSnack(snackName);
        if (selected != null) {
            vendingMachine.setSelectedSnack(selected);
            vendingMachine.setCurrentState(new WaitingForMoneyState());
            System.out.printf("Snack %s selected. Insert $%.2f%n", snackName, selected.getPrice());
        } else {
            System.out.printf("Snack %s is not available.%n", snackName);
        }
    }

    public void insertMoney(VendingMachine vendingMachine, double amount) {
        System.out.println("Please select a snack first.");
    }

    public void dispenseSnack(VendingMachine vendingMachine) {
        System.out.println("Please select a snack first.");
    }
}

// State where the machine waits for money insertion
class WaitingForMoneyState implements State {
    public void selectSnack(VendingMachine vendingMachine, String snackName) {
        System.out.println("Snack already selected. Please insert money.");
    }

    public void insertMoney(VendingMachine vendingMachine, double amount) {
        vendingMachine.addMoney(amount);
        Snack selected = vendingMachine.getSelectedSnack();
        if (vendingMachine.getMoneyInserted() >= selected.getPrice()) {
            vendingMachine.setCurrentState(new DispensingState());
            vendingMachine.dispenseSnack();
        } else {
            double remaining = selected.getPrice() - vendingMachine.getMoneyInserted();
            System.out.printf("Additional $%.2f required.%n", remaining);
        }
    }

    public void dispenseSnack(VendingMachine vendingMachine) {
        System.out.println("Not enough money. Insert more to continue.");
    }
}

// State where the machine is dispensing the snack
class DispensingState implements State {
    public void selectSnack(VendingMachine vendingMachine, String snackName) {
        System.out.println("Currently dispensing a snack. Please wait.");
    }

    public void insertMoney(VendingMachine vendingMachine, double amount) {
        System.out.println("Currently dispensing a snack. Please wait.");
    }

    public void dispenseSnack(VendingMachine vendingMachine) {
        Snack selected = vendingMachine.getSelectedSnack();
        if (selected.getQuantity() > 0) {
            selected.setQuantity(selected.getQuantity() - 1);
            vendingMachine.setMoneyInserted(0);
            vendingMachine.setCurrentState(new IdleState());
            System.out.printf("Dispensing %s. Enjoy your snack!%n", selected.getName());
            if (selected.getQuantity() == 0) {
                System.out.printf("%s is out of stock!%n", selected.getName());
            }
        } else {
            System.out.printf("%s is out of stock!%n", selected.getName());
            vendingMachine.setMoneyInserted(0);
            vendingMachine.setCurrentState(new IdleState());
        }
    }
}

// Abstract handler for the chain of responsibility
abstract class SnackDispenseHandler {
    protected SnackDispenseHandler nextHandler;

    public void setNextHandler(SnackDispenseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void dispenseSnack(String snackName, VendingMachine vendingMachine);
}

// Specific handler for Coke
class CokeHandler extends SnackDispenseHandler {
    public void dispenseSnack(String snackName, VendingMachine vendingMachine) {
        if ("Coke".equalsIgnoreCase(snackName)) {
            vendingMachine.dispenseSnack();
        } else if (nextHandler != null) {
            nextHandler.dispenseSnack(snackName, vendingMachine);
        } else {
            System.out.printf("Snack %s not available in this machine.%n", snackName);
        }
    }
}

// Specific handler for Pepsi
class PepsiHandler extends SnackDispenseHandler {
    public void dispenseSnack(String snackName, VendingMachine vendingMachine) {
        if ("Pepsi".equalsIgnoreCase(snackName)) {
            vendingMachine.dispenseSnack();
        } else if (nextHandler != null) {
            nextHandler.dispenseSnack(snackName, vendingMachine);
        } else {
            System.out.printf("Snack %s not available in this machine.%n", snackName);
        }
    }
}

// Specific handler for Cheetos
class CheetosHandler extends SnackDispenseHandler {
    public void dispenseSnack(String snackName, VendingMachine vendingMachine) {
        if ("Cheetos".equalsIgnoreCase(snackName)) {
            vendingMachine.dispenseSnack();
        } else if (nextHandler != null) {
            nextHandler.dispenseSnack(snackName, vendingMachine);
        } else {
            System.out.printf("Snack %s not available in this machine.%n", snackName);
        }
    }
}

// Specific handler for Doritos
class DoritosHandler extends SnackDispenseHandler {
    public void dispenseSnack(String snackName, VendingMachine vendingMachine) {
        if ("Doritos".equalsIgnoreCase(snackName)) {
            vendingMachine.dispenseSnack();
        } else if (nextHandler != null) {
            nextHandler.dispenseSnack(snackName, vendingMachine);
        } else {
            System.out.printf("Snack %s not available in this machine.%n", snackName);
        }
    }
}

// Specific handler for KitKat
class KitKatHandler extends SnackDispenseHandler {
    public void dispenseSnack(String snackName, VendingMachine vendingMachine) {
        if ("KitKat".equalsIgnoreCase(snackName)) {
            vendingMachine.dispenseSnack();
        } else if (nextHandler != null) {
            nextHandler.dispenseSnack(snackName, vendingMachine);
        } else {
            System.out.printf("Snack %s not available in this machine.%n", snackName);
        }
    }
}

// Specific handler for Snickers
class SnickersHandler extends SnackDispenseHandler {
    public void dispenseSnack(String snackName, VendingMachine vendingMachine) {
        if ("Snickers".equalsIgnoreCase(snackName)) {
            vendingMachine.dispenseSnack();
        } else if (nextHandler != null) {
            nextHandler.dispenseSnack(snackName, vendingMachine);
        } else {
            System.out.printf("Snack %s not available in this machine.%n", snackName);
        }
    }
}

// VendingMachine class
class VendingMachine {
    private Map<String, Snack> snacks;
    private State currentState;
    private Snack selectedSnack;
    private double moneyInserted;

    // Chain of responsibility handlers
    private SnackDispenseHandler firstHandler;

    public VendingMachine() {
        snacks = new HashMap<>();
        currentState = new IdleState();
        selectedSnack = null;
        moneyInserted = 0;

        // Set up handlers in the requested order: Coke -> Pepsi -> Cheetos -> Doritos -> KitKat -> Snickers
        CokeHandler cokeHandler = new CokeHandler();
        PepsiHandler pepsiHandler = new PepsiHandler();
        CheetosHandler cheetosHandler = new CheetosHandler();
        DoritosHandler doritosHandler = new DoritosHandler();
        KitKatHandler kitKatHandler = new KitKatHandler();
        SnickersHandler snickersHandler = new SnickersHandler();

        cokeHandler.setNextHandler(pepsiHandler);
        pepsiHandler.setNextHandler(cheetosHandler);
        cheetosHandler.setNextHandler(doritosHandler);
        doritosHandler.setNextHandler(kitKatHandler);
        kitKatHandler.setNextHandler(snickersHandler);

        firstHandler = cokeHandler;
    }

    // Add snacks to the vending machine
    public void addSnack(Snack snack) {
        snacks.put(snack.getName(), snack);
    }

    public Snack getSnack(String name) {
        return snacks.get(name);
    }

    public void setCurrentState(State state) {
        currentState = state;
    }

    public void setSelectedSnack(Snack snack) {
        selectedSnack = snack;
    }

    public Snack getSelectedSnack() {
        return selectedSnack;
    }

    public double getMoneyInserted() {
        return moneyInserted;
    }

    public void setMoneyInserted(double money) {
        moneyInserted = money;
    }

    public void addMoney(double amount) {
        moneyInserted += amount;
    }

    // Delegate state behavior to the current state object
    public void selectSnack(String snackName) {
        currentState.selectSnack(this, snackName);
    }

    public void insertMoney(double amount) {
        currentState.insertMoney(this, amount);
    }

    public void dispenseSnack() {
        currentState.dispenseSnack(this);
    }

    // Process snack request via the chain of handlers
    public void handleSnackRequest(String snackName) {
        firstHandler.dispenseSnack(snackName, this);
    }
}

// Driver program
public class Driver {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        // Initialize snacks
        vendingMachine.addSnack(new Snack("Coke", 1.50, 5));
        vendingMachine.addSnack(new Snack("Pepsi", 1.40, 5));
        vendingMachine.addSnack(new Snack("Cheetos", 1.00, 5));
        vendingMachine.addSnack(new Snack("Doritos", 1.00, 5));
        vendingMachine.addSnack(new Snack("KitKat", 1.20, 5));
        vendingMachine.addSnack(new Snack("Snickers", 1.30, 1));

        // Dispense snacks in the specified order
        String[] snacksInOrder = {"Coke", "Pepsi", "Cheetos", "Doritos", "KitKat", "Snickers"};
        double[] moneyInserted = {1.50, 1.40, 1.00, 1.00, 1.20, 1.30};

        for (int i = 0; i < snacksInOrder.length; i++) {
            String snackName = snacksInOrder[i];
            double amount = moneyInserted[i];

            // Select the snack
            vendingMachine.selectSnack(snackName);

            // Insert the correct amount of money
            vendingMachine.insertMoney(amount);

            // Request to dispense the snack
            vendingMachine.handleSnackRequest(snackName);
        }

        // Try to dispense Snickers again to show that it's out of stock
        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(1.30);
        vendingMachine.handleSnackRequest("Snickers");
    }
}

