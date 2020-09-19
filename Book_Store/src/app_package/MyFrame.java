package app_package;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame{
	Vector <Book> books=new Vector<Book>();
     MyFrame()
     {
    	 this.setSize(400,400);
    	 this.setTitle("Book Store Test App");
    	 this.setResizable(false);
    	 this.setLayout(new GridLayout(3,2));
    	 JButton b=new JButton("ADD");
    	 b.addActionListener(new ActionListener()
    	 {
    		 public void actionPerformed(ActionEvent ae)
    		 {
    			 String title=JOptionPane.showInputDialog("Insert books name");
    			 for(int i=0;i<books.size();i++)
    			 {
    				 if(books.get(i).getTitle().equals(title))
    				 {
    					 JOptionPane.showMessageDialog(null,"Book "+title+" already exists in the list");
    					 return;
    				 }
    			 }
    			 String author=JOptionPane.showInputDialog("Give authors name");
    			 double price=Double.parseDouble(JOptionPane.showInputDialog("Give Books price"));
    			 Book newbook=new Book(title,author,price);
    			 books.add(newbook);
    		 }
    	 });
    	 JButton b1=new JButton("SHOW");
    	 b1.addActionListener(new ActionListener()
    	 {
    		 public void actionPerformed(ActionEvent e)
    		 {
    			 String message="<html><body><h3 style=text-align:center;>Books List</h3><ul>";
    			 for(Book b:books)
    			 {
    				 message+="<li>"+b.tostr()+"</li>";
    			 }
    			 message+="</ul></body></html>";
    			 JOptionPane.showMessageDialog(null, message);
    		 }
    	 });
    	 JButton b2=new JButton("SHOW A-K");
    	 b2.addActionListener(new ActionListener()
    	{
    		 public void actionPerformed(ActionEvent e)
    		 {
    			 JFileChooser ch=new JFileChooser();
    			 int rval=ch.showSaveDialog(MyFrame.this);
    			 if(rval==JFileChooser.APPROVE_OPTION)
    			 {
    				 String fn=ch.getSelectedFile().getAbsolutePath();
    				 try {
						FileWriter fw=new FileWriter(fn);
						PrintWriter pw=new PrintWriter(fw);
						pw.println("Books with name first character(A-Z)");
						for(Book b:books)
						{
							if(b.getTitle().charAt(0)>='A' && b.getTitle().charAt(0)<='Z')
							{
								pw.println(b.tostr());
							}
						}
						pw.close();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null,"No file found(Error)");
					}
    			 }
    		 }
    	});
    	 JButton b3=new JButton("LOAD");
    	 b3.addActionListener(new ActionListener()
    	{
    		 public void actionPerformed(ActionEvent e)
    		 {
    			 JFileChooser ch=new JFileChooser();
    			 int value=ch.showOpenDialog(MyFrame.this);
    			 if(value==JFileChooser.APPROVE_OPTION)
    			 {
    			      String fn=ch.getSelectedFile().getAbsolutePath();
    			      FileReader fr=null;
					try {
						fr = new FileReader(fn);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						return;
					}
    			      Scanner sc=new Scanner(fr);
    			      while(sc.hasNextLine())
    			      {
    			    	  String line=sc.nextLine();
    			    	  String data[]=line.split(",");
    			    	  if(data.length!=3)
    			    	  {
    			    		  continue;
    			    	  }
    			    	  Book b=new Book(data[0],data[1],Double.parseDouble(data[2]));
    			    	  boolean f =false;
    			    	  for(Book blist:books)
    			    	  {
    			    		  if(blist.getTitle().equals(b.getTitle()))
    			    		  {
    			    			  f=true;
    			    		  }
    			    	  }
    			          if(!f)
    			          {
    			        	  books.add(b);
    			          }
    			      }
    			      sc.close();
    			 }
    		 }
    	});
    	 Mythread th=new Mythread(books);
    	 JButton b4=new JButton("SHOW THREAD");
    	 b4.addActionListener(new ActionListener()
    	 {
    		 public void actionPerformed(ActionEvent ac)
    		 {
    			 th.start();
    		 }
    	 });
    	 this.add(b);
    	 this.add(b1);
    	 this.add(b2);
    	 this.add(b3);
    	 this.add(b4);
    	 this.add(th.label);
    	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 this.setVisible(true);
     }
}
