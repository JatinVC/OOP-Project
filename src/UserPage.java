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
      //launch rainbow individual section
    }else if(ae.getActionCommand().equals("CS:GO")){
      //launch csgo individual section
    }else if(ae.getActionCommand().equals("League of Legends")){
      //launch league of legends individual section
    }else if(ae.getActionCommand().equals("Overwatch")){
      //launch overwatch individual section
    }else if(ae.getActionCommand().equals("Login Record")){
      //display login record
    }else if(ae.getActionCommand().equals("About Us")){
      AboutUs about = new AboutUs();
      about.setVisible(true);
    }
  }
}
