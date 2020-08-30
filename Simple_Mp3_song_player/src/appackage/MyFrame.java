package appackage;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MyFrame extends JFrame{
	Player p;
	int pos;
     JComboBox <String> songs=new JComboBox<String>();
     JPanel p1;
     int status=0;
     void panel1()
     {
    	 p1=new JPanel();
    	 p1.setLayout(new FlowLayout());
    	 JLabel lb=new JLabel("Control Panel",JLabel.LEFT);
    	 JButton b0=new JButton("Load");
    	 b0.addActionListener(new ActionListener()
    	 {
    		 public void actionPerformed(ActionEvent e)
    		 {
    			JFileChooser file=new JFileChooser();
    			int rval=file.showOpenDialog(MyFrame.this);
    			if(rval==JFileChooser.APPROVE_OPTION)
    			{
    				String fn=file.getSelectedFile().getAbsolutePath();
    				FileInputStream fis=null;
    				try {
						fis=new FileInputStream(fn);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    				try {
						p=new Player(fis);
					} catch (JavaLayerException e1) {
					System.out.println("Error");
					}
    			}
    		 }
    	 });
    	 JButton b1=new JButton("Play");
    	 b1.addActionListener(new ActionListener()
    	 {
    		 public void actionPerformed(ActionEvent e)
    		 {
    			 if(status==1)
    			 {
    				 try {
						p.play(pos);
					} catch (JavaLayerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    				 status=0;
    				 return;
    			 }
    			try {
					p.play();
				} catch (JavaLayerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		 }
    	 });
    	 p1.add(lb);
    	 p1.add(b0);
    	 p1.add(b1);
    	 this.add(p1);
     }
     MyFrame()
     {
    	 this.setSize(600,600);
    	 this.setTitle("Multimedia Test");
    	 this.setLayout(new GridLayout(0,1));
    	 panel1();
    	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 this.setVisible(true);
     }
}
