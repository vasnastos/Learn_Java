package bank;

import java.util.ArrayList;
import java.util.List;

public class bankinfo {
 private List <account> accounts=new ArrayList<account>();
 public void add_account(account acc)
 {
	 this.accounts.add(acc);
 }
 public String print_accounts()
 {
	 String accs="List of Accounts\n";
	 for(account acc:accounts)
	 {
		 accs+="Name:"+acc.get_name()+"    Balance:"+String.valueOf(acc.get_balance())+"\n";
	 }
	 return accs;
 }
 public void deposit(String n,double b)
 {
	 for(account acc:accounts)
	 {
		 if(acc.get_name()==n)
		 {
			 acc.deposit(b);
		 }
	 }
 }
 public void erase_account(String name)
 {
	 for(account acc:accounts)
	 {
		 if(acc.get_name()==name)
		 {
			 accounts.remove(accounts.indexOf(name));
		 }
	 }
	 System.out.println("Account of "+name+" has been deleted");
 }
 public void withdraw(String n,double b)
 {
	 for(account acc:accounts)
	 {
		 if(acc.get_name()==n)
		 {
			 acc.withdraw(b);
		 }
	 } 
 }
 public void add_interest(double r)
 {
	 for(account acc:accounts)
	 {
		 acc.deposit(acc.get_balance()*r*0.01);
	 }
 }
}
