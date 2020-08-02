package appPackage;

public class stats {
   private String Period;
   private String gender;
   private String age;
   int count;
   public stats(String p,String g,String a,int c)
   {
	   this.Period=p;
	   this.gender=g;
	   this.age=a;
	   this.count=c;
   }
   public String get_period() {return this.Period;}
   public String get_gender() {return this.gender;}
   public String get_age() {return this.age;}
   public int get_count() {return this.count;}
   public String to_string()
   {
	   return "Period:"+this.Period+"  Gender:"+this.gender+"  Count:"+String.valueOf(this.count);
   }
}
