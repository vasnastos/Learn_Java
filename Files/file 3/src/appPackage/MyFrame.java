package appPackage;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.scene.paint.Color;

public class MyFrame extends JFrame{
	Vector <source> records=new Vector();
	JComboBox <String> periods=new JComboBox();
	JComboBox <String> rate=new JComboBox();
	void make_form_1()
	{
		ImageIcon img=new ImageIcon(new ImageIcon("central.png").getImage().getScaledInstance(200, 200,Image.SCALE_SMOOTH));
		JLabel label=new JLabel(img,JLabel.CENTER);
		this.add(label);
	}
	void make_form_2()
	{
		JPanel panel=new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		JLabel information=new JLabel("Search by period form",JLabel.RIGHT);
		information.setForeground(java.awt.Color.RED);
		JButton search=new JButton("SEARCH");
		search.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(records.size()==0)
				{
					JOptionPane.showMessageDialog(null,"No data loaded");
					return;
				}
				int index=periods.getSelectedIndex();
				String period=periods.getItemAt(index);//periods.getSelectedItem().toString();
				String msg="Information for period "+period+"\n";
				for(source x:records)
				{
					if(x.get_period().equals(period))
					{
						msg+="Rate:"+x.get_rate()+"    Count:"+x.get_count()+"\n";
					}
				}
				JOptionPane.showMessageDialog(null,msg);
			}
		});
		panel.add(information);
		panel.add(periods);
		panel.add(search);
		this.add(panel);
	}
    void make_form_3()
    {
    	JPanel panel=new JPanel();
    	panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
    	JLabel label=new JLabel("Search by rate",JLabel.CENTER);
    	JButton b=new JButton("SEARCH");
    	b.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent ae)
    		{
    			if(records.size()==0)
				{
					JOptionPane.showMessageDialog(null,"No data loaded");
					return;
				}
    			String text=rate.getSelectedItem().toString();
    			String msg="Information for rate "+text+"\n";
    			for(source s:records)
    			{
    				if(s.get_rate().equals(text))
    				{
    					msg+="Period:"+s.get_period()+"    Count:"+s.get_count()+"\n";
    				}
    			}
    			JOptionPane.showMessageDialog(null,msg);
    		}
    	});
    	panel.add(label);
    	panel.add(rate);
    	panel.add(b);
    	this.add(panel);
    }
    void make_menu()
    {
    	JMenu menu=new JMenu("EDIT");
    	JMenuBar bar=new JMenuBar();
    	this.setJMenuBar(bar);
    	JMenuItem item1=new JMenuItem();
    	item1.setText("LOAD");
    	item1.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent ae)
    		{
    			JFileChooser ch=new JFileChooser();
    			int ret=ch.showOpenDialog(MyFrame.this);
    			if(JFileChooser.APPROVE_OPTION==ret)
    			{
    				FileReader reader=null;
    				String fn=ch.getSelectedFile().getAbsolutePath();
    				try {
						reader=new FileReader(fn);
					} catch (FileNotFoundException e) {
						JOptionPane.showMessageDialog(null, "No file Selected");
					}
    				Scanner sc=new Scanner(reader);
    				int count=0;
    				while(sc.hasNextLine())
    				{
    					count++;
    					String line=sc.nextLine();
    					if(line.startsWith("#")) continue;
    					if(count==1)
    					{
    						continue;
    					}
    					String data[]=line.split(",");
    					source s=new source(data[0],data[1],Double.parseDouble(data[2]));
    					records.add(s);
    				}
    				sc.close();
    				Vector <String> prs=new Vector();
    				for(source s:records)
    				{
    					boolean f=false;
    					for(String x:prs)
    					{
    						if(s.get_period().equals(x))
    						{
    							f=true;
    							break;
    						}
    					}
    					if(!f)
    					{
    						prs.add(s.get_period());
    					}
    				}
    				Vector <String> rates=new Vector();
    				for(source s:records)
    				{
    					boolean f=false;
    					for(String r:rates)
    					{
    						if(s.get_rate().equals(r))
    						{
    							f=true;
    						}
    					}
    					if(!f)
    					{
    						rates.add(s.get_rate());
    					}
    				}
    				for(String h:prs)
    				{
    					periods.addItem(h);
    				}
    			    for(String n:rates)
    			    {
    			    	rate.addItem(n);
    			    }
    			}
    		}
    	});
    	JMenuItem item2=new JMenuItem("SAVE");
    	item2.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent ae)
    		{
    			JFileChooser fc=new JFileChooser();
    			int retval=fc.showSaveDialog(MyFrame.this);
    			if(retval==JFileChooser.APPROVE_OPTION)
    			{
    				String fn=fc.getSelectedFile().getAbsolutePath();
    				try {
						FileWriter fw=new FileWriter(fn);
						PrintWriter pw=new PrintWriter(fw);
						Vector <String> rates=new Vector();
	    				for(source s:records)
	    				{
	    					boolean f=false;
	    					for(String r:rates)
	    					{
	    						if(s.get_rate().equals(r))
	    						{
	    							f=true;
	    						}
	    					}
	    					if(!f)
	    					{
	    						rates.add(s.get_rate());
	    					}
	    				}
						pw.println("**************** Info Rate **********************\n");
						for(String s:rates)
						{
							pw.println("\n #### Rate:"+s+" ####\n");
							for(source sc:records)
							{
								pw.println("Period:"+sc.get_period()+"    Count:"+String.valueOf(sc.get_count()));
							}
							pw.println("#######################\n");
						}
						pw.println("***************************************************");
						pw.close();
					} catch (IOException e) {
						return;
					}
    			}
    		}
    	});
    	JMenuItem item3=new JMenuItem("EXIT");
    	item3.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent ae)
    		{
    			System.exit(0);
    		}
    	});
    	menu.add(item1);
    	menu.add(item2);
    	menu.add(item3);
    	bar.add(menu);
    }
    public MyFrame()
    {
    	super("File handling");
    	this.setSize(300,300);
    	this.setLayout(new GridLayout(0,1,2,2));
    	make_menu();
    	this.make_form_1();
    	this.make_form_2();
    	this.make_form_3();
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
    }
}
