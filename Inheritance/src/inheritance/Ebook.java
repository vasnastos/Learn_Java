package inheritance;

public class Ebook extends book {

	private String downloadUrl;
	private double sizeMb;
	public Ebook(String is, String t, String at, double p,String du,double sm) {
		super(is, t, at, p);//Κλήση constructor της κλάσης βάσης.
		this.downloadUrl=du;
		this.sizeMb=sm;
	}
	 String to_str()
	  {
		  String str="•"+this.isbn+"-"+this.Author+"-"+this.title+"-"+String.valueOf(this.price)+"\n";
		  str+="Url:"+this.downloadUrl+"\n";
		  str+="MB:"+String.valueOf(this.sizeMb)+"\n";
		  return str;
	  }
}
