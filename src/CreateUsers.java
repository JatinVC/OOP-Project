import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CreateUsers {

	private static String[] user = new String[1024];
	private static int count = 0;
	private JFrame frame;
	private JTextField textNewUsername;
	private JTextField textNewPassword;
	private JTextField textNewID;
	private JTextField textNewRemark;
	/**
	 * Create the application.
	 */
	public CreateUsers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 300, 500, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("New Username:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 52, 158, 47);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewPassword.setBounds(10, 127, 158, 47);
		frame.getContentPane().add(lblNewPassword);

		JLabel lblNewID = new JLabel("New ID:");
		lblNewID.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewID.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewID.setBounds(10, 202, 247, 47);
		frame.getContentPane().add(lblNewID);

		JLabel lblNewRemark = new JLabel("New Remark:");
		lblNewRemark.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewRemark.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewRemark.setBounds(-10, 277, 247, 47);
		frame.getContentPane().add(lblNewRemark);

		textNewUsername = new JTextField();
		textNewUsername.setFont(new Font("Arial", Font.BOLD, 20));
		textNewUsername.setBounds(177, 52, 247, 47);
		frame.getContentPane().add(textNewUsername);
		textNewUsername.setColumns(10);

		textNewPassword = new JTextField();
		textNewPassword.setFont(new Font("Arial", Font.BOLD, 20));
		textNewPassword.setColumns(10);
		textNewPassword.setBounds(177, 127, 247, 47);
		frame.getContentPane().add(textNewPassword);

		textNewID = new JTextField();
		textNewID.setFont(new Font("Arial", Font.BOLD, 20));
		textNewID.setColumns(10);
		textNewID.setBounds(177, 202, 247, 47);
		frame.getContentPane().add(textNewID);

		textNewRemark = new JTextField();
		textNewRemark.setFont(new Font("Arial", Font.BOLD, 20));
		textNewRemark.setColumns(10);
		textNewRemark.setBounds(177, 277, 247, 47);
		frame.getContentPane().add(textNewRemark);

		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				      File myObj = new File("G18User.csv");
				      Scanner myReader = new Scanner(myObj);
				      count = 0;
				      while (myReader.hasNextLine()) {
				        String data = myReader.nextLine();
				        user[count] = data;
				        count++;
				      }
				      myReader.close();
				    } catch (FileNotFoundException e1) {
				      e1.printStackTrace();
				    }

				try {
				      FileWriter myWriter = new FileWriter("G18User.csv");
				      for (int i = 0; i < count; i ++) {
				    	  String temp = user[i];
				    	  myWriter.write(temp+"\n");
				      }
				      String newName = textNewUsername.getText();
				      String newPw = encryptPwd(textNewPassword.getText());
							String ID = textNewID.getText();
							String uRole = "GUser";
							int yearOfBirth = 2000;
							String remarks = textNewRemark.getText();
							myWriter.write(ID+","+newPw+","+newName+","+uRole+","+yearOfBirth+","+remarks);
				      myWriter.close();
				    } catch (IOException e2) {
				    	JOptionPane.showMessageDialog(null, "Error!","Error!", JOptionPane.ERROR_MESSAGE);
				      e2.printStackTrace();
				    }
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBounds(32, 350, 158, 47);
		frame.getContentPane().add(btnNewButton);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNewUsername.setText(null);
				textNewPassword.setText(null);
			}
		});
		btnClear.setFont(new Font("Arial", Font.BOLD, 20));
		btnClear.setBounds(243, 350, 158, 47);
		frame.getContentPane().add(btnClear);
		frame.setVisible(true);
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
