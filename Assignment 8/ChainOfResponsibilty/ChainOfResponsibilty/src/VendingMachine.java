import java.util.*;

public class VendingMachine {
private StateOfVendingMachine currentState;
private SnackDispenseHandler snackDispenser;
private Map<String, Snack> snacks;
private double balance;
private Snack selectedItem;

public VendingMachine() {
    currentState = new IdleState(this);
    snackDispenser = new SnackDispenseHandler();
    snacks = new HashMap<>();
    balance = 0.0;
}

public void setCurrentState(Object object) {
    this.currentState = object;
}

public StateOfVendingMachine getCurrentState() {
    return currentState;
}

public void setSnackDispenser(SnackDispenseHandler snackDispenser) {
    this.snackDispenser = snackDispenser;
}

public SnackDispenseHandler getSnackDispenser() {
    return snackDispenser;
}

public void addSnack(Snack snack) {
    snacks.put(snack.getName(), snack);
}

public Map<String, Snack> getSnacks() {
    return snacks;
}

public void addToBalance(double amount) {
    balance += amount;
}

public double getBalance() {
    return balance;
}

public Snack getSelectedItem() {
    return selectedItem;
}

public void setSelectedItem(Snack selectedItem) {
    this.selectedItem = selectedItem;
}

public void setWaitingForMoneyState() {
    currentState = new WaitingForMoneyState(this);
}

public void setWaitingForSelectionState() {
    currentState = new StateOfVendingMachine(this);
}

public void setDispensingState() {
    currentState = new DispensingState(this);
}

public StateOfVendingMachine getWaitingForMoneyState() {
    return currentState;
}

public StateOfVendingMachine getDispensingState() {
    return currentState;
}

}