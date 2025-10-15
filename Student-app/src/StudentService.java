import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class StudentService {
    private List<Student> students = new ArrayList<>();
    
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
    int originalSize = students.size();
    students = students.stream()
            .filter(s -> !s.getNim().equalsIgnoreCase(nim))
            .collect(Collectors.toList());
    return students.size() < originalSize;
    }
}