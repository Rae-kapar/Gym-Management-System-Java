
/**
 * Write a description of class Gymmember here.
 *The GymMember class serves as an abstract class designed to represent the common properties 
 *and behaviors of a gym member in a fitness center or gym system. It defines essential member 
 *attributes, methods for managing membership status, and mechanisms for tracking member
 *activities.
 
  * @author (Renu Kumari Kapar)
 * @version (2025-03-06)
 */
public abstract class GymMember {
    // Attributes with protected access modifier
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    
    // Constructor
    public GymMember(int id3, String name3, String location3, String phone3, String email3, 
                     String gender3, String DOB3, String membershipStartDate3) {
        this.id = id3;
        this.name = name3;
        this.location = location3;
        this.phone = phone3;
        this.email = email3;
        this.gender = gender3;
        this.DOB = DOB3;
        this.membershipStartDate = membershipStartDate3;
        this.attendance = 0; 
        this.loyaltyPoints = 0.0; 
        this.activeStatus = false; 
    }

    // Abstract method markAttendance 
    public abstract void markAttendance();

     // Method to activate membership
    public void activateMembership() {
        if (!activeStatus) {
            activeStatus = true; 
            System.out.println("Membership activated.");
        } else {
            System.out.println("Membership is already active.");
        }
    }

     // Method to deactivate membership
    public void deactivateMembership() {
        if (activeStatus) {
            activeStatus = false;
            System.out.println("Membership deactivated.");
        } else {
            System.out.println("Membership is not active, cannot deactivate.");
        }
    }

    // Method to reset the member details
    public void resetMember() {
        this.activeStatus = false;
        this.attendance = 0;
        this.loyaltyPoints = 0.0;
    }

    //Getters method
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getDOB() {
        return DOB;
    }

    public String getMembershipStartDate() {
        return membershipStartDate;
    }

    public int getAttendance() {
        return attendance;
    }

    public double getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }
    // Method to display member details
    public void display() {
        System.out.println("Gym Member Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("DOB: " + DOB);
        System.out.println("Membership Start Date: " + membershipStartDate);
        System.out.println("Attendance: " + attendance);
        System.out.println("Loyalty Points: " + loyaltyPoints);
        System.out.println("Active Status: " + (activeStatus ? "Active" : "Inactive"));
    }
}
