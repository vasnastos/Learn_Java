package source;

public class driver {

	public static void main(String[] args) {
		String date=String.valueOf(java.time.LocalDate.now());
		String time=String.valueOf(java.time.LocalTime.now());
        System.out.println("App open at:"+date+"  "+time);
        MyFrame f=new MyFrame("Company App");
	}
}
