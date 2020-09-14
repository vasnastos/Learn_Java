package musicpackage;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class MyFrame extends JFrame{
   JPanel p1,p2;
   MediaPlayer player=null;
   JLabel gifsong;
   JSlider duration;
   String song="";
   double volume=0.10;
   boolean muted=false;
   boolean paused=true;
   JButton b1=new JButton();
   JList <String> lst=new JList<String>();
   DefaultListModel model=null;
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
				   String f=ch.getSelectedFile().getAbsolutePath();
				   model.addElement(f);
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
			   JOptionPane.showMessageDialog(null,"Song Played:"+lst.getSelectedValue());
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
	   gifsong.setSize((int)(0.98*this.getWidth()),(int)(0.3*this.getHeight()));
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
	   b1.setText("Play");
	   b1.addActionListener(new ActionListener()
	    {
		   public void actionPerformed(ActionEvent e)
		   {
			   paused=!paused;
			   if(!paused && player!=null)
			   {
				   player.play();
				   b1.setText("Pause");
			   }
			   else
			   {
				   if(player!=null)
				   {
					   player.pause();
					   b1.setText("Play");
				   }
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
	   JButton next=new JButton("Next");
	   next.addActionListener(new ActionListener()
	   {
		   public void actionPerformed(ActionEvent e)
		   {
			   if(player!=null)
			   {
				   player.stop();
			   }
			   int i=lst.getSelectedIndex();
			   System.out.print(lst.getLastVisibleIndex());
			   if(i==lst.getLastVisibleIndex())
			   {
			    i=0;
			   }
			   else
			   {
				   i++;
			   }
			   lst.setSelectedIndex(i);
			   File fp=new File(lst.getSelectedValue());
			   String filepath=fp.toURI().toString();
			   Media m=new Media(filepath);
			   player=new MediaPlayer(m);
			   player.play();
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
	   JButton prev=new JButton("Prev");
	   prev.addActionListener(new ActionListener()
	   {
		   public void actionPerformed(ActionEvent e)
		   {
			   if(player!=null)
			   {
				   player.stop();
			   }
			   int i=lst.getSelectedIndex();
			   if(i==0)
			   {
				   i=lst.getLastVisibleIndex();
			   }
			   else
			   {
				   i--;
			   }
			   File fp=new File(lst.getSelectedValue());
			   String filepath=fp.toURI().toString();
			   Media m=new Media(filepath);
			   player=new MediaPlayer(m);
			   player.setVolume(volume);
			   player.play();
		   }
	   });
	   p1.add(b1);
	   p1.add(slider);
	   p1.add(next);
	   p1.add(b3);
	   p1.add(prev);
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
	   lst.setSize((int)(0.95*this.getWidth()),(int)(0.47*this.getHeight()));
       model=new DefaultListModel();
       lst.setAlignmentX(CENTER_ALIGNMENT);
       lst.setModel(model);
       lst.addListSelectionListener(new ListSelectionListener()
       {
    	   public void valueChanged(ListSelectionEvent arg0) {
					String k=lst.getSelectedValue();
					if(player!=null)
					{
						player.stop();
					}
					File fp=new File(k);
					String filepath=fp.toURI().toString();
					Media md=new Media(filepath);
					player=new MediaPlayer(md);
					player.setVolume(volume);
					 player.setOnEndOfMedia(new Runnable()
			          {
			            @Override
					     public void run() {
					       int index=lst.getSelectedIndex();
					       if(index==lst.getLastVisibleIndex())
					       {
					    	  index=0;
					       }
					       else
					       {
					    	   index++;
					       }
					       lst.setSelectedIndex(index);
					       System.out.println(lst.getSelectedIndex());
					       String filepath=lst.getSelectedValue();
					       File fp=new File(filepath);
					       String uriformat=fp.toURI().toString();
					       Media md=new Media(uriformat);
					       player=new MediaPlayer(md);
					       player.setVolume(volume);
					       player.play();
					       b1.setText("Pause");
					}
			       });
       }
       });
	   JScrollPane pane=new JScrollPane(lst);
	   this.add(pane);
	   songoptions();
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   this.setVisible(true);
   }
}