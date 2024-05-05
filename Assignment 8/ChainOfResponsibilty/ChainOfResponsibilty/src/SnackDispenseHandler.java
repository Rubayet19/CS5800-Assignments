public abstract class SnackDispenseHandler {
    private SnackDispenseHandler nextHandler;

    public void setNextHandler(SnackDispenseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void dispense(Snack snack, int quantity, int amount) {
        if (canHandle(snack, quantity, amount)) {
            handle(snack, quantity, amount);
        } else if (nextHandler != null) {
            nextHandler.dispense(snack, quantity, amount);
        } else {
            System.out.println("Sorry, the selected snack is not available or the amount is insufficient.");
        }
    }

    protected abstract boolean canHandle(Snack snack, int quantity, int amount);

    protected abstract void handle(Snack snack, int quantity, int amount);

    public Snack handle(Snack selectedItem, double balance) {
        return selectedItem;
    }

}