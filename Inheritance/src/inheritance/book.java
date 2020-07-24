package inheritance;

public class book {
  protected String isbn;
  protected String title;
  protected String Author;
  protected double price;
  public book(String is,String t,String at,double p)
  {
	  this.isbn=is;
	  this.title=t;
	  this.Author=at;
	  this.price=p;
  }
  String to_str()
  {
	  String str=this.isbn+"-"+this.Author+"-"+this.title+"-"+String.valueOf(this.price);
	  return str;
  }
}
