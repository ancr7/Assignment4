package Assignment4Files;

import Assignment1.ItemModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnect {

  //  private  DBConnect single_instance;
  private Statement statement;

  public DBConnect() {
    Connection connection;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url = "jdbc:mysql://127.0.0.1:3306/assignment";
      Properties info = new Properties();
      info.put("user", "admin");
      info.put("password", "Password@123");

      connection = DriverManager.getConnection(url, info);
      statement = connection.createStatement();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

//  public static DBConnect getInstance() {
//    if (single_instance == null) {
//      try {
//        single_instance = new DBConnect();
//      } catch (Exception e) {
//        e.printStackTrace();
//      }
//    }
//    return single_instance;
//  }

  public ResultSet readDatabase(String query) {
    try {
      return statement.executeQuery(query);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void writeDatabase(String DBName, ItemModel model) {
    try {

      statement.executeUpdate(
          "INSERT INTO " + DBName + " values(" + model.getId() + "," + model.getTax() + ")");

      System.out.println("Data Written to DB " + model.getName());

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}
