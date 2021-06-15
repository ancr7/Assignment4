package Assignment1;

public class RawModel extends ItemModel {

  // method to calculate raw tax.
  public double calcTax(double total) {
    if (total < 0) throw new RuntimeException("Total cant be -ve");
    double tax = 0;
    tax += total * 12.50 / 100;
    return tax;
  }

}
