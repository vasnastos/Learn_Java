package app_Package;

public class student {
   private String id;
   private double theory;
   private double lab;
   public student(String i,double t,double l)
   {
	   this.id=i;
	   this.theory=t;
	   this.lab=l;
   }
   public String get_id() {return this.id;}
   public double get_theory() {return this.theory;}
   public double get_lab() {return this.lab;}
   public double get_total(double thpr,double lbpr)
   {
	   double total=(this.theory*thpr)/100.0+(this.lab*lbpr)/100.0;
	   return total;
   }
}
