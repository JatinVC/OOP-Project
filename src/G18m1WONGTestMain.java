import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.*;


public class G18m1WONGTestMain extends JFrame implements ActionListener {
	JPanel panelBelow = new JPanel();
	JLabel labelInfo = new JLabel("This is the system for you applying the game of OverWatch");

	JLabel Photo = new JLabel(new ImageIcon("overwatch.jpg"));
	JButton butAboutMe = new JButton("About Me");
	JButton apply = new JButton("Apply");
	JButton display = new JButton("Display");

	G18m1WONGTestMain(){
	setTitle ( "Overwatch Appointment System" );
	setSize ( 450, 450 );
	setDefaultCloseOperation ( EXIT_ON_CLOSE );
	initGUI();
	}
	public void initGUI(){

		panelBelow.add(apply);
		panelBelow.add(display);
		panelBelow.add(butAboutMe);
		add(Photo, BorderLayout.CENTER);
		add(panelBelow, BorderLayout.SOUTH);
		add(labelInfo, BorderLayout.NORTH);
		butAboutMe.addActionListener(this);
		

		apply.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent event1) {
		String maxSizeStr = JOptionPane.showInputDialog(null, "How many appointment do you want to apply MAX:3?");
		int rMaxSize = Integer.parseInt(maxSizeStr);
		while (rMaxSize>3){
			JOptionPane.showMessageDialog(null, "Out of range", "WARNING", JOptionPane.WARNING_MESSAGE);
			maxSizeStr = JOptionPane.showInputDialog(null, "How many appointment do you want to apply MAX:3?");
			rMaxSize = Integer.parseInt(maxSizeStr);
			}
		G18m1Record [] allS = new G18m1Record [rMaxSize];
		int rIndex=0;
		while (rIndex < rMaxSize){
			allS[rIndex] = G18m1Record.userCreateS();
			rIndex++;
		}
		String [][] rInfoArr = new String[rIndex][];
		for (int i=0; i<allS.length; i++){
			rInfoArr[i] = allS[i].getRInfo().split(",");

		}

		String [] colName = {"AR_ID","U_ID","Reserved_Date","Reserved_Time","Appointment_Type","Time_Recorded","Remarks"};
		JOptionPane.showMessageDialog(null, new JScrollPane(
			new JTable(new DefaultTableModel(rInfoArr, colName))),
			"Your appointment record", JOptionPane.INFORMATION_MESSAGE);
		//input to csv.
		try {
				final String fileName = "G18m1WONG.csv";
				PrintWriter outStream = new PrintWriter(fileName);
				if(rMaxSize==1)
				outStream.println(rInfoArr[0][0]+","+rInfoArr[0][1]+","+rInfoArr[0][2]+","+rInfoArr[0][3]+","+rInfoArr[0][4]+","+rInfoArr[0][5]+","+rInfoArr[0][6]);
			    if(rMaxSize==2){
				outStream.println(rInfoArr[0][0]+","+rInfoArr[0][1]+","+rInfoArr[0][2]+","+rInfoArr[0][3]+","+rInfoArr[0][4]+","+rInfoArr[0][5]+","+rInfoArr[0][6]);
				outStream.println(rInfoArr[1][0]+","+rInfoArr[1][1]+","+rInfoArr[1][2]+","+rInfoArr[1][3]+","+rInfoArr[1][4]+","+rInfoArr[1][5]+","+rInfoArr[1][6]);
				}
				if(rMaxSize==3){
				outStream.println(rInfoArr[0][0]+","+rInfoArr[0][1]+","+rInfoArr[0][2]+","+rInfoArr[0][3]+","+rInfoArr[0][4]+","+rInfoArr[0][5]+","+rInfoArr[0][6]);
				outStream.println(rInfoArr[1][0]+","+rInfoArr[1][1]+","+rInfoArr[1][2]+","+rInfoArr[1][3]+","+rInfoArr[1][4]+","+rInfoArr[1][5]+","+rInfoArr[1][6]);
				outStream.println(rInfoArr[2][0]+","+rInfoArr[2][1]+","+rInfoArr[2][2]+","+rInfoArr[2][3]+","+rInfoArr[2][4]+","+rInfoArr[2][5]+","+rInfoArr[2][6]);}
			    outStream.close();
			 } catch (FileNotFoundException e){
				JOptionPane.showMessageDialog(null, "ERR: FileNotFoundException", "MESSAGE", JOptionPane.WARNING_MESSAGE);}
		}
	}
		);

		display.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent event2) {

		// read csv.
		ArrayList<String> retAList = new ArrayList<String>();
			try{
				String strLine;
				BufferedReader bufferReader = new BufferedReader(new FileReader("G18m1WONG.csv"));
				while ((strLine = bufferReader.readLine()) != null)
					retAList.add(strLine);
				bufferReader.close(); //close the stream
			}catch (FileNotFoundException fnFe){
				JOptionPane.showMessageDialog(null, "FileNotFoundException", "MESSAGE", JOptionPane.WARNING_MESSAGE);
				String[] readTextFile = null;
			}catch (IOException ioE){
				JOptionPane.showMessageDialog(null, ">>> Exception, IOException", "MESSAGE", JOptionPane.WARNING_MESSAGE);
				String[] readTextFile = null;
			}
			String[] readTextFile = retAList.toArray(new String[retAList.size()]);
			String [] fRdata = readTextFile;
			if (fRdata!=null){ // read ok
				JOptionPane.showMessageDialog(null, fRdata, "Your appointment record", JOptionPane.INFORMATION_MESSAGE);
			}
			// missing the part of finding the U_ID that is it match his/her own UID
		}
		} );

	}
		public void actionPerformed(ActionEvent event3) { openAboutMe(); }
		void openAboutMe(){
			JOptionPane.showMessageDialog(null,
			"My info:\n" +
			"Wong Man Ho\n20093274",
			"About Me: G18, 2019-2020, OOP",
			JOptionPane.INFORMATION_MESSAGE,
			new ImageIcon("G18m1WONGTestMain.jpg.png"));
		}
	}
