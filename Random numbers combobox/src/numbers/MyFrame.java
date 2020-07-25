package numbers;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	String names[]= {"Sum","Average","Max","Min"};
     JComboBox <String> combo=new JComboBox<String>();
     Vector <Integer> numbers=new Vector<Integer>();
     JTextField num;
     JButton b1;
     public MyFrame(String t)
     {
    	 super(t);
    	 this.setSize(400,400);
    	 this.setLayout(new FlowLayout());
    	 JPanel p1,p2;
    	 p1=new JPanel();
    	 p2=new JPanel();
    	 this.add(p1);
    	 this.add(p2);
    	 ImageIcon img=new ImageIcon("number.png");
    	 JLabel label=new JLabel(img,JLabel.CENTER);
    	 p1.setLayout(new FlowLayout());
    	 p2.setLayout(new FlowLayout());
    	 p1.add(label);
    	 num=new JTextField(10);
    	 b1=new JButton("INSERT");
    	 for(String n:names)
    	 {
    		 combo.addItem(n);
    	 }
    	 p2.add(num);
    	 p2.add(b1);
    	 p2.add(combo);
    	 b1.addActionListener(new ActionListener()
         {
    		 public void actionPerformed(ActionEvent e)
    		 {
    			 if(num.getText().length()==0)
    			 {
    				 JOptionPane.showMessageDialog(null,"Fill the blanks");
    			 }
    			 int number=Integer.parseInt(num.getText());
    			 numbers.add(number);
    		 }
         });
    	 combo.addItemListener(new ItemListener()
    	{
    		 public void itemStateChanged(ItemEvent e)
    		 {
    			 if(e.getStateChange()==ItemEvent.SELECTED)
    			 {
    				 if(combo.getSelectedIndex()==0)
    				 {
    					 int sum=0;
    					 for(Integer i:numbers)
    					 {
    						 sum+=i;
    					 }
    					 JOptionPane.showMessageDialog(null,"Sum="+String.valueOf(sum));
    				 }
    				 else if(combo.getSelectedIndex()==1)
    				 {
    					 int sum=0;
    					 for(Integer i:numbers)
    					 {
    						 sum+=i;
    					 }
    					 double avg=(double)sum/numbers.size();
    					 JOptionPane.showMessageDialog(null,"Average="+String.valueOf(avg)); 
    				 }
    				 else if(combo.getSelectedIndex()==2)
    				 {
    					 int max=numbers.get(0);
    					 for(int i=1;i<numbers.size();i++)
    					 {
    						 if(numbers.get(i)>max)
    						 {
    							 max=numbers.get(i);
    						 }
    					 }
    					 JOptionPane.showMessageDialog(null,"Max="+String.valueOf(max));
    				 }
    				 else if(combo.getSelectedIndex()==3)
    				 { 
    					 int min=numbers.get(0);
					     for(int i=1;i<numbers.size();i++)
					     {
						   if(numbers.get(i)<min)
						   {
							  min=numbers.get(i);
						   }
					     }
					     JOptionPane.showMessageDialog(null,"Min="+String.valueOf(min));
    			    }
    			 }
    		 }
    	    });
    	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 this.setVisible(true);
     }
}