public class SnackDispenseHandler {
    private SnackDispenseHandler nextHandler;

    public void setNextHandler(SnackDispenseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(Snack snack) {
        if (nextHandler != null) {
            nextHandler.handle(snack);
        } else {
            System.out.println("Sorry, the selected snack is not available");
        }
    }
}