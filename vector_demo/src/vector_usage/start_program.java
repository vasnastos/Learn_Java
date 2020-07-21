package vector_usage;

import java.util.Scanner;

import javax.swing.JOptionPane; 

public class start_program {

	public static void main(String[] args) {
		base newhandler=new base();
		Scanner sc=new Scanner(System.in);
		int id;
		String d;
		double pr;
		int choice;
        while(true)
        {
        	System.out.println("Choose action:(1|Add product,0|Main Menu,2|Exit program):");
        	choice=sc.nextInt();
        	if(choice==1)
        	{
        		System.out.println("Give id of the product:");
        		id=sc.nextInt();
        		System.out.println("Give description of the product:");
        		sc=new Scanner(System.in);
        		d=sc.nextLine();
        		System.out.println("Give price of the product:");
        		pr=sc.nextDouble();
        		product p=new product(id,d,pr);
        		newhandler.add_product(p);
        	}
        	else if(choice==2)
        	{
        		break;
        	}
        	else if(choice==0)
        	{
        		String menu="Main Menu::\n";
        		menu+="1-Search for product\n";
        		menu+="2-Delete product\n";
        		menu+="3-Search by filters\n";
        		menu+="4-Show products\n";
        		menu+="Give choice:";
        		System.out.println(menu);
        		choice=sc.nextInt();
        		if(choice==1)
        		{
        			id=sc.nextInt();
        			System.out.println("Give id of product you want to search:");
        			newhandler.search_product(id);
        		}
        		else if(choice==2)
        		{
        			System.out.println("Give id you want to erase:");
        			id=sc.nextInt();
        			newhandler.delete_product(id);
        		}
        		else if(choice==3)
        		{
        			double lower,up;
        			System.out.println("Give lower bound of price:");
        			lower=sc.nextDouble();
        			System.out.println("Give upper bound of price:");
        			up=sc.nextDouble();
        			String message=newhandler.show_filter_products(lower, up);
        			JOptionPane.showMessageDialog(null,message);
        		}
        		else if(choice==4)
        		{
        			newhandler.show_products();
        		}
        		else
        		{
        			System.out.println("Invalid choice--Redirect to start page");
        		}
        	}
        }
	}

}
