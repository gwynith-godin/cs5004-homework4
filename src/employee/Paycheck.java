package employee;

import java.text.DecimalFormat;

import java.math.BigDecimal;

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
    if (this.getTotalPay() < 400) {
      taxedPay = getTotalPay() * 0.90;}
    else {
      taxedPay = getTotalPay() * 0.85;
    }
    if(taxedPay > 0 && taxedPay < 0.01){
      taxedPay = 0.01;
    }
      return taxedPay;
  }

  public String toString() {
    return "Payment after taxes: "
            + new DecimalFormat("$ ###.00").format(this.getPayAfterTaxes());
  }

}


