package P01_StudentManagement;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentManager {

    private List<Student> students;

    private final String pathFileToInput; // "./resources/student-input.txt"

    StudentDataService service;

    public StudentManager(String pathFileToInput) {

        this.pathFileToInput = pathFileToInput;

        this.service = new StudentDataService();

        try {

            this.students = service.read(pathFileToInput);

        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }

    public List<Student> getStudents() {
        return students;
    }





    public void sortByName() {

        Collections.sort(this.students, (s1, s2) -> s1.getName().compareTo(s2.getName()));

        //students = students.stream().sorted((s1, s2) -> s1.getName().compareTo(s2.getName())).collect(Collectors.toList());

        //students = students.stream().sorted(Comparator.comparing(Student::getName).reversed()).collect(Collectors.toList());

        //students = students.stream().sorted(Comparator.comparing(Student::getName).reversed()).collect(Collectors.toList());

    }

    public void sortById() {

        //Collections.sort(students, (s1, s2) -> s1.getId() - s2.getId());
        Collections.sort(students, (s1, s2) -> Integer.compare(s1.getId(), s2.getId()));
        //Collections.sort(students, Collections.reverseOrder((s1, s2) -> s1.getId() - s2.getId()));

        // using stream()
        //students = students.stream().sorted((s1, s2) -> Integer.compare(s1.getId(), s2.getId())).collect(Collectors.toList());
        //students = students.stream().sorted(Comparator.comparing(Student::getId).reversed()).collect(Collectors.toList());

    }

    public void addStudent(Scanner sc) {

        this.students.add(new Student().input(sc));
    }

    public Student findByName(String name) {

        for (Student s: this.students) {
            if (s.getName().equals(name)) {
                return s;
            }
        }

        return null;
    }
    public Student findByName2(String name) {

        return this.students.stream()
                .filter(s -> s.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public Student findById(int id) {

        for (Student s: this.students) {
            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }

    public void delete(int id) {

        Student student = findById(id);

        students.remove(student);
    }

    public void edit(int id) {
        Student student = findById(id);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new name: ");
        String newName = scanner.nextLine();
        student.setName(newName);
    }

    public void edit2(Scanner sc) {
        System.out.println("Enter id: ");
        int id = sc.nextInt();
        sc.nextLine(); // ignore new line

        Student student = findById(id);
        student.edit2(sc);
    }

    public void showAll() {

        for (int i = 0; i < students.size(); ++i) {
            //System.out.println(students.get(i).toString());
            students.get(i).showInfo();
        }

//        for (var s: students) {
//            s.showInfo();
//        }

    }

}
