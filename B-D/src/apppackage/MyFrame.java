package apppackage;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
	String names[]= {"Bin to Dec","Dec to Bin"};
    JComboBox <String> fr=new JComboBox<String>(names);
    JTextField text,res;
    JPanel p2;
    void panel1()
    {
       JLabel lb=new JLabel();
       lb.setSize(this.getWidth(),(int)(0.4*this.getHeight()));
       ImageIcon ic=new ImageIcon(new ImageIcon("icon.png").getImage().getScaledInstance(lb.getWidth(),lb.getHeight(),Image.SCALE_SMOOTH));
       lb.setIcon(ic);
       this.add(lb);
    }
    void panel2()
    {
    	p2=new JPanel();
    	p2.setLayout(new FlowLayout(FlowLayout.LEFT));
    	text=new JTextField(6);
    	res=new JTextField(6);
    	fr.addItemListener(new ItemListener()
    	{
    		public void itemStateChanged(ItemEvent ie)
    		{
    			if(text.getText().length()==0)
    			{
    				JOptionPane.showMessageDialog(null,"Empty field no available number for conversition");
    				return;
    			}
    			String sel=fr.getSelectedItem().toString();
    			if(sel.equals("Bin to Dec"))
    			{
    				String num=text.getText();
    				int counter=0;
    				for(int i=0;i<num.length();i++)
    				{
    					if(num.charAt(i)=='0' || num.charAt(i)=='1')
    					{
    						counter++;
    					}
    				}
    				if(counter!=num.length())
    				{
    					JOptionPane.showMessageDialog(null,"Not a Binary Number");
    					return;
    				}
    				Stack <Integer> digs=new Stack();
    				for(int i=0;i<num.length();i++)
    				{
    					String k="";
    					k+=num.charAt(i);
    					digs.push(Integer.parseInt(k));
    				}
    				int summary=0;
    				int j=1;
    				while(!digs.empty())
    				{
    					summary+=digs.peek()*j;
    					j*=2;
    					digs.pop();
    				}
    				res.setText(String.valueOf(summary));
    			}
    			else
    			{
    				int summary=Integer.parseInt(text.getText());
    				Stack <Character> digits=new Stack();
    				while(summary!=0)
    				{
    					digits.push((char) ((summary%2)+'0'));
    					summary/=2;
    				}
    				String result="";
    				while(!digits.empty())
    				{
    					result+=digits.peek();
    					digits.pop();
    				}
    				res.setText(result);
    			}
    		}
    	});
    	p2.add(text);
    	p2.add(fr);
    	p2.add(res);
    	this.add(p2);
    }
    MyFrame()
    {
    	this.setSize(400,400);
    	this.setTitle("Binary_Decimal Converter");
    	this.setLayout(new GridLayout(0,1));
    	panel1();
    	panel2();
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
    }
}
