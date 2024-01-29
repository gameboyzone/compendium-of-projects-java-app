import java.io.*;
import java.awt.*;
import java.awt.event.*;

class Main implements ActionListener,WindowListener
{
Frame f;
Button b1,b2,b3,b4,b5,b6,b7;
TextArea ta;
Label l1,l2,l3,l4,l5;
Dialog d,d1;
Panel p,p1;

	Main()
	{
	f=new Frame("                                  <----------------  COMPENDIUM OF PROJECTS  ---------------->");
	d=new Dialog(f,"Select the desired Option:");
	d1=new Dialog(f,"Are you sure you want to Quit:");
	p=new Panel();
	p1=new Panel();
	b1=new Button("Login");
	b2=new Button("Documentation");
	l1=new Label("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	l2=new Label("-----------------------------------------------------------------------------------");
	l3=new Label("-----------------------------------------------------------------------------------");
	l4=new Label("Welcome to,");
	l5=new Label("COMPENDIUM OF PROJECTS");
	b1=new Button("LOGIN");
	b2=new Button("DOCUMENTATION");
	b3=new Button("CREDITS");
	b4=new Button("Enter into DB");
	b5=new Button("Retrieve from DB");
	b6=new Button("Yes");
	b7=new Button("No");
	ta=new TextArea();
	ta.append("Class: T.E. - I.T.   Batch: B4\nSubject: Software Engineering\nAcademic Year: 2008\n\n<-------- PROJECT BY ---------->\nHardik Shah\nAnkith Shetty\nAlok Sarang\nPooja Yadav\nKiran Waghmare\n\n<----------- PROJECT GUIDE ----------->\nMs. Nazneen Ansari");
	ta.setEditable(false); 
	
	f.setLayout(new FlowLayout(FlowLayout.LEFT));
	//f.setLayout(null);	

	f.add(l1);
	f.add(l2);
	f.add(l3);
	f.add(ta);
	f.add(l4);
	f.add(l5);
	f.add(b1);
	f.add(b2);
	f.add(b3);
	p.add(b4);
	p.add(b5);
	d.add(p);
	p1.add(b6);
	p1.add(b7);
	d1.add(p1);
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	b5.addActionListener(this);
	b6.addActionListener(this);
	b7.addActionListener(this);
	f.addWindowListener(this);
	d.addWindowListener(this);
	d1.addWindowListener(this);
	
	f.setSize(700,500);
	f.setVisible(true);
	f.setResizable(false);
	f.setLocation(50,40);
	d.setSize(300,80);
	d.setVisible(false);
	d1.setSize(300,80);
	d1.setVisible(false);
	
	l1.setLocation(3,145);
	l2.setLocation(3,260);
	l3.setLocation(4,375);
	l4.setLocation(180,60);
	l5.setLocation(250,90);
	b1.setLocation(110,200);
	b1.setSize(120,24);
	b2.setLocation(110,310);
	b2.setSize(120,24);
	b3.setLocation(110,425);
	b3.setSize(120,24);
	ta.setLocation(350,180);
	ta.setSize(325,300);
	ta.setEditable(false);
	ta.setFocusable(false);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
		d.setVisible(true);
		}
		
		if(e.getSource()==b2)
		{
		f.dispose();
		Documentation dt=new Documentation();
		}
		
		if(e.getSource()==b3)
		{
		f.dispose();
		Credits cs=new Credits();
		}
		
		if(e.getSource()==b4)
		{
		f.dispose();
		Enter et=new Enter();
		}
		
		if(e.getSource()==b5)
		{
		f.dispose();
		Retrieve rt=new Retrieve();
		}
		
		if(e.getSource()==b6)
		{
		f.dispose();
		System.exit(0);
		}
		
		if(e.getSource()==b7)
		{
		d1.dispose();
		}
	}
	
	public void windowClosing(WindowEvent e1)
	{
		if(e1.getSource()==f)
		{
		d1.setVisible(true);
		}
		
		if(e1.getSource()==d)
		{
		d.dispose();
		}
		
		if(e1.getSource()==d1)
		{
		d1.dispose();
		}
		
		
	}
	
	public void windowOpened(WindowEvent e1)
	{
	}
	
	public void windowClosed(WindowEvent e1)
	{
	}
	
	public void windowIconified(WindowEvent e1)
	{
	}
	
	public void windowDeiconified(WindowEvent e1)
	{
	}
	
	public void windowActivated(WindowEvent e1)
	{
	}
	
	public void windowDeactivated(WindowEvent e1)
	{
	}
	
	public static void main(String[] args) 
	{
		System.out.println("\n\n     <---------- Welcome to Compendium of Projects ------------->\n\n");
		Main mn=new Main();
	}
}