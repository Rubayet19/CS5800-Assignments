public class WaitingForMoneyState extends StateOfVendingMachine {
    public WaitingForMoneyState() {
        super("Waiting for money");
    }

    @Override
    public void doAction(VendingMachine vendingMachine) {
        System.out.println("Insert money to buy snacks");
    }
}