import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Documentation implements WindowListener
{
Frame f3;
TextArea ta3;
Color c0;

	Documentation()
	{
	f3=new Frame("                                         <----------------  DOCUMENTATION  ---------------->");
	ta3=new TextArea();
	c0=new Color(145,153,101);
	ta3.append("<-------  Objective & Application of the Project  ------->\nThis application is for all neophytes out there who have got skill-sets like\nJava, VB, .NET, etc but are not sure which particular project to pursue and\nin which field. This Application consists of a COMPENDIUM(Collection) of\nall types of projects one can pursue in a particular field. The no. of Projects\nin the application may not be more to appease you but can give you an idea\nof what can be possible.\n\n<-------  Recommended System Requirements:  ------->\nAtleast P-2(266 Mhz), 32 MB RAM\n1 MB HDD Space\nJDK 1.5 Compatible OS\n\n<-------  Optimal Graphics Specifications & Requirements:  ------->\nOptimal Resolution 800*600 unit pixels\nAtleast 4 MB Shared Graphics\n\n<-------  Author:  ------->\nHardik Shah\nE-mail: hardikguru@yahoo.com\nHomePage: www.gameboyzone.com");
	
	f3.setLayout(new FlowLayout());
	
	f3.add(ta3);
	
	f3.addWindowListener(this);
	
	f3.setSize(700,500);
	f3.setVisible(true);
	f3.setResizable(false);
	f3.setLocation(50,40);
	f3.setBackground(c0);
	
	ta3.setLocation(130,70);
	ta3.setSize(440,350);
	ta3.setEditable(false);
	ta3.setFocusable(false);
	}

	public void windowClosing(WindowEvent e10)
	{
		if(e10.getSource()==f3)
		{
		f3.dispose();
		Main mn=new Main();
		}
				
	}
	
	public void windowOpened(WindowEvent e10)
	{
	}
	
	public void windowClosed(WindowEvent e10)
	{
	}
	
	public void windowIconified(WindowEvent e10)
	{
	}
	
	public void windowDeiconified(WindowEvent e10)
	{
	}
	
	public void windowActivated(WindowEvent e10)
	{
	}
	
	public void windowDeactivated(WindowEvent e10)
	{
	}
	
	public static void main(String args[])
	{
	Documentation dt=new Documentation();
	System.out.println("\n\n     <---------- Welcome to Documentation ------------->\n\n");
	}
}