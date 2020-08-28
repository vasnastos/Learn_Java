package appackage;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javafx.util.Pair;

public class MyFrame extends JFrame{
  JTextField f1;
  JPanel p1,p2,p3;
  String in[]= {"To ASCII","TO BINARY"};
  JComboBox <String> sel=new JComboBox<String>(in);
  Vector <Pair<Character,String>> transforms=new Vector<Pair<Character,String>>();
  void panel1()
  {
	  p1=new JPanel();
	  p1.setLayout(new FlowLayout());
	  f1=new JTextField(6);
	  f1.setBackground(java.awt.Color.white);
	  sel.addItemListener(new ItemListener()
	   {
		  public void itemStateChanged(ItemEvent e)
		  {
			 
			  if(e.getStateChange()==ItemEvent.SELECTED)
			  {
				  if(f1.getText().length()==0)
				  {
					  JOptionPane.showMessageDialog(null,"No input have been given");
					  return;
				  }
				  String selectoption=sel.getItemAt(sel.getSelectedIndex());
				  if(selectoption.equals("TO BINARY"))
				  {
					  String result="";
					  String text=f1.getText();
					  for(int i=0;i<text.length();i++)
					  {
						 for(Pair <Character,String> x:transforms)
						 {
							 if(x.getKey()==text.charAt(i))
							 {
								 result+=x.getValue()+" ";
								 break;
							 }
						 }
					  }
					  JOptionPane.showMessageDialog(null,f1.getText()+"==>"+result);
				  }
				  else
				  {
					  String result="";
					  String text=f1.getText();
					  String data[]=text.split(" ");
					  for(int i=0;i<data.length;i++)
					  {
						  for(Pair <Character,String> p:transforms)
						  {
							  if(data[i].equals(p.getValue()))
							  {
								  result+=p.getKey();
								  break;
							  }
						  }
					  }
					  JOptionPane.showMessageDialog(null,text+"==>"+result);
				  }
			  }
		  }
	   });
	  p1.add(f1);
	  p1.add(sel);
	  this.add(p1);
  }
  void load_ascii_to_binary()
  {
	  String fn="ascii_indeex.txt";
	  try {
		FileReader fr=new FileReader(fn);
		Scanner sc=new Scanner(fr);
		while(sc.hasNextLine())
		{
			String line=sc.nextLine();
			String data[]=line.split(",");
			Pair <Character,String> p1=new Pair<Character, String>(data[0].charAt(0),data[1]);
			transforms.add(p1);
		}
		sc.close();
	} catch (FileNotFoundException e) {
		JOptionPane.showMessageDialog(null,"No file loaded");
	}
  }
  void panel0()
  {
	  JLabel lb=new JLabel();
	  lb.setSize((int)(0.98*this.getWidth()),(int)(0.3*this.getHeight()));
	  ImageIcon ic=new ImageIcon(new ImageIcon("icon.jpg").getImage().getScaledInstance(lb.getWidth(),lb.getHeight(),Image.SCALE_SMOOTH));
	  lb.setIcon(ic);
	  this.add(lb);  
  }
  void panel2()
  {
	  p3=new JPanel();
	JTextArea ar1=new JTextArea(5,30);
	ar1.setAlignmentX(JTextArea.LEFT_ALIGNMENT);
	ar1.setSize((int)(0.50*this.getWidth()),(int)(0.4*this.getHeight()));
	ar1.setEditable(true);
	JButton b1=new JButton("SAVE");
	b1.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			String name="";
			name=JOptionPane.showInputDialog("Give Name of file you want to save the result","");
			if(name==null)
			{
				ar1.setText("");
				return;
			}
			try {
				FileWriter fw=new FileWriter(name);
				int counter=0;
				int counter1=0;
				String text=ar1.getText();
				String data[]=text.split(" ,.");
				for(int i=0;i<data.length;i++)
				{
					int letters=0,digits=0;
					for(int j=0;j<data[i].length();j++)
					{
						if(data[i].charAt(j)>='0' && data[i].charAt(j)<='9')
						{
							digits++;
						}
						else 
						{
							letters++;
						}
					}
					if(digits==data[i].length()) counter++;
					else counter1++;
				}
				if(data.length==counter1)
				{
					PrintWriter pw=new PrintWriter(fw);
					String time=java.time.LocalDateTime.now().toString();
					pw.println("File Created at:"+time);
					pw.println("Input text:");
					pw.println(ar1.getText());
					pw.println("");
					pw.println("Output By Converter");
					String result="";
					for(int i=0;i<data.length;i++)
					{
						String text1=data[i];
						 for(int j=0;j<text1.length();j++)
						  {
							 for(Pair <Character,String> x:transforms)
							 {
								 if(x.getKey()==text1.charAt(i))
								 {
									 result+=x.getValue()+" ";
									 break;
								 }
							 }
						  }
					  }
					pw.println(result);
					pw.close();
				}
				else if(data.length==counter)
				{
					PrintWriter pw=new PrintWriter(fw);
					String time=java.time.LocalDateTime.now().toString();
					pw.println("File Created at:"+time);
					pw.println("Input text:");
					pw.println(f1.getText());
					pw.println("");
					pw.println("Output By Converter");
					String result="";
					for(int i=0;i<data.length;i++)
					{
						for(Pair <Character,String> p:transforms)
						{
							 if(data[i].equals(p.getValue()))
							 {
								  result+=p.getKey();
							      break;
						     }
						 }
					  }
					pw.println(result);
					pw.close();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid type");
					return;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
	p3.add(ar1);
	p3.add(b1);
	this.add(p3);
	
  }
  public MyFrame()
  {
	  this.setSize(500,500);
	  this.setTitle("Binary-Text Converter");
	  this.setBackground(java.awt.Color.decode("#699ff5"));
	  this.load_ascii_to_binary();
	  System.out.println(String.valueOf(transforms.size()));
	  this.setLayout(new GridLayout(0,1));
	  panel0();
	  panel1();
	  panel2();
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setVisible(true);
  }
}
