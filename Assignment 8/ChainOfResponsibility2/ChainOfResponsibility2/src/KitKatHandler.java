public class KitKatHandler extends SnackDispenseHandler {
    @Override
    public void handle(Snack snack) {
        if (snack.getName().equalsIgnoreCase("KitKat")) {
            System.out.println("Dispensing KitKat...");
        } else {
            super.handle(snack);
        }
    }
}