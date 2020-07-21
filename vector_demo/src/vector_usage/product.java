package vector_usage;

public class product {
  private int id; 
  private String desc;
  private double price;
  public product(int i,String d,double p)
  {
	this.id=i;
	this.desc=d;
	this.price=p;
  }
  public  int get_id() {return this.id;}
  public String get_desc() {return this.desc;}
  public double get_price() {return this.price;}
}
