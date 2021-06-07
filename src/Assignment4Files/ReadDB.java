package Assignment4Files;

import Assignment1.AssignmentService;
import Assignment1.ItemModel;
import java.sql.ResultSet;
import java.util.LinkedList;

public class ReadDB extends DataInterface implements Runnable {

  private Thread ReadThread;
  private final ResultSet DBSnapshot;
  private final String DBName = "ItemTable";

  static boolean alive = false;
//  private
//  AssignmentService assignmentService;

  ReadDB() {
    Data = new LinkedList<>();
    ReadThread = null;
    String query = "select * from " + DBName;
    this.DBSnapshot = new DBConnect().readDatabase(query);
  }

  static boolean isAlive() {
    return alive;
  }

  @Override
  public void run() {
    System.out.println(DBName);
    try {

      while (DBSnapshot.next()) {
        String queryInput =
            "-name " + DBSnapshot.getString("name") + " -type " + DBSnapshot.getString("type")
                + " -price " + DBSnapshot.getString("price") + " -quantity " + DBSnapshot
                .getString("quantity");

        ItemModel model = new ItemModel();
        AssignmentService assignmentService = new AssignmentService(model);

        model.setId(Integer.parseInt(DBSnapshot.getString("id")));
        double total = assignmentService.processInput(queryInput);
        if (total >= 0) {
          System.out.println("Data Added " + model.getId());
          Data.add(model);
        } else {
          System.out.println("Error!");
        }
        Thread.sleep(500);
      }
      alive = false;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void start() {
//    System.out.println("Starting " +  DBName );
    if (ReadThread == null) {
      ReadThread = new Thread(this, DBName);
      alive = true;
      ReadThread.start();
    }
  }
}
