
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
@RunWith(value = Parameterized.class)
public class LoanNegativeTest {


    // The amount of the loan
    private double loanAmount;
    // The length of loan
    private int period;


    public LoanNegativeTest(Double loanAmount, int period){

        this.loanAmount = loanAmount;
        this.period = period;
    }

    @Parameterized.Parameters(name = "{index}: checkInput({1})={0}")
    public static Collection<Object[]> getTestParameters(){
        return Arrays.asList(new Object[][]
                {
                        {499.99, 2},
                        {5000.01, 2},
                        {5000.99, 2},
                        {10000.01, 2},
                        {2500, 0},
                        {7500, 6},
                        {"testing", 2},
                        {7500, "testing"},
                        {0.0,0}
                }

        );
    }

    @Rule public ExpectedException exception = ExpectedException.none();

    @Test
    public void getAmount() {
        exception.expect(IllegalArgumentException.class);
        //exception.expectMessage(containsString(""));
        Loan loanNegativeTest = new Loan(loanAmount, period);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getPeriod() {
        Loan loanNegativeTest = new Loan(loanAmount, period);
    }
}