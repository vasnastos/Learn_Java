package source;

public class department {
   private int depid;
   private String depname;
   public department(int did,String dn)
   {
	   this.depid=did;
	   this.depname=dn;
   }
   public int get_depid() {return this.depid;}
   public String get_depname() {return this.depname;}
}
