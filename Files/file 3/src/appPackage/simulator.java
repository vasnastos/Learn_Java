package appPackage;

public class simulator {

	public static void main(String[] args) {
		String date=String.valueOf(java.time.LocalDate.now());
		String time=String.valueOf(java.time.LocalTime.now());
        System.out.println("App used at:"+date+"---"+time);
        MyFrame f=new MyFrame();
	}

}
