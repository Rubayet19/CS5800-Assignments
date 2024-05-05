public class CokeHandler extends SnackDispenseHandler {
    @Override
    public void handle(Snack snack) {
        if (snack.getName().equalsIgnoreCase("Coke")) {
            System.out.println("Dispensing Coke...");
        } else {
            super.handle(snack);
        }
    }
}