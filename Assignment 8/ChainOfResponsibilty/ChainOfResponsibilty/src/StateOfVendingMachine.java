public interface StateOfVendingMachine {
    void insertMoney(double amount);
    void selectSnack(String snackName);
    void dispenseSnack();
    //void ejectMoney();
}
