public class Main {
    public static void main(String[] args) {
        Student student = new Student("Alice", "S101", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);
        controller.showStudent();
        controller.updateStudent("Alice Johnson", "S101", "A+");
        controller.showStudent();
    }
}
