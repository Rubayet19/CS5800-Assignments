import java.util.ArrayList;
import java.util.List;

abstract class Pizza {
    String chain;
    String size;
    String toppings = "";
    
    void eat() {
        System.out.println("Eating a " + size + " " + chain + " pizza with toppings: " + toppings);
    }
}

class PizzaHut extends Pizza {
    private PizzaHut(PizzaBuilder builder) {
        this.chain = "Pizza Hut";
        this.size = builder.size;
        this.toppings = String.join(", ", builder.toppings);
    }
    
    static class PizzaBuilder {
        private String size;
        private List<String> toppings = new ArrayList<>();
        
        PizzaBuilder(String size) {
            this.size = size;
        }
        
        PizzaBuilder addTopping(String topping) {
            toppings.add(topping);
            return this;
        }
        
        PizzaHut build() {
            return new PizzaHut(this);
        }
    }
}

class LittleCaesars extends Pizza {
    private LittleCaesars(PizzaBuilder builder) {
        this.chain = "Little Caesars";
        this.size = builder.size;
        this.toppings = String.join(", ", builder.toppings);
    }
    
    static class PizzaBuilder {
        private String size;
        private List<String> toppings = new ArrayList<>();
        
        PizzaBuilder(String size) {
            this.size = size;
        }
        
        PizzaBuilder addTopping(String topping) {
            toppings.add(topping);
            return this;
        }
        
        LittleCaesars build() {
            return new LittleCaesars(this);
        }
    }
}

class Dominos extends Pizza {
    private Dominos(PizzaBuilder builder) {
        this.chain = "Dominos";
        this.size = builder.size;
        this.toppings = String.join(", ", builder.toppings);
    }
    
    static class PizzaBuilder {
        private String size;
        private List<String> toppings = new ArrayList<>();
        
        PizzaBuilder(String size) {
            this.size = size;
        }
        
        PizzaBuilder addTopping(String topping) {
            toppings.add(topping);
            return this;
        }
        
        Dominos build() {
            return new Dominos(this);
        }
    }
}

public class Driver {
    public static void main(String[] args) {
        PizzaHut ph1 = new PizzaHut.PizzaBuilder("Large")
                .addTopping("Pepperoni")
                .addTopping("Mushrooms")
                .addTopping("Onions")
                .build();
                
        PizzaHut ph2 = new PizzaHut.PizzaBuilder("Medium")
                .addTopping("Sausage")
                .addTopping("Peppers")
                .addTopping("Olives")
                .addTopping("Pepperoni")
                .addTopping("Extra Cheese")
                .addTopping("Mushrooms")
                .build();
                
        PizzaHut ph3 = new PizzaHut.PizzaBuilder("Small")
                .addTopping("Ham")
                .addTopping("Pineapple")
                .addTopping("Bacon")
                .addTopping("Pepperoni")
                .addTopping("Sausage")
                .addTopping("Chicken")
                .addTopping("Mushrooms")
                .addTopping("Olives")
                .addTopping("Spinach")
                .build();
        

        PizzaHut ph4 = new PizzaHut.PizzaBuilder("Large")
                .addTopping("Spicy Pork")
                .addTopping("Ham and Pineapple")
                .addTopping("Beef")
                .build();
                
        PizzaHut ph5 = new PizzaHut.PizzaBuilder("Small")
                .addTopping("Chicken")
                .addTopping("Onions")
                .build();
        
        LittleCaesars lc1 = new LittleCaesars.PizzaBuilder("Medium")
                .addTopping("Pepperoni")
                .addTopping("Sausage")
                .addTopping("Bacon")
                .addTopping("Ham")
                .addTopping("Chicken")
                .addTopping("Onions")
                .addTopping("Olives")
                .addTopping("Mushrooms")
                .build();
                  
        LittleCaesars lc2 = new LittleCaesars.PizzaBuilder("Small")
                .addTopping("Peppers")
                .addTopping("Onions")
                .addTopping("Olives")
                .addTopping("Mushrooms")
                .addTopping("Extra Cheese")
                .addTopping("Spinach")
                .build();

        Dominos d1 = new Dominos.PizzaBuilder("Small")
                .addTopping("Pepperoni")
                .build();
                
        Dominos d2 = new Dominos.PizzaBuilder("Large")
                .addTopping("Sausage")
                .addTopping("Peppers")
                .addTopping("Mushrooms")
                .build();
        
        ph1.eat(); 
        ph2.eat();
        ph3.eat();
        ph4.eat();
        ph5.eat();
        lc1.eat();
        lc2.eat(); 
        d1.eat();
        d2.eat();
    }
}