/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.*;

public class Cocurriculum {
    
    // Club data from ClubSocieties.txt
    private static final Map<String, String> clubData = new HashMap<>();

    // Categories for validation
    private static final Set<String> societiesCodes = new HashSet<>(Arrays.asList("P01", "P81", "P82"));
    private static final Set<String> uniformBodiesCodes = new HashSet<>(Arrays.asList("B01", "B03", "B07"));
    private static final Set<String> sportsClubsCodes = new HashSet<>(Arrays.asList("S01", "S10", "S15"));

    static {
        clubData.put("P01", "Computer Society");
        clubData.put("P81", "Young Entrepreneur Society");
        clubData.put("P82", "Robotic Club");
        clubData.put("B01", "Scout");
        clubData.put("B03", "Police Cadet");
        clubData.put("B07", "The Boys' Brigade");
        clubData.put("S01", "Badminton Club");
        clubData.put("S10", "Swimming Club");
        clubData.put("S15", "Fencing Club");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Collecting club codes from the user
        List<String> userSocieties = new ArrayList<>();
        List<String> userUniformBodies = new ArrayList<>();
        List<String> userSportsClubs = new ArrayList<>();

        System.out.println("Enter your Society club code (Pxx): ");
        userSocieties.add(scanner.nextLine());

        System.out.println("Enter your Uniform Body club code (Bxx): ");
        userUniformBodies.add(scanner.nextLine());

        System.out.println("Enter your Sports club code (Sxx): ");
        userSportsClubs.add(scanner.nextLine());

        // Display the collected co-curricular clubs
        displayCoCurriculum(userSocieties, userUniformBodies, userSportsClubs);
        
        scanner.close();
    }

    public static void displayCoCurriculum(List<String> userSocieties, List<String> userUniformBodies, List<String> userSportsClubs) {
        System.out.println("Your Cocurricular Clubs:");
        System.out.println("****************************************************");
        System.out.println("****************************************************");

        // Display Societies
        System.out.print("Societies: ");
        displayClubs(userSocieties, societiesCodes);

        // Display Uniform Bodies
        System.out.print("Uniform Body: ");
        displayClubs(userUniformBodies, uniformBodiesCodes);

        // Display Sports Clubs
        System.out.print("Sports Club: ");
        displayClubs(userSportsClubs, sportsClubsCodes);

        System.out.println("****************************************************");
        System.out.println("****************************************************");
        System.out.println("Generate Transcript?");
    }

    private static void displayClubs(List<String> clubs, Set<String> validCodes) {
        List<String> output = new ArrayList<>();
        for (String clubCode : clubs) {
            if (clubData.containsKey(clubCode)) {
                if (validCodes.contains(clubCode)) {
                    output.add(clubCode + "-" + clubData.get(clubCode).replace(" ", ""));
                } else {
                    output.add(clubCode + "-Invalid");
                }
            } else {
                output.add(clubCode + "-Invalid");
            }
        }
        System.out.println(String.join(", ", output));
    }
}