public class IdleState extends StateOfVendingMachine {
    public IdleState() {
        super("Idle");
    }

    @Override
    public void doAction(VendingMachine vendingMachine) {
        System.out.println("Vending machine is idle");
    }
}