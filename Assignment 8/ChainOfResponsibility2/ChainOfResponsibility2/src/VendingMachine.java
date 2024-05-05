import java.util.*;

public class VendingMachine {
    private StateOfVendingMachine state;
    private List<Snack> snacks;
    private double balance;

    public VendingMachine() {
        state = new IdleState();
        snacks = new ArrayList<>();
    }

    public void insertMoney(double amount) {
        if (state.toString() == State.WAITING_FOR_MONEY) {
            balance += amount;
            state.toString() = String.valueOf(State.IDLE);
        }
    }

    private enum State {
        IDLE,
        WAITING_FOR_MONEY,
        DISPENSING_SNACK
    }

    public boolean dispenseSnack(String snackName) {
        if (state == State.IDLE) {
            Snack snack = findSnack(snackName);
            if (snack != null && snack.getPrice() <= balance && snack.dispense()) {
                balance -= snack.getPrice();
                state = State.DISPENSING_SNACK;
                snackDispenseHandler.handle(snack);
                state = State.IDLE;
                return true;
            }
        }
        return false;
    }

    public void setState(StateOfVendingMachine state) {
        this.state = state;
    }

    public StateOfVendingMachine getState() {
        return state;
    }

    public void addSnack(Snack snack) {
        snacks.add(snack);
    }

    public List<Snack> getSnacks() {
        return snacks;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public Snack findSnack(String name) {
        for (Snack snack : snacks) {
            if (snack.getName().equals(name)) {
                return snack;
            }
        }
        return null;
    }
}