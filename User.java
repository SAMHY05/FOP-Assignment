/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.List;

public class User {
    private String email;
    private String matricNum;
    private String password;
    private List<String> subjects;
    private List<String> societies; 
    private List<String> uniformBodies; 
    private List<String> sportsClubs;
    
    public User(String email, String matricNum, String password, List<String>subjects, List<String> societies, List<String> uniformBodies, List<String> sportsClubs) {
        this.email = email;
        this.matricNum = matricNum;
        this.password = password;
        this.subjects = subjects;
        this.societies = societies; 
        this.uniformBodies = uniformBodies; 
        this.sportsClubs = sportsClubs;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getMatricNum(){
        return matricNum;
    }
    public void setMatricNum(String matricNum){
        this.matricNum=matricNum;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public List<String> getSubjects(){
        return subjects;
    }
    public void setSubjects(List<String>subjects){
        this.subjects=subjects;
    }
    public List<String> getSocieties() { 
        return societies; 
    } 
    public void setSocieties(List<String> societies) { 
        this.societies = societies; 
    } 
    public List<String> getUniformBodies() { 
        return uniformBodies; 
    } 
    public void setUniformBodies(List<String> uniformBodies) { 
        this.uniformBodies = uniformBodies; 
    } 
    public List<String> getSportsClubs() { 
        return sportsClubs; 
    } 
    public void setSportsClubs(List<String> sportsClubs) { 
        this.sportsClubs = sportsClubs; 
    }

    public String toString() {
        return "<User Account>" + "\n" +
               "Student Email: " + email + "\n" +
               "Matric Number: " + matricNum + "\n" +
               "Password: " + password + "\n" +
               "Academic Subjects: " + String.join(", ", subjects) + "\n" +
               "Societies: " + String.join(", ", societies) + "\n" + 
               "Uniform Bodies: " + String.join(", ", uniformBodies) + "\n" + 
               "Sports Clubs: " + String.join(", ", sportsClubs);
    }
    
}
