package vector_usage;

import java.util.Vector;

public class base {
  private Vector<product> products=new Vector<product>();
  public void add_product(product p) {this.products.add(p);}
  public void search_product(int id)
  {
	  boolean found=false;
	  for(product x:products)
	  {
		  if(x.get_id()==id)
		  {
			  String info="Description:"+x.get_desc()+"\n";
			  info+="Price:"+String.valueOf(x.get_price());
			  System.out.println(info);
			  found=true;
			  break;
		  }
	  }
	  if(!found)
	  {
		  System.out.println("Product did not found!!!");
	  }
  }
  public void delete_product(int id)
  {
	  for(int i=0;i<this.products.size();i++)
	  {
		  if(this.products.get(i).get_id()==id)
		  {
			  this.products.remove(i);
		  }
	  }
  }
  public String show_filter_products(double lower,double upper)
  {
	  String ret="";
	  if(lower>upper)
	  {
		  double temp=lower;
		  lower=upper;
		  upper=temp;
	  }
	  for(product x:this.products)
	  {
		  if(x.get_price()>lower && x.get_price()<upper)
		  {
			  ret+="Id:"+String.valueOf(x.get_id())+"\tDesc:"+x.get_desc()+"\tPrice:"+String.valueOf(x.get_price())+"\n";
		  }
	  }
	  return ret;
  }
  public void show_products()
  {
	  String n="";
	  for(product x:this.products)
	  {
		  n+="Id:"+String.valueOf(x.get_id())+"\tDesc:"+x.get_desc()+"\tPrice:"+String.valueOf(x.get_price())+"\n";
	  }
	  System.out.println(n);
  }
  public void delete_products()
  {
	  this.products.clear();
  }
}
