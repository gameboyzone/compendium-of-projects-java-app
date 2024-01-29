import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Credits implements WindowListener
{
Frame f4;
TextArea ta4;
Color c1;

	Credits()
	{
	f4=new Frame("                                                <----------------  CREDITS  ---------------->");
	ta4=new TextArea();
	c1=new Color(57,74,83);
	ta4.append("<---------------------- CREDITS  -------------------------->\nLolita....This is my Section.....All cheers to my TEAM.....\n\nMs. Nazneen Ansari:\nFirst of all kudos for our Project guide for being compliant and conciliatory throughout\nthe Semester. Trust me she obliged readily to any of our demands.\n\nHardik Shah [ <---Guru---> ]:\nYa Ya !! All cheers to me too. My contribution was critical for the majority of the project but ya\nI did so with some fabulous ideas from Alok and Ankith. During the coding phase I was\npretty much happy that I'm putting my knowledge to some practical use but unhappy at the\nsame time that when I was stuck with some problems I had nobody to help me. Get one\nthing from me JDK 1.4 really sucks. I'll recommend JDK 1.5 or if possible even JDK 1.6\nfor die-hard Coders.\n\nAnkith Shetty [ Trigger ]:\nHe's been my mentor throughout the project and critical to the design and coding part of\nthe project. One thing I need to applaud about him is he's pretty much innovative and got\na hell lot of ideas.\n\nAlok Sarang [ Loki ]:\nWow!! do we smell -- LOVE IS IN THE AIR --. These days he's pretty much busy with some\nvery important business but still he did contribute towards the design and Coding issues.\n\nKiran Waghmare & Pooja Yadav:\nI had a verbal spat with both of them at the start since they wanted to pursue the project\nin VB and me in JAVA. We finally sorted it out and reconciled. Yups both did support me\non our project by contributing their valuable ideas.");
	
	f4.setLayout(new FlowLayout());
	
	f4.add(ta4);
	
	f4.addWindowListener(this);
	
	f4.setSize(700,520);
	f4.setVisible(true);
	f4.setResizable(false);
	f4.setLocation(50,30);
	f4.setBackground(c1);
	
	ta4.setLocation(90,45);
	ta4.setSize(520,450);
	ta4.setEditable(false);
	ta4.setFocusable(false);
	}

	public void windowClosing(WindowEvent e11)
	{
		if(e11.getSource()==f4)
		{
		f4.dispose();
		Main mn=new Main();
		}
				
	}
	
	public void windowOpened(WindowEvent e11)
	{
	}
	
	public void windowClosed(WindowEvent e11)
	{
	}
	
	public void windowIconified(WindowEvent e11)
	{
	}
	
	public void windowDeiconified(WindowEvent e11)
	{
	}
	
	public void windowActivated(WindowEvent e11)
	{
	}
	
	public void windowDeactivated(WindowEvent e11)
	{
	}
	
	public static void main(String args[])
	{
	Credits cs=new Credits();
	System.out.println("\n\n     <------------ Credits ------------->\n\n");
	}
}