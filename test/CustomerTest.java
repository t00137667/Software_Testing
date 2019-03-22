import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Customer.class)

public class CustomerTest {

    @Test
    public void testOwner() throws Exception {
        System.out.println("in test");
        Customer buddyLoan = new Customer();

        /*call the createMock to create a mock for the Owner class */
        Loan mockLoan = EasyMock.createMock(Loan.class);

        /* Tell PowerMock to intercept any new call and return mockOwner */
        PowerMock.expectNew(Loan.class,5000.00,5).andReturn(mockLoan);

        /* set up the expected values and return values */
        expect(mockLoan.getMonthlyPayment()).andReturn(96.66);

        /*activate the mock */
        PowerMock.replay(mockLoan, Loan.class);

        double expResult = 96.66;
        buddyLoan.takeoutloan();
        double result = buddyLoan.getMonthlypayments();
        assertEquals(expResult, result, 0.01);
        /* verify that PowerMock was called and used */
        PowerMock.verify(mockLoan, Loan.class);
    }

}