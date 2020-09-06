package musicpackage;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.beans.value.ObservableValue;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MyFrame extends JFrame{
   JPanel p1,p2;
   MediaPlayer player=null;
   JLabel gifsong;
   String song="";
   double volume=0.10;
   boolean muted=false;
   void makemenu()
   {
	   JMenuBar bar=new JMenuBar();
	   this.setJMenuBar(bar);
	   JMenu menu=new JMenu("EDIT");
	   JMenuItem it1=new JMenuItem("Song");
	   it1.setIcon(new ImageIcon(new ImageIcon("song.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH)));
	   it1.addActionListener(new ActionListener()
	   {
		   public void actionPerformed(ActionEvent ae)
		   {
			   JFileChooser ch=new JFileChooser();
			   int rval=ch.showOpenDialog(MyFrame.this);
			   if(rval==JFileChooser.APPROVE_OPTION)
			   {
				   String fn=ch.getSelectedFile().getAbsolutePath();
				   File fp=new File(fn);
				   song=fn;
				   String filepath=fp.toURI().toString();
				   Media med=new Media(filepath);
				   player=new MediaPlayer(med);
				   player.setVolume(volume);
			   }
		   }
	   });
	   JMenuItem it2=new JMenuItem("PlayedSong");
	   it2.setIcon(new ImageIcon(new ImageIcon("info.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
	   it2.addActionListener(new ActionListener()
	   {
		   public void actionPerformed(ActionEvent ae)
		   {
			   if(song=="")
			   {
				   JOptionPane.showMessageDialog(null,"No song is currently played");
				   return;
			   }
			   String data[]=song.split("/");
			   JOptionPane.showMessageDialog(null,"Song Played:"+data[data.length-1]);
		   }
	   });
	   menu.add(it1);
	   menu.add(it2);
	   bar.add(menu);
   }
   void Gifpanel()
   {
	   p2=new JPanel();
	   p2.setLayout(new FlowLayout());
	   gifsong=new JLabel();
	   gifsong.setSize((int)(0.98*this.getWidth()),(int)(0.4*this.getHeight()));
	   ImageIcon icon=new ImageIcon("music.gif");
	   icon.setImage(icon.getImage().getScaledInstance(gifsong.getWidth(),gifsong.getHeight(),Image.SCALE_REPLICATE));
	   gifsong.setIcon(icon);
	   p2.add(gifsong);
	   this.add(p2);
   }
   void songoptions()
   {
	   p1=new JPanel();
	   p1.setLayout(new FlowLayout());
	   JButton b1=new JButton("Play");
	   JButton b2=new JButton("Pause");
	   b1.addActionListener(new ActionListener()
		{
		   public void actionPerformed(ActionEvent e)
		   {
			   if(player!=null)
			   {
				   player.play();
			   }
		   }
		});
	   b2.addActionListener(new ActionListener()
	   {
		   public void actionPerformed(ActionEvent e)
		   {
			   if(player!=null)
			   {
				   player.pause();
			   }
		   }
	   });
	   JSlider slider=new JSlider(JSlider.HORIZONTAL);
	   slider.setMaximum(100);
	   slider.setMinimum(0);
	   slider.setValue((int)(volume*100));
	   slider.addChangeListener(new ChangeListener()
	    {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				int newval=slider.getValue();
				volume=(double)(newval)/100.0;
				player.setVolume(volume);
			}
          
	    });
	   JButton b3=new JButton("Mute");
	   b3.addActionListener(new ActionListener()
	   {
		   public void actionPerformed(ActionEvent ae)
		   {
			   muted=!muted;
			   player.setMute(muted);
		   }
	   });
	   p1.add(b1);
	   p1.add(b2);
	   p1.add(slider);
	   p1.add(b3);
	   this.add(p1);
   }
   MyFrame()
   {
	   this.setSize(500,400);
	   this.setResizable(false);
	   this.setTitle("Music file player");
	   this.setLayout(new GridLayout(0,1));
	   makemenu();
	   Gifpanel();
	   songoptions();
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   this.setVisible(true);
   }
}