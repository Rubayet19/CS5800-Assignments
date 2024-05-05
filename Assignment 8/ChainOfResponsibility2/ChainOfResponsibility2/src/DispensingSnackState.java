public class DispensingSnackState extends StateOfVendingMachine {
    public DispensingSnackState() {
        super("Dispensing snack");
    }

    @Override
    public void doAction(VendingMachine vendingMachine) {
        System.out.println("Dispensing snack");
    }
}