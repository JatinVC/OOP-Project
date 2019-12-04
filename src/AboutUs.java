import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AboutUs extends JFrame implements ActionListener {
	JPanel panelTop = new JPanel(); // new GUI components
	JButton butAboutUs = new JButton("About Us");

	AboutUs(){ // A No-Argument Constructor
	setTitle ( "TEST" );
	setSize ( 500, 300 );
	setDefaultCloseOperation ( EXIT_ON_CLOSE );
	initGUI();
	}
	void initGUI(){
	
		panelTop.add(butAboutUs);
		add(panelTop, BorderLayout.SOUTH); //add JPanel to top of JFrame
		// registering this class object as event listener for the Button
		butAboutUs.addActionListener(this);
	}
	public void actionPerformed(ActionEvent event) { openAboutUs(); }
	void openAboutUs(){
		// show AboutMe Message Dialog window
			JOptionPane.showMessageDialog(null,
				"Members(left to right):\n" +
				"Wong Man Ho\n 123\n 123\n 123 ",
				"About Us: G??, 2019-2020, OOP",
				JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("Aboutus.png"));
		} 

public static void main(String[] args){ // Method to start program
	 (new AboutUs()).setVisible(true);
	 }
	}