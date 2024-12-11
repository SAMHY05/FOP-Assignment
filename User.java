import java.util.List;
public class User {
    private String email;
    private String matricNum;
    private String password;
    private List<String>subjects;
    private List<String>clubs;
    
    public User(String email,String matricNum,String password,List<String>subjects,List<String>clubs){
        this.email=email;
        this.matricNum=matricNum;
        this.password=password;
        this.subjects=subjects;
        this.clubs=clubs;
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
    public List<String> getClubs(){
     return clubs;
    }
    public void setClubs(List<String>clubs){
     this.clubs=clubs;
    }

    public String toString(){
        return "<User Account> "+"\n"+
               "\nStudent Email: "+email+
               "\nMatric Number: "+matricNum+
               "\nPassword: "+password+
               "\nAcademic Subjects: "+String.join(", ", subjects)+
               "\nCo-curricular Clubs: "+String.join(", ",clubs);
    }

    public static void main(String[] args) {
      List<String>subjects=List.of("Computing Mathematics","Fundamental of Programming","Computer System and Organisation");
       List<String>clubs=List.of("English Club","Robotics Club");
       
       User user1=new User("24004567@siswa.um.edu.my","24004567","1234567",subjects,clubs);
       System.out.println(user1.toString());
    }
    
}
