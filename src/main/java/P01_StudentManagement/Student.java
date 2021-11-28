package P01_StudentManagement;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {

    private int id;
    private String name;
    private String klass;
    private String address;

    //constructors
    public Student() {

    }

    public Student(int id, String name, String klass, String address) {
        this.id = id;
        this.name = name;
        this.klass = klass;
        this.address = address;
    }

    // methods
    public Student input(Scanner sc) {

        //Scanner sc = new Scanner(System.in);

        System.out.println("Enter student id: ");
        //System.out.println("Input student information:");
        int id = sc.nextInt();
        sc.nextLine(); // ignore new line

        System.out.println("Enter full name: ");
        String name = sc.nextLine();

        System.out.println("Enter class: ");
        String klass = sc.nextLine();

        System.out.println("Enter address: ");
        String address = sc.nextLine();

        //sc.close();

        return new Student(id, name, klass, address);

    }

    public void showInfo() {

        System.out.printf("%-5d %-20s %-15s %-15s \n", id, name, klass, address);
    }

    @Override
    public String toString() {

        //return "Student{" + "id=" + id + ", name=" + name + ", klass=" + klass + ", address=" + address + '}';
        return id + ", " + name + ", " + klass + ", " + address;
    }


    //getters, setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKlass() {
        return klass;
    }

    public void setKlass(String klass) {
        this.klass = klass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
