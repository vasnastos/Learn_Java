package app_Package;


public class simulator {

	public static void main(String[] args) {
		System.out.println("Hello world from app");
	    System.out.print("Loading app.....");
	   for(int i=0;i<5;i++)
	   {
		   System.out.print(".....");
		   try {
			  Thread.sleep(1000);
		   } catch (InterruptedException e) {}
	   }
	   MyFrame create=new MyFrame();
  }

}
