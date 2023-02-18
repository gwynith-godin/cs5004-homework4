package employee;

import java.text.DecimalFormat;

public abstract class Paycheck implements IPaycheck {

  // hourly paycheck and salary inherit from the Paycheck class
  public Paycheck() {
  }

  /**
   * Method that returns the pay after taxes for an employee.
   *
   * @return the pay after taxes.
   */
  @Override
  public double getPayAfterTaxes() {
    double taxedPay;
    if (this.getTotalPay() < 400 && this.getTotalPay() > 0.01) {
      taxedPay = getTotalPay() * 0.90;
      return taxedPay;
    } else if (this.getTotalPay() > 400) {
      taxedPay = getTotalPay() * 0.85;
      return taxedPay;
    }
    return 0.01;
  }

  public String toString() {
    return "Payment after taxes: "
            + new DecimalFormat("$ 000.00").format(this.getPayAfterTaxes());
  }

}


