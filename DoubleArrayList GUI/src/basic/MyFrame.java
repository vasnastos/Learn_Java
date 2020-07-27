package basic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
    JButton b1,b2,b3,b4;
    JLabel label;
    JTextField text;
    numbers_sequence s1;
    JPanel p1,p2,p3;
    JComboBox <String> combo=new JComboBox<String>();
    public void add_form()
    {
    	p1.setLayout(new GridLayout(1,3));
    	text=new JTextField("",7);
    	text.setToolTipText("Double Number");
    	b1=new JButton();
    	s1=new numbers_sequence();
    	b1.setText("ADD");
    	JLabel in=new JLabel("Add a number",JLabel.LEFT);
    	in.setForeground(Color.BLUE);
    	p1.add(in);
    	p1.add(text);
    	p1.add(b1);
    	b1.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			if(text.getText().length()==0)
    			{
    				JOptionPane.showMessageDialog(null,"Fill the number blank");
    				return;
    			}
    			s1.add_number(Double.parseDouble(text.getText()));
    			boolean found=false;
    			for(int i=0;i<combo.getItemCount();i++)
    			{
    				System.out.println(combo.getItemAt(i)+"--"+text.getText());
    				if(combo.getItemAt(i).equals(text.getText()))
    				{
    					found=true;
    				}
    			}
    			if(!found)
    			{
    			  combo.addItem(text.getText());
    			}
    		}
    	});
    }
    public void delete_form()
    {
    	p2.setLayout(new GridLayout(1,3));
    	b1=new JButton("Delete");
    	JLabel in=new JLabel("Delete a number",JLabel.CENTER);
    	in.setForeground(Color.BLUE);
    	p2.add(in);
    	p2.add(combo);
    	p2.add(b1);
    	b1.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			int index=combo.getSelectedIndex();
    			String num=combo.getItemAt(index);
    			combo.removeItemAt(index);
    			double convertnum=Double.parseDouble(num);
    			for(int i=0;i<s1.size();i++)
    			{
    				if(s1.get(i)==convertnum)
    				{
    					s1.remove_number(i);
    				}
    			}
    		}
    	});
    }
    public void buttons_party()
    {
    	p3.setLayout(new GridLayout(1,3));
    	b2=new JButton("AVERAGE");
    	b3=new JButton("MAX_MIN");
    	b4=new JButton("SHOW");
    	p3.add(b2);
    	p3.add(b3);
    	p3.add(b4);
    	b2.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			JOptionPane.showMessageDialog(null, "Average is:"+String.valueOf(s1.average()));
    		}
    	});
    	b3.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			double max=s1.max_element();
    			double min=s1.min_element();
    			String message="Max is:"+String.valueOf(max)+"\n";
    			message+="Min is:"+String.valueOf(min);
    			JOptionPane.showMessageDialog(null,message);
    		}
    	});
    	b4.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			JOptionPane.showMessageDialog(null, s1.show());
    		}
    	});
    }
    public MyFrame(String title)
    {
    	super(title);
    	this.setSize(400,400);
    	this.setLayout(new FlowLayout(FlowLayout.LEADING));
    	ImageIcon img=new ImageIcon("numbers.png");
    	JLabel image=new JLabel("",JLabel.CENTER);
    	image.setIcon(img);
    	int width=95*this.getWidth()/100;
    	int height=40*this.getHeight()/100;
    	image.setSize(width, height);
    	this.add(image);
    	p1=new JPanel();
    	p2=new JPanel();
    	p3=new JPanel();
    	this.add(p1);
    	this.add_form();
    	this.add(p2);
    	this.delete_form();
    	this.add(p3);
    	this.buttons_party();
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
    }
}
