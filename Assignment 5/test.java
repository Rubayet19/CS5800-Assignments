// Test.java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class test {
    private static int testCount = 0;
    private static int passedCount = 0;

    @BeforeAll
    public static void setUp() {
        System.out.println("Starting tests...");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("Tests completed.");
        System.out.println("Total tests: " + testCount);
        System.out.println("Passed tests: " + passedCount);
    }

    @Test
    public void testBurgerCost() {
        testCount++;
        FoodItem burger = new Burger();
        Assertions.assertEquals(5.0, burger.getCost());
        System.out.println("Test testBurgerCost passed.");
        passedCount++;
    }

    @Test
    public void testFriesCost() {
        testCount++;
        FoodItem fries = new Fries();
        Assertions.assertEquals(2.5, fries.getCost());
        System.out.println("Test testFriesCost passed.");
        passedCount++;
    }

    @Test
    public void testDrinkCost() {
        testCount++;
        FoodItem drink = new Drink();
        Assertions.assertEquals(1.5, drink.getCost());
        System.out.println("Test testDrinkCost passed.");
        passedCount++;
    }

    @Test
    public void testCheeseDecorator() {
        testCount++;
        FoodItem burger = new Burger();
        FoodItem cheeseburger = new Cheese(burger);
        Assertions.assertEquals("Burger, Cheese", cheeseburger.getDescription());
        Assertions.assertEquals(5.5, cheeseburger.getCost());
        System.out.println("Test testCheeseDecorator passed.");
        passedCount++;
    }

    @Test
    public void testBaconDecorator() {
        testCount++;
        FoodItem burger = new Burger();
        FoodItem baconBurger = new Bacon(burger);
        Assertions.assertEquals("Burger, Bacon", baconBurger.getDescription());
        Assertions.assertEquals(6.0, baconBurger.getCost());
        System.out.println("Test testBaconDecorator passed.");
        passedCount++;
    }

    @Test
    public void testOrderTotalCost() {
        testCount++;
        FoodItem burger = new Burger();
        FoodItem fries = new Fries();
        FoodItem drink = new Drink();

        Order order = new Order();
        order.addItem(burger);
        order.addItem(fries);
        order.addItem(drink);

        Assertions.assertEquals(9.0, order.getTotalCost());
        System.out.println("Test testOrderTotalCost passed.");
        passedCount++;
    }

    @Test
    public void testLoyaltyDiscount() {
        testCount++;
        LoyaltyDiscount loyaltyDiscount = new LoyaltyDiscount(0.1);
        double totalCost = 100.0;
        double discountedCost = loyaltyDiscount.applyDiscount(totalCost);
        Assertions.assertEquals(90.0, discountedCost);
        System.out.println("Test testLoyaltyDiscount passed.");
        passedCount++;
    }
}