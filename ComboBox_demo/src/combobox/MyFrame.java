package combobox;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {
	String items[]= {"school","factory","car","home"};
   JComboBox <String> combo=new JComboBox<>(items);
   JLabel label;
   public MyFrame(String name)
   {
	   super(name);
	   this.setSize(600,600);
	   this.setLayout(new GridLayout(2,1));
	   this.add(combo);
	   label=new JLabel();
	   int w=this.getWidth()*30/100;
	   int h=this.getHeight()*10/100;
	   label.setSize(w, h);
	   this.add(label);
	   combo.addItemListener(new ItemListener()
	   {
		   public void itemStateChanged(ItemEvent e)
		   {
			   if(e.getStateChange()==ItemEvent.SELECTED)
			   {
				   for(int i=0;i<4;i++)
				   {
					   if(combo.getSelectedIndex()==i)
					   {
						   ImageIcon img=new ImageIcon(items[i]+".png");
						   label.setIcon(img);
					   }
				   }
			   }
		   }
	   });
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   this.setVisible(true);
   }
}
