import java.util.Random;

abstract class Macronutrient {
    String name;
    abstract void printName();
}

abstract class Carbs extends Macronutrient {}
abstract class Protein extends Macronutrient {}
abstract class Fats extends Macronutrient {}

class Cheese extends Carbs {
    Cheese() { name = "Cheese"; }
    void printName() { System.out.print(name + " "); }
}

class Bread extends Carbs {
    Bread() { name = "Bread"; }
    void printName() { System.out.print(name + " "); }
}

class Lentils extends Carbs {
    Lentils() { name = "Lentils"; }
    void printName() { System.out.print(name + " "); }
}

class Pistachio extends Carbs {
    Pistachio() { name = "Pistachio"; }
    void printName() { System.out.print(name + " "); }
}

class Fish extends Protein {
    Fish() { name = "Fish"; }
    void printName() { System.out.print(name + " "); }
}

class Chicken extends Protein {
    Chicken() { name = "Chicken"; }
    void printName() { System.out.print(name + " "); }
}

class Beef extends Protein {
    Beef() { name = "Beef"; }
    void printName() { System.out.print(name + " "); }
}

class Tofu extends Protein {
    Tofu() { name = "Tofu"; }
    void printName() { System.out.print(name + " "); }
}

class Avocado extends Fats {
    Avocado() { name = "Avocado"; }
    void printName() { System.out.print(name + " "); }
}

class SourCream extends Fats {
    SourCream() { name = "Sour cream"; }
    void printName() { System.out.print(name + " "); }
}

class Tuna extends Fats {
    Tuna() { name = "Tuna"; }  
    void printName() { System.out.print(name + " "); }
}

class Peanuts extends Fats {
    Peanuts() { name = "Peanuts"; }
    void printName() { System.out.print(name + " "); }
}

abstract class MacronutrientFactory {
    abstract Carbs createCarbs();
    abstract Protein createProtein();
    abstract Fats createFats();
}

class NoRestrictionFactory extends MacronutrientFactory {
    private static NoRestrictionFactory instance;
    
    private NoRestrictionFactory() {}
    
    static NoRestrictionFactory getInstance() {
        if (instance == null) {
            instance = new NoRestrictionFactory();
        }
        return instance;
    }
    
    Carbs createCarbs() {
        Random random = new Random();
        switch(random.nextInt(4)) {
            case 0: return new Cheese();
            case 1: return new Bread();
            case 2: return new Lentils();
            default: return new Pistachio();
        }
    }
    
    Protein createProtein() {
        Random random = new Random();
        switch(random.nextInt(4)) {
            case 0: return new Fish();
            case 1: return new Chicken(); 
            case 2: return new Beef();
            default: return new Tofu();
        }
    }
    
    Fats createFats() {
        Random random = new Random();
        switch(random.nextInt(4)) {
            case 0: return new Avocado();
            case 1: return new SourCream();
            case 2: return new Tuna();
            default: return new Peanuts();
        }
    }
}

class PaleoFactory extends MacronutrientFactory {
    private static PaleoFactory instance;
    
    private PaleoFactory() {}
    
    static PaleoFactory getInstance() {
        if (instance == null) {
            instance = new PaleoFactory();
        }
        return instance;
    }
    
    Carbs createCarbs() {
        return new Pistachio();
    }
    
    Protein createProtein() {
        Random random = new Random();
        switch(random.nextInt(3)) {
            case 0: return new Fish();
            case 1: return new Chicken();
            default: return new Beef();
        }
    }
    
    Fats createFats() {
        Random random = new Random();
        switch(random.nextInt(3)) {
            case 0: return new Avocado();
            case 1: return new Tuna();
            default: return new Peanuts();
        }
    }
}

class VeganFactory extends MacronutrientFactory {
    private static VeganFactory instance;
    
    private VeganFactory() {}
    
    static VeganFactory getInstance() {
        if (instance == null) {
            instance = new VeganFactory();
        }
        return instance;
    }

    Carbs createCarbs() {
        Random random = new Random();
        switch(random.nextInt(3)) {
            case 0: return new Bread();
            case 1: return new Lentils();
            default: return new Pistachio();
        }
    }
    
    Protein createProtein() {
        return new Tofu();
    }
    
    Fats createFats() {
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            return new Avocado();
        } else {
            return new Peanuts();
        }
    }
}

class NutAllergyFactory extends MacronutrientFactory {
    private static NutAllergyFactory instance;
    
    private NutAllergyFactory() {}
    
    static NutAllergyFactory getInstance() {
        if (instance == null) {
            instance = new NutAllergyFactory();
        }
        return instance;
    }
    
    Carbs createCarbs() {
        Random random = new Random();
        switch(random.nextInt(2)) {
            case 0: return new Cheese();
            default: return new Bread(); 
        }
    }
    
    Protein createProtein() {
        Random random = new Random();
        switch(random.nextInt(3)) {
            case 0: return new Fish();
            case 1: return new Chicken();
            default: return new Beef();
        }
    }
    
    Fats createFats() {
        Random random = new Random();
        switch(random.nextInt(2)) {
            case 0: return new Avocado();
            default: return new Tuna();
        }
    }
}

abstract class AbstractMacronutrientFactory {
    private static AbstractMacronutrientFactory instance;
    
    protected AbstractMacronutrientFactory() {}
    
    public static AbstractMacronutrientFactory getInstance() {
        if (instance == null) {
            instance = new ConcreteMacronutrientFactory();
        }
        return instance;
    }
    
    abstract MacronutrientFactory createMacronutrientFactory(String diet);
}

class ConcreteMacronutrientFactory extends AbstractMacronutrientFactory {
    MacronutrientFactory createMacronutrientFactory(String diet) {
        switch(diet) {
            case "Paleo": 
                return PaleoFactory.getInstance();
            case "Vegan":
                return VeganFactory.getInstance();
            case "Nut Allergy":
                return NutAllergyFactory.getInstance();
            default:
                return NoRestrictionFactory.getInstance();
        }
    }
}

class Meal {
    Carbs carbs;
    Protein protein; 
    Fats fats;
    
    Meal(MacronutrientFactory factory) {
        carbs = factory.createCarbs();
        protein = factory.createProtein();
        fats = factory.createFats();
    }
    
    void printMeal(String customerName) {
        System.out.print(customerName + "'s Meal: ");
        carbs.printName();
        protein.printName();
        fats.printName(); 
        System.out.println();
    }
}

public class Driver {
    public static void main(String[] args) {
        String[] customers = {"John", "Alice", "Bob", "Mary", "Tom", "Kate"};
        String[] dietPlans = {"No Restriction", "Paleo", "Vegan", "Nut Allergy", "Vegan", "Paleo"};
        
        AbstractMacronutrientFactory abstractFactory = AbstractMacronutrientFactory.getInstance();
        
        for (int i = 0; i < customers.length; i++) {
            String customer = customers[i];
            String diet = dietPlans[i];
            
            System.out.println("Customer: " + customer);
            System.out.println("Diet: " + diet);
            
            MacronutrientFactory factory = abstractFactory.createMacronutrientFactory(diet);
            Meal meal = new Meal(factory);
            meal.printMeal(customer);
            
            System.out.println();
        }
    }
}
