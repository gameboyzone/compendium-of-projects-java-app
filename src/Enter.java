import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Enter implements ActionListener,WindowListener,ItemListener
{
Frame f1;
Label ll1,ll2,ll3,ll4,ll5,ll6,ll7;
Choice c1,c2;
TextField pn,gn,pl,pg;
TextArea ta1;
Button bb1,bb2,bb3,bb4;
Dialog d2,d3;
Statement s;
Connection c;
int n2;

	Enter()
	{
	f1=new Frame("                                            <----------------  Enter into DB  ---------------->");
	ll1=new Label("Project Type: ");
	ll2=new Label("Project Sub-Type: ");
	ll3=new Label("Project Name: ");
	ll4=new Label("Group Name: ");
	ll5=new Label("PC & Lab no.: ");
	ll6=new Label("Project Guide: ");	
	ll7=new Label("Project Description: ");
	c1=new Choice();
	c2=new Choice();
	pn=new TextField(15);
	gn=new TextField(15);
	pl=new TextField(15);
	pg=new TextField(15);
	ta1=new TextArea();
	ta1.setText("Application of the Project:\n\nSkill-Sets used in the Project:\n\nRecommended System Requirements:\n\nOptimal Graphics Specifications & Requirements:\n\nHelp Desk:\n\n");
	bb1=new Button("OK");
	bb2=new Button("RESET");
	bb3=new Button("OK");
	bb4=new Button("OK");
	d2=new Dialog(f1,"Please ensure all the fields are Complete");
	d3=new Dialog(f1,"Values Inserted Successfully");
		
	f1.setLayout(new FlowLayout(FlowLayout.LEFT));
	//f1.setLayout(null);
	d2.setLayout(new FlowLayout());
	d3.setLayout(new FlowLayout());
		
	c1.add("Web Development");
	c1.add("Application Development");
	c1.add("Digital Computing");
	c1.add("Database Mgmt. Systems");
	c1.add("Graphics & Animation");
	c1.add("Software Testing");
	
	f1.add(ll1);
	f1.add(c1);
	f1.add(ll2);
	f1.add(c2);
	f1.add(ll3);
	f1.add(pn);
	f1.add(ll4);
	f1.add(gn);
	f1.add(ll5);
	f1.add(pl);
	f1.add(ll6);
	f1.add(pg);
	f1.add(ll7);
	f1.add(ta1);
	f1.add(bb1);
	f1.add(bb2);
	d2.add(bb3);
	d3.add(bb4);
	
	f1.addWindowListener(this);
	d2.addWindowListener(this);
	d3.addWindowListener(this);
	bb1.addActionListener(this);
	bb2.addActionListener(this);
	bb3.addActionListener(this);
	bb4.addActionListener(this);
	c1.addItemListener(this);
		
	f1.setSize(700,500);
	f1.setVisible(true);
	f1.setResizable(false);
	f1.setLocation(50,40);
	d2.setVisible(false);
	d2.setSize(350,80);
	d3.setVisible(false);
	d3.setSize(275,80);
		
	ll1.setLocation(15,50);
	c1.setLocation(110,50);
	ll2.setLocation(310,50);
	c2.setLocation(430,50);
	c2.setSize(180,25);
	ll3.setLocation(15,90);
	pn.setLocation(110,90);
	ll4.setLocation(15,130);
	gn.setLocation(110,130);
	ll5.setLocation(15,170);
	pl.setLocation(110,170);
	ll6.setLocation(15,210);
	pg.setLocation(110,210);
	ll7.setLocation(15,250);
	ta1.setLocation(145,250);
	bb1.setLocation(290,450);
	bb2.setLocation(370,450); 
	}
	
	public void actionPerformed(ActionEvent e2)
	{
		
		if(e2.getSource()==bb1)
		{
		
		if((pn.getText().equals(""))||(gn.getText().equals(""))||(pl.getText().equals(""))||(pg.getText().equals(""))||(c2.getSelectedItem()==null))
		{
		d2.setVisible(true);
		}
		
		else
		{
			
			try
			{
			String s1=c1.getSelectedItem();
			String s2=c2.getSelectedItem();
			String s3=pn.getText();
			String s4=gn.getText();
			String s5=pl.getText();
			String s6=pg.getText();
			String s7=ta1.getText();
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			c=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+"DB.mdb"+";DriverID=22;READONLY=false");
			s=c.createStatement();
			
			//s.execute("Create table ProjectDB(pt text(25),ps text(25),pn text(25),gn text(25),pl text(20),pg text(25),pd text(255));");
			//System.out.println("\n\nTable Created Successfully\n\n");
			
			s.execute("Insert into ProjectDB values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')");
			System.out.println("Values Inserted Successfully\n\n");		
			
			d3.setVisible(true);
			
			s.close();
			c.close();
			}
			
			catch(Exception e5)
			{
			e5.printStackTrace();
			}
		}
		
		}
		
		if(e2.getSource()==bb2)
		{ 
			pn.setText("");
			gn.setText("");
			pl.setText("");
			pg.setText("");
			ta1.setText("Application of the Project:\n\nSkill-Sets used in the Project:\n\nRecommended System Requirements:\n\nOptimal Graphics Specifications & Requirements:\n\nHelp Desk:\n\n");
			
			n2=c2.getItemCount();
		
			for(int i=0;i<n2-1;i++)
			{
			String s2=c2.getItem(i);
			c2.remove(s2);
			}
			String s2=c2.getItem(0);
			c2.remove(s2);
		}
		
		if(e2.getSource()==bb3)
		{
		d2.dispose();
		}
		
		if(e2.getSource()==bb4)
		{
		d3.dispose();
		}
		
	}
	
	public void itemStateChanged(ItemEvent e4)
	{
		if(e4.getSource()==c1)
		{
		String s1=c1.getSelectedItem();
	
			if(s1=="Web Development")
			{
			n2=c2.getItemCount();
		
				if(n2!=0)
				{
					for(int i=0;i<n2-1;i++)
					{
					String s2=c2.getItem(i);
					c2.remove(s2);
					}
					String s2=c2.getItem(0);
					c2.remove(s2);
				}
				
			c2.add("Online Chatting");
			c2.add("Online Passport Application");
			c2.add("Online Banking");
			}
		
			if(s1=="Application Development")
			{
			n2=c2.getItemCount();
		
				if(n2!=0)
				{
					for(int i=0;i<n2-1;i++)
					{
					String s2=c2.getItem(i);
					c2.remove(s2);
					}
					String s2=c2.getItem(0);
					c2.remove(s2);
				}
				
			c2.add("Notepad Editor");
			c2.add("Audio-Video Player");
			c2.add("File-Format Converter");
			}
			
			if(s1=="Digital Computing")
			{
			n2=c2.getItemCount();
		
				if(n2!=0)
				{
					for(int i=0;i<n2-1;i++)
					{
					String s2=c2.getItem(i);
					c2.remove(s2);
					}
					String s2=c2.getItem(0);
					c2.remove(s2);
				}
			c2.add("Waveform Generation");
			c2.add("Image Mapping");
			c2.add("Graph Plotting");
			}
			
			if(s1=="Database Mgmt. Systems")
			{
			n2=c2.getItemCount();
		
				if(n2!=0)
				{
					for(int i=0;i<n2-1;i++)
					{
					String s2=c2.getItem(i);
					c2.remove(s2);
					}
					String s2=c2.getItem(0);
					c2.remove(s2);
				}
			c2.add("DB Administrator");
			c2.add("DB Logger and Reporter");
			c2.add("DB Statistics");
			}
			
			if(s1=="Graphics & Animation")
			{
			n2=c2.getItemCount();
		
				if(n2!=0)
				{
					for(int i=0;i<n2-1;i++)
					{
					String s2=c2.getItem(i);
					c2.remove(s2);
					}
					String s2=c2.getItem(0);
					c2.remove(s2);
				}
			c2.add("Canvas Drawing");
			c2.add("2D & 3D Graphics Expert");
			c2.add("Animation Manager");
			}
			
			if(s1=="Software Testing")
			{
			n2=c2.getItemCount();
		
				if(n2!=0)
				{
					for(int i=0;i<n2-1;i++)
					{
					String s2=c2.getItem(i);
					c2.remove(s2);
					}
					String s2=c2.getItem(0);
					c2.remove(s2);
				}
			c2.add("Software Expert");
			c2.add("Alpha & Beta Tester");
			c2.add("Software Statistics");
			}
		
		//f1.repaint();
		//f1.validate();
		}
		
		//f1.repaint();
		//f1.validate();
	}
	
	public void windowClosing(WindowEvent e3)
	{
		if(e3.getSource()==f1)
		{
		f1.dispose();
		Main mn=new Main();
		}
		
		if(e3.getSource()==d2)
		{
		d2.dispose();
		}
		
		if(e3.getSource()==d3)
		{
		d3.dispose();
		}
		
	}
	
	public void windowOpened(WindowEvent e3)
	{
	}
	
	public void windowClosed(WindowEvent e3)
	{
	}
	
	public void windowIconified(WindowEvent e3)
	{
	}
	
	public void windowDeiconified(WindowEvent e3)
	{
	}
	
	public void windowActivated(WindowEvent e3)
	{
	}
	
	public void windowDeactivated(WindowEvent e3)
	{
	}
	
	public static void main(String args[])
	{
		System.out.println("\n\n     <---------- Enter into DB ------------->\n\n");
		Enter et=new Enter();
	}
}