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
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login extends JFrame implements ActionListener{
	public static String loginFilePath = "G18User.csv";
	public static String loginRecordPath = "G18LoginRecord.csv";
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
		verifyLogin(uValue, encryptPwd(pValue), loginFilePath);
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
					String pwd = encryptPwd(userAttributes[1]);
					String uName = userAttributes[2];
					String uRole = userAttributes[3];
					int yearOfBirth = Integer.parseInt(userAttributes[4]);
					String remarks = userAttributes[5];
					user = new User(uID, pwd, uName, uRole, yearOfBirth, remarks);
					//update login record of this user
					updateRecord(uID, loginRecordPath);
					if(uRole.equals("Admin")){
						AdminPage admin = new AdminPage();
						admin.frame.setVisible(true);
					}else{
						UserPage user = new UserPage();
						UserPage.welcomeLabel.setText("Welcome " + userAttributes[2]);
					}
				}else{
					found=false;
				}
			}
			scan.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		if(!found){
			System.out.println("Enter the valid username and password");
			JOptionPane.showMessageDialog(null, "Incorrect login or password", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void updateRecord(int uID, String filepath){
		LocalTime now = LocalTime.now();
		LocalDate lrID = LocalDate.now();
		Random number = new Random();
		int random = number.nextInt(100);
		try {
			FileWriter fw = new FileWriter(filepath,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			pw.println(lrID+Integer.toString(random)+","+uID+","+now+","+"-");
			pw.flush();
			pw.close();

			JOptionPane.showMessageDialog(null, "Login record updated");
		} catch(Exception e) {
			e.getStackTrace();
		}
	}

	public static String encryptPwd(String pwd){
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] passBytes = pwd.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<digested.length;i++){
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			System.out.println(sb.toString());
			return sb.toString();
		}catch(NoSuchAlgorithmException e){
			System.out.println(e.getStackTrace());
		}
		return null;
	}
}
