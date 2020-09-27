package appackage;

public class object {
    private String period;
    private String gender;
    private double age;
    public object(String p,String g,double a)
    {
    	this.period=p;
    	this.gender=g;
    	this.age=a;
    }
    public String getperiod() {return this.period;}
    public String getgender() {return this.gender;}
    public double getage() {return this.age;}
    public String to_str() {return this.period+"-"+this.gender+"-"+String.valueOf(this.age);}
}
