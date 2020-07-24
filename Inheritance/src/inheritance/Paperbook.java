package inheritance;

public class Paperbook extends book{
private double shippingweight;
   private boolean inStock; 
   public Paperbook(String is, String t, String at, double p,double sw,boolean ist) {
		super(is, t, at, p);
		this.shippingweight=sw;
		this.inStock=ist;
	}
   String to_str()
	  {
		  String str="•"+this.isbn+"-"+this.Author+"-"+this.title+"-"+String.valueOf(this.price)+"\n";
		  str+="Shipping Weight:"+String.valueOf(this.shippingweight)+"\n";
		  str+="In Stock:";
		  if(this.inStock)
		  {
			  str+="True";
		  }
		  else
		  {
			  str+="False";
		  }
		  str+="\n";
		  return str;
	  }
}
