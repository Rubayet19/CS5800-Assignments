public class DoritosHandler extends SnackDispenseHandler {
    @Override
    public void handle(Snack snack) {
        if (snack.getName().equalsIgnoreCase("Doritos")) {
            System.out.println("Dispensing Doritos...");
        } else {
            super.handle(snack);
        }
    }
}
