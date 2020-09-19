package app_package;

public class Book {
   private String Title;
   private String Author;
   private double price;
   public Book(String t,String a,double p)
   {
	   this.Author=a;
	   this.Title=t;
	   this.price=p;
   }
   public String getTitle()
   {
	   return this.Title;
   }
   public String getAuthor()
   {
	   return this.Author;
   }
   public double getprice()
   {
	   return this.price;
   }
   public String tostr()
   {
	   return this.Author+" "+this.Title+" "+String.valueOf(this.price);
   }
}
