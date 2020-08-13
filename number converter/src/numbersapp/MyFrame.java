package numbersapp;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Stack;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
    JComboBox <String> systems=new JComboBox();
    JPanel panel1,panel2;
    void fillcomboBox()
    {
    	systems.addItem("Binary");
    	systems.addItem("Hex");
    	systems.addItem("Octal");
    }
    void form1()
    {
    	panel1=new JPanel();
    	panel1.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
    	JTextField num=new JTextField(6);
    	num.setToolTipText("Give decimal integer number");
    	JTextField res=new JTextField(6);
    	systems.addItemListener(new ItemListener()
    	{
    	     public void itemStateChanged(ItemEvent e)
    	     {
    		    if(e.getStateChange()==ItemEvent.SELECTED)
    		    {
    		    	if(systems.getSelectedIndex()==0)
    		    	{
    		    		if(num.getText().length()==0)
    		    		{
    		    			JOptionPane.showMessageDialog(null,"Please give a number");
    		    			return;
    		    		}
    		    		int number=Integer.parseInt(num.getText());
    		    		Stack <Character> digits=new Stack();
    		    		String result="";
    		    		while(number!=0)
    		    		{
    		    			digits.push((char) ((number%2)+'0'));
    		    			number/=2;
    		    		}
    		    		while(!digits.empty())
    		    		{
    		    			result+=digits.peek();
    		    			digits.pop();
    		    		}
    		    		res.setText(result);
    		    		res.setToolTipText("to "+systems.getSelectedItem().toString());
    		    	}
    		    	else if(systems.getSelectedIndex()==1)
    		    	{
    		    		int number=Integer.parseInt(num.getText());
    		    		Stack <Character> digits=new Stack();
    		    		while(number!=0)
    		    		{
    		    			char symbol;
    		    			if(number%16>9 && number%16<=15)
    		    			{
    		    				symbol=(char)((number%16-9)+'A');
    		    			}
    		    			else
    		    			{
    		    				symbol=(char) ((number%16)+'0');
    		    			}
    		    			digits.push(symbol);
    		    			number/=16;
    		    		}
    		    		String result="";
    		    		while(!digits.empty())
    		    		{
    		    			result+=digits.peek();
    		    			digits.pop();
    		    		}
    		    		res.setText(result);
    		    		res.setToolTipText("to "+systems.getSelectedItem().toString());
    		    	}
    		    	else
    		    	{
    		    		int number=Integer.parseInt(num.getText());
    		    		Stack <Character> digits=new Stack();
    		    		String result="";
    		    		while(number!=0)
    		    		{
    		    			digits.push((char) ((number%8)+'0'));
    		    			number/=8;
    		    		}
    		    		while(!digits.empty())
    		    		{
    		    			result+=digits.peek();
    		    			digits.pop();
    		    		}
    		    		res.setText(result);
    		    		res.setToolTipText("to "+systems.getSelectedItem().toString());
    		    	}
    		    }
    	     }
    	});
    	panel1.add(num);
    	panel1.add(systems);
    	panel1.add(res);
    	this.add(panel1);
    }
    MyFrame()
    {
    	super("App Gui");
    	this.setSize(500,500);
    	this.setLayout(new GridLayout(0,1));
    	fillcomboBox();
    	form1();
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
    }
}
