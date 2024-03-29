import java.util.ArrayList;
import java.util.List;
// Decorator.java
interface FoodItem {
    String getDescription();
    double getCost();
}

class Burger implements FoodItem {
    @Override
    public String getDescription() {
        return "Burger";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}

class Fries implements FoodItem {
    @Override
    public String getDescription() {
        return "Fries";
    }

    @Override
    public double getCost() {
        return 2.5;
    }
}

class Drink implements FoodItem {
    @Override
    public String getDescription() {
        return "Drink";
    }

    @Override
    public double getCost() {
        return 1.5;
    }
}

abstract class ToppingDecorator implements FoodItem {
    protected FoodItem foodItem;

    public ToppingDecorator(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription();
    }

    @Override
    public double getCost() {
        return foodItem.getCost();
    }
}

class Cheese extends ToppingDecorator {
    public Cheese(FoodItem foodItem) {
        super(foodItem);
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return foodItem.getCost() + 0.5;
    }
}

class Bacon extends ToppingDecorator {
    public Bacon(FoodItem foodItem) {
        super(foodItem);
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + ", Bacon";
    }

    @Override
    public double getCost() {
        return foodItem.getCost() + 1.0;
    }
}

class Order {
    private List<FoodItem> items = new ArrayList<>();

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (FoodItem item : items) {
            totalCost += item.getCost();
        }
        return totalCost;
    }

    public void printOrder() {
        for (FoodItem item : items) {
            System.out.println(item.getDescription() + " - $" + item.getCost());
        }
        System.out.println("Total Cost: $" + getTotalCost());
    }
}

class LoyaltyDiscount {
    private double discountPercentage;

    public LoyaltyDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double applyDiscount(double totalCost) {
        return totalCost - (totalCost * discountPercentage);
    }
}

public class Decorator {
    public static void main(String[] args) {
        FoodItem burger = new Burger();
        FoodItem fries = new Fries();
        FoodItem drink = new Drink();

        burger = new Cheese(burger);
        burger = new Bacon(burger);

        Order order = new Order();
        order.addItem(burger);
        order.addItem(fries);
        order.addItem(drink);

        System.out.println("Order Details:");
        order.printOrder();

        LoyaltyDiscount loyaltyDiscount = new LoyaltyDiscount(0.1);
        double discountedTotal = loyaltyDiscount.applyDiscount(order.getTotalCost());
        System.out.println("Discounted Total: $" + discountedTotal);
    }
}