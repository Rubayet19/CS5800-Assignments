class Instructor {
    private String firstName;
    private String lastName;
    private String officeNumber;

    public Instructor(String firstName, String lastName, String officeNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeNumber = officeNumber;
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

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }
    
    // Print function for Instructor details
    public void print() {
        System.out.println("Instructor: " + firstName + " " + lastName + ", Office Number: " + officeNumber);
    }
}

class Textbook {
    private String title;
    private String author;
    private String publisher;

    public Textbook(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    // Accessors (getters) and mutators (setters)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    // Print function for Textbook details
    public void print() {
        System.out.println("Textbook: " + title + " by " + author + ", Publisher: " + publisher);
    }
}

class Course {
    private String courseName;
    private Instructor[] instructors;
    private Textbook[] textbooks;

    public Course(String courseName, Instructor[] instructors, Textbook[] textbooks) {
        this.courseName = courseName;
        this.instructors = instructors;
        this.textbooks = textbooks;
    }

    public void print() {
        System.out.println("Course Name: " + courseName);
        for (int i = 0; i < instructors.length || i < textbooks.length; i++) {
            if (i < instructors.length) instructors[i].print();
            if (i < textbooks.length) textbooks[i].print();
        }
    }
}

public class Ans3 {
    public static void main(String[] args) {
        Instructor instructor1 = new Instructor("Nima", "Davarpanah", "3-2636");
        Instructor instructor2 = new Instructor("Jane", "Doe", "1-2345");
        Textbook textbook1 = new Textbook("Clean Code", "Robert C. Martin", "Prentice Hall");
        Textbook textbook2 = new Textbook("Effective Java", "Joshua Bloch", "Addison-Wesley");

        Instructor[] instructors = {instructor1, instructor2};
        Textbook[] textbooks = {textbook1, textbook2};

        Course course = new Course("Software Development", instructors, textbooks);
        course.print();
    }
}

