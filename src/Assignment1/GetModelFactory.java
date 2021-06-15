package Assignment1;

public class GetModelFactory {

  public static ItemModel getModel(String type) {
    if (type == null) {
      return null;
    }
    switch (type) {
      case "RAW":
        return new RawModel();
      case "IMPORTED":
        return new ImportedModel();
      case "MANUFACTURED":
        return new ManufacturedModel();
    }
    return null;
  }
}
