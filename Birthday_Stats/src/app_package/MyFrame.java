package app_package;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
    JComboBox <String> year=new JComboBox();
    JComboBox <String> age=new JComboBox();
    JComboBox <String> saveage=new JComboBox();
    List <birth> dets=new ArrayList<birth>();
    JPanel p0,p1,p2,p3;
    Vector <String> get_distinct_year()
    {
    	Vector <String> yr=new Vector();
    	for(birth b:dets)
    	{
    		boolean f=false;
    		for(String x:yr)
    		{
    			if(x.equals(b.getPeriod()))
    			{
    				f=true;
    				break;
    			}
    		}
    		if(!f)
    		{
    			yr.add(b.getPeriod());
    		}
    	}
    	return yr;
    }
    Vector <String> get_distinct_age()
    {
    	Vector <String> ag=new Vector();
    	for(birth b:dets)
    	{
    		boolean f=false;
    		for(String y:ag)
    		{
    			if(y.equals(b.getAge()))
    			{
    				f=true;
    				break;
    			}
    		}
    		if(!f)
    		{
    			ag.add(b.getAge());
    		}
    	}
    	return ag;
    }
    void panel0()
    {
    	p0=new JPanel();
    	p0.setLayout(new FlowLayout(FlowLayout.CENTER));
    	JLabel lb=new JLabel("Load File",JLabel.CENTER);
    	lb.setSize((int)0.4*this.getWidth(),(int)0.05*this.getHeight());
    	JButton b=new JButton("LOAD");
    	b.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent ae)
    		{
    			JFileChooser chooser=new JFileChooser();
    			int rval=chooser.showOpenDialog(MyFrame.this);
    			if(rval==JFileChooser.APPROVE_OPTION)
    			{
    				String filename=chooser.getSelectedFile().getAbsolutePath();
    				try {
						FileReader reader=new FileReader(filename);
						Scanner sc=new Scanner(reader);
						int counter=0;
						while(sc.hasNextLine())
						{
							String line=sc.nextLine();
							counter++;
							if(counter==1) continue;
							if(line.startsWith("#")) continue;
							String data[]=line.split(",");
							if(data.length!=3) continue;
							birth bd=new birth(data[0],data[1],Double.parseDouble(data[2]));
							dets.add(bd);
						}
						sc.close();
						Vector <String> years=get_distinct_year();
						for(String x:years)
						{
							year.addItem(x);
						}
						Vector <String> ages=get_distinct_age();
						for(String x:ages)
						{
							age.addItem(x);
							saveage.addItem(x);
						}
					} catch (FileNotFoundException e) {
						JOptionPane.showMessageDialog(null,"No file selected");						
					}
    			}
    		}
    	});
    	p0.add(lb);
    	p0.add(b);
    	this.add(p0);
    }
    void panel1()
    {
    	p1=new JPanel();
    	p1.setLayout(new FlowLayout(FlowLayout.CENTER));
    	JLabel in=new JLabel("Search by Year",JLabel.RIGHT);
    	in.setBackground(java.awt.Color.red);
    	JButton b=new JButton("Search");
    	b.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			String src=year.getSelectedItem().toString();
    			String message="";
    			for(int i=0;i<dets.size();i++)
    			{
    				if(dets.get(i).getPeriod().equals(src))
    				{
    					message+=dets.get(i).getAge()+"----"+String.valueOf(dets.get(i).getRate())+"\n";
    				}
    			}
    			JOptionPane.showMessageDialog(null,message);
    		}
    	});
    	p1.add(in);
    	p1.add(year);
    	p1.add(b);
    	this.add(p1);
    }
    void panel2()
    {
    	p2=new JPanel();
    	p2.setLayout(new FlowLayout(FlowLayout.CENTER));
    	JLabel in=new JLabel("Search by Age",JLabel.RIGHT);
    	in.setSize((int)0.3*in.getWidth(),(int)0.1*in.getHeight());
    	in.setBackground(java.awt.Color.red);
    	JButton b=new JButton("Search");
    	b.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			String message="";
    			String src=age.getSelectedItem().toString();
    			for(int i=0;i<dets.size();i++)
    			{
    				if(src.equals(dets.get(i).getAge()))
    				{
    					message+=dets.get(i).getPeriod()+"---"+dets.get(i).getRate()+"\n";
    				}
    			}
    			JOptionPane.showMessageDialog(null,message);
    		}   				
    	});
    	p2.add(in);
    	p2.add(age);
    	p2.add(b);
    	this.add(p2);
    }
    void panel3()
    {
    	p3=new JPanel();
    	p3.setLayout(new FlowLayout(FlowLayout.CENTER));
    	JLabel lb=new JLabel("Save File by Age",JLabel.RIGHT);
    	lb.setSize((int)0.4*this.getWidth(),(int)0.1*this.getHeight());
    	lb.setBackground(java.awt.Color.red);
    	JButton b=new JButton("Save");
    	b.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent ae)
    		{
    			String sel=saveage.getSelectedItem().toString();
    			String fn=saveage.getSelectedItem().toString()+" info.csv";
    			try {
					FileWriter fw=new FileWriter(fn);
					PrintWriter pw=new PrintWriter(fw);
					for(birth b:dets)
					{
						if(b.getAge().equals(sel))
						{
							pw.println(b.getPeriod()+"---"+b.getRate());
						}
					}
					pw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	});
    	p3.add(lb);
    	p3.add(saveage);
    	p3.add(b);
    	this.add(p3);
    }
    MyFrame(String tit)
    {
    	super(tit);
    	this.setSize(600,600);
    	this.setTitle("BirthDay App");
    	this.setLayout(new GridLayout(0,1));
    	JLabel lb=new JLabel();
    	lb.setSize(this.getWidth(),(int) ((int)this.getHeight()*0.2));
    	ImageIcon ic=new ImageIcon(new ImageIcon("brd.png").getImage().getScaledInstance(lb.getWidth(),lb.getHeight(),Image.SCALE_SMOOTH));
    	lb.setIcon(ic);
    	this.add(lb);
    	panel0();
    	panel1();
    	panel2();
    	panel3();
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
    }
}
