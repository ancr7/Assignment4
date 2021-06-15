package Assignment1;

public class ImportedModel extends ItemModel {

  // method to calculate imported tax.
  public double calcTax(double total) {
    if (total < 0) throw new RuntimeException("Total cant be -ve");
    double tax = total * 0.1;
    if (total <= 100) tax += 5;
    else if (total <= 200) tax += 10;
    else tax += (total + tax) * 0.05;
    return tax;
  }
}
