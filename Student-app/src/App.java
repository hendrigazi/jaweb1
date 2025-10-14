import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n=== Student Management Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Delete User melalui NIM");
            System.out.println("99. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

        switch (choice) {
            case 1 -> {
                System.out.print("Enter NIM: ");
                String nim = scanner.nextLine();

                System.out.print("Enter Name: ");
                String name = scanner.nextLine();

                LocalDate dob = null;
                    while (dob == null) {
                        System.out.print("Masukkan tanggal lahir (yyyy-MM-dd): ");
                        String dobInput = scanner.nextLine();
                        try {
                            dob = LocalDate.parse(dobInput);
                        } catch (DateTimeParseException e) {
                            System.out.println("gagal memasukkan date format. tolong gunakan yyyy-MM-dd.");
                        }
                    }
                System.out.print("Enter Address: ");
                String address = scanner.nextLine();

                Student student = new Student();
                student.setNim(nim);
                student.setName(name);
                service.addStudent(student);
                student.setDob(dob);
                student.setAddress(address);
            }
            case 2 -> service.listStudent();
            case 3 -> {
                System.out.print("Enter NIM of the student to delete: ");
                String nimToDelete = scanner.nextLine();
                boolean removed = service.removeStudentByNim(nimToDelete);
                if (removed) {
                    System.out.println("Student deleted successfully.");
                } else {
                    System.out.println("Student with NIM " + nimToDelete + " not found.");
                }
            }

            case 99 -> {
                System.out.println("Goodbye!");
                return;
            }
            default -> System.out.println("Invalid option.");
            }
        }
    }
}
