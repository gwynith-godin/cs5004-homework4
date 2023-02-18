package employee;

/**
 * Interface that represents an employee paycheck.
 */
public interface IPaycheck {

  /**
   * Method that returns the total pay of an employee.
   *
   * @return the total pay
   */
  double getTotalPay();

  /**
   * Method that returns the pay after taxes for an employee.
   *
   * @return the pay after taxes.
   */
  double getPayAfterTaxes();

  /**
   * Method that returns the pay rate of the employee.
   * Salaried employee pay rate is a yearly salary.
   * Hourly employee pay rate is an hourly rate.
   *
   * @return the pay rate
   */
  double getPayRate();
}
