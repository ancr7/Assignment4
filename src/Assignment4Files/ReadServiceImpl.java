package Assignment4Files;

import Assignment1.AssignmentService;
import Assignment1.ItemModel;
import java.sql.ResultSet;

class ReadServiceImpl implements DBService, Runnable {

  private Thread readThread;
  private final ResultSet dbSnapshot;
  private final String dbName = "ItemTable";
  static boolean alive = false;

  ReadServiceImpl() {
    readThread = null;
    String query = "select * from " + dbName;
    this.dbSnapshot = new Repo().readDatabase(query);
  }

  static boolean isAlive() {
    return alive;
  }

  @Override
  public void run() {
    System.out.println(dbName);
    try {
      while (dbSnapshot.next()) {
        String queryInput =
            "-name " + dbSnapshot.getString("name") + " -type " + dbSnapshot.getString("type")
                + " -price " + dbSnapshot.getString("price") + " -quantity " + dbSnapshot
                .getString("quantity");

        ItemModel model = new ItemModel();
        AssignmentService assignmentService = new AssignmentService(model);

        model.setId(Integer.parseInt(dbSnapshot.getString("id")));

        double total = assignmentService.processInput(queryInput);

        if (total >= 0) {
          System.out.println("DB Read " + model.getName());
          data.add(model);
        } else {
          System.out.println("Data Invalid!");
        }
        Thread.sleep(1);
      }
      alive = false;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void start() {
//    System.out.println("Starting " +  DBName );
    if (readThread == null) {
      readThread = new Thread(this, dbName);
      alive = true;
      readThread.start();
    }
  }
}
