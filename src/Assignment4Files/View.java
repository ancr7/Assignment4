package Assignment4Files;

import java.sql.ResultSet;

public class View implements Runnable {

  private Thread ReadThread;
  private ResultSet DBSnapshot;
  private final String DBName = "ItemTable";
  private final String query = "select * from ItemTable,TaxTable where ItemTable.id = TaxTable.id";
  static boolean alive = false;
  private DBConnect dbConnect;
//  AssignmentService assignmentService;

  View() {
    ReadThread = null;
    dbConnect = new DBConnect();
  }

  static boolean isAlive() {
    return alive;
  }

  @Override
  synchronized public void run() {
    System.out.println(DBName);
    try {
      while (WriteDB.isAlive()) {
        System.out.println("WAIT!!!!!!");
        Thread.sleep(500);
      }
      DBSnapshot = dbConnect.readDatabase(query);
      while (DBSnapshot.next()) {
        System.out.println("-----------------------------------------------------------------");
        String queryOutput =
            "name: " + DBSnapshot.getString("name") + " type: " + DBSnapshot.getString("type")
                + " price: " + DBSnapshot.getString("price") + " quantity: " + DBSnapshot
                .getString("quantity");
        System.out.println(queryOutput);
        System.out.println("-----------------------------------------------------------------");
        Thread.sleep(500);
      }
      alive = false;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void start() {
    if (ReadThread == null) {
      ReadThread = new Thread(this, DBName);
      alive = true;
      ReadThread.start();
    }
  }
}
