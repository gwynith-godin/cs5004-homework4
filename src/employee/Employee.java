package employee;

import java.text.DecimalFormat;

public class Employee {
  private final IPaycheck delegate;
  private final String name;
  private final String id;
  private boolean isManager;

  /**
   * Constructor that represents a Salaried employee.
   *
   * @param name        name of employee
   * @param id          employee ID
   * @param payRate     pay rate of employee
   * @param payInterval pay frequency of employee
   * @param isManager   if the employee is a manager
   * @throws IllegalArgumentException if invalid pay rate is given.
   */
  public Employee(String name, String id, double payRate, int payInterval, boolean isManager)
          throws IllegalArgumentException {

    this.delegate = new SalariedPaycheck(payRate, payInterval);
    this.name = name;
    this.id = id;
    this.isManager = isManager;
  }

  /**
   * Constructor that represents an Hourly employee.
   *
   * @param name        name of employee
   * @param id          employee ID
   * @param payRate     pay rate of employee
   * @param hoursWorked number of hours worked in a week.
   * @throws IllegalArgumentException if name/ID are null or empty strings or payRate < 0.
   */

  public Employee(String name, String id, double payRate, double hoursWorked)
          throws IllegalArgumentException {
    if (name == null || name == "") {
      throw new IllegalArgumentException("Name cannot be empty or null.");
    }
    if (id == null || id == "") {
      throw new IllegalArgumentException("ID cannot be empty or null.");
    }
    this.delegate = new HourlyPaycheck(payRate, hoursWorked);
    this.name = name;
    this.id = id;
  }

  /**
   * Determine is a salaried employee is a manager or not.
   *
   * @return true or false
   */
  public boolean isManager() {
    return this.isManager;
  }

  public IPaycheck getPaycheck() {
    return this.delegate;
  }

  public String toString() {
    return "Name: " + this.name + "\nID: " + id + "\nPayment after taxes: "
            + new DecimalFormat("$ 000.00").format(this.delegate.getPayAfterTaxes());
  }
}
