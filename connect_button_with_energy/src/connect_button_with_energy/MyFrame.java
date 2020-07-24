package connect_button_with_energy;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame{
    JButton b1,b2;
    FlowLayout lay;
    public MyFrame(String title)
    {
    	super(title);
    	this.setSize(400,400);
    	lay=new FlowLayout();
    	this.setLayout(lay);
    	b1=new JButton();
    	b1.setText("Button1");
    	b2=new JButton("button2");
    	this.add(b1);
    	this.add(b2);
    	b1.addActionListener(new ActionListener() 
    	{
    		public void actionPerformed(ActionEvent e) 
    		{
    			JOptionPane.showMessageDialog(null,"button 1 pressed!!");
    		}
    	});
    	b2.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			JOptionPane.showMessageDialog(null,"button 2 pressed");
    		}
    	});
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
    }
}
