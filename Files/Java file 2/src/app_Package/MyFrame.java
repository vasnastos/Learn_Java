package app_Package;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.scene.paint.Color;

public class MyFrame extends JFrame{
	Vector <student> students=new Vector();
	private double theorypercent;
	private double labpercent;
	JLabel label;
	private String loadlesson=null;
    void button_form()
    {
    	JPanel buttonpanel=new JPanel();
    	JButton b1=new JButton("PASS");
    	JButton b2=new JButton("FAIL");
    	JButton b3=new JButton("AVERAGE");
    	label=new JLabel("Lesson Loaded:"+loadlesson,JLabel.CENTER);
    	label.setForeground(java.awt.Color.red);
    	b1.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent ae)
    		{
    			if(students.size()==0)
    			{
    				JOptionPane.showMessageDialog(null,"No Lesson have been loaded!!Please first load a lesson");
    				return;
    			}
    			String message="Pass at lesson "+loadlesson+"\n";
    			for(student s:students)
    			{
    				if(s.get_total(theorypercent, labpercent)>=5.0)
    				{
    					message+="Id:"+s.get_id()+"   Grade:"+s.get_total(theorypercent,labpercent)+"\n";
    				}
    			}
    			JOptionPane.showMessageDialog(null, message);
    		}
    	});
      	b2.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent ae)
    		{
    			if(students.size()==0)
    			{
    				JOptionPane.showMessageDialog(null,"No Lesson have been loaded!!Please first load a lesson");
    				return;
    			}
    			String message="Fail at lesson "+loadlesson+"\n";
    			for(student s:students)
    			{
    				if(s.get_total(theorypercent, labpercent)<5.0)
    				{
    					message+="Id:"+s.get_id()+"   Grade:"+s.get_total(theorypercent,labpercent)+"\n";
    				}
    			}
    			JOptionPane.showMessageDialog(null, message);
    		}
    	});
      	b3.addActionListener(new ActionListener()
      	{
      		public void actionPerformed(ActionEvent ae)
      		{
      			if(students.size()==0)
      			{
      				JOptionPane.showMessageDialog(null,"No Lesson have been loaded!!Please first load a lesson");
    				return;
      			}
      			double sumth=0.0,suml=0.0;
      			for(student s:students)
      			{
      				sumth+=s.get_theory();
      				suml+=s.get_lab();
      			}
      		String message="Average grade of theory in lesson "+loadlesson+":"+String.valueOf(sumth/students.size())+"\n";
      		message+="Average grade of theory in lesson "+loadlesson+":"+String.valueOf(suml/students.size())+"\n";
      		JOptionPane.showMessageDialog(null, message);
      		}
      	  });
      	 buttonpanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
      	 buttonpanel.add(label);
      	 buttonpanel.add(b1);
      	 buttonpanel.add(b2);
      	 buttonpanel.add(b3);
      	 this.add(buttonpanel);
    }
	
    void make_menu()
    {
    	JMenu menu=new JMenu("EDIT");
    	JMenuBar bar=new JMenuBar();
    	this.setJMenuBar(bar);
    	JMenuItem item1=new JMenuItem("LOAD");
    	JMenuItem item2=new JMenuItem("SAVE");
    	JMenuItem item3=new JMenuItem("EXIT");
    	item1.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent ae)
    		{
    			JFileChooser ch=new JFileChooser();
    			int value=ch.showOpenDialog(MyFrame.this);
    			if(value==JFileChooser.APPROVE_OPTION)
    			{
    				String filename=ch.getSelectedFile().getAbsolutePath();
    				FileReader Fr=null;
    				try
    				{
    					Fr=new FileReader(filename);
    				}
    				catch(FileNotFoundException ex)
    				{
    					JOptionPane.showMessageDialog(null, "File did not found");
    				}
    				int counter=0;
    				Scanner scanner=new Scanner(Fr);
    				while(scanner.hasNextLine())
    				{
    					counter++;
    					//fetch next line from the file
    					String line=scanner.nextLine();
    					if(line.startsWith("#")) continue;
    					if(counter==1)
    					{
    						loadlesson=line;
    					}
    					if(counter==2)
    					{
    						String percents[]=line.split(",");
    						int validance=0;
    						for(String pr:percents)
    						{
    							validance++;
    						}
    						if(validance!=2)
    						{
    							JOptionPane.showMessageDialog(null,"Wrong format detected in line "+String.valueOf(counter));
    							return;
    						}
    						theorypercent=Double.parseDouble(percents[0]);
    						labpercent=Double.parseDouble(percents[1]);
    					}
    					String data[]=line.split(",");
    					int validance=0;
						for(String pr:data)
						{
							validance++;
						}
						if(validance!=3)
						{
							continue;
						}
						student newstudent=new student(data[0],Double.parseDouble(data[1]),Double.parseDouble(data[2]));
						students.add(newstudent);
    				}
    				scanner.close();
    				label.setText("Lesson Loaded:"+loadlesson);
    				label.setForeground(java.awt.Color.blue);
    			}
    		}
    	});
    	item2.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent ae)
    		{
    			JFileChooser ch=new JFileChooser();
    			int value=ch.showSaveDialog(MyFrame.this);
    			if(value==JFileChooser.APPROVE_OPTION)
    			{
    				if(students.size()==0)
    				{
    					JOptionPane.showMessageDialog(null,"No loaded elements!!Please load a file");
    					return;
    				}
    				String fn=ch.getSelectedFile().getAbsolutePath();
    				FileWriter fw;
					try {
						fw = new FileWriter(fn);
    				PrintWriter writer=new PrintWriter(fw);
    				String date=String.valueOf(java.time.LocalDate.now());
    				String time=String.valueOf(java.time.LocalTime.now());
    				writer.println("File created at:"+date+"----"+time);
    				writer.println("Information for lesson "+loadlesson);
    				writer.println("");
    				writer.println("*************** Pass Information *****************");
    				String pass="";
    				String fail="";
    				for(student s:students)
    				{
    					if(s.get_total(theorypercent, labpercent)>=5.0)
    					{
    						pass+="ID:"+s.get_id()+"        Grade:"+s.get_total(theorypercent, labpercent)+"\n";
    					}
    					else
    					{
    						fail+="ID:"+s.get_id()+"        Grade:"+s.get_total(theorypercent, labpercent)+"\n";
    					}
    				}
    				writer.println(pass);
    				writer.println("**************************************************");
    				writer.println("");
    				writer.println("*************** Fail Information *****************");
    				writer.println(fail);
    				writer.println("**************************************************");
					fw.close();
					} catch (IOException e) {
						return;
					}
    			}
    		}
    	});
    	item3.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent ae)
    		{
    			System.exit(0);
    		}
    	});
    	menu.add(item1);
    	menu.add(item2);
    	menu.add(item3);
    	bar.add(menu);
    }
    
	public MyFrame()
    {
    	super("File Handling 2");
    	this.setSize(300,300);
    	this.setLayout(new GridLayout(0,1));
    	ImageIcon image=new ImageIcon(new ImageIcon("file.png").getImage().getScaledInstance(100, 100,Image.SCALE_SMOOTH));
    	JLabel central=new JLabel(image,JLabel.CENTER);
    	this.add(central);
    	button_form();
    	make_menu();
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
    }
}
