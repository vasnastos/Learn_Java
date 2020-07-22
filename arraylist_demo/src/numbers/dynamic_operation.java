package numbers;

import java.util.ArrayList;
import java.util.List;

public class dynamic_operation {
   private List <Integer> array=new ArrayList<Integer>();
   public dynamic_operation() {}
   public void add_element(Integer x) {array.add(x);}
   public int get_sum()
   {
	   int sum=0;
	   for(Integer y:this.array)
	   {
		   sum+=y;
	   }
	   return sum;
   }
   public double get_average()
   {
	   int sum=this.get_sum();
	   return (double)sum/this.array.size();
   }
   public Integer get_max_element()
   {
	   Integer max=this.array.get(0);
	   for(int i=1;i<this.array.size();i++)
	   {
		   if(this.array.get(i)>max)
		   {
			   max=this.array.get(i);
		   }
	   }
	   return max;
   }
   public Integer get_min_element()
   {
	   Integer min=this.array.get(0);
	   for(int i=1;i<this.array.size();i++)
	   {
		   if(this.array.get(i)<min)
		   {
			   min=this.array.get(i);
		   }
	   }
	   return min;
   }
   public void find_max_positions()
   {
	   String message="Max POSITIONS LIST:::\n";
	   Integer max=this.get_max_element();
	   for(int i=0;i<array.size();i++)
	   {
		   if(array.get(i).equals(max))
		   {
			   message+="Position:"+String.valueOf(i)+"\n";
		   }
	   }
	   System.out.println(message);
   }
   public void find_min_positions()
   {
	   String message="Min POSITIONS LIST:::\n";
	   Integer min=this.get_min_element();
	   for(int i=0;i<array.size();i++)
	   {
		   if(array.get(i).equals(min))
		   {
			   message+="Position:"+String.valueOf(i)+"\n";
		   }
	   }
	   System.out.println(message);
   }
}
