import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Rule;


public class LoanTest {

    public Loan validLoanTest = new Loan(2500,2);


    Loan nullLoan = new Loan();

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
        Loan rateLoan = new Loan(2500,2);
        assertEquals(10, rateLoan.getRate(),0);

        //These were added after code coverage analysis
        rateLoan = new Loan(7500,2);
        assertEquals(8, rateLoan.getRate(),0);

        rateLoan = new Loan(2500,4);
        assertEquals(6, rateLoan.getRate(),0);

        rateLoan = new Loan(7500,4);
        assertEquals(5, rateLoan.getRate(),0);
    }

    @Test
    public void getMonthlyPayment() {
        assertEquals(115.36,validLoanTest.getMonthlyPayment(),0.01);
    }

    @Test
    public void getTotalPayment() { assertEquals(2768.70, validLoanTest.getTotalPayment(), 0.01);
    }

    @Test
    public void constructerTest(){

        assertEquals(2500, validLoanTest.getAmount(),0);
        assertEquals(2,validLoanTest.getPeriod());
    }
}