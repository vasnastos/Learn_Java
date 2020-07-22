package numbers;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class start_execution {

	public static void main(String[] args) {
		dynamic_operation dyn=new dynamic_operation();
		try (Scanner scanner = new Scanner(System.in)) {
			int value;
			while(true)
			{
				value=scanner.nextInt();
				if(value==-1)
				{
					break;
				}
				dyn.add_element(value);
			}
		}
		double average=dyn.get_average();
        int max=dyn.get_max_element();
        int min=dyn.get_min_element();
        String message="Average="+String.valueOf(average)+"\n";
        message+="Max:"+String.valueOf(max)+"\n";
        message+="Min:"+String.valueOf(min)+"\n";
        JOptionPane.showMessageDialog(null, message);
        dyn.find_max_positions();
        dyn.find_min_positions();
	}

}
