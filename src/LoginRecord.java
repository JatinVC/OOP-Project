import java.util.ArrayList;
import java.util.List;
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
import java.io.File;

public class LoginRecord{
  JFrame frame;
  JTable table;
  LoginRecord(){
    frame = new JFrame("Login Record");
    String[] columnNames = {"LR_ID","U_ID","Login Time","Remarks"};
    List<String[]> data = new ArrayList<String[]>();
    try {
      Scanner scan = new Scanner(new File(Login.loginRecordPath));
      scan.nextLine();
      String[] line;
      while(scan.hasNext()){
        int uID = Login.user.getUID();
        line = scan.nextLine().split(",");
        if(line[1].equals(Integer.toString(uID))){
          data.add(line);
        }
      }
      String[][] rowData = data.toArray(new String[0][]);
      table = new JTable(rowData, columnNames);
      table.setBounds(30,40,200,300);
      JScrollPane sp = new JScrollPane(table);
      frame.add(sp);
      frame.setSize(500,200);
      frame.setVisible(true);
      scan.close();
    } catch(Exception e) {
      JOptionPane.showMessageDialog(null,e.getMessage());
    }
  }

  public static void main(String[] args) {
    LoginRecord login = new LoginRecord();
  }
}
