package bank;

public class account {
    private String name;
    private double balance;
    public account(String n,double b)
    {
    	this.name=n;
    	this.balance=b;
    }
    public account(String n)
    {
    	this.name=n;
    	this.balance=0.0;
    }
    public String get_name() {
    	return this.name;
    }
    public double get_balance() {
    	return this.balance;
    }
    public void deposit(double b)
    {
    	this.balance+=b;
    }
    public void withdraw(double b)
    {
    	if(this.balance<b)
    	{
    		System.out.println("Invalid ammount of cash please select a different amount!!!\n");
    	}
    	else
    	{
    		this.balance-=b;
    	}
    }
}
