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
import information.Information;
public class register {

	private static String[] user = new String[1024];
	private static int count = 0;
	private JFrame frame;
	private JTextField SteamUsername;
	private JTextField RankOrCausal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register window = new register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Steam Username:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(117, 13, 180, 24);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewPassword = new JLabel("Rank/Causal?");
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewPassword.setBounds(10, 118, 168, 47);
		frame.getContentPane().add(lblNewPassword);

		SteamUsername = new JTextField();
		SteamUsername.setFont(new Font("Arial", Font.BOLD, 20));
		SteamUsername.setBounds(32, 50, 367, 55);
		frame.getContentPane().add(SteamUsername);
		SteamUsername.setColumns(10);

		RankOrCausal = new JTextField();
		RankOrCausal.setFont(new Font("Arial", Font.BOLD, 20));
		RankOrCausal.setColumns(10);
		RankOrCausal.setBounds(175, 118, 240, 50);
		frame.getContentPane().add(RankOrCausal);

		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				      File myObj = new File("Record.txt");
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
				Information window = new Information();
				window.frame.setVisible(true);
				try {
				      FileWriter myWriter = new FileWriter("Records.txt");
				      for (int i = 0; i < count; i ++) {
				    	  String temp = user[i];
				    	  myWriter.write(temp+"\n");
				      }
				      String newName = SteamUsername.getText();
				      String newPw = RankOrCausal.getText();
				      myWriter.write(newName+"\n");
				      myWriter.write(newPw);
				      myWriter.close();
				    } catch (IOException e2) {
				    	JOptionPane.showMessageDialog(null, "Error!","Error!", JOptionPane.ERROR_MESSAGE);
				      e2.printStackTrace();
				    }
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBounds(32, 193, 158, 47);
		frame.getContentPane().add(btnNewButton);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SteamUsername.setText(null);
				RankOrCausal.setText(null);
			}
		});
		btnClear.setFont(new Font("Arial", Font.BOLD, 20));
		btnClear.setBounds(241, 193, 158, 47);
		frame.getContentPane().add(btnClear);
	}
}
