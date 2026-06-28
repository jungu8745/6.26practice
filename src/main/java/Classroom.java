import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Classroom {

    private final List<Student> students;

    public Classroom() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public Optional<Student> findById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }

    public List<Student> getPassedStudents() {
        return students.stream()
                .filter(student -> student.getPassStatus() == PassStatus.PASSED)
                .toList();
    }

    public Optional<Student> findTopStudent() {
        return students.stream()
                .max((s1, s2) -> Integer.compare(s1.getScore(), s2.getScore()));
    }

    public List<Student> searchByName(String keyword) {
        return students.stream()
                .filter(student -> student.getName().contains(keyword))
                .toList();
    }
}