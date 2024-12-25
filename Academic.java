/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.*;
import java.io.*;

public class Academic {
    private static final String ACADEMIC_FILE = "AcademicSubjects.txt";
    
    public static void main(String[] args) {
        try{
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(ACADEMIC_FILE));
            
            outputStream.println("1103,Malay Language"); 
            outputStream.println("1119,English Language"); 
            outputStream.println("1223,Islamic Education"); 
            outputStream.println("1225,Moral Education"); 
            outputStream.println("1249,History"); 
            outputStream.println("1449,Mathematics"); 
            outputStream.println("1511,Science"); 
            outputStream.println("3472,Additional Mathematics"); 
            outputStream.println("3754,Entrepreneurial Studies"); 
            outputStream.println("3766,Business"); 
            outputStream.println("3756,Principles of Accounting"); 
            outputStream.println("3767,Economics"); 
            outputStream.println("4531,Physics"); 
            outputStream.println("4541,Chemistry"); 
            outputStream.println("4551,Biology"); 
            outputStream.println("6531,Chinese Language");
            System.out.println("Academic subjects saved to file.");
            
            outputStream.close();
        } catch(IOException e){
            System.out.println("Problem with file output" + e.getMessage());
        }
        
    }
        
    public static void viewAcademicSubjects() { 
        try { 
            Scanner inputStream = new Scanner(new FileInputStream("src/assignment/AcademicSubjects.txt"));
            List<String> subjects = new ArrayList<>(); 
            
            while (inputStream.hasNextLine()) { 
                subjects.add(inputStream.nextLine());
            } 
            inputStream.close(); 
            
            subjects.sort(Comparator.comparing(s -> s.split(",")[1])); 
            
            System.out.println("Enrolled Subjects:"); 
            System.out.println("============================================================================"); 
            for (String subject : subjects) { 
                String[] parts = subject.split(",");
                System.out.println(parts[0] + ": " + parts[1]); 
            } 
        } catch (FileNotFoundException e) { 
            System.out.println("File was not found: " + e.getMessage());
        }
    }
     
}
