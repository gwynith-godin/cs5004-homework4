package employee;

/**
 * Class that represents an hourly employee paycheck.
 */
public class HourlyPaycheck extends Paycheck implements IPaycheck {

  private double payRate;
  private double hoursWorked;

  /**
   * Constructor for the hourly paycheck employee.
   *
   * @param payRate     hourly pay rate of the employee
   * @param hoursWorked number of hours worked per week (up to 40 hours).
   * @throws IllegalArgumentException if the pay rate or hours worked is < 0.
   */
  public HourlyPaycheck(double payRate, double hoursWorked) throws IllegalArgumentException {
    if (payRate < 0 || hoursWorked < 0) {
      throw new IllegalArgumentException("Pay rate or hours worked cannot be less than 0.");
    }
    this.payRate = payRate;
    this.hoursWorked = hoursWorked;
  }

  /**
   * Method that returns the total pay of an hourly employee.
   * Method accounts for overtime (time worked over 40 hours).
   *
   * @return the total pay
   */
  @Override
  public double getTotalPay() {
    double overtime = this.hoursWorked - 40;
    double totalPay;
    if (overtime > 0) {
      totalPay = (this.payRate * 40) + (overtime * (payRate * 1.5));
    } else {
      totalPay = this.payRate * this.hoursWorked;
    }
    if (totalPay > 0 && totalPay < 0.01) {
      return 0.01;
    }
    return totalPay;
  }

  /**
   * Method that returns the pay rate of the employee.
   * Hourly employee pay rate is an hourly rate.
   *
   * @return the pay rate
   */

  @Override
  public double getPayRate() {
    return this.payRate;
  }

  /**
   * Method that returns the current hours worked for a paycheck.
   *
   * @return the current hours worked.
   */
  public double getHoursWorked() {
    return this.hoursWorked;
  }

  /**
   * Method that adds (or subtracts) hours to current hours worked.
   *
   * @param hoursAdded the hours to be added (or subtracted)
   */
  public void addHoursWorked(double hoursAdded) {
    double newHours = this.hoursWorked + hoursAdded;
    if (newHours > 0) {
      this.hoursWorked = newHours;
    }
  }

  /**
   * Method that resets the hours worked to 0.
   */
  public void resetHoursWorked() {
    this.hoursWorked = 0;
  }

}
