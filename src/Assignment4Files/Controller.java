package Assignment4Files;

public class Controller {

  public static void main(String[] args) {
    ReadServiceImpl readServiceImpl = new ReadServiceImpl();
    WriteServiceImpl writeServiceImpl = new WriteServiceImpl();
    View view = new View();
    readServiceImpl.start();
    writeServiceImpl.start();
    view.start();
  }
}
