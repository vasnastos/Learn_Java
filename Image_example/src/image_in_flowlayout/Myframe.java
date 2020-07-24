package image_in_flowlayout;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Myframe extends JFrame{
    FlowLayout lay;
    JLabel label,label2;
    public Myframe(String title)
    {
    	super(title);
    	this.setSize(300,300);
    	this.setResizable(true);
    	lay=new FlowLayout();
    	this.setLayout(lay);
    	ImageIcon img=new ImageIcon("test.png");
    	label=new JLabel(img,JLabel.CENTER);
    	this.add(label);
    	label2=new JLabel("Another Label");
    	this.add(label2);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
    }
}
