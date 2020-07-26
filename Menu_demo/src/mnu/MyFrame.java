package mnu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame{
    JMenu men;
    JMenuItem it1,it2,it3;
    JMenuBar bar;
    public MyFrame(String t)
    {
    	super(t);
    	this.setSize(400, 200);
    	this.setLayout(new FlowLayout());
    	bar=new JMenuBar();
    	this.setJMenuBar(bar);
    	men=new JMenu();
    	men.setText("File");
    	it1=new JMenuItem("Load");
    	it2=new JMenuItem("Save");
    	it3=new JMenuItem("Exit");
    	men.add(it1);
    	men.add(it2);
    	men.add(it3);
    	it1.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			JOptionPane.showMessageDialog(null,e.getActionCommand()+" selected");
    		}
    	});
    	it2.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			JOptionPane.showMessageDialog(null,e.getActionCommand()+" selected");
    		}
    	});
    	it3.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			System.exit(0);
    		}
    	});
    	bar.add(men);
    	JLabel label=new JLabel();
    	label.setText("Demo for menu usage uploaded for academic use at \n :https://github.com/vasnastos/Learn_Java");
    	this.add(label);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
    }
}
