package P01_StudentManagement;

import java.io.IOException;
import java.util.Collections;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author huynq
 */
public class Main {

    public static Scanner scanner = new Scanner(System.in);
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        //StudentDataService service = new StudentDataService();
        //Path pathFileToRead = Paths.get("./resources/student-input.txt");
        //List<Student> students = service.read("./resources/student-input.txt");
        //students.forEach(System.out::println);
//        for (Student student: students) {
//            System.out.println(student);
//        }
//
//        for (int i = 0; i < students.size(); ++i) {
//            System.out.println(students.get(i).toString());
//        }
        //Path pathFileToWrite = Paths.get("./resources/student-output.txt");
//        service.write("./resources/student-output.txt", students);
//        Collections.sort(
//                students,
//                (Student s1, Student s2) -> {
//                    return s2.getName().compareTo(s1.getName());
//                });
//        Collections.sort(
//                students,
//                (s1, s2) -> s1.getId() - s2.getId()
//        );
        //StudentManager studentManager = new StudentManager("./resources/student-input.txt");

        //studentManager.sortByName(students);
        //studentManager.sortById(students);
//        //
//        studentManager.getStudents().forEach(System.out::println);
//
//        //
//        studentManager.sortById();
//        studentManager.getStudents().forEach(System.out::println);
//
//        //
//        Student findByName = studentManager.findByName("nguyen van a");
//        findByName.showInfo();
        //
        //studentManager.addStudent();

        //studentManager.getStudents().forEach(System.out::println);



        String choose = null;
        boolean exit = false;
        StudentManager studentManager = new StudentManager("./resources/student-input.txt");
        int studentId;

        // show menu
        showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("Add student");
                    studentManager.addStudent(scanner);
                    break;
                case "2":
                    System.out.println("Enter id: ");
                    studentId = scanner.nextInt();
                    scanner.nextLine(); // ignore new line
                    studentManager.edit(studentId);
                    break;
                case "3":
                    System.out.println("Enter id: ");
                    studentId = scanner.nextInt();
                    scanner.nextLine(); // ignore new line
                    studentManager.delete(studentId);
                    break;
                case "4":
                    studentManager.sortByName();
                    break;
                case "5":
                    studentManager.sortById();
                    break;
                case "6":
                    System.out.println("Show all students");
                    studentManager.showAll();
                    break;
                case "0":
                    System.out.println("exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("invalid! please choose action in below menu:");
                    break;
            }

            if (exit) {
                break;
            }
            // show menu
            showMenu();
        }

    }


    public static void showMenu() {
        System.out.println("-----------menu------------");
        System.out.println("1. Add student.");
        System.out.println("2. Edit student by id.");
        System.out.println("3. Delete student by id.");
        System.out.println("4. Sort student by gpa.");
        System.out.println("5. Sort student by name.");
        System.out.println("6. Show student.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.println("Please choose: ");
    }
}
