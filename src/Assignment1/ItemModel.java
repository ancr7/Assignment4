package Assignment1;

public  class ItemModel {

  // all member variables
  private String name;
  private double price, tax;
  private int quantity, id;

  // getter methods
  public String getName() {return name; }

  public double getPrice() {return price; }

  public double getTax() {return tax; }

  public int getQuantity() { return quantity; }

  public int getId() { return id; }

  // setter methods
  public void setId(final int id) { this.id = id; }

  public void setName(String name) { this.name = name; }

  public void setPrice(double price) { this.price = price; }

  public void setTax(double tax) { this.tax = tax; }

  public void setQuantity(int quantity) { this.quantity = quantity; }

//   double calcTax(double total);
}
