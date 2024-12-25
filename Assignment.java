/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment;

import java.util.*; 
import java.io.*;
        
public class Assignment {

    public static void main(String[] args) {
        try {
            LoginPage.createUserFile();
            List<User> users = LoginPage.loadUsers(); 

            Scanner sc = new Scanner(System.in); 
            while (true) { 
                System.out.println("\nWelcome to the Student Portal");
                System.out.println("1. Login"); 
                System.out.println("2. Register"); 
                System.out.println("3. View Academic Subjects"); 
                System.out.println("4. View Cocurricular Activities"); 
                System.out.println("5. Exit"); 
                System.out.print("Choose an option: "); 
                int choice = Integer.parseInt(sc.nextLine().trim()); 
                
                switch (choice) { 
                    case 1: 
                        LoginPage.login(users);
                        break; 
                    case 2: 
                        LoginPage.register(users); 
                        break; 
                    case 3: 
                        Academic.viewAcademicSubjects(); 
                        break; 
                    case 4: 
                        Cocurriculum.displayCoCurriculum(new ArrayList<>(), new ArrayList<>(), new ArrayList<>()); 
                        break; 
                    case 5: 
                        System.out.println("Thank you!"); 
                        return; 
                    default: 
                        System.out.println("Invalid choice. Please try again."); 
                } 
            } 
        } catch (IOException e) { 
            System.err.println("Error: Unable to process the file. " + e.getMessage());
        }
    }
}