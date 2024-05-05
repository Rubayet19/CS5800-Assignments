public class DispensingState implements StateOfVendingMachine {
    private final VendingMachine vendingMachine;

    public DispensingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String item) {
        System.out.println("Please wait, we're currently dispensing another item");
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Please wait, we're currently dispensing another item");
    }

    @Override
    public void dispenseSnack() {
        SnackDispenseHandler chain = new SnackDispenseHandler(vendingMachine.getSnacks());
        Snack snack = chain.handle(vendingMachine.getSelectedItem(), vendingMachine.getBalance());
        if (snack != null) {
            vendingMachine.addToBalance(vendingMachine.getBalance() - snack.getPrice());
            snack.setQuantity(snack.getQuantity() - 1);
            System.out.println("Dispensing " + snack.getName() + "...");
            if (vendingMachine.getBalance() > 0) {
                vendingMachine.setCurrentState(vendingMachine.getWaitingForMoneyState());
            } else {
                vendingMachine.setCurrentState(vendingMachine.getCurrentState());
            }
        } else {
            System.out.println("Sorry, the selected snack is unavailable or insufficient funds");
            vendingMachine.setCurrentState(vendingMachine.setWaitingForSelectionState());
        }
    }

    @Override
    public String toString() {
        return "Dispensing Snack";
    }
}