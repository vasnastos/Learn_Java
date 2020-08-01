package convert_app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javafx.scene.shape.Box;

public class MyFrame extends JFrame{
	JTextField text,result;
	JPanel p1,p2;
	List <String> splitdata=new ArrayList<String>();
	String plugins[]= {"euro","dollar","Yen","Lira","ruble","rupi"};
	JComboBox <String> fcoins=new JComboBox<String>(plugins);
	JComboBox <String> tcoins=new JComboBox<String>(plugins);
	void make_panel_1()
	{
		p1.setLayout(new GridLayout(1,3));
		JLabel l=new JLabel("",JLabel.CENTER);
		String msglabel="From";
		l.setForeground(Color.BLUE);
		l.setText(msglabel);
		p1.add(l);
		text=new JTextField(8);
		text.setToolTipText("Enter amount in order to check the concurrency");
		text.setText("Input:");
		p1.add(text);
		p1.add(fcoins);
	}
	void make_panel_2()
	{
		p2.setLayout(new GridLayout(1,3));
		JLabel l=new JLabel("",JLabel.CENTER);
		String msglabel="To";
		l.setForeground(Color.RED);
		l.setText(msglabel);
		p2.add(l);
		result=new JTextField(8);
		result.setEditable(false);
		result.setToolTipText("Converted Concurrency");
		p2.add(result);
		p2.add(tcoins);
		tcoins.addItemListener(new ItemListener()
		{
			
		    public void itemStateChanged(ItemEvent e)	
		    {
		    	splitdata.clear();
		    	if(e.getStateChange()==ItemEvent.SELECTED)
		    	{
	             String key=fcoins.getSelectedItem().toString();
	             String in=text.getText();
	             String data[]=in.split(":");
	             for(String x:data)
	             {
	        	    splitdata.add(x);
	             }
	             double res=0.0;
	           String target=tcoins.getItemAt(tcoins.getSelectedIndex());
	           if(splitdata.size()!=2)
	           {
	        	   JOptionPane.showMessageDialog(null, "Fill correct the blank");
	        	   return;
	           }
	           double coinnum=Double.parseDouble(data[1]);
	           System.out.println(key+"--"+target);
	           if(key.equals("euro") && target.equals("dollar"))
	           {
	        	   System.out.println("in");
	        	   res=coinnum*1.18;
	           }
	           else if(key.equals("euro") && target.equals("Yen"))
	           {
	        	   res=coinnum*123.72;
	           }
	           else if(key.equals("euro") && target.equals("Lira"))
	           {
	        	   res=coinnum*0.91;
	           }
	           else if(key.equals("euro") && target.equals("ruble"))
	           {
	        	   res=coinnum*85.48;
	           }
	           else if(key.equals("euro") && target.equals("rupi"))
	           {
	        	   res=coinnum*88.38;
	           }
	           else if(key.equals("dollar") && target.equals("euro"))
	           {
	        	   res=coinnum/1.18;
	           }
	           else if(key.equals("dollar") && target.equals("Yen"))
	           {
	        	   res=coinnum*105.04;
	           }
	           else if(key.equals("dollar") && target.equals("Lira"))
	           {
	        	   res=coinnum*0.77;
	           }
	           else if(key.equals("dollar") && target.equals("ruble"))
	           {
	        	   res=coinnum*73.71;
	           }
	           else if(key.equals("dollar") && target.equals("rupi"))
	           {
	        	   res=coinnum*74.89;
	           }
	           else if(key.equals("Yen") && target.equals("euro"))
	           {
	        	   res=coinnum/123.72;
	           }
	           else if(key.equals("Yen") && target.equals("dollar"))
	           {
	        	   res=coinnum/105.04;
	           }
	           else if(key.equals("Yen") && target.equals("Lira"))
	           {
	        	   res=0.0073*coinnum;
	           }
	           else if(key.equals("Yen") && target.equals("rupi"))
	           {
	        	   res=coinnum*0.71;
	           }
	           else if(key.equals("Yen") && target.equals("ruble"))
	           {
	        	   res=coinnum*0.70;
	           }
	           else if(key.equals("Lira") && target.equals("euro"))
	           {
	        	   res=coinnum/0.91;
	           }
	           else if(key.equals("Lira") && target.equals("dollar"))
	           {
	        	   res=coinnum/0.77;
	           }
	           else if(key.equals("Lira") && target.equals("Yen"))
	           {
	        	   res=coinnum/0.0073;
	           }
	           else if(key.equals("Lira") && target.equals("ruble"))
	           {
	        	   res=coinnum*95.94;
	           }
	           else if(key.equals("Lira") && target.equals("rupi"))
	           {
	        	   res=coinnum*97.81;
	           }
	           else if(key.equals("ruble") && target.equals("euro"))
	           {
	        	   res=coinnum/85.48;
	           }
	           else if(key.equals("ruble") && target.equals("dollar"))
	           {
	        	   res=coinnum/73.71;
	           }
	           else if(key.equals("ruble") && target.equals("Yen"))
	           {
	        	   res=coinnum/0.70;
	           }
	           else if(key.equals("ruble") && target.equals("Lira"))
	           {
	        	   res=coinnum/95.94;
	           }
	           else if(key.equals("ruble") && target.equals("rupi"))
	           {
	        	   res=coinnum*1.02;
	           }
	           else if(key.equals("rupi") && target.equals("euro"))
	           {
	        	   res=coinnum/88.38;
	           }
	           else if(key.equals("rupi") && target.equals("dollar"))
	           {
	        	   res=coinnum/74.89;
	           }
	           else if(key.equals("rupi") && target.equals("Yen"))
	           {
	        	   res=coinnum/0.71;
	           }
	           else if(key.equals("rupi") && target.equals("Lira"))
	           {
	        	   res=coinnum/97.81;
	           }
	           else if(key.equals("rupi") && target.equals("ruble"))
	           {
	        	   res=coinnum/1.02;
	           }
	           String k=String.format("Result:%.3f",res);
	           result.setText(k);
		    }
		    	
		    }
		});
	}
   public MyFrame(String title)
   {
	   super(title);
	   this.setSize(600,600);
	   this.setLayout(new FlowLayout(FlowLayout.LEADING));
	   ImageIcon img=new ImageIcon("home.png");
	   p1=new JPanel();
	   int w=(95*this.getWidth())/100;
	   int h=(15*this.getHeight())/100;
	   p1.setSize(w, h);
	   p2=new JPanel();
	   p2.setSize(w, h);
	   JLabel label=new JLabel(img,JLabel.CENTER);
	   this.add(label);
	   this.make_panel_1();
	   this.make_panel_2();
	   this.add(p1);
	   this.add(p2);
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   this.setVisible(true);
   }
}
