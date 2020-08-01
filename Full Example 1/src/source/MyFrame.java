package source;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
      JComboBox <String> departments=new JComboBox<String>();
      JComboBox <String> projects=new JComboBox<String>();
      Vector <employee> employees=new Vector<employee>();
      JComboBox <Integer> departmentids=new JComboBox<Integer>();
      Vector <department> deps=new Vector<department>();
      JTextArea text=new JTextArea();
      void employee_form()
      {
    	  JComboBox <Integer> emplid=new JComboBox<Integer>();
    	  JPanel p1=new JPanel();
    	  JPanel p2=new JPanel();
    	  JPanel p3=new JPanel();
    	  JPanel p4=new JPanel();
    	  JPanel p5=new JPanel();
    	  JPanel p6=new JPanel();
    	  JLabel label=new JLabel("INSERT EMPLOYEE",JLabel.CENTER);
    	  label.setBackground(Color.red);
    	  int w=(90*this.getWidth())/100;
    	  int h=(10*this.getHeight())/100;
    	  label.setSize(w,h);
    	  this.add(label);
    	  
    	  //employees id
    	  JLabel lid=new JLabel("Give employee id",JLabel.LEFT);
    	  lid.setForeground(Color.BLACK);
    	  JTextField id=new JTextField(7);
    	  p1.setLayout(new FlowLayout(FlowLayout.CENTER));
    	  p1.add(lid);
    	  p1.add(id);
    	  
    	  //employye's department id
    	  JLabel lb1=new JLabel("Select department id",JLabel.LEFT);
    	  lb1.setForeground(Color.BLACK);
    	  p2.setLayout(new FlowLayout(FlowLayout.CENTER));
    	  p2.add(lb1);
    	  p2.add(departmentids);
    	  
    	  //employee's Name
    	  JLabel name=new JLabel("Give employees name",JLabel.LEFT);
    	  name.setForeground(Color.BLACK);
    	  JTextField nm=new JTextField(7);
    	  p3.setLayout(new FlowLayout(FlowLayout.CENTER));
    	  p3.add(name);
    	  p3.add(nm);
    	  
    	  //employee's Salary
    	  JLabel sal=new JLabel("Give employees Salary",JLabel.LEFT);
    	  sal.setForeground(Color.BLACK);
    	  JTextField sl=new JTextField(7);
    	  p4.setLayout(new FlowLayout(FlowLayout.CENTER));
    	  p4.add(sal);
    	  p4.add(sl);
    	  
    	  
    	  
    	  //buttons 
    	  p6.setLayout(new FlowLayout(FlowLayout.CENTER));
    	  JButton button=new JButton();
    	  JButton cancel=new JButton();
    	  button.setText("INSERT");
    	  cancel.setText("CANCEL");
    	  button.addActionListener(new ActionListener()
    	  {
    		  public void actionPerformed(ActionEvent e)
    		  {
    			  if(id.getText().isEmpty() || sl.getText().isEmpty() ||  nm.getText().isEmpty())
    			  {
    				  JOptionPane.showMessageDialog(null,"Fill all the blanks");
    				  return;
    			  }
    			  if(departmentids.getItemCount()==0)
    			  {
    				  JOptionPane.showMessageDialog(null,"You did not insert any department");
    				  return;
    			  }
    			  for(employee emp:employees)
    			  {
                     if(emp.get_empid()==Integer.parseInt(id.getText()))
                     {
                    	 JOptionPane.showMessageDialog(null,"Employee already exists in the department");
                    	 return;
                     }
    			  }
    			  int eid=Integer.parseInt(id.getText());
    			  int did=departmentids.getItemAt(departmentids.getSelectedIndex());
    			  String name=nm.getText();
    			  double salar=Double.parseDouble(sl.getText());
    			  employees.add(new employee(eid,did,name,salar));
    			  emplid.addItem(eid);
    		  }
    	  });
    	  cancel.addActionListener(new ActionListener()
    	  {
    		  public void actionPerformed(ActionEvent e)
    		  {
    			  id.setText("");
    			  nm.setText("");
    			  sl.setText("");
    			  departmentids.setSelectedIndex(0);
    		  }
    	  });
    	  p6.add(button);
    	  p6.add(cancel);
    	  
    	//employee's Project
    	  JLabel pname=new JLabel("Give employees Project name",JLabel.LEFT);
    	  pname.setForeground(Color.BLACK);
    	  JTextField pr=new JTextField(7);
    	  JButton b=new JButton("ADD");
    	  b.addActionListener(new ActionListener()
    	  {
    		  public void actionPerformed(ActionEvent e)
    		  {
    			  for(employee emps:employees)
    			  {
    				  if(emps.get_empid()==emplid.getItemAt(emplid.getSelectedIndex()))
    				  {
    					  emps.add_project(pr.getText());
    					  break;
    				  }
    			  }
    			  boolean f=false;
    			  for(int i=0;i<projects.getItemCount();i++)
    			  {
    				  if(projects.getItemAt(i).equals(pr.getText()))
    				  {
    					  f=true;
    					  break;
    				  }
    			  }
    			  if(!f)
    			  {
    				  projects.addItem(pr.getText());
    			  }
    		  }
    	  });
    	  p5.setLayout(new FlowLayout(FlowLayout.CENTER));
    	  p5.add(pname);
    	  p5.add(emplid);
    	  p5.add(pr);
    	  p5.add(b);
    	  
    	  //Add panels to MainWindow
    	  this.add(p1);
    	  this.add(p2);
    	  this.add(p3);
    	  this.add(p4);
    	  this.add(p6);
    	  this.add(p5);
      }
      void department_form()
      {
    	  JPanel deppanel=new JPanel();
    	  JPanel buttons=new JPanel();
    	  
    	  JLabel in=new JLabel("INSERT A DEPARTMENT",JLabel.CENTER);
    	  in.setBackground(Color.BLUE);
    	  this.add(in);
    	  
    	  //Department forms
    	  deppanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    	  JLabel label=new JLabel("INSERT DEPARTMENT",JLabel.LEFT);
    	  label.setForeground(Color.BLACK);
    	  JTextField id=new JTextField(7);
    	  JTextField  name=new JTextField(7);
    	  id.setToolTipText("Department's id");
    	  name.setToolTipText("Department's name");
    	  deppanel.add(label);
    	  deppanel.add(id);
    	  deppanel.add(name);
    	  
    	  //Department Buttons
    	  buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
    	  JButton b1=new JButton("INSERT");
    	  JButton b2=new JButton("CLEAR");
    	  b1.addActionListener(new ActionListener()
    	  {
    		  public void actionPerformed(ActionEvent e)
    		  {
    			  if(id.getText().isEmpty() || name.getText().isEmpty())
    			  {
    				  JOptionPane.showMessageDialog(null, "Fill all the blanks");
    				  return;
    			  }
    			  for(department dep:deps)
    			  {
    				if(dep.get_depid()==Integer.parseInt(id.getText()))
    				{
    					JOptionPane.showMessageDialog(null,"Department already registered i the app");
    					return;
    				}
    			  }
    			  deps.add(new department(Integer.parseInt(id.getText()),name.getText()));
    			  departments.addItem(name.getText());
    			  departmentids.addItem(Integer.parseInt(id.getText()));
    			  
    		  }
    	  });
    	  b2.addActionListener(new ActionListener()
    			  {
                     public void actionPerformed(ActionEvent e)
                     {
                    	 id.setText("");
                    	 name.setText("");
                     }
    			  });
    	  buttons.add(b1);
    	  buttons.add(b2);
    	  
    	  //Add Buttons
    	  this.add(deppanel);
    	  this.add(buttons);
      }
      
      void search_by_department_form()
      {
    	  JPanel s=new JPanel();
    	  s.setLayout(new FlowLayout(FlowLayout.CENTER));
    	  JLabel label=new JLabel("Search by department",JLabel.LEFT);
    	  label.setForeground(Color.BLACK);
    	  JButton search=new JButton("SEARCH");
    	  search.addActionListener(new ActionListener()
    	  {
    		  public void actionPerformed(ActionEvent ev)
    		  {
    			  String depname=departments.getSelectedItem().toString();
    			  int depid=0;
    			  for(department d:deps)
    			  {
    				  if(d.get_depname().equals(depname))
    				  {
    					  depid=d.get_depid();
    					  break;
    				  }
    			  }
    			  String message="List of Employees works for "+depname+"\n";
    			  for(employee e:employees)
    			  {
    				  if(e.get_dep_id()==depid)
    				  {
    					  message+="NAME:"+e.get_name()+"  ID:"+String.valueOf(e.get_empid())+"  SALARY:"+String.valueOf(e.get_salary())+"\n";
    				  }
    			  }
    			  //JOptionPane.showMessageDialog(null, message);-->message in message Box.
    			  text.setText(message);
    		  }
    	  });
    	  s.add(label);
    	  s.add(departments);
		  s.add(search);
		  this.add(s);
      }
      
      void search_by_project_form()
      {
      JPanel p1=new JPanel();
      p1.setLayout(new FlowLayout(FlowLayout.CENTER));
      JLabel label=new JLabel("Search by Project",JLabel.LEFT);
   	  label.setForeground(Color.BLACK);
   	  JButton search=new JButton("SEARCH");
   	  search.addActionListener(new ActionListener()
   	  {
   		  public void actionPerformed(ActionEvent ev)
   		  {
   			  String projectname=projects.getSelectedItem().toString();
   			String message="List of Employees works in "+projectname+"\n";
			  for(employee e:employees)
			  {
				  int size=e.get_projects();
				  for(int j=0;j<size;j++)
				  {
					if(e.get(j).equals(projectname))
				    {
					   message+="NAME:"+e.get_name()+"  ID:"+String.valueOf(e.get_empid())+"  SALARY:"+String.valueOf(e.get_salary())+"\n";
				       break;
				    }
				  }
			  }
			  text.setText(message);
   		  }
   	  });
   	  p1.add(label);
   	  p1.add(projects);
   	  p1.add(search);
   	  this.add(p1);
      }
      public MyFrame(String title)
      {
    	  super(title);
    	  this.setSize(600,600);
    	  this.setLayout(new GridLayout(0,1,10,10));
    	  this.employee_form();
    	  this.department_form();
    	  this.search_by_department_form();
    	  this.search_by_project_form();
    	  this.add(text);
    	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  this.setVisible(true);
      }
}
