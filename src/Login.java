import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener{
	JLabel uLabel = new JLabel();
	JLabel pLabel = new JLabel();
	JButton SUBMIT = new JButton("SUBMIT");
	final JTextField UTEXTFIELD = new JTextField(15);
	final JTextField PTEXTFIELD = new JTextField(15);
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
		if(uValue.equals("Jatin") && pValue.equals("root")) {
			NextPage page = new NextPage();
			page.setVisible(true);
			JLabel label = new JLabel("Welcome:"+uValue);
			page.getContentPane().add(label);
		}else {
			System.out.println("Enter the valid username and password");
      JOptionPane.showMessageDialog(this, "Incorrect login or password", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
