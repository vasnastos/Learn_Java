package textfield;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class form extends JFrame{
  JButton b1,b2;
  JLabel label;
  JPanel panel;
  JTextField tex;
  List <Double> numbers=new ArrayList<Double>();
  public form(String title)
  {
	  super(title);
	  this.setSize(500,500);
	  this.setLayout(new GridLayout(2,3));
	  ImageIcon img=new ImageIcon("numbers.png");
	  label=new JLabel(img,JLabel.CENTER);
	  img.setDescription("Basic numbers image");
	  //Τοποθέτηση στο κέντρο του label
	  this.add(label);
	  panel=new JPanel();
	  this.add(panel);
	  panel.setLayout(new FlowLayout(FlowLayout.CENTER));
	  tex=new JTextField(10);
	  b1=new JButton("Add");
	  b2=new JButton("Show");
	  tex.setToolTipText("Insert Double Number");
	  panel.add(tex);
	  panel.add(b1);
	  panel.add(b2);
	  b1.addActionListener(new ActionListener()
	  {
		public void actionPerformed(ActionEvent e)
		{
			if(tex.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"Fill the number blank");
				return;
			}
			double number=Double.parseDouble(tex.getText());
			numbers.add(number);
		}
	  });
	  b2.addActionListener(new ActionListener()
	  {
		  public void actionPerformed(ActionEvent e)
		  {
			  String list="List of Numbers::\n";
			  for(Double x:numbers)
			  {
				  list+="Number:"+String.valueOf(x)+"\n";
			  }
			  JOptionPane.showMessageDialog(null,list);
		  }
	  });
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setVisible(true);
  }
}
