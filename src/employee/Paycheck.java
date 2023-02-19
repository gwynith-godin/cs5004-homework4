package employee;

import java.text.DecimalFormat;

/**
 * Abstract class that represents a paycheck.
 * Implements the IPaycheck protocol.
 */
public abstract class Paycheck implements IPaycheck {

  /**
   * Method that returns the pay after taxes for an employee.
   *
   * @return the pay after taxes.
   */
  @Override
  public double getPayAfterTaxes() {
    double taxedPay;
    if (this.getTotalPay() < 400) {
      taxedPay = getTotalPay() * 0.90;
    } else {
      taxedPay = getTotalPay() * 0.85;
    }
    if (taxedPay > 0 && taxedPay < 0.01) {
      taxedPay = 0.01;
    }
    return taxedPay;
  }

  /**
   * Creates a string representing the payment after taxes for an employee.
   *
   * @return a string
   */

  public String toString() {
    return "Payment after taxes: "
            + new DecimalFormat("$ ##0.00").format(this.getPayAfterTaxes());
  }

}


