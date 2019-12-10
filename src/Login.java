import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
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

public class Login extends JFrame implements ActionListener{
	public static String loginFilePath = "/csv/G18User.csv";
	public static String loginRecordPath = "/csv/G18LoginRecord.csv";
	JLabel uLabel = new JLabel();
	JLabel pLabel = new JLabel();
	JButton SUBMIT = new JButton("SUBMIT");
	final JTextField UTEXTFIELD = new JTextField(15);
	final JTextField PTEXTFIELD = new JTextField(15);
	public static User user;
	Login(){
		//fields for username
		uLabel.setText("Username");

		//fields for password
		pLabel.setText("Password");

		JPanel panel = new JPanel(new GridLayout(3,1));
		panel.add(uLabel);
		panel.add(UTEXTFIELD);
		panel.add(pLabel);
		panel.add(PTEXTFIELD);
		panel.add(SUBMIT);

		add(panel, BorderLayout.CENTER);
		SUBMIT.addActionListener(this);
		setTitle("LOGIN FORM");
	}

	public void actionPerformed(ActionEvent ae) {
		String uValue = UTEXTFIELD.getText();
		String pValue = PTEXTFIELD.getText();
		verifyLogin(uValue, pValue, loginFilePath);
	}

	public static void verifyLogin(String username, String password, String filepath){
		boolean found = false;
		String line;
		try {
			Scanner scan = new Scanner(new File(filepath));
			//skip first line
			scan.nextLine();
			while(scan.hasNext() && !found){
				line = scan.nextLine();
				String[] userAttributes = line.split(",");

				if(userAttributes[2].trim().equals(username.trim()) && userAttributes[1].trim().equals(password.trim())){
					found=true;
					int uID = Integer.parseInt(userAttributes[0]);
					String pwd = userAttributes[1];
					String uName = userAttributes[2];
					String uRole = userAttributes[3];
					int yearOfBirth = Integer.parseInt(userAttributes[4]);
					String remarks = userAttributes[5];
					user = new User(uID, pwd, uName, uRole, yearOfBirth, remarks);
					//update login record of this user
					updateRecord(uID, loginRecordPath);
					if(uRole.trim().equals("Admin")){
						AdminPage admin = new AdminPage();
					}else{
						UserPage user = new UserPage();
						UserPage.welcomeLabel.setText("Welcome " + userAttributes[2]);
					}
				}else{
					System.out.println("Enter the valid username and password");
					JOptionPane.showMessageDialog(null, "Incorrect login or password", "Error", JOptionPane.ERROR_MESSAGE);
				}
				scan.close();
			}
		} catch(Exception e) {
			e.getStackTrace();
		}
	}

	public static void updateRecord(int uID, String filepath){
		LocalTime now = LocalTime.now();
		int lrID = 1;
		try {
			FileWriter fw = new FileWriter(filepath,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			pw.println(lrID+","+uID+","+now+","+"-");
			pw.flush();
			pw.close();

			JOptionPane.showMessageDialog(null, "Login record updated");
		} catch(Exception e) {
			e.getStackTrace();
		}

	}


}
