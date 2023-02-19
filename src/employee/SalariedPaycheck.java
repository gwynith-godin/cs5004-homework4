package employee;

/**
 * Class that represents a salaried employee paycheck.
 * Implements the IPaycheck protocol.
 * Extends Paycheck Abstract class.
 */
public class SalariedPaycheck extends Paycheck implements IPaycheck {
  private double payRate;
  private double payInterval;

  /**
   * Constructor for the salary paycheck employee.
   *
   * @param payRate     the pay rate of the employee (YTD).
   * @param payInterval the pay interval: weekly, bi-weekly, or quarterly.
   * @throws IllegalArgumentException if the pay rate or pay interval is < 0.
   */
  public SalariedPaycheck(double payRate, int payInterval)
          throws IllegalArgumentException {
    if (payRate < 0) {
      throw new IllegalArgumentException("Pay rate cannot be less than 0.");
    } else {
      this.payRate = payRate;
    }
    if (payInterval == 1 || payInterval == 2 || payInterval == 4) {
      this.payInterval = payInterval;
    } else {
      throw new IllegalArgumentException("Pay interval has to be 1, 2, or 4.");
    }
  }

  /**
   * Method that returns the total pay of a salaried employee.
   *
   * @return the total pay
   */
  @Override
  public double getTotalPay() {
    double totalPay;
    totalPay = (getPayRate() / 52) * this.payInterval;
    /**
    if (totalPay > 0 && totalPay < 0.01) {
      return 0.01;
    }
     */
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
}
