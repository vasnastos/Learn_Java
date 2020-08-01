package convert_app;

public class mainclass {

	public static void main(String[] args) {
		MyFrame f=new MyFrame("Converter coins app");
		String date=String.valueOf(java.time.LocalDate.now());
		String time=String.valueOf(java.time.LocalTime.now());
        System.out.println("Use converter app at:"+date+"   "+time);
	}

}
