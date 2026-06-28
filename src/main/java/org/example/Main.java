import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private final Scanner scanner;

    public Main() {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        Classroom classroom = new Classroom();

        classroom.addStudent(new Student(1, "김하나", 87));
        classroom.addStudent(new Student(2, "이도윤", 92));
        classroom.addStudent(new Student(3, "박서준", 58));

        printStudents(classroom.getStudents());

        System.out.print("수정할 학생 id: ");
        int id = readInt();

        System.out.print("새 점수: ");
        int score = readInt();

        Optional<Student> student = classroom.findById(id);

        if (student.isEmpty()) {
            System.out.println("학생을 찾을 수 없습니다.");
            return;
        }

        try {
            student.get().updateScore(score);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("\n합격자 목록");
        printStudents(classroom.getPassedStudents());

        System.out.println("\n최고 점수 학생");
        printTopStudent(classroom.findTopStudent());

        System.out.println("\n이름 검색(김)");
        printStudents(classroom.searchByName("김"));
    }

    private void printStudents(List<Student> students) {
        students.forEach(System.out::println);
    }

    private void printTopStudent(Optional<Student> student) {
        student.ifPresent(System.out::println);
    }

    private int readInt() {
        return scanner.nextInt();
    }
}