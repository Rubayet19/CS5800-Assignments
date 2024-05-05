public class IdleState implements StateOfVendingMachine {
    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void insertMoney(double amount) {
        vendingMachine.setCurrentState(new WaitingForMoneyState(vendingMachine));
        System.out.println("Money inserted: " + amount);
    }

    public void selectSnack(String snackName) {
        System.out.println("Please insert money first");
    }

    public void dispenseSnack() {
        System.out.println("Please select a snack first");
    }

    public void ejectMoney() {
        System.out.println("No money to eject");
    }
}
