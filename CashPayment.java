package paytransactions;

/**
 * Class represents a payment made in cash.
 */


/**
 *
 * @author k8port
 */
public class CashPayment extends Payment {
   
    /**
     * No-Argument constructor.
     */
    public CashPayment() {super();}
    
    /**
     * Constructor with parameters
     * @param theAmount the payment amount
     */
    public CashPayment(double theAmount) {
        super(theAmount);
    }
    
    /**
     * The copy constructor.
     * @param otherCashPayment the payment to be copied.
     */
    public CashPayment(CashPayment otherCashPayment) {super(otherCashPayment);}
    
    /**
     * Outputs an English language explanation of the payment
     */
    @Override
    public void paymentDetails() {
        System.out.println("A cash payment of " + toString() + " was received.");
        System.out.println("");
    }
}
