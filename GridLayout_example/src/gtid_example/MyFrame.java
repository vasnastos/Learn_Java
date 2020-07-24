package gtid_example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
   JLabel label1,label2;
   FlowLayout f;
   GridLayout lay1;
   BorderLayout b1;
   JPanel panel1;
   JPanel panel2;
   public MyFrame(String title)
   {
	   super(title);
	   this.setSize(400,400);
	   f=new FlowLayout();
	   this.setLayout(f);
	   panel1=new JPanel();
	   panel2=new JPanel();
	   this.add(panel1);
	   this.add(panel2);
	   lay1=new GridLayout(2,1);
	   panel1.setLayout(lay1);
	   panel2.setLayout(new GridLayout(2,1));
	   JLabel lab1,lab2,lab3;
	   lab1=new JLabel("Label 1 on panel 1");
	   lab1.setBackground(Color.red);
	   lab1.setForeground(Color.blue);
	   lab2=new JLabel("Label 2 on panel 1");
	   lab2.setBackground(Color.green);
	   lab2.setForeground(Color.red);
	   lab3=new JLabel();
	   lab3.setBackground(Color.yellow);
	   lab3.setForeground(Color.green);
	   lab3.setText("Label 3 on panel 2");
	   panel1.add(lab1);
	   panel1.add(lab2);
	   panel2.add(lab3);
	   JOptionPane.showMessageDialog(this, "Panel example pres ok to continue!!!!!");
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   this.setVisible(true);
   }
}
