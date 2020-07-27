package basic;

import java.util.ArrayList;
import java.util.List;

public class numbers_sequence {
    private List <Double> list=new ArrayList<Double>();
    public void add_number(double x) {this.list.add(x);}
    public void remove_number(int i) {this.list.remove(i);}
    public double max_element()
    {
    	double max=this.list.get(0);
    	for(int i=0;i<list.size();i++)
    	{
    		if(list.get(i)>max)
    		{
    			max=list.get(i);
    		}
    	}
    	return max;
    }
    public double min_element()
    {
    	double min=this.list.get(0);
    	for(int i=0;i<list.size();i++)
    	{
    		if(list.get(i)<min)
    		{
    			min=list.get(i);
    		}
    	}
    	return min;
    }
    public double average()
    {
    	double avg=0.0;
    	for(Double x:list)
    	{
    		avg+=x;
    	}
    	avg/=list.size();
    	return avg;
    }
    public String show()
    {
    	String message="List of numbers::\n";
    	for(Double x:list)
    	{
    		message+="ELEMENT:"+String.valueOf(x)+"\n";
    	}
    	return message;
    }
    public int size()
    {
    	return list.size();
    }
    public double get(int i)
    {
    	return list.get(i);
    }
}   
