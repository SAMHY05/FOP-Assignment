/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.*;
import java.io.*;

public class LoginPage {
    
    private static final String FILE = "UserData.txt";
    private static final Scanner sc = new Scanner(System.in); 
    
    public static List<User> loadUsers() throws IOException {
        List<User> users = new ArrayList<>();
        BufferedReader inputStream = new BufferedReader(new FileReader(FILE));
        String line;

        while ((line = inputStream.readLine()) != null) {
            line = line.trim();
            if(line.isEmpty()){
                continue;
            }
            
            String email = line;
            String matricNum  = inputStream.readLine();
            String password = inputStream.readLine();
            String subjectsStr = inputStream.readLine();
            String societiesStr = inputStream.readLine(); 
            String uniformBodiesStr = inputStream.readLine(); 
            String sportsClubsStr = inputStream.readLine();
            
            if (matricNum == null || password == null || subjectsStr == null || societiesStr == null || uniformBodiesStr == null || sportsClubsStr == null) {
                System.out.println("Warning:Incompleter data for user with email: "+email);
                continue;
            }
            
            matricNum = matricNum.trim();
            password = password.trim();
            subjectsStr = subjectsStr.trim();
            societiesStr = societiesStr.trim(); 
            uniformBodiesStr = uniformBodiesStr.trim(); 
            sportsClubsStr = sportsClubsStr.trim();
            
            List<String> subjects = Arrays.asList(subjectsStr.split(",")); 
            List<String> societies = Arrays.asList(societiesStr.split(",")); 
            List<String> uniformBodies = Arrays.asList(uniformBodiesStr.split(",")); 
            List<String> sportsClubs = Arrays.asList(sportsClubsStr.split(",")); 
            users.add(new User(email, matricNum, password, subjects, societies, uniformBodies, sportsClubs)); 
        }
        
        inputStream.close();
        return users;
    }
    
    public static void saveUsers(List<User> users) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE, false))) { 
            for (User user : users) {
                writer.println(user.getEmail()); 
                writer.println(user.getMatricNum()); 
                writer.println(user.getPassword()); 
                writer.println(String.join(",", user.getSubjects())); 
                writer.println(String.join(",", user.getSocieties())); 
                writer.println(String.join(",", user.getUniformBodies())); 
                writer.println(String.join(",", user.getSportsClubs())); 
                writer.println(); 
            }
        }
    }

     
    public static void createUserFile() throws IOException {  
        String userData =
                "s100201@student.fop\n" +
                "s100201\n" +
                "pw-Stud#1\n" +
                "1103,1119,1225,1249,1449,3472,4531,4541,4551,6531\n" +
                "B07,P82,S01\n" +
                "\n"+
                "s100202@student.fop\n" +
                "S100202\n" +
                "pw-Stud#2\n" +
                "1103,1119,1223,1249,1449,1511,3754,3766,3756,3767\n" +
                "B01,P27,S15\n";

        File myfile = new File(FILE);
        if (!myfile.exists()) {
            try (FileWriter myWriter = new FileWriter(myfile)) { 
                myWriter.write(userData);
                System.out.println("User Data.txt file created successfully.");
            }
        } else {
            System.out.println("User Data.txt file already exists.");
        }
    }
    public static void login(List<User> users) {
        System.out.print("Enter email: ");
        String email = sc.nextLine().trim();
        System.out.print("Enter password: ");
        String password = sc.nextLine().trim();

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login successful! Welcome, " + user.getMatricNum()); 
                System.out.println("\n---- User Details ----"); 
                System.out.println("Matric Number: " + user.getMatricNum()); 
                System.out.println("Academic Subjects: " + String.join(", ", user.getSubjects())); 
                System.out.println("Societies: " + String.join(", ", user.getSocieties())); 
                System.out.println("Uniform Bodies: " + String.join(", ", user.getUniformBodies())); 
                System.out.println("Sports Clubs: " + String.join(", ", user.getSportsClubs())); 
                return; 
            }
        }
        System.out.println("Invalid email or password. Please try again.");
    }
    public static void register(List<User> users) {
        System.out.print("Enter email: ");
        String email = sc.nextLine().trim();
        
        if(email.startsWith("s100201@student.fop")){
            email="p01" + email;
        }

        for (User user : users) {
            if (user.getEmail().equals(email)) {
                System.out.println("Email already exists. Please try logging in.");
                return;
            }
        }

        System.out.print("Enter matric number: ");
        String matricNum = sc.nextLine().trim();
        System.out.print("Enter password: ");
        String password = sc.nextLine().trim();
        System.out.print("Enter academic subjects (comma-separated): "); 
        List<String> subjects = Arrays.asList(sc.nextLine().trim().split(",")); 
        System.out.print("Enter societies (comma-separated): "); 
        List<String> societies = Arrays.asList(sc.nextLine().trim().split(",")); 
        System.out.print("Enter uniform bodies (comma-separated): "); 
        List<String> uniformBodies = Arrays.asList(sc.nextLine().trim().split(",")); 
        System.out.print("Enter sports clubs (comma-separated): "); 
        List<String> sportsClubs = Arrays.asList(sc.nextLine().trim().split(",")); 
        
        User newUser = new User(email, matricNum, password, subjects, societies, uniformBodies, sportsClubs); 
        users.add(newUser);
        System.out.println("Registration successful! You can now log in.");
        try{
            saveUsers(users);
        }catch(IOException e){
            System.err.println("Error saving user data: "+e.getMessage());
        }
    }
    
}
