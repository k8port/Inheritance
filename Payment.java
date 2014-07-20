package paytransactions;

/**
 * Base Class to define a payment.
 */

import java.text.DecimalFormat;

/**
 *
 * @author k8port
 */
public class Payment {
    
    private double amount; // the payment amount
    
    /**
     * No Argument Constructor.
     */
    public Payment() {amount = 0.00;}
    
    /**
     * Constructor
     * @pre: amount must be nonnegative.
     * @param theAmount the amount to pay.
     */
    public Payment(double theAmount) {
        if (theAmount >= 0) 
            amount = theAmount;
        else {
            System.out.println("Fatal error: negative amount.");
            System.exit(0);
        }    
    }
    
    /**
     * Copy Constructor.
     * @param otherPayment the payment being copied.
     */
    public Payment(Payment otherPayment) {
        if (otherPayment == null) {
            System.out.println("Fatal error.");
            System.exit(0);
        }
        else
            amount = otherPayment.amount;
    }
    
    /**
     * @return the payment amount
     */
    public double getAmount() {return amount;}
    
    /**
     * Sets payment.
     * @pre: must be nonnegative amount
     * @param newAmount the payment amount 
     */
    public void setAmount(double newAmount) {
        if (newAmount >= 0)
            amount = newAmount;
        else {
            System.out.println("Fatal error: negative amount.");
            System.exit(0);
        }
    }
    
    /**
     * Outputs an English language explanation of the payment
     */
    public void paymentDetails() {
        System.out.println("A payment of " + toString() + " was received.");
        System.out.println("");
    }
    
    /**
     * @return a String representation of money using DecimalFormat
     */
    @Override
    public String toString() {
        DecimalFormat money = new DecimalFormat("$#0.00");
        return money.format(amount);
    }
    
    /**
     * @param other the other payment object
     * @return true if payments are equal
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) 
            return false;
        else if (getClass() != other.getClass())
            return false;
        else {
            Payment otherPayment = (Payment) other;
            return amount == otherPayment.getAmount();
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.amount) ^ (Double.doubleToLongBits(this.amount) >>> 32));
        return hash;
    }
}
