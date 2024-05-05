public class Driver {
    public static void main(String[] args) {
        // create vending machine
        VendingMachine vendingMachine = new VendingMachine();

        // create snacks
        Snack coke = new Snack("Coke", 1.5, 5);
        Snack pepsi = new Snack("Pepsi", 1.5, 3);
        Snack cheetos = new Snack("Cheetos", 2.0, 4);
        Snack doritos = new Snack("Doritos", 2.0, 2);
        Snack kitkat = new Snack("KitKat", 1.0, 3);
        Snack snickers = new Snack("Snickers", 1.0, 0);

        // add snacks to vending machine
        vendingMachine.addSnack(coke);
        vendingMachine.addSnack(pepsi);
        vendingMachine.addSnack(cheetos);
        vendingMachine.addSnack(doritos);
        vendingMachine.addSnack(kitkat);
        vendingMachine.addSnack(snickers);

        // set up chain of responsibility
        SnackDispenseHandler cokeHandler = new CokeHandler();
        SnackDispenseHandler pepsiHandler = new PepsiHandler();
        SnackDispenseHandler cheetosHandler = new CheetosHandler();
        SnackDispenseHandler doritosHandler = new DoritosHandler();
        SnackDispenseHandler kitkatHandler = new KitKatHandler();
        SnackDispenseHandler snickersHandler = new SnickersHandler();

        cokeHandler.setNextHandler(pepsiHandler);
        pepsiHandler.setNextHandler(cheetosHandler);
        cheetosHandler.setNextHandler(doritosHandler);
        doritosHandler.setNextHandler(kitkatHandler);
        kitkatHandler.setNextHandler(snickersHandler);

        // set up vending machine state
        vendingMachine.setState(new IdleState());

        // simulate user interactions
        vendingMachine.insertMoney(2.0);
        vendingMachine.findSnack("Coke");

        vendingMachine.insertMoney(1.0);
        vendingMachine.findSnack("Snickers");

        vendingMachine.insertMoney(1.0);
        vendingMachine.findSnack("Snickers");

        vendingMachine.insertMoney(2.5);
        vendingMachine.findSnack("Cheetos");

        vendingMachine.insertMoney(1.5);
        vendingMachine.findSnack("Doritos");

        vendingMachine.insertMoney(1.0);
        vendingMachine.findSnack("Kitkat");
    }
}
