public class SnickersHandler extends SnackDispenseHandler {
    @Override
    public void handle(Snack snack) {
        if (snack.getName().equalsIgnoreCase("Snickers")) {
            if (snack.getQuantity() > 0) {
                System.out.println("Dispensing Snickers...");
                snack.setQuantity(snack.getQuantity() - 1);
            } else {
                System.out.println("Sorry, Snickers is out of stock.");
            }
        } else {
            super.handle(snack);
        }
    }
}