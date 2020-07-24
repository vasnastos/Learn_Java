package simple;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {
  private BorderLayout lay;
  private JLabel label;
  private JButton button;
  MyFrame(String title)
  {
	  super(title);
	  this.setSize(300,300);
	  lay=new BorderLayout();
	  this.setLayout(lay);
	  label=new JLabel();
	  label.setText("Tryout Label");
	  int labelwidth=20*this.getWidth()/100;
	  int labelheight=20*this.getHeight()/100;
	  label.setSize(labelwidth,labelheight);
	  this.add(label,BorderLayout.CENTER);
	  button=new JButton("button");
	  button.setBackground(Color.blue);
	  this.add(button);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setVisible(true);
  }
}
