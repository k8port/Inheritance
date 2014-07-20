package paytransactions;


import paytransactions.Payment;
import java.util.Arrays;
import java.util.Objects;

/**
 * Class represents a payment made with credit.
 */


/**
 *
 * @author k8port
 */
public class CreditCardPayment extends Payment {
    
    private static final int CARD_DIGITS = 16; // number of digits in a credit card number
    private String name;
    private ExpirationDate expiration;
    private int[] cardNumber;
    
    /**
     * No-Argument constructor.
     */
    public CreditCardPayment() {
        super();
        name = "no name";
        expiration = new ExpirationDate(01, 1000);
        cardNumber = new int[CARD_DIGITS];
        for (int i = 0; i < cardNumber.length; i++) {
            cardNumber[i] = 1;
        }
    }
    
    /**
     * Constructor with parameters.
     * @param theAmount the payment amount
     * @param theName the name on the credit card
     * @param theDate the expiration date on the credit card
     * @param theCardNumber the credit card number
     */
    public CreditCardPayment(double theAmount, String theName, ExpirationDate 
            theDate, int[] theCardNumber) {
        super(theAmount);
        if (theName == null || theDate == null || theCardNumber == null) {
            System.out.println("Fatal error.");
            System.exit(0);
        }
        else {
            name = theName;
            expiration = new ExpirationDate(theDate);
            cardNumber = new int[CARD_DIGITS];
            for (int i = 0; i <  cardNumber.length; i++) {
                cardNumber[i] = theCardNumber[i];
            }
        }
    }
    
    /**
     * The copy constructor.
     * @param otherPayment the payment to be copied
     */
    public CreditCardPayment(CreditCardPayment otherPayment) {
        super(otherPayment);
        name = otherPayment.name;
        expiration = new ExpirationDate(otherPayment.expiration);
        cardNumber = new int[CARD_DIGITS];
        for (int i = 0; i < cardNumber.length; i++) {
            cardNumber[i] = otherPayment.cardNumber[i];
        }
    }
    
    /**
     * @return the name on the credit card
     */
    public String getNameOnCard() {return name;}
    
    /**
     * @return the expiration date of the credit card
     */
    public ExpirationDate getExpirationDate() {return expiration;}
    
    /**
     * @return the credit card number
     */
    public int[] getCardNumber() {return cardNumber;}
    
    /**
     * To change the name on the credit card
     * @param newName the name on the credit card
     */
    public void setNameOnCard(String newName) {
        if (newName == null) {
            System.out.println("Fatal error.");
            System.exit(0);
        }
        else
            name = newName;
    }
    
    /**
     * To change the credit card expiration date
     * @param newExpiration the new expiration date of the credit card
     */
    public void setExpirationDate(ExpirationDate newExpiration) {
        if (newExpiration == null) {
            System.out.println("Fatal error.");
            System.exit(0);
        }
        else
            expiration = new ExpirationDate(newExpiration);
    }
    
    /**
     * To change the credit card number.
     * @param newCardNumber the new credit card number
     */
    public void setCardNumber(int[] newCardNumber) {
        if (newCardNumber == null) {
            System.out.println("Fatal error.");
            System.exit(0);
        }
        else 
            System.arraycopy(newCardNumber, 0, cardNumber, 0, CARD_DIGITS);
    }
    
    /**
     * Outputs an English language explanation of the payment
     */
    @Override
    public void paymentDetails() {
        StringBuilder sb = new StringBuilder();
        String pay = "A credit card payment of " + toString() + " was received. "
                + "\nName:" + name 
                + "\nExpiration Date: " + expiration.toString()
                + "\nCard Number:";
        for (int i = 0; i < CARD_DIGITS; i++) {
            sb.append(cardNumber[i]);
        }
        System.out.println(pay + "\n" + sb.toString());
        System.out.println("");
    }
    
    /**
     * @param other the other object
     * @return true if other object is same or equal
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) 
            return false;
        else if (getClass() != other.getClass())
            return false;
        else {
            CreditCardPayment otherPayment = (CreditCardPayment) other;
            return getAmount() == otherPayment.getAmount() 
                    && name.equals(otherPayment.name)
                    && expiration.equals(otherPayment.expiration)
                    && Arrays.equals(cardNumber, otherPayment.cardNumber);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.expiration);
        hash = 89 * hash + Arrays.hashCode(this.cardNumber);
        return hash;
    }
}
