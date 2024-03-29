import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class UserPage implements ActionListener{
  public static JLabel welcomeLabel = new JLabel("Welcome");
  UserPage(){
    JFrame mainPage = new JFrame("Main User Page");
    mainPage.setSize(500, 500);
    mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainPage.setLayout(new FlowLayout());
    JButton rSixButton = new JButton("Rainbow Six");
    JButton csgoButton = new JButton("CS:GO");
    JButton lolButton = new JButton("League of Legends");
    JButton overwatchButton = new JButton("Overwatch");
    JButton displayLoginRecord = new JButton("Login Record");
    JButton aboutUs = new JButton("About Us");

    rSixButton.addActionListener(this);
    csgoButton.addActionListener(this);
    lolButton.addActionListener(this);
    overwatchButton.addActionListener(this);
    displayLoginRecord.addActionListener(this);
    aboutUs.addActionListener(this);

    mainPage.add(welcomeLabel);
    mainPage.add(rSixButton);
    mainPage.add(csgoButton);
    mainPage.add(lolButton);
    mainPage.add(overwatchButton);
    mainPage.add(displayLoginRecord);
    mainPage.add(aboutUs);

    mainPage.setVisible(true);
  }
  public void actionPerformed(ActionEvent ae){
    if(ae.getActionCommand().equals("Rainbow Six")){
      G18M4MAIN rSix = new G18M4MAIN();
    }else if(ae.getActionCommand().equals("CS:GO")){
      G18M3Register csgo = new G18M3Register();
      csgo.frame.setVisible(true);
    }else if(ae.getActionCommand().equals("League of Legends")){
      G18M2TESTMAIN league = new G18M2TESTMAIN(Login.user.getUID(), Login.user.getUID(), "21/21/2019", "Type,", "String", "REUID");
    }else if(ae.getActionCommand().equals("Overwatch")){
      G18m1WONG overwatch = new G18m1WONG();
      overwatch.setVisible(true);
    }else if(ae.getActionCommand().equals("Login Record")){
      LoginRecord record = new LoginRecord();
    }else if(ae.getActionCommand().equals("About Us")){
      AboutUs about = new AboutUs();
    }
  }
}
