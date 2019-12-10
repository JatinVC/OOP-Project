import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.*;


public class G18m1Record {

	int AR_ID;
	int U_ID;
	String Reserved_Date;
	String Reserved_Time;
	String Appointment_Type;
	String Time_Recorded;
	String Remarks;
	public static int totalR = 0;

	public G18m1Record (int uid, String rd,String rt, String at, String tr, String rs){
        this(totalR, uid, rd, rt, at, tr, rs);
    }



	public G18m1Record (int aid, int uid, String rd, String rt, String at, String tr, String rs){
        AR_ID = aid;  		AR_ID++;       U_ID = uid;
		Reserved_Date = rd; Reserved_Time = rt;   Appointment_Type = at;
		Time_Recorded = tr;	Remarks = rs;
		totalR++;
    }


	public String getRInfo(){
        return  String.format("%04d",AR_ID)+","+String.format("%04d",U_ID)+","+Reserved_Date+","+Reserved_Time+","+Appointment_Type+","+Time_Recorded+","+Remarks+",";
    }

	public void dispRInfo(){
        JOptionPane.showMessageDialog(null,
                "Appointment G18m1Record Info:\n AR_ID,U_ID,Reserved_Date,Reserved_Time,Appointment_Type,Time_Recorded,Remarks:\n" + getRInfo());
    }

	public static G18m1Record userCreateS(){ // a class (static) method
		String U_ID, Reserved_Date, Reserved_Time, Appointment_Type, Remarks;
		Date Time_Recorded = new Date();
		U_ID = JOptionPane.showInputDialog (null, "What is your U_ID?");
		Reserved_Date = JOptionPane.showInputDialog (null, "What is the Reserved_Date? Please type in this format [09/12/2019]");
		Reserved_Time = JOptionPane.showInputDialog (null, "What is the Reserved_Time?");
		String[] optVal = { "Attack", "Healing", "Defense" }; // option values
		Appointment_Type = (String) JOptionPane.showInputDialog(null, // "select" prog code
			"Choose your hero type", "hero type Input",
			JOptionPane.INFORMATION_MESSAGE,
			null, optVal, optVal[0]);
		Remarks = JOptionPane.showInputDialog (null, "What is ur remarks?");
		G18m1Record retS = new G18m1Record(Integer.parseInt(U_ID), Reserved_Date,Reserved_Time, Appointment_Type, Time_Recorded.toString(), Remarks);
		return retS;
	}
}
