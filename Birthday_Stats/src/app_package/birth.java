package app_package;

public class birth {
   private String period;
   private String mage;
   private double rate;
   public birth(String p,String m,double r)
   {
	   this.period=p;
	   this.mage=m;
	   this.rate=r;
   }
   public String getPeriod() {return this.period;}
   public String getAge() {return this.mage;}
   public double getRate() {return this.rate;}
   public String to_String()
   {
	   return this.period+"--"+this.mage+"--"+String.valueOf(this.rate);
   }
}
