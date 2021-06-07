package Assignment4Files;

import Assignment1.ItemModel;

public class WriteDB extends DataInterface implements Runnable {

  private Thread WriteThread;
  private final String DBName = "TaxTable";
  static boolean alive = false;
  private DBConnect dbConnect;

  public WriteDB() {
    WriteThread = null;
    dbConnect = new DBConnect();
  }

  static boolean isAlive() {
    return alive;
  }

  @Override
  synchronized public void run() {
    try {
      while (ReadDB.isAlive() || !Data.isEmpty()) {

        while (Data.isEmpty()) {
          if (!ReadDB.isAlive()) break;
          System.out.println("wait");
          Thread.sleep(1000);
        }
        if (!ReadDB.isAlive()) break;

        ItemModel model = Data.poll();
        dbConnect.writeDatabase(DBName, model);
      }
      alive = false;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void start() {
    if (WriteThread == null) {
      WriteThread = new Thread(this, DBName);
      alive = true;
      WriteThread.start();
    }
  }
}
