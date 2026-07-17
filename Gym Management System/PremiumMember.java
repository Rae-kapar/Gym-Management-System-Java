
/**
 * Write a description of class PremiumMember here.
 *The PremiumMember class is a subclass of GymMember that adds features like premium charges, 
 *personal trainer assignments, payment tracking, and discounts for premium members.
 * @author (Renu Kumari Kapar)
 * @version (2025-03-06)
 */

public class PremiumMember extends GymMember {
    //Attributes
    private static final double PREMIUM_CHARGE = 50000;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;

    //constructor
    public PremiumMember(int id3, String name3, String location3, String phone3, String email3, String gender3, String DOB3, String membershipStartDate3, String personalTrainer3) {
        super(id3, name3, location3, phone3, email3, gender3, DOB3, membershipStartDate3);
        this.personalTrainer = personalTrainer3;
        this.isFullPayment = false;
        this.paidAmount = 0.0;
        this.discountAmount = 0.0;
    }

    //Getters methods
    public String getPersonalTrainer() {
        return personalTrainer;
    }

    public boolean isFullPayment() {
        return isFullPayment;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }


    public void markAttendance() {
        attendance ++;
    loyaltyPoints +=10;
    }

    // Method to pay due amount
    public String payDueAmount(double amount) {
        if (isFullPayment) {
            return ".Payment has been fulled";
        }
        
        if (paidAmount + amount > PREMIUM_CHARGE) {
            return "Amount exceeds the premium charge. Payment not accepted.";
        }

        paidAmount += amount;

        if (paidAmount == PREMIUM_CHARGE) {
            isFullPayment = true;
            discountAmount = 0.10 * PREMIUM_CHARGE; 
            return "Payment successful. Remaining amount: 0.0. Discount applied: " + discountAmount;
        } else if (paidAmount < PREMIUM_CHARGE) {
            return "Full payment received. Remaining amount: " + (PREMIUM_CHARGE - paidAmount);
        } else {
            return "Invalid payment amount.";
        }
    }

    // Method to calculate discount
    public void calculateDiscount() {
        if (isFullPayment) {
            discountAmount = 0.10 * PREMIUM_CHARGE;
            System.out.println("Discount applied: " + discountAmount);
        } else {
            System.out.println("No discount available cause full payment has not been received.");
        }
    }

    // Method to revert PremiumMember
    public void revertPremiumMember() {
        super.resetMember(); 
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0.0;
        this.discountAmount = 0.0;
    }

    // Method to display the details
    public void display() {
        super.display(); 
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Full Payment Status: " + (isFullPayment ? "Yes" : "No"));
        double remainingAmount = PREMIUM_CHARGE - paidAmount;
        System.out.println("Remaining Amount: " + remainingAmount);
        if (isFullPayment) {
            System.out.println("Discount Amount: " + discountAmount);
        }
    }
}



