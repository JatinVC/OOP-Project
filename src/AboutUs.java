import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AboutUs{
	AboutUs(){ // A No-Argument Constructor
		// show AboutMe Message Dialog window
		JOptionPane.showMessageDialog(null,
			"Members(left to right):\n" +
			"Wong Man Ho\n Chandwaney Jatin Vimal\n Mok Chun Chung\n Yuen Ho Yee",
			"About Us: G??, 2019-2020, OOP",
			JOptionPane.INFORMATION_MESSAGE,
			new ImageIcon("Group.PNG"));
	}
}
