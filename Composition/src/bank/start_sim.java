package bank;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class start_sim {

	public static void main(String[] args) {
		bankinfo b=new bankinfo();
		String name;
		double balance;
        Scanner sc=new Scanner(System.in);
        int choice;
        while(true)
        {
        	System.out.println("Give 0|add account,1|Main menu,2|Exit app:");
        	choice=sc.nextInt();
        	if(choice==0)
        	{
        		sc=new Scanner(System.in);
        		System.out.println("Give name of owner:");
        		name=sc.nextLine();
        		System.out.println("Give balance:");
        		balance=sc.nextDouble();
        		account acc=new account(name,balance);
        		b.add_account(acc);
        	}
        	else if(choice==1)
        	{
        		String menu="Main Menu::\n";
        		menu+="1-Deposit\n";
        		menu+="2-Withdraw\n";
        		menu+="3-Show all Accounts\n";
        		menu+="4-Add interest\n";
        		menu+="5-Erase account\n";
        		menu+="Give choice:";
        		System.out.println(menu);
        		choice=sc.nextInt();
        		if(choice==1)
        		{
        			System.out.println("Give name for transaction:");
        			name=sc.nextLine();
        			System.out.println("Give balance:");
        			balance=sc.nextDouble();
        			b.deposit(name, balance);
        		}
        		else if(choice==2)
        		{
        			System.out.println("Give name for transaction:");
        			name=sc.nextLine();
        			System.out.println("Give balance:");
        			balance=sc.nextDouble();
        			b.withdraw(name, balance);
        		}
        		else if(choice==3)
        		{
        			JOptionPane.showMessageDialog(null,b.print_accounts());
        		}
        		else if(choice==4)
        		{
        			b.add_interest(1.3);
        			JOptionPane.showMessageDialog(null,b.print_accounts());
        		}
        		else if(choice==5)
        		{
        			System.out.println("Give name of account:");
        			name=sc.nextLine();
        			b.erase_account(name);
        		}
        		else 
        		{
        			System.out.println("Invalid choice please try again\n");
        		}
        	}
        	else if(choice==2)
        	{
        		break;
        	}
        	else
        	{
        		System.out.println("Invalid choice!!!!!\n");
        	}
        }
	}
}
