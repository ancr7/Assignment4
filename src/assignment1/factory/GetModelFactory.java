package assignment1.factory;

import assignment1.models.ImportedModel;
import assignment1.models.ItemModel;
import assignment1.models.ManufacturedModel;
import assignment1.models.RawModel;
import static assignment1.constants.Constant.*;

public class GetModelFactory {

  public static ItemModel getModel(String type) {
    if (type == null) {
      return null;
    }
    switch (type) {
      case RAW:
        return new RawModel();
      case IMPORTED:
        return new ImportedModel();
      case MANUFACTURED:
        return new ManufacturedModel();
    }
    return null;
  }
}
