import java.util.*;
import java.io.*;
public class LoginPage {
    private static final String FILE = "UserData.txt";
    private static final Scanner sc= new Scanner(System.in); 
    
    static class User {
        private String email;
        private String matricNum;
        private String password;
        private String subjects;
        private String clubs;

        public User(String email, String matricNum, String password, String subjects, String clubs) {
            this.email = email;
            this.matricNum  = matricNum ;
            this.password = password;
            this.subjects = subjects;
            this.clubs = clubs;
        }

        public String getEmail() {
            return email;
        }

        public String getMatricNum() {
            return matricNum;
        }

        public String getPassword() {
            return password;
        }

        public String getSubjects() {
            return subjects;
        }

        public String getClubs() {
            return clubs;
        }
        
    }
    public static List<User> loadUsers() throws IOException {
        List<User> users = new ArrayList<>();
        BufferedReader inputStream = new BufferedReader(new FileReader("UserData.txt"));
        String line;

        while ((line = inputStream.readLine()) != null) {
            String email = line.trim();
            String matricNum  = inputStream.readLine().trim();
            String password = inputStream.readLine().trim();
            String subjects = inputStream.readLine().trim();
            String clubs = inputStream.readLine().trim();

            users.add(new User(email, matricNum, password, subjects, clubs));
        }
        inputStream.close();
        return users;
    }
    
    public static void saveUsers(List<User> users) throws IOException {
        FileWriter mywrite = new FileWriter("UserData.txt");
        for (User user : users) {
            mywrite.write(user.getEmail() + "\n");
            mywrite.write(user.getMatricNum () + "\n");
            mywrite.write(user.getPassword() + "\n");
            mywrite.write(user.getSubjects() + "\n");
            mywrite.write(user.getClubs() + "\n");
        }
        mywrite.close();
    }

     
    public static void createUserFile() throws IOException {  
        String userData =
                "s100201@student.fop\n" +
                "s100201\n" +
                "pw-Stud#1\n" +
                "1103,1119,1225,1249,1449,3472,4531,4541,4551,6531\n" +
                "B07,P82,S01\n" +
                "s100202@student.fop\n" +
                "\n"+
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
                return;
            }
        }
        System.out.println("Invalid email or password. Please try again.");
    }
    public static void register(List<User> users) {
        System.out.print("Enter email: ");
        String email = sc.nextLine().trim();

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
        String subjects = sc.nextLine().trim();
        System.out.print("Enter co-curricular clubs (comma-separated): ");
        String clubs = sc.nextLine().trim();

        User newUser = new User(email, matricNum, password, subjects, clubs);
        users.add(newUser);
        System.out.println("Registration successful! You can now log in.");
    }
    public static void main(String[] args) {
        try {
            createUserFile();

            List<User> users = loadUsers();

            while (true) {
                System.out.println("\nWelcome to the Login System");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1:
                        login(users);
                        break;
                    case 2:
                        register(users);
                        saveUsers(users); // Save the updated user list to the file
                        break;
                    case 3:
                        System.out.println("Thankyou!");
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


    

