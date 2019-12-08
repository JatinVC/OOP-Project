import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class User{
  public int uID;
  public String pwd;
  public String uName;
  public String uRole;
  public int yearOfBirth;
  public String remarks;

  public User(int uID, String pwd, String uName, String uRole, int yearOfBirth, String remarks){
    this.uID = uID;
    this.pwd = pwd;
    this.uName = uName;
    this.uRole = uRole;
    this.yearOfBirth = yearOfBirth;
    this.remarks = remarks;
  }

  //methods allowed on user
  public static List<User> getUsers(String filePath){
    return readUserFromFile(filePath);
  }
  private static List<User> readUserFromFile(String filePath){
    List<User> users = new ArrayList<>();
    Path pathToFile = Paths.get(filePath);

    try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
      //skip first line of csv file
      br.readLine();
      String line = null;
      while((line = br.readLine()) != null ){
        String[] userAttributes = line.split(",");
        users.add(createUserFromFile(userAttributes));
      }
    } catch(IOException ioe) {
      ioe.printStackTrace();
    }
    return users;
  }

  private static User createUserFromFile(String[] metadata){
    int uID = Integer.parseInt(metadata[0]);
    String pwd = metadata[1];
    String uName = metadata[2];
    String uRole = metadata[3];
    int yearOfBirth = Integer.parseInt(metadata[4]);
    String remarks = metadata[5];

    return new User(uID, pwd, uName, uRole, yearOfBirth, remarks);
  }

  public static User writeUserToFile(int uID, String pwd, String uName, String uRole, int yearOfBirth, String remarks, String filePath){
    try {
      FileWriter fw = new FileWriter(filePath, true);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter(bw);

      pw.println(uID + "," + pwd + "," + uName + "," + uRole + "," + yearOfBirth + "," + remarks);
      pw.flush();
      pw.close();

      JOptionPane.showMessageDialog(null, "Record saved to csv file");
    } catch(Exception e) {
      JOptionPane.showMessageDialog(null, "Record not saved to csv file");
    }
    return new User(uID, pwd, uName, uRole, yearOfBirth, remarks);
  }
}
