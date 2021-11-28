/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package P01_StudentManagement;

import java.util.Scanner;

/**
 *
 * @author huynq
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Hello");

        Scanner sc = new Scanner(System.in);

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


    }

}
