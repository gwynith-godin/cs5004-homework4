import org.junit.Before;
import org.junit.Test;

import employee.Employee;
import employee.IPaycheck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmployeeTest {
  private IPaycheck paycheck1;
  private IPaycheck paycheck2;
  private Employee hourly1;
  private Employee salary1;

  /**
   * public IPaycheck createInstance() {
   * return (IPaycheck) new Employee("Mike", "1234", 30.00, 20);
   * }
   */
  @Before
  public void setUp() {
    hourly1 = new Employee("Mike Smith", "1234", 30.00, 20);
    salary1 = new Employee("Jen Ross", "567869", 100000, 2, true);
  }

  @Test
  public void testIsManager() {
    assertTrue(salary1.isManager());
  }

  public boolean checkPaycheckInstance() {
    paycheck1 = hourly1.getPaycheck();
    paycheck2 = salary1.getPaycheck();
    if (paycheck1 instanceof IPaycheck
            && paycheck2 instanceof IPaycheck) {
      return true;
    }
    return false;
  }

  @Test
  public void testCheckGetPaycheck() {
    assertTrue(checkPaycheckInstance());
  }

  @Test
  public void testToString() {
    String hourly1String = "Name: Mike Smith\n" + "ID: 1234\n"
            + "Payment after taxes: $ 510.00";
    assertEquals(hourly1String, hourly1.toString());
  }
}
