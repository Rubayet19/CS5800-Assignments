public class PepsiHandler extends SnackDispenseHandler {
    @Override
    public void handle(Snack snack) {
        if (snack.getName().equalsIgnoreCase("Pepsi")) {
            System.out.println("Dispensing Pepsi...");
        } else {
            super.handle(snack);
        }
    }
}