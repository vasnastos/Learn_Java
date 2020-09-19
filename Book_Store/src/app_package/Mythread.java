package app_package;

import java.util.Vector;

import javax.swing.JLabel;

public class Mythread extends Thread{
      JLabel label=new JLabel();
      Vector <Book> bks;
      Mythread(Vector <Book> bs)
      {
    	  bks=bs;
      }
     @Override
      public void run()
      {
    	 int i=0;
    	 while(i<bks.size())
    	 {  
    		 String message="";
    		 message+="<html><body><h3 style=text-align:center;>Books Summary</h3>";
    		 try {
		    	sleep(1000);
		    	for(int j=0;j<=i;j++)
		    	message+="<li>"+bks.get(j).tostr()+"</li>";
		    } catch (InterruptedException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		    }
    		 message+="</ul></body></html>";
    		 label.setText(message);
    	   i++;
    	 }
      }
}
