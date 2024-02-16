// Employee base class
class Employee {
    public String firstName;
    public String lastName;
    private String socialSecurityNumber;

    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    // Accessors (getters) and mutators (setters)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    // Additional methods, if needed
}

// SalariedEmployee subclass
class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
        super(firstName, lastName, socialSecurityNumber);
        this.weeklySalary = weeklySalary;
    }

    // Accessors and mutators
    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    // Additional methods, if needed
}

// HourlyEmployee subclass
class HourlyEmployee extends Employee {
    private double wage;
    private int hoursWorked;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, int hoursWorked) {
        super(firstName, lastName, socialSecurityNumber);
        this.wage = wage;
        this.hoursWorked = hoursWorked;
    }

    // Accessors and mutators
    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    // Additional methods, if needed
}

// CommissionEmployee subclass
class CommissionEmployee extends Employee {
    private double commissionRate;
    private double grossSales;

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double commissionRate, double grossSales) {
        super(firstName, lastName, socialSecurityNumber);
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
    }

    // Accessors and mutators
    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    // Additional methods, if needed
}

// BaseEmployee subclass
class BaseEmployee extends Employee {
    private double baseSalary;

    public BaseEmployee(String firstName, String lastName, String socialSecurityNumber, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber);
        this.baseSalary = baseSalary;
    }

    // Accessors and mutators
    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Additional methods, if needed
}

public class Ans1 {

    public static void main(String[] args) {
        // Create instances of each type of employee with the information provided
        SalariedEmployee salariedEmployee = new SalariedEmployee("Joe", "Jones", "111-11-1111", 2500.0);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Stephanie", "Smith", "222-22-2222", 25.0, 32);
        HourlyEmployee hourlyEmployee2 = new HourlyEmployee("Mary", "Quinn", "333-33-3333", 19.0, 47);
        CommissionEmployee commissionEmployee = new CommissionEmployee("Nicole", "Dior", "444-44-4444", 0.15, 50000.0);
        BaseEmployee baseEmployee = new BaseEmployee("Mike", "Davenport", "666-66-6666", 95000.0);
        CommissionEmployee commissionEmployee2  = new CommissionEmployee("Mahnaz", "Vaziri", "777-77-7777", 0.22, 40000.0);

        // Print out information for each employee
        // Here we would typically call a toString method or similar to output the employee details, but this method would need to be implemented in each class.
        System.out.println("Salaried Employee: " + salariedEmployee.getFirstName() + " " + salariedEmployee.getLastName() + " earns " + salariedEmployee.getWeeklySalary());
        System.out.println("Hourly Employee: " + hourlyEmployee.getFirstName() + " " + hourlyEmployee.getLastName() + " earns " + hourlyEmployee.getWage() + " per hour and worked " + hourlyEmployee.getHoursWorked() + " hours");
        System.out.println("Hourly Employee 2: " + hourlyEmployee2.getFirstName() + " " + hourlyEmployee2.getLastName() + " earns " + hourlyEmployee2.getWage() + " per hour and worked " + hourlyEmployee2.getHoursWorked() + " hours");
        System.out.println("Commission Employee: " + commissionEmployee.getFirstName() + " " + commissionEmployee.getLastName() + " has a commission rate of " + commissionEmployee.getCommissionRate() + " and gross sales of " + commissionEmployee.getGrossSales());
        System.out.println("Base Employee: " + baseEmployee.getFirstName() + " " + baseEmployee.getLastName() + " has a base salary of " + baseEmployee.getBaseSalary());
        System.out.println("Commission Employee 2: " + commissionEmployee2.getFirstName() + " " + commissionEmployee2.getLastName() + " has a base salary of " + commissionEmployee2.getCommissionRate() + " and a commission rate of " + commissionEmployee2.getCommissionRate());
    }
}

