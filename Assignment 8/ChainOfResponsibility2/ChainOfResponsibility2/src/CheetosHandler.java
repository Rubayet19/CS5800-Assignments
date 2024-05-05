public class CheetosHandler extends SnackDispenseHandler {
    @Override
    public void handle(Snack snack) {
        if (snack.getName().equalsIgnoreCase("Cheetos")) {
            System.out.println("Dispensing Cheetos...");
        } else {
            super.handle(snack);
        }
    }
}