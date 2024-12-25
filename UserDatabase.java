/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.io.*;
import java.util.*;

public class UserDatabase {

    private static final String USER_DATA_DIR = "users";

    public static void registerUser(String email, String matricId, String password) throws IOException {
        String filename = getFileName(email);
        File userFile = new File(USER_DATA_DIR, filename);

        if (userFile.exists()) {
            System.out.println("User already registered!");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile))) {
            writer.write("Email: " + email + "\n");
            writer.write("Matric ID: " + matricId + "\n");
            writer.write("Password: " + password + "\n");
            writer.write("Academic List: \n");
            writer.write("Societies List: \n"); 
            writer.write("Uniform Bodies List: \n"); 
            writer.write("Sports Clubs List: \n");
        }

        System.out.println("User registered successfully!");
    }

    public static void loginUser(String email, String password, Scanner scanner) throws IOException {
        String filename = getFileName(email);
        File userFile = new File(USER_DATA_DIR, filename);

        if (!userFile.exists()) {
            System.out.println("User does not exist!");
            return;
        }

        boolean passwordMatched = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Password: " + password)) {
                    passwordMatched = true;
                    break;
                }
            }
        }

        if (!passwordMatched) {
            System.out.println("Incorrect password!");
            return;
        }

        System.out.println("Login successful!");

        System.out.println("Enter academic subjects (comma-separated):");
        String[] academicList = scanner.nextLine().split(",");
        addAcademicList(email, academicList);

        System.out.println("Enter societies (comma-separated):"); 
        String[] societiesList = scanner.nextLine().split(","); 
        addSocietiesList(email, societiesList); 
        
        System.out.println("Enter uniform bodies (comma-separated):"); 
        String[] uniformBodiesList = scanner.nextLine().split(","); 
        addUniformBodiesList(email, uniformBodiesList); 
        
        System.out.println("Enter sports clubs (comma-separated):"); 
        String[] sportsClubsList = scanner.nextLine().split(","); 
        addSportsClubsList(email, sportsClubsList);
    }

    public static void addAcademicList(String email, String[] academicList) throws IOException { 
        String filename = getFileName(email); 
        File userFile = new File(USER_DATA_DIR, filename); 
        
        if (!userFile.exists()) { 
            System.out.println("User file does not exist!"); 
            return; 
        } 
        
        StringBuilder fileContent = new StringBuilder(); 
        try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) { 
            String line; 
            while ((line = reader.readLine()) != null) { 
                fileContent.append(line).append("\n"); 
                if (line.startsWith("Academic List:")) { 
                    for (String subject : academicList) { 
                        fileContent.append("- ").append(subject.trim()).append("\n"); 
                    } 
                } 
            } 
        } 
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile))) { 
            writer.write(fileContent.toString()); 
        } 
        
        System.out.println("Academic list added successfully!"); 
    }
    
    public static void addSocietiesList(String email, String[] societiesList) throws IOException { 
        String filename = getFileName(email); 
        File userFile = new File(USER_DATA_DIR, filename); 
        
        if (!userFile.exists()) { 
            System.out.println("User file does not exist!"); 
            return; 
        } 
        
        StringBuilder fileContent = new StringBuilder(); 
        try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) { 
            String line; 
            while ((line = reader.readLine()) != null) { 
                fileContent.append(line).append("\n"); 
                if (line.startsWith("Societies List:")) { 
                    for (String society : societiesList) { 
                        fileContent.append("- ").append(society.trim()).append("\n"); 
                    } 
                } 
            } 
        } 
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile))) { 
            writer.write(fileContent.toString()); 
        } 
        
        System.out.println("Societies list added successfully!"); 
    } 
    
    public static void addUniformBodiesList(String email, String[] uniformBodiesList) throws IOException { 
        String filename = getFileName(email); 
        File userFile = new File(USER_DATA_DIR, filename); 
        
        if (!userFile.exists()) { 
            System.out.println("User file does not exist!"); 
            return; 
        } 
        
        StringBuilder fileContent = new StringBuilder(); 
        try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) { 
            String line; 
            while ((line = reader.readLine()) != null) { 
                fileContent.append(line).append("\n"); 
                if (line.startsWith("Uniform Bodies List:")) { 
                    for (String uniformBody : uniformBodiesList) { 
                        fileContent.append("- ").append(uniformBody.trim()).append("\n"); 
                    } 
                } 
            } 
        } 
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile))) { 
            writer.write(fileContent.toString()); 
        } 
        
        System.out.println("Uniform bodies list added successfully!"); 
    } 
    
    public static void addSportsClubsList(String email, String[] sportsClubsList) throws IOException { 
        String filename = getFileName(email); 
        File userFile = new File(USER_DATA_DIR, filename); 
        
        if (!userFile.exists()) { 
            System.out.println("User file does not exist!"); 
            return; 
        } 
        
        StringBuilder fileContent = new StringBuilder(); 
        try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) { 
            String line; 
            while ((line = reader.readLine()) != null) { 
                fileContent.append(line).append("\n"); 
                if (line.startsWith("Sports Clubs List:")) { 
                    for (String sportsClub : sportsClubsList) { 
                        fileContent.append("- ").append(sportsClub.trim()).append("\n"); 
                    } 
                } 
            } 
        } 
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile))) { 
            writer.write(fileContent.toString()); 
        } 
        
        System.out.println("Sports clubs list added successfully!"); 
    } 
    
    private static String getFileName(String email) { 
        return email.replaceAll("[^a-zA-Z0-9]", "_") + ".txt"; 
    } 
}