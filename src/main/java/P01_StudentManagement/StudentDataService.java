/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P01_StudentManagement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author huynq
 */
public class StudentDataService {

    public List<Student> read(String path) throws IOException {

        List<Student> students = new ArrayList<>();

        //Path pathFileToRead = Paths.get("./resources/student-input.txt");
        Path pathFileToRead = Paths.get(path);

        List<String> allLines = Files.readAllLines(pathFileToRead);

        //String[] lineArray = readAllLines.toArray(new String[0]);
        //String[] lineArray = allLines.toArray(String[]::new );


//        for (int i = 0; i < lineArray.length; ++i) {
//
//            //String[] data = lineArray[i].split("\\s+"); //Split on your delimiter
//            String[] data = lineArray[i].split(","); //Split on your delimiter
//
//            Student student = new Student(Integer.parseInt(data[0]) , data[1].trim(), data[2].trim(), data[3].trim());
//            students.add(student);
//        }


        for (int i = 0; i < allLines.size(); ++i) {

            String line = allLines.get(i);
            String[] data = line.split(",");
            Student student = new Student(Integer.parseInt(data[0]) , data[1].trim(), data[2].trim(), data[3].trim());
            students.add(student);
        }



        /* Way 1a
        students = Files.readAllLines(pathFileToRead)
                .stream()
                .map(line -> {
                    String[] data = line.split(",");
                    return new Student(Integer.parseInt(data[0]), data[1].trim(), data[2].trim(), data[3].trim());
                })
                .collect(Collectors.toList());
        */


        /* Way 2
        students = Files.lines(pathFileToRead)
                .map(line -> {
                    String[] data = line.split(","); //Split on your delimiter
                    return new Student(Integer.parseInt(data[0]), data[1].trim(), data[2].trim(), data[3].trim());
                })
                .collect(Collectors.toList());
        */

        return students;

    }

    public void write(String path, List<Student> students) throws IOException {

        List<String> list = new ArrayList<>();

        Student[] studentArray = students.toArray(new Student[0]);

        for (int i = 0; i < studentArray.length; ++i) {
            list.add(studentArray[i].toString());
        }

        //Path pathFileToWrite = Paths.get("./resources/student-output.txt");
        Path pathFileToWrite = Paths.get(path);
        Files.write(pathFileToWrite, list);



        //
        List<String> outList2 = students.stream()
                .map(student -> {
                    //student.toString();
                    return student.getId() + ", " + student.getName() + ", " + student.getKlass() + ", " + student.getAddress();
                })
                .collect(Collectors.toList());

        Path output2 = Paths.get("./resources/student-output2.txt");
        Files.write(output2, outList2);


        //
        List<String> outList3 = students.stream()
                .map(Student::toString)
                .collect(Collectors.toList());

        Path output3 = Paths.get("./resources/student-output3.txt");
        Files.write(output3, outList3);

    }

}
