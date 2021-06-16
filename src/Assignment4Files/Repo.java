package Assignment4Files;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Repo {

  private Statement statement;

  Repo() {
    try {
      Connection connection = DBConnect.getInstance().getConnection();
      statement = connection.createStatement();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public ResultSet readDatabase(String query) {
    try {
      return statement.executeQuery(query);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void writeDatabase(String query) {
    try {
      statement.executeUpdate(query);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}