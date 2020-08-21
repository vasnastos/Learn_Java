import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.stage.FileChooser;

public class MyFrame extends JFrame{
     JComboBox <String> combo=new JComboBox();
     JPanel p1,p2;
     Vector <rate> rates=new Vector();
     Vector <String> get_distinct_years()
     {
    	 Vector <String> years=new Vector();
    	 for(rate r:rates)
    	 {
    		 boolean f=false;
    		 for(String y:years)
    		 {
    			 if(r.get_year()==Integer.parseInt(y))
    			 {
    				 f=true;
    				 break;
    			 }
    		 }
    		 if(!f)
    		 {
    			 years.add(String.valueOf(r.get_year()));
    		 }
    	 }
    	 return years;
     }
     void panel1()
     {
    	 p1=new JPanel();
    	 p1.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
    	 JButton b1=new JButton();
    	 ImageIcon ic1=new ImageIcon(new ImageIcon("marriage.jpg").getImage().getScaledInstance(40, 10, Image.SCALE_SMOOTH));
    	 b1.setIcon(ic1);
    	 b1.addActionListener(new ActionListener()
    	{
    		 public void actionPerformed(ActionEvent e)
    		 {
    			 if(rates.size()==0)
    			 {
    				JOptionPane.showMessageDialog(null, "No data loaded at the vector");
    				return;
    			 }
    		     String message="";
    			 String x="Marriage Rate";
    		     for(rate r:rates)
    		    {
    			  if(r.get_type().equals(x))
    			  {
    				  message+=String.valueOf(r.get_year())+"---"+String.valueOf(r.get_count())+"\n";
    			  }
    		    }
    		     JOptionPane.showMessageDialog(null, message);
    		 }
    	});
    	 JButton b2=new JButton();
    	 ImageIcon ic2=new ImageIcon(new ImageIcon("divorces.jpg").getImage().getScaledInstance(40, 10, Image.SCALE_SMOOTH));
    	 b2.setIcon(ic2);
    	 b2.addActionListener(new ActionListener()
    	 {
    		 public void actionPerformed(ActionEvent e)
    		 {
    			 if(rates.size()==0)
    			 {
    				JOptionPane.showMessageDialog(null, "No data loaded at the vector");
    				return;
    			 }
    		     String message="";
    			 String x="Divorce Rate";
    		     for(rate r:rates)
    		    {
    			  if(r.get_type().equals(x))
    			  {
    				  message+=String.valueOf(r.get_year())+"---"+String.valueOf(r.get_count())+"\n";
    			  }
    		    }
    		     JOptionPane.showMessageDialog(null, message);
    		 }	 
    	 });
    	 p1.add(b1);
    	 p1.add(b2);
    	 this.add(p1);
     }
     void panel2()
     {
    	 p2=new JPanel();
    	 p2.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
    	 JButton s=new JButton("SHOW");
    	 s.addActionListener(new ActionListener()
    	 {
    		public void actionPerformed(ActionEvent e)
    		{
    			if(rates.size()==0)
    			{
    				JOptionPane.showMessageDialog(null, "No data have been loaded to the app");
    				return;
    			}
    			String choosenelement=combo.getSelectedItem().toString();
    			int selectedyear=Integer.parseInt(choosenelement);
    			String message="";
    			for(rate r:rates)
    			{
    				if(r.get_year()==selectedyear)
    				{
    					message+=r.get_type()+"---"+String.valueOf(r.get_count())+"\n";
    				}
    			}
    			JOptionPane.showMessageDialog(null, message);
    		}
    	 });
    	 p2.add(combo);
    	 p2.add(s);
    	 this.add(p2);
     }
     void make_menu()
     {
    	 JMenu menu=new JMenu("EDIT");
    	 JMenuBar bar=new JMenuBar();
    	 this.setJMenuBar(bar);
    	 JMenuItem it1=new JMenuItem();
    	 it1.setText("LOAD");
  	 
    	 ImageIcon ic1=new ImageIcon(new ImageIcon("load.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    	 it1.setIcon(ic1);
    	 JMenuItem it2=new JMenuItem();
    	 ImageIcon ic2=new ImageIcon(new ImageIcon("quit.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    	 it2.setText("QUIT");
    	 it2.setIcon(ic2);
    	 it1.addActionListener(new ActionListener()
    	{
    		 public void actionPerformed(ActionEvent e)
    		 {
    			 JFileChooser ch=new JFileChooser();
    			 int val=ch.showOpenDialog(MyFrame.this);
    			 if(val==JFileChooser.APPROVE_OPTION)
    			 {
    				 rates.clear();
    				 String fn=ch.getSelectedFile().getAbsolutePath();
    				 try {
						FileReader rd=new FileReader(fn);
						Scanner sc=new Scanner(rd);
						int counter=0;
						while(sc.hasNextLine())
						{
							String line=sc.nextLine();
							counter++;
							if(counter==1)
							{
								continue;
							}
							String data[]=line.split(",");
							if(data.length!=3)
							{
								continue;
							}
							rate newrate=new rate(Integer.parseInt(data[0]),data[1],Double.parseDouble(data[2]));
							rates.add(newrate);
						}
						sc.close();
						Vector <String> elements=get_distinct_years();
				    	 for(String elem:elements)
				    	 {
				    		 combo.addItem(elem);
				    	 }
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(null,"No file selected");
						return;
					}
    			 }
    		 }
    	});
    	 it2.addActionListener(new ActionListener()
    	 {
    		 public void actionPerformed(ActionEvent e)
    		 {
    			 System.exit(0);
    		 }
    	 });
    	 menu.add(it1);
    	 menu.add(it2);
    	 bar.add(menu);
     }
     public MyFrame(String title)
     {
    	 super(title);
    	 this.setSize(500,500);
    	 this.setLayout(new GridLayout(0,1));
    	 JLabel label=new JLabel();
    	 int h=(30*this.getHeight())/100;
    	 label.setSize(this.getWidth(), h);
    	 ImageIcon img=new ImageIcon(new ImageIcon("marriages-divorces.jpg").getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
    	 label.setIcon(img);
    	 this.add(label);
    	 make_menu();
    	 panel1();
    	 panel2();
    	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 this.setVisible(true);
     }
}
