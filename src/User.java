import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.*;
import java.util.Scanner;

public class User{
  private int uID;
  private String pwd;
  private String uName;
  private String uRole;
  private int yearOfBirth;
  private String remarks;
  public static String loginFilePath = "/csv/G18User.csv";

  public User(int uID, String pwd, String uName, String uRole, int yearOfBirth, String remarks){
    this.uID = uID;
    this.pwd = pwd;
    this.uName = uName;
    this.uRole = uRole;
    this.yearOfBirth = yearOfBirth;
    this.remarks = remarks;
  }
  public int getUID(){
    return uID;
  }
  public void setUID(int uID){
    this.uID = uID;
  }
  public String getPwd(){
    return pwd;
  }
  public void setPwd(String pwd){
    this.pwd = pwd;
  }
  public String getUName(){
    return uName;
  }
  public void setUName(String uName){
    this.uName = uName;
  }
  public String getURole(){
    return uRole;
  }
  public void setURole(String uRole){
    this.uRole = uRole;
  }
  public int getYearOfBirth(){
    return yearOfBirth;
  }
  public void setYearOfBirth(int yearOfBirth){
    this.yearOfBirth = yearOfBirth;
  }
  public String getRemarks(){
    return this.remarks;
  }
  public void setRemarks(String remarks){
    this.remarks = remarks;
  }

  private static int[] readUID(){
    int recordCount = 0;
    Path pathToFile = Paths.get(loginFilePath);

    try{
      BufferedReader br = Files.newBufferedReader(pathToFile);
      br.readLine();
      while(br.readLine() != null){
        recordCount++;
      }
      br.close();
      BufferedReader nbr = Files.newBufferedReader(pathToFile);
      //skip first line of csv file
      nbr.readLine();
      String line = null;
      int count = 0;
      while((line = br.readLine()) != null){
        String[] userAttributes = line.split(",");
        int[] uIDs = new int[recordCount];
        uIDs[count] = Integer.parseInt(userAttributes[0]);
      }
      return uIDs;
    } catch(IOException ioe) {
      ioe.printStackTrace();
    }
  }

  private static String[] readPwd(){
    int recordCount = 0;
    Path pathToFile = Paths.get(loginFilePath);

    try{
      BufferedReader br = Files.newBufferedReader(pathToFile);
      br.readLine();
      while(br.readLine() != null){
        recordCount++;
      }
      br.close();
      BufferedReader nbr = Files.newBufferedReader(pathToFile);
      //skip first line of csv file
      nbr.readLine();
      String line = null;
      int count = 0;
      while((line = br.readLine()) != null){
        String[] userAttributes = line.split(",");
        String[] pwds = new String[recordCount];
        pwds[count] = userAttributes[1];
      }
      return pwds;
    } catch(IOException ioe) {
      ioe.printStackTrace();
    }
  }

  private static String[] readUName(){
    int recordCount = 0;
    Path pathToFile = Paths.get(loginFilePath);

    try{
      BufferedReader br = Files.newBufferedReader(pathToFile);
      br.readLine();
      while(br.readLine() != null){
        recordCount++;
      }
      br.close();
      BufferedReader nbr = Files.newBufferedReader(pathToFile);
      //skip first line of csv file
      nbr.readLine();
      String line = null;
      int count = 0;
      while((line = br.readLine()) != null){
        String[] userAttributes = line.split(",");
        String[] unames = new String[recordCount];
        unames[count] = userAttributes[2];
      }
      return unames;
    } catch(IOException ioe) {
      ioe.printStackTrace();
    }
  }

  private static String[] readURole(){
    int recordCount = 0;
    Path pathToFile = Paths.get(loginFilePath);

    try{
      BufferedReader br = Files.newBufferedReader(pathToFile);
      br.readLine();
      while(br.readLine() != null){
        recordCount++;
      }
      br.close();
      BufferedReader nbr = Files.newBufferedReader(pathToFile);
      //skip first line of csv file
      nbr.readLine();
      String line = null;
      int count = 0;
      while((line = br.readLine()) != null){
        String[] userAttributes = line.split(",");
        String[] uRoles = new String[recordCount];
        uRoles[count] = userAttributes[3];
      }
      return uRoles;
    } catch(IOException ioe) {
      ioe.printStackTrace();
    }
  }

  private static int[] readYearOfBirth(){
    int recordCount = 0;
    Path pathToFile = Paths.get(loginFilePath);

    try{
      BufferedReader br = Files.newBufferedReader(pathToFile);
      br.readLine();
      while(br.readLine() != null){
        recordCount++;
      }
      br.close();
      BufferedReader nbr = Files.newBufferedReader(pathToFile);
      //skip first line of csv file
      nbr.readLine();
      String line = null;
      int count = 0;
      while((line = br.readLine()) != null){
        String[] userAttributes = line.split(",");
        int[] yobs = new int[recordCount];
        yobs[count] = Integer.parseInt(userAttributes[4]);
      }
      return yobs;
    } catch(IOException ioe) {
      ioe.printStackTrace();
    }
  }

  private static String[] readRemarks(){
    int recordCount = 0;
    Path pathToFile = Paths.get(loginFilePath);

    try{
      BufferedReader br = Files.newBufferedReader(pathToFile);
      br.readLine();
      while(br.readLine() != null){
        recordCount++;
      }
      br.close();
      BufferedReader nbr = Files.newBufferedReader(pathToFile);
      //skip first line of csv file
      nbr.readLine();
      String line = null;
      int count = 0;
      while((line = br.readLine()) != null){
        String[] userAttributes = line.split(",");
        String[] remarkss = new String[recordCount];
        remarkss[count] = userAttributes[3];
      }
      return remarkss;
    } catch(IOException ioe) {
      ioe.printStackTrace();
    }
  }

  public static User[] createUserFromFile(String[] metadata){
    records = recordInFile();
    int[] uID;
    uID = readUID();
    String[] pwd;
    pwd = readPwd();
    String[] uName;
    uName = readUName();
    String[] uRole;
    uRole = readURole();
    int[] yearOfBirth;
    yearOfBirth = readYearOfBirth();
    String[] remarks;
    remarks = readRemarks();

    int length = uID.length;
    User[] users = new User[length];
    for(int i=0;i<length;i++){
      users[i] = new User(uID[i], pwd[i], uName[i], uRole[i], yearOfBirth[i], remarks[i]);
    }
    return users;
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

  public static boolean validateLogin(String uName, String pass ,String filePath){
    Path pathToFile = Paths.get(filePath);
    try(BufferedReader br = Files.newBufferedReader(pathToFile)) {
      //skip first line of csv file
      br.readLine();
      String line = null;
      while((line = br.readLine()) != null ){
        String[] userAttributes = line.split(",");
        String uname = userAttributes[2];
        String pwd = userAttributes[1];
        if ((uname == uName)&&(pwd == pass)) {
          return true;
        }
      }
    } catch(IOException ioe) {
      ioe.printStackTrace();
    }
    return false;
  }
  private static int recordInFile(){
    int recordCount = 0;
    Path pathToFile = Paths.get(loginFilePath);

    try{
      BufferedReader br = Files.newBufferedReader(pathToFile);
      br.readLine();
      while(br.readLine() != null){
        recordCount++;
      }
    }catch(Exception ioe){
      ioe.printStackTrace();
    }
    return recordCount;
  }
}
