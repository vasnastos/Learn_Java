package appackage;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;

public class MyFrame extends JFrame{
     JPanel p1,p2,p3,p4;
     List <object> stats=new ArrayList<object>();
     JList <String> showlist;
     JComboBox <String> pers=new JComboBox<String>();
     DefaultListModel <String> model;
     void centralpicture()
     {
    	 p1=new JPanel();
    	 p1.setLayout(new FlowLayout());
    	 JLabel label=new JLabel();
    	 label.setSize((int)(0.98*this.getWidth()),(int)(0.5*this.getHeight()));
    	 ImageIcon ic=new ImageIcon(new ImageIcon("central.jpg").getImage().getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_REPLICATE));
    	 label.setIcon(ic);
    	 p1.add(label);
    	 this.add(p1);
     }
     
     void make_menu()
     {
    	 JMenuBar bar=new JMenuBar();
    	 JMenu menu=new JMenu("EDIT");
    	 this.setJMenuBar(bar);
    	 JMenuItem it1=new JMenuItem("LOAD");
    	 ImageIcon item1icon=new ImageIcon(new ImageIcon("laodsong.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH));
    	 it1.setIcon(item1icon);
    	 it1.addActionListener(new ActionListener()
    	 {
    		 public void actionPerformed(ActionEvent ae)
    		 {
    			 JFileChooser ch=new JFileChooser();
    			 ch.setDialogTitle("Choose Csv file");
    			 ch.setFileFilter(new FileFilter()
    			{
    				 @Override
							public boolean accept(File f) {
						if(f.getParent().toLowerCase().endsWith(".csv"))
						{
							return true;
						}
						return false;
				}

					@Override
					public String getDescription() {
						return "Csv file with stats";
					}	 
    			});
    			 int retval=ch.showOpenDialog(MyFrame.this);
    			 if(retval==JFileChooser.APPROVE_OPTION)
    			 {
    				 String fn=ch.getSelectedFile().getAbsolutePath();
    				 try {
						FileReader rd=new FileReader(fn);
						Scanner sc=new Scanner(rd);
						while(sc.hasNextLine())
						{
							String line=sc.nextLine();
							if(line.startsWith("#")) continue;
							String data[]=line.split(",");
							if(data.length!=3) continue;
							object obj=new object(data[0],data[1],Double.parseDouble(data[2]));
							stats.add(obj);
							model.addElement(obj.to_str());
							boolean found=false;
							for(int i=0;i<pers.getItemCount();i++)
							{
								if(pers.getItemAt(i).equals(data[0]))
								{
									found=true;
									break;
								}
							}
							if(!found)
							{
								pers.addItem(data[0]);
							}
						}
						
						sc.close();
					} catch (FileNotFoundException e) {
						JOptionPane.showMessageDialog(null,"No file found");
					}
    			 }
    		 }
    	 });
    	 JMenuItem it2=new JMenuItem("EXIT");
    	 ImageIcon ic2=new ImageIcon(new ImageIcon("quit.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH));
    	 it2.setIcon(ic2);
    	 it2.addActionListener(new ActionListener()
    	{
    		 public void actionPerformed(ActionEvent ae)
    		 {
    			 System.exit(0);
    		 }
    	});
    	 menu.add(it1);
    	 menu.add(it2);
    	 bar.add(menu);
     }
     void first_row()
     {
    	 p2=new JPanel();
    	 p2.setLayout(new FlowLayout());
    	 model=new DefaultListModel();
    	 showlist=new JList<String>(model);
    	 showlist.setSize((int)(0.98*this.getWidth()),(int)0.4*this.getHeight());
    	 p2.add(showlist);
    	 this.add(p2);
     }
     void second_row()
     {
    	 p3=new JPanel();
    	 p3.setLayout(new FlowLayout());
    	  JLabel lb=new JLabel();
    	  lb.setSize((int)(0.2*this.getWidth()),(int)(0.1*this.getHeight()));
    	  lb.setForeground(Color.blue);
    	  lb.setText("SEARCH BY PERIOD");
    	 JButton b1=new JButton("SEARCH");
    	 b1.addActionListener(new ActionListener()
    	{
    		 public void actionPerformed(ActionEvent ae)
    		 {
    			 String prd=pers.getSelectedItem().toString();
    			 String message="<html><body><ul><h3>"+prd+"</h3>";
    			 for(object obj:stats)
    			 {
    				 if(obj.getperiod()==prd)
    				 {
    					 message+="<li>"+obj.getgender()+"-"+String.valueOf(obj.getage())+"</li>";
    				 }
    			 }
    			 message+="</ul></body></html>";
    			 JOptionPane.showMessageDialog(null,message);
    		 }
    	}); 
    	 p3.add(lb);
    	 p3.add(pers);
    	 p3.add(b1);
    	 this.add(p3);
     }
     void third_row()
     {
    	 p4=new JPanel();
    	 p4.setLayout(new FlowLayout());
    	 JButton but=new JButton();
    	 but.setSize((int)(0.1*this.getWidth()),(int)(0.05*this.getHeight()));
    	 ImageIcon butic=new ImageIcon(new ImageIcon("male.png").getImage().getScaledInstance(but.getWidth(),but.getHeight(),Image.SCALE_SMOOTH));
    	 but.setIcon(butic);
    	 but.addActionListener(new ActionListener()
    	 {
    		 public void actionPerformed(ActionEvent ae)
    		 {
    			 String message="<html><body><h3>Information for Males</h3><ul>";
    			 for(object obj:stats)
    			 {
    				 if(obj.getgender().equals("Male"))
    				 {
    					 message+="<li>"+obj.getperiod()+"-"+String.valueOf(obj.getage())+"</li>";
    				 }
    			 }
    			 message+="</ul></body></html>";
    			 JOptionPane.showMessageDialog(null, message);
             }
    	 });
    	 JButton but1=new JButton();
    	 but1.setSize((int)(0.1*this.getWidth()),(int)(0.05*this.getHeight()));
    	 ImageIcon butic1=new ImageIcon(new ImageIcon("female.png").getImage().getScaledInstance(but.getWidth(),but.getHeight(),Image.SCALE_SMOOTH));
    	 but1.setIcon(butic1);
    	 but1.addActionListener(new ActionListener()
    	 {
    		 public void actionPerformed(ActionEvent ae)
    		 {
    			 String message="<html><body><h3>Information for Females</h3><ul>";
    			 for(object obj:stats)
    			 {
    				 if(obj.getgender().equals("Female"))
    				 {
    					 message+="<li>"+obj.getperiod()+"-"+String.valueOf(obj.getage())+"</li>";
    				 }
    			 }
    			 message+="</ul></body></html>";
    			 JOptionPane.showMessageDialog(null, message);
             }
    	 });
    	 p4.add(but);
    	 p4.add(but1);
    	 this.add(p4);
     }
     public MyFrame()
     {
    	 this.setSize(300,300);
    	 this.setResizable(false);
    	 this.setTitle("Divorces-Marriages");
    	 this.setLayout(new GridLayout(0,1));
    	 make_menu();
    	 centralpicture();
    	 first_row();
    	 second_row();
    	 third_row();
    	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 this.setVisible(true);
     }
}
