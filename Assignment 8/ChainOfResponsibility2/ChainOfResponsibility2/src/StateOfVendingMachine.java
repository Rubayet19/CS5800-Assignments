public class StateOfVendingMachine {
    private String name;

    public StateOfVendingMachine(String name) {
        this.name = name;
    }

    public void doAction(VendingMachine vendingMachine) {
        System.out.println("Unknown state");
    }

    @Override
    public String toString() {
        return name;
    }
}