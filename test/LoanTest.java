import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Rule;


public class LoanTest {

    public Loan validLoanTest = new Loan(2500,2);



    @Test
    public void getAmount() {
        assertEquals(2500, validLoanTest.getAmount(),0);
    }

    @Test
    public void getPeriod() {
        assertEquals(2, validLoanTest.getPeriod(),0);
    }

    @Test
    public void getRate() {
        assertEquals(10, validLoanTest.getRate(),0);
    }

    @Test
    public void getMonthlyPayment() {
        assertEquals(114.83,validLoanTest.getMonthlyPayment(),0);
    }

    @Test
    public void getTotalPayment() {
    }

    @Test
    public void constructerTest(){

        assertEquals(2500, validLoanTest.getAmount(),0);
        assertEquals(2,validLoanTest.getPeriod());
    }
}