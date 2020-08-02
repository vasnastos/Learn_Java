package appPackage;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class MyFrame extends JFrame{
     Vector <stats> statistics=new Vector();
     JComboBox <String> ages=new JComboBox();
     JTextArea results=new JTextArea();
     void panel_1()
     {
    	 JPanel p1=new JPanel();
    	 p1.setLayout(new FlowLayout(FlowLayout.CENTER,12,18));
    	 JLabel label=new JLabel("Search by Age",JLabel.RIGHT);
    	 JButton sh=new JButton("Search");
    	 sh.addActionListener(new ActionListener()
    	 {
    		 public void actionPerformed(ActionEvent ae)
    		 {
    			 String age=ages.getSelectedItem().toString();
    			 String message="";
    			 message+="Information for "+age+"\n";
    			 for(stats s:statistics)
    			 {
    				 if(s.get_age().equals(age))
    				 {
    					 message+=s.to_string()+"\n";
    				 }
    			 }
     			 results.setText(message);
    			 //JOptionPane.showMessageDialog(null, message);
    		 }
    	 });
    	 p1.add(label);
    	 p1.add(ages);
    	 p1.add(sh);
    	 this.add(p1);
     }
     
     private void fill_ages()
     {
    	for(stats s:statistics)
    	{
    		boolean found=false;
    		for(int i=0;i<ages.getItemCount();i++)
    		{
    			if(ages.getItemAt(i).equals(s.get_age()))
    			{
    				found=true;
    			}
    		}
    		if(!found)
    		{
    			ages.addItem(s.get_age());
    		}
    	}
     }
     
     void make_menu()
     {
    	 JMenu men=new JMenu();
    	 men.setText("FILE");
    	 JMenuBar bar=new JMenuBar();
    	 this.setJMenuBar(bar);
    	 JMenuItem item1=new JMenuItem("LOAD");
    	 item1.addActionListener(new ActionListener()
    	  {
    		 public void actionPerformed(ActionEvent ae)
    		 {
    			 //file selector
    			 JFileChooser chooser=new JFileChooser();
    			 int counter=0;
    			 int res=chooser.showOpenDialog(MyFrame.this);
    			 if(res==JFileChooser.APPROVE_OPTION)
    			 {
    					 String fn=chooser.getSelectedFile().getAbsolutePath();//file path 
    					 FileReader fr=null;
    					 try {
							fr=new FileReader(fn);
						} catch (FileNotFoundException e) {
							JOptionPane.showMessageDialog(null, "No file found or selected");
						}
    					 Scanner sc=new Scanner(fr);
    					 while(sc.hasNextLine())
    					 {
    						 String line=sc.nextLine();
    						 counter++;
    						 if(counter==1) continue;
    						 if(line.startsWith("#")) continue;
    						 String data[]=line.split(",");
    						 int count=0;
    						 for(String x:data)
    						 {
    							 System.out.println(x);
    							 count++;
    						 }
    						 if(count!=4) continue;
    						 stats newstat=new stats(data[0],data[1],data[2],Integer.parseInt(data[3]));
    						 statistics.add(newstat);
    					 }
    					 System.out.println(counter);
    					 sc.close();
    		             fill_ages();			
    			 }
    			 else
    			 {
    				 JOptionPane.showMessageDialog(null, "You did not select a file");
    			 }
    		 }
    	  });
    	 JMenuItem item2=new JMenuItem("EXIT");
    	 item2.addActionListener(new ActionListener()
    	  {
    		 public void actionPerformed(ActionEvent ae)
    		 {
    			 System.exit(0);
    		 }
    	  });
    	 men.add(item1);
    	 men.add(item2);
    	 bar.add(men);
     }
     public MyFrame()
     {
    	 super("File example 1");
    	 this.setSize(750,750);
    	 this.setLayout(new GridLayout(0,1,5,10));
    	 ImageIcon ic=new ImageIcon(new ImageIcon("stats.png").getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH));
    	 JLabel lb=new JLabel(ic,JLabel.CENTER);
    	 this.add(lb);
    	 panel_1();
    	 make_menu();
    	 JScrollPane pane=new JScrollPane(results);
    	 pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    	 this.add(pane);
    	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 this.setVisible(true);
     }
}
