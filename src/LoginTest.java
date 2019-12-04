import javax.swing.*;
public class LoginTest{
  public static void main(String[] args){
    try{
      Login frame = new Login();
      frame.setSize(300, 100);
      frame.setVisible(true);
    }catch(Exception e){
      JOptionPane.showMessageDialog(null, e.getMessage());
    }
  }
}
