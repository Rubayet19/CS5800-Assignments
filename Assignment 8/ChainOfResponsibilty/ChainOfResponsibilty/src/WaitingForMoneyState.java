public class WaitingForMoneyState implements StateOfVendingMachine {
    private final VendingMachine vendingMachine;

    public WaitingForMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String item) {
        System.out.println("Please insert money first");
    }

    @Override
    public void insertMoney(double amount) {
        vendingMachine.addToBalance(amount);
        vendingMachine.setCurrentState(vendingMachine.getDispensingState());
    }

    @Override
    public void dispenseSnack() {
        System.out.println("Please insert money first");
    }

    @Override
    public String toString() {
        return "Waiting for Money";
    }
}
