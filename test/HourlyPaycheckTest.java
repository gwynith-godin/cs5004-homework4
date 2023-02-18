import org.junit.Before;
import org.junit.Test;

import employee.HourlyPaycheck;

import static org.junit.Assert.assertEquals;

/**
 * Class that tests the HourlyPaycheck Class.
 * Tests HourlyPaycheck independently.
 */
public class HourlyPaycheckTest {
  private HourlyPaycheck paycheck1;
  private HourlyPaycheck paycheck2;
  private HourlyPaycheck paycheck3;
  private HourlyPaycheck paycheck4;

  /**
   * Construct HourlyPaycheck objects.
   */
  @Before
  public void setUp() {
    paycheck1 = new HourlyPaycheck(20.00, 40);
    paycheck2 = new HourlyPaycheck(33.98, 55);
    paycheck3 = new HourlyPaycheck(13, 15.5);
    paycheck4 = new HourlyPaycheck(0.0034, 10);
  }

  // variable to check if decimal value meets specifications
  private static final double DELTA = 1e-5;

  /**
   * Test the getTotalPay() method.
   */
  @Test
  public void testGetTotalPay() {
    assertEquals(800.00, paycheck1.getTotalPay(), DELTA);
    assertEquals(2123.75, paycheck2.getTotalPay(), DELTA); // 1359.2 + 764.55
    assertEquals(201.5, paycheck3.getTotalPay(), DELTA);
  }

  /**
   * Test the getPayAfterTaxes() method.
   */
  @Test
  public void testGetPayAfterTaxes() {
    assertEquals(680.00, paycheck1.getPayAfterTaxes(), DELTA);
    assertEquals(1805.19, paycheck2.getPayAfterTaxes(), DELTA);
    assertEquals(181.35, paycheck3.getPayAfterTaxes(), DELTA); // less than 400
  }

  /**
   * Test the getPayRate() method.
   */

  @Test
  public void testGetPayRate() {
    assertEquals(20.00, paycheck1.getPayRate(), DELTA);
    assertEquals(13.00, paycheck3.getPayRate(), DELTA);
  }

  /**
   * Test the getHoursWorked() method.
   */

  @Test
  public void testGetHoursWorked() {
    assertEquals(40.00, paycheck1.getHoursWorked(), DELTA);
    assertEquals(15.50, paycheck3.getHoursWorked(), DELTA);
  }

  /**
   * Test the addHoursWorked() method.
   */

  @Test
  public void testAddHoursWorked() {
    paycheck1.addHoursWorked(30);
    paycheck2.addHoursWorked(-14);
    assertEquals(70.00, paycheck1.getHoursWorked(), DELTA);
    assertEquals(41.00, paycheck2.getHoursWorked(), DELTA);

    // check if reducing hours to negative number changes.
    // hours should not be changed if this is the case.
    paycheck3.addHoursWorked(-16);
    assertEquals(15.5, paycheck3.getHoursWorked(), DELTA);
  }

  /**
   * Test the resetHoursWorked() method.
   */
  @Test
  public void testResetHoursWorked() {
    paycheck1.resetHoursWorked();
    paycheck2.resetHoursWorked();
    assertEquals(0, paycheck1.getHoursWorked(), DELTA);
    assertEquals(0, paycheck2.getHoursWorked(), DELTA);
  }

  /**
   * Test Illegal Argument Exception.
   * If payRate < 0 upon creation.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgument_PayRate() {
    HourlyPaycheck paycheck4 = new HourlyPaycheck(8, -5);
  }

  /**
   * Test Illegal Argument Exception.
   * If HoursWorked < 0 upon creation.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgument_HoursWorked() {
    HourlyPaycheck paycheck5 = new HourlyPaycheck(-8, 50);
  }

  @Test
  public void testToString() {
    String testPaycheck1 = "Payment after taxes: $ 680.00";
    String testPaycheck2 = "Payment after taxes: $ 1805.19";

    assertEquals(testPaycheck1, paycheck1.toString());
    assertEquals(testPaycheck2, paycheck2.toString());

  }

}
