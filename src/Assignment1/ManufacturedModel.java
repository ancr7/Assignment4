package Assignment1;

public class ManufacturedModel extends ItemModel {

  // method to calculate manufactured tax.
  public double calcTax(double total) {
    if (total < 0) throw new RuntimeException("Total cant be -ve");
    double tax = 0;
    tax += total * 12.5 / 100;
    tax += (total + tax) * 2.0 / 100;
    return tax;
  }
}
