import org.junit.Before;
import org.junit.Test;

import employee.SalariedPaycheck;

import static org.junit.Assert.assertEquals;

/**
 * Class that tests the SalariedPaycheck Class.
 * Tests SalariedPaycheck independently.
 */
public class SalariedPaycheckTest {
  private SalariedPaycheck paycheck1;
  private SalariedPaycheck paycheck2;
  private SalariedPaycheck paycheck3;
  private SalariedPaycheck paycheck4;

  /**
   * Construct SalariedPaycheck objects.
   */
  @Before
  public void setUp() {
    paycheck1 = new SalariedPaycheck(100500.00, 4);
    paycheck2 = new SalariedPaycheck(50698.99, 2);
    paycheck3 = new SalariedPaycheck(0.5, 1);
    paycheck4 = new SalariedPaycheck(0.25, 2);
  }

  // variable to check if decimal value meets specifications
  private static final double DELTA = 1e-2;

  /**
   * Test the getTotalPay() method.
   */
  @Test
  public void testGetTotalPay() {
    assertEquals(7730.77, paycheck1.getTotalPay(), DELTA);
    assertEquals(1949.96, paycheck2.getTotalPay(), DELTA);
    assertEquals(0.01, paycheck3.getTotalPay(), DELTA);
    assertEquals(0.01, paycheck4.getTotalPay(), DELTA);
  }

  /**
   * Test the getPayAfterTaxes() method.
   */
  @Test
  public void testGetPayAfterTaxes() {
    assertEquals(6571.15, paycheck1.getPayAfterTaxes(), DELTA);
    assertEquals(1657.47, paycheck2.getPayAfterTaxes(), DELTA);
    assertEquals(0.01, paycheck3.getPayAfterTaxes(), DELTA); // less than 0.01
  }

  /**
   * Test the getPayRate() method.
   */

  @Test
  public void testGetPayRate() {
    assertEquals(100500.00, paycheck1.getPayRate(), DELTA);
    assertEquals(0.5, paycheck3.getPayRate(), DELTA);
  }

  /**
   * Test Illegal Argument Exception.
   * If payRate < 0 upon creation.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgument_PayRate() {

    SalariedPaycheck paycheck5 = new SalariedPaycheck(-500, 2);
  }

  /**
   * Test Illegal Argument Exception.
   * If payInterval not equal to 1, 2, or 4.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgument_HoursWorked() {
    SalariedPaycheck paycheck6 = new SalariedPaycheck(6000.00, 3);
  }

  @Test
  public void testToString() {
    String testPaycheck1 = "Payment after taxes: $ 6571.15";
    String testPaycheck3 = "Payment after taxes: $ 000.01";

    assertEquals(testPaycheck1, paycheck1.toString());
    assertEquals(testPaycheck3, paycheck3.toString());

  }

}

