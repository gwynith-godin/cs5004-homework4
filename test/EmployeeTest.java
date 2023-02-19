import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import employee.Employee;
import employee.IPaycheck;

import org.junit.Before;
import org.junit.Test;

/**
 * Class that tests the Employee Class.
 */
public class EmployeeTest {
  private IPaycheck paycheck1;
  private IPaycheck paycheck2;
  private Employee hourly1;
  private Employee salary1;
  private Employee salary2;

  /**
   * Set up the Employee objects to use for testing.
   */
  @Before
  public void setUp() {
    hourly1 = new Employee("Mike Smith", "1234", 30.00, 20);
    salary1 = new Employee("Jen Ross", "567869", 100000, 2, true);
    salary2 = new Employee("Owen Brooks", "COOL-GUY-57", 1000000, 2, false);
  }

  /**
   * Test isManager() method.
   */
  @Test
  public void testIsManager() {
    assertTrue(salary1.isManager());
    assertFalse(salary2.isManager());
  }

  /**
   * Method that creates an hourly and salaried paycheck instance.
   * Needed to test the type return of the getPaycheck() method.
   * Then confirms if they are an IPaycheck instance.
   *
   * @return a boolean
   */

  public boolean checkPaycheckInstance() {
    paycheck1 = hourly1.getPaycheck();
    paycheck2 = salary1.getPaycheck();

    // check if paycheck1 and paycheck2 are instances od IPaycheck.
    if (paycheck1 != null
            && paycheck2 != null) {
      return true;
    }
    return false;
  }

  /**
   * Test if instances of IPaycheck are true.
   * Tests the type return of the getPaycheck() method.
   */
  @Test
  public void testCheckGetPaycheck() {
    assertTrue(checkPaycheckInstance());
  }

  /**
   * Test the toString method for the Employee class.
   * Tests the print out of the employee name, id, and pay after taxes.
   */

  @Test
  public void testToString() {
    String hourly1String = "Name: Mike Smith\n" + "ID: 1234\n"
            + "Payment after taxes: $ 510.00";
    String salaried2String = "Name: Owen Brooks\n" + "ID: COOL-GUY-57\n"
            + "Payment after taxes: $ 32692.31";
    assertEquals(hourly1String, hourly1.toString());
    assertEquals(salaried2String, salary2.toString());
  }

  /**
   * Test an IllegalArgumentException.
   * Tests an HourlyPaycheck object with an empty name string.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgument_NoNameHourly() {
    new Employee("", "123", 500.00, 80);
  }

  /**
   * Test an IllegalArgumentException.
   * Tests a SalariedPaycheck object with an empty name string.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgument_NoNameSalaried() {
    new Employee("", "1253", 500.00, 2, true);
  }

  /**
   * Test an IllegalArgumentException.
   * Tests an HourlyPaycheck object with null ID.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgument_NoIdNullHourly() {
    new Employee("Danny Devito", null, 50.00, 2);
  }

  /**
   * Test an IllegalArgumentException.
   * Tests an SalariedPaycheck object with null ID.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgument_NoIdNullSalaried() {
    new Employee("Danny Devito", null, 50.00, 2, true);
  }

  /**
   * Test an IllegalArgumentException.
   * Tests an HourlyPaycheck object with null name.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgument_NoNameNullHourly() {
    new Employee(null, "1872", 50.00, 2);
  }

  /**
   * Test an IllegalArgumentException.
   * Tests an SalariedPaycheck object with null name.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgument_NoNameNullSalaried() {
    new Employee(null, "9187239", 50.00, 2, false);
  }

}
