import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class piechart extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage argstage) throws Exception {
		Vector <precent> prcs=new Vector<precent>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Open File dialog??(0,yes|1,No):");
		int in=sc.nextInt();
		if(in==0)
		{
			JFileChooser chooser=new JFileChooser("Select a sample file");
			int rval=chooser.showOpenDialog(null);
			if(rval==JFileChooser.APPROVE_OPTION)
			{
				String fn=chooser.getSelectedFile().getAbsolutePath();
				FileReader fr=new FileReader(fn);
				Scanner scn=new Scanner(fr);
				while(scn.hasNextLine())
				{
					String line=scn.nextLine();
					if(line.startsWith("#")) continue;
					if(line.length()==0) continue;
					String data[]=line.split("-");
					if(data.length!=2) continue;
					prcs.add(new precent(data[0],Double.parseDouble(data[1])));
				}
				sc.close();
			}
			if(prcs.size()==0)
			{
				JOptionPane.showMessageDialog(null,"No data uploaded");
				System.exit(1);
			}
			argstage.setTitle("Operating systems Chart example");
			PieChart.Data data[]=new PieChart.Data[prcs.size()];
			for(int i=0;i<prcs.size();i++)
			{
				data[i]=new PieChart.Data(prcs.get(i).getdesc(),prcs.get(i).getprc());
			}
			PieChart chart=new PieChart(FXCollections.observableArrayList(data));
			Scene scene=new Scene(new Group(chart),500,400);
			argstage.setScene(scene);
			argstage.show();
		}
		else
		{
			JOptionPane.showMessageDialog(null,"No file open closing program bye bye!!!!");
			System.exit(0);
		}
	}

}
