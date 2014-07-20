/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paytransactions;

/**
 *
 * @author k8port
 */
public class PayTransactions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] x = {5, 6, 7, 8, 3, 4, 5, 6, 3, 6, 3, 6, 0, 9, 9, 9};
        int[] y = {6, 7, 1, 1, 3, 4, 5, 6, 0, 2, 2, 2, 3, 5, 6, 7};
        
        CashPayment albertsons = new CashPayment();
        CashPayment cigarrette = new CashPayment(81.20);
        CashPayment fare = new CashPayment(albertsons);
        
        fare.setAmount(2.25);
        
        CreditCardPayment target = new CreditCardPayment();
        CreditCardPayment giant = new CreditCardPayment(216.77, "PP James", 
                new ExpirationDate(1, 2017), y);
        CreditCardPayment pizza = new CreditCardPayment(target);
        
        pizza.setCardNumber(x);
        pizza.setAmount(13.45);
        pizza.setExpirationDate(new ExpirationDate(07, 2016));
        pizza.setNameOnCard("Lois Lane");
        
        albertsons.paymentDetails();
        cigarrette.paymentDetails();
        fare.paymentDetails();
        target.paymentDetails();
        giant.paymentDetails();
        pizza.paymentDetails();
    }
    
}
