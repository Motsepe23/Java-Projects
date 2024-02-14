import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Course class to represent course information
class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private int enrolledStudents;

    public Course(String code, String title, String description, int capacity) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolledStudents = 0;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean registerStudent() {
        if (enrolledStudents < capacity) {
            enrolledStudents++;
            return true;
        } else {
            return false;
        }
    }

    public void removeStudent() {
        if (enrolledStudents > 0) {
            enrolledStudents--;
        }
    }

    public String toString() {
        return "Course Code: " + code + "\nTitle: " + title + "\nDescription: " + description +
                "\nCapacity: " + capacity + "\nEnrolled Students: " + enrolledStudents;
    }
}

// Student class to represent student information
class Student {
    private int id;
    private String name;
    private List<Course> registeredCourses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (course.registerStudent()) {
            registeredCourses.add(course);
            System.out.println("Course registered: " + course.getCode());
        } else {
            System.out.println("Course is full. Cannot register.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.remove(course)) {
            course.removeStudent();
            System.out.println("Course dropped: " + course.getCode());
        } else {
            System.out.println("You are not registered in this course.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Course c1 = new Course("CSC101", "Introduction to Programming", "An introductory course on programming", 30);
        Course c2 = new Course("MAT201", "Linear Algebra", "An advanced course on linear algebra", 25);
        Course c3 = new Course("PHY301", "Physics for Engineers", "An introductory course on physics", 40);

        Student student = new Student(123, "Thapelo Masalesa");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCourse Listing:");
            System.out.println("1. " + c1);
            System.out.println("2. " + c2);
            System.out.println("3. " + c3);
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    student.registerCourse(c1);
                    break;
                case 2:
                    student.registerCourse(c2);
                    break;
                case 3:
                    student.registerCourse(c3);
                    break;
                case 4:
                    System.out.println("Exiting.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
