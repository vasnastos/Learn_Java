package app_package;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame{
  ArrayList <student> sp=new ArrayList<student>();
  JButton readButton;
  JButton showButton;
  MyFrame()
  {
	  this.setSize(300,300);
	  this.setTitle("Exersice 2 app window");
	  this.setResizable(false);
	  this.setLayout(new FlowLayout());
	  ImageIcon ic=new ImageIcon();
	  JLabel lb=new JLabel();
	  lb.setSize((int)(0.98*this.getWidth()),(int)(0.4*this.getHeight()));
	  ic.setImage(new ImageIcon("ArrayList.gif").getImage().getScaledInstance(lb.getWidth(),lb.getHeight(),Image.SCALE_REPLICATE));
	  lb.setIcon(ic);
	  readButton=new JButton("READ");
	  readButton.addActionListener(new ActionListener()
	  {
		  public void actionPerformed(ActionEvent e)
		  {
			  int id=Integer.parseInt(JOptionPane.showInputDialog("Give Student's Id"));
			  for(student s:sp)
			  {
				  if(s.getid()==id)
				  {
					  JOptionPane.showMessageDialog(null, "student "+String.valueOf(id)+" already exists in list");
					  return;
				  }
			  }
			  String name=JOptionPane.showInputDialog("Give student's name");
			  String lastname=JOptionPane.showInputDialog("Give student's lastname");
			  student newstudent=new student();
			  newstudent.set_name(name);
			  newstudent.setlastname(lastname);
			  newstudent.setid(id);
			  sp.add(newstudent);
			  JOptionPane.showMessageDialog(null,"Student "+String.valueOf(id)+" added in to the list");
		  }
	  });
	  showButton=new JButton("SHOW");
	  showButton.addActionListener(new ActionListener()
	{
		  public void actionPerformed(ActionEvent e)
		  {
			  if(sp.size()==0)
			  {
				  JOptionPane.showMessageDialog(null,"No student on the list");
				  return;
			  }
			  String message="<html><body>";
			  message+="<h3 style=text-align:center; color:red;>Students List</h3>";
			  message+="<ul>";
			  for(student s:sp)
			  {
				  message+="<li>"+s.getname()+"-"+s.getlastname()+"-"+String.valueOf(s.getid())+"</li>";
			  }
			  message+="</ul></body></html>";
			  JOptionPane.showMessageDialog(null, message);
		  }
	});
	  this.add(lb);
	  this.add(readButton);
	  this.add(showButton);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setVisible(true);
  }
}
