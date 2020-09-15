package app_package;

import javax.swing.JOptionPane;

public class start_program {

	static void show_passo(String source,int times)
	{
		String msg="";
		for(int i=0;i<times;i++)
		{
			msg+=source+" ";
		}
		JOptionPane.showMessageDialog(null, msg);
	}
	public static void main(String[] args) {
		String input=JOptionPane.showInputDialog("Give Input");
		show_passo(input,6);
	}

}
