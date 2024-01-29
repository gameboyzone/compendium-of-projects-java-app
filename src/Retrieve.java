import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Retrieve implements ActionListener,WindowListener,ItemListener
{
Frame f2;
Label lll1,lll2,lll3,lll4,lll5,lll6,lll7,note1,note2;
Choice cc1;
TextField t1,t2,t3,t4,t5;
TextArea t6;
Button bbb2;
Statement ss;
Connection cc;
ResultSet rs2;
ResultSetMetaData rsm2;
int colu;
int k=0,l=0,i,b;
String st1,app;
String nm[]=new String[50];
String all[]=new String[6];
String bp[]={"pt","ps","gn","pl","pg","pd"};

	Retrieve()
	{
	f2=new Frame("                                       <----------------  Retrieve from DB  ---------------->");
	lll1=new Label("Project Name: ");
	lll2=new Label("Project Type: ");
	lll3=new Label("Project Sub-Type: ");
	lll4=new Label("Group Name: ");
	lll5=new Label("PC & Lab no.: ");
	lll6=new Label("Project Guide: ");	
	lll7=new Label("Project Description: ");
	note1=new Label("<---- Please select the available Project names");
	note2=new Label("from the DB to retrieve its Contents");
	cc1=new Choice();
	t1=new TextField(20);
	t2=new TextField(20);
	t3=new TextField(15);
	t4=new TextField(15);
	t5=new TextField(20);
	t6=new TextArea();
	bbb2=new Button("BACK");
	
	f2.setLayout(new FlowLayout(FlowLayout.LEFT));
	
		try
		{
		String st="Select pn from ProjectDB;";
		
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		cc=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+"DB.mdb"+";DriverID=22;READONLY=false");
		ss=cc.createStatement();
		
		ResultSet rs1=ss.executeQuery(st);
		ResultSetMetaData rsm1=rs1.getMetaData();
		int col=rsm1.getColumnCount();
		
			for(int a=1;a<=col;a++)
			{
				while(rs1.next())
				{
				nm[k]=rs1.getString(a).trim();
				k++; 
				}
			}
		
		//System.out.println("\nProject Names for Choice cc1 retrieved from DB successfully.\n");
		//System.out.println("Length of \"Project Name\" array: "+k+"\n");
			
		ss.close();
		cc.close();	
		}
		
		catch(Exception e8)
		{
		e8.printStackTrace();
		}
	
	for(int j=0;j<k;j++)
	{
	cc1.add(nm[j]);
	}
	
	f2.repaint();
	f2.validate();
	
	f2.add(lll1);
	f2.add(cc1);
	f2.add(note1);
	f2.add(note2);
	f2.add(lll2);
	f2.add(t1);
	f2.add(lll3);
	f2.add(t2);
	f2.add(lll4);
	f2.add(t3);
	f2.add(lll5);
	f2.add(t4);
	f2.add(lll6);
	f2.add(t5);
	f2.add(lll7);
	f2.add(t6);
	f2.add(bbb2);
	
	bbb2.addActionListener(this);
	f2.addWindowListener(this);
	cc1.addItemListener(this);
	
	f2.setSize(700,500);
	f2.setVisible(true);
	f2.setResizable(false);
	f2.setLocation(50,40);
	
	lll1.setLocation(15,50);
	cc1.setLocation(110,50);
	note1.setLocation(285,42);
	note2.setLocation(310,58);
	lll2.setLocation(15,90);
	t1.setLocation(405,90);
	lll3.setLocation(285,90);
	t2.setLocation(110,90);
	lll4.setLocation(15,130);
	t3.setLocation(110,130);
	lll5.setLocation(15,170);
	t4.setLocation(110,170);
	lll6.setLocation(15,210);
	t5.setLocation(110,210);
	lll7.setLocation(15,250);
	t6.setLocation(145,250);
	bbb2.setSize(80,25);
	bbb2.setLocation(320,450);	
	
	t1.setEditable(false);
	t2.setEditable(false);
	t3.setEditable(false);
	t4.setEditable(false);
	t5.setEditable(false);
	t6.setEditable(false);
	t1.setFocusable(false);
	t2.setFocusable(false);
	t3.setFocusable(false);
	t4.setFocusable(false);
	t5.setFocusable(false);
	t6.setFocusable(false); 
	}

	public void actionPerformed(ActionEvent e6)
	{
		if(e6.getSource()==bbb2)
		{
		f2.dispose();
		Main mn=new Main();
		}
	}
	
	public void itemStateChanged(ItemEvent e9)
	{
	int op=0;
		if(e9.getSource()==cc1)
		{
		String sr=cc1.getSelectedItem();
		System.out.println("\nThe Selected Choice:"+sr);
		
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection ccc=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+"DB.mdb"+";DriverID=22;READONLY=false");
		Statement sss=ccc.createStatement();
		
		for(i=0;i<bp.length;i++)
		{
		st1="Select "+bp[i]+" from ProjectDB where pn='"+sr+"';";
			
		rs2=sss.executeQuery(st1);
		rsm2=rs2.getMetaData();
		colu=rsm2.getColumnCount();
		
			for(b=1;b<=colu;b++)
			{
				while(rs2.next())
				{
				all[i]=rs2.getString(b).trim();
				}
			} 
		
			}
			
		t1.setText(all[1]);
		t2.setText(all[0]);
		t3.setText(all[2]);
		t4.setText(all[3]);
		t5.setText(all[4]);
		t6.setText(all[5]);
			
		sss.close();
		ccc.close();	
		}
	
		catch(Exception e8)
		{
		e8.printStackTrace();
		}
		
		}
	}
	
	public void windowClosing(WindowEvent e7)
	{
		if(e7.getSource()==f2)
		{
		f2.dispose();
		Main mn=new Main();
		}
		
	}
	
	public void windowOpened(WindowEvent e7)
	{
	}
	
	public void windowClosed(WindowEvent e7)
	{
	}
	
	public void windowIconified(WindowEvent e7)
	{
	}
	
	public void windowDeiconified(WindowEvent e7)
	{
	}
	
	public void windowActivated(WindowEvent e7)
	{
	}
	
	public void windowDeactivated(WindowEvent e7)
	{
	}
	
	public static void main(String args[])
	{
		System.out.println("\n\n     <---------- Retrieve from DB ------------->\n\n");
		Retrieve rt=new Retrieve();
	}

}