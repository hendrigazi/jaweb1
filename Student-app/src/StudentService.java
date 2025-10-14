import java.util.ArrayList;
import java.util.List;


public class StudentService {
    private final List<Student> students = new ArrayList<>();
    
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successsfully");
    }

    public void listStudent(){
        if (students.isEmpty()){
            System.out.println("No students available");
            return;
        }
        students.forEach(System.out::println);
    }
    public boolean removeStudentByNim(String nim) {
    for (Student s : students) {
        if (s.getNim().equalsIgnoreCase(nim)) {
            students.remove(s);
            return true;
            }
        }
        return false;
    }
}