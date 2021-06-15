package Assignment1;

public class AssignmentService {

  private ItemModel model;

  public AssignmentService() {}

  public AssignmentService(ItemModel model) {this.model = model;}

  // method to calculate total cost.
  double calculateCost() {
    double totalCost = model.getPrice() * model.getQuantity();
//    double tax = model.calcTax(totalCost);
    double tax = 0;
//    if (model.getType().equals(ItemModel.types.RAW)) tax += rawTax(totalCost);
//    if (model.getType().equals(ItemModel.types.MANUFACTURED))
//      tax += manufacturedTax(totalCost);
//    if (model.getType().equals(ItemModel.types.IMPORTED)) tax += importedTax(totalCost);
//    model.setTax(tax);
    return totalCost + tax;
  }



  // validate input method
  boolean isInputValid(String inputString) {

    // input can have only 1 name argument
    if (inputString.split("-name", -1).length - 1 != 1) {
      System.out.println("Invalid name");
      return false;
    }

    // input can have only 1 price argument
    if (inputString.split("-price", -1).length - 1 != 1) {
      System.out.println("Invalid price");
      return false;
    }

    // input can have only 1 quantity argument
    if (inputString.split("-quantity", -1).length - 1 != 1) {
      System.out.println("Invalid quantity");
      return false;
    }

    // input can have only 1 type argument
    if (inputString.split("-type", -1).length - 1 != 1) {
      System.out.println("Invalid type");
      return false;
    }

    // input should begin with name argument
    if (inputString.indexOf("-name") != 0) {
      System.out.println("Invalid name position");
      return false;
    }

    String name = extractWord(inputString, inputString.indexOf("-name") + 5).trim();
    String quantity = extractWord(inputString, inputString.indexOf("-quantity") + 9).trim();
    String price = extractWord(inputString, inputString.indexOf("-price") + 6).trim();
    String type = extractWord(inputString, inputString.indexOf("-type") + 5).trim();

    // check name empty
    if (name.isEmpty() && !name.matches("^[ A-Za-z]+$")) {
      System.out.println("Invalid name");
      return false;
    }
    // check price empty price should only have numbers and can have decimal (.) once.
    if (price.isEmpty() || !price.matches("[0-9.]*")
        || price.length() - price.replace(".", "").length() > 1) {
      System.out.println("Invalid price");
      return false;
    }
    // check quantity empty quantity should only have numbers.
    if (quantity.isEmpty() || !quantity.matches("[0-9]*") || Integer.parseInt(quantity) <= 0) {
      System.out.println("Invalid quantity");
      return false;
    }
    // check type empty
    if (type.isEmpty()) {
      System.out.println("Invalid type");
      return false;
    }
    switch (type) {
      case "RAW":
      case "IMPORTED":
      case "MANUFACTURED":
        break;
      default:
        return false;
    }
    return true;
  }

  // extract input method
  void extractData(String inputString) {
    String name = extractWord(inputString, inputString.indexOf("-name") + 5).trim();
    String quantity = extractWord(inputString, inputString.indexOf("-quantity") + 9).trim();
    String price = extractWord(inputString, inputString.indexOf("-price") + 6).trim();
    String type = extractWord(inputString, inputString.indexOf("-type") + 5).trim().toUpperCase();
//    model.setType(ItemModel.types.valueOf(type.toUpperCase()));
    model = GetModelFactory.getModel(type);
    // store data into model
    model.setName(name);
    model.setPrice(Double.parseDouble(price));
    model.setQuantity(Integer.parseInt(quantity));
  }

  public double processInput(String inputString) {
    // 1. validate input
    if (!isInputValid(inputString)) return -1;
    // 2. if input is valid, extract input then store into model class
    extractData(inputString);
    // 3. calculate tax and return final data to controller
//    System.out.println("Data Extracted sucessfully");
    return calculateCost();
  }
}
