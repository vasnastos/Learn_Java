
public class rate {
   private int year;
   private String type;
   private double  count;
   public rate(int y,String t,double c)
   {
	   this.year=y;
	   this.type=t;
	   this.count=c;
   }
   public int get_year() {return this.year;}
   public String get_type() {return this.type;}
   public double get_count() {return this.count;}
   public String to_str()
   {
	   return String.valueOf(this.year)+"-"+this.type+"-"+String.valueOf(this.count);
   }
}
