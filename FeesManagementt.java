import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class FeesManagementt{
    public static void main(String[] args) {
        FeesManagementSystem feesSystem = new FeesManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Fees Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Record Fee Payment");
            System.out.println("3. Display Student Information");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Please enter the Student data to record:");
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    feesSystem.addStudent(id, name);
                    break;
                case 2:
                    System.out.println("Please enter the Student data to record the Payment details:");
                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    System.out.print("Enter Payment Amount: ");
                    double paymentAmount = scanner.nextDouble();
                    feesSystem.recordFeePayment(studentId, paymentAmount);
                    break;
                case 3:
                    System.out.println("Please enter the Student data to view the Fee details:");
                    System.out.print("Enter Student ID: ");
                    int infoStudentId = scanner.nextInt();
                    System.out.println("Total Fees is: 1000");
                    feesSystem.displayStudentInfo(infoStudentId);
                    break;
                case 4:
                    System.out.println("You have choose to exit");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("You have given Invalid choice");
            }
        }
    }
}

class Student {
    private int id;
    private String name;
    private double totfepaid;

     Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.totfepaid = 0.0;
    }

     int getId() {
        return id;
    }

     String getName() {
        return name;
    }

     double feepaid() {
        return totfepaid;
    }

     void payFees(double fees) {
        totfepaid += fees;
    }
}

class FeesManagementSystem {
     List<Student> students;

     FeesManagementSystem() {
        students = new ArrayList<>();
    }

     void addStudent(int id, String name) {
        students.add(new Student(id, name));
    }

     void recordFeePayment(int studentId, double fees) {
        Student student = findStudentById(studentId);
        if (student != null) {
            student.payFees(fees);
            System.out.println("Payment recorded successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

     void displayStudentInfo(int studentId) {
        Student student = findStudentById(studentId);
        if (student != null) {
            System.out.println("Student ID: " + student.getId());
            System.out.println("Student Name: " + student.getName());
            double fpaid=0.0;
            fpaid= student.feepaid();
            System.out.println("Fees Paid: " +fpaid );
            double remFees =0.0;
            remFees= calculateRemainingFees(fpaid);
            System.out.println("Remaining Fees: " + remFees);
        } else {
            System.out.println("Student not found.");
        }
    }

     Student findStudentById(int studentId) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }

     double calculateRemainingFees(double fp) {
        return (10000-fp);
    }
}


