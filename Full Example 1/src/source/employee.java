package source;

import java.util.ArrayList;
import java.util.List;

public class employee {
   private int empid;
   private int depid;
   private String name;
   private double salary;
   private List <String> projects=new ArrayList<String>();
   public employee(int eid,int did,String n,double s)
   {
	   this.empid=eid;
	   this.depid=did;
	   this.name=n;
	   this.salary=s;
   }
   public int get_empid() {return this.empid;}
   public int get_dep_id() {return this.depid;}
   public String get_name() {return this.name;}
   public double get_salary() {return this.salary;}
   public void add_project(String projectname) {this.projects.add(projectname);}
   public int get_projects() {return this.projects.size();}
   public String get(int i) {return this.projects.get(i);}
}
