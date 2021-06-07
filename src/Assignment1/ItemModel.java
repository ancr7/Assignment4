package Assignment1;

public class ItemModel {

  // all member variables
  String name;
  types type;
  double price, tax;
  int quantity, id;

  enum types {
    RAW,
    MANUFACTURED,
    IMPORTED;

    public static boolean contains(String test) {
      for (types c : types.values()) {
        if (c.name().toLowerCase().equals(test.toLowerCase())) return true;
      }
      return false;
    }
  }

  // getter methods
  public String getName() {return name; }

  public double getPrice() {return price; }

  public double getTax() {return tax; }

  public int getQuantity() { return quantity; }

  public types getType() { return type; }

  public int getId() { return id; }

  // setter methods

  public void setId(final int id) { this.id = id; }

  public void setName(String name) { this.name = name; }

  public void setPrice(double price) { this.price = price; }

  public void setTax(double tax) { this.tax = tax; }

  public void setQuantity(int quantity) { this.quantity = quantity; }

  public void setType(types type) { this.type = type; }

}
