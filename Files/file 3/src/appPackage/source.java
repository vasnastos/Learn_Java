package appPackage;

public class source {
   private String period;
   private String rate;
   private double count;
   public source(String p,String r,double c)
   {
	   this.period=p;
	   this.rate=r;
	   this.count=c;
   }
   public String get_period() {return this.period;}
   public String get_rate() {return this.rate;}
   public double get_count() {return this.count;} 
}
