package Assignment4Files;

public class Controller {
  public static void main(String[] args) throws InterruptedException {
    ReadDB readDB = new ReadDB();
    WriteDB writeDB = new WriteDB();
    View view = new View();
    readDB.start();
    writeDB.start();
    view.start();
  }
}
