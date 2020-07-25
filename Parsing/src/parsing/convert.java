package parsing;

public class convert {

	public static void main(String[] args) {
		//conversions in java from primitive types to other primitive types(String,double,int)
		String x="30";
		String y="34.5";
		int parsex=Integer.parseInt(x);
        double parsey=Double.parseDouble(y);
        String message="After Parsing:x="+String.valueOf(parsex)+"\n";
        message+="y:"+String.valueOf(parsey);
        System.out.println(message);
	}

}
