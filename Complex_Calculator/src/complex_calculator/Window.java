/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complex_calculator;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author nasto
 */
public class Window extends JFrame{
    private JPanel panel2,panel3,panel4;
    private JTextField r1,r2,im1,im2;
    private final String ops[]={"+","-","*","/"};
    private final String extra[]={"Abs","Pow","Conj"};
    private void Make_menu()
    {
        JMenuBar bar=new JMenuBar();
        this.setJMenuBar(bar);
        JMenu menu=new JMenu();
        menu.setText("OPTIONS");
        JMenuItem it1=new JMenuItem("SAVE A Calc");
        JMenuItem it2=new JMenuItem("Show A Calc");
        JMenuItem it3=new JMenuItem("Quit");
        it1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                JFileChooser ch=new JFileChooser();
                int retval=ch.showSaveDialog(Window.this);
                double rp1,imp1,rp2,imp2;
                Random r=new Random(20000);
                rp1=r.nextDouble()%400;
                imp1=r.nextDouble()%400;
                rp2=r.nextDouble()%400;
                imp2=r.nextDouble()%400;
                int power=r.nextInt()%10;
                if(retval==JFileChooser.APPROVE_OPTION)
                {
                    String fn=ch.getSelectedFile().getAbsolutePath();
                    try {
                        FileWriter fw=new FileWriter(fn);
                        PrintWriter pw=new PrintWriter(fw);
                        Complex c1=new Complex(rp1,imp1);
                        Complex c2=new Complex(rp2,imp2);
                        pw.println("1st Complex:"+c1.to_Str());
                        pw.println("2nd Complex:"+c2.to_Str());
                        pw.println("Add:"+(c1.add(c2)).to_Str());
                        pw.println("Sub:"+(c1.sub(c2)).to_Str());
                        pw.println("Mul:"+c1.mul(c2).to_Str());
                        pw.println("Div:"+c1.div(c2).to_Str());
                        pw.println("Abs(1st Complex):"+String.valueOf(c1.Abs()));
                        pw.println("Abs(2nd Complex):"+String.valueOf(c2.Abs()));
                        pw.println("Conj(1st Complex):"+String.valueOf(c1.conj()));
                        pw.println("Conj(2nd Complex):"+String.valueOf(c2.conj()));
                        c1.Pow(power);
                        c2.Pow(power);
                        pw.println("Pow(1st complex-"+String.valueOf(power)+"):"+String.valueOf(c1.to_Str()));
                        pw.println("Pow(2nd complex-"+String.valueOf(power)+"):"+String.valueOf(c2.to_Str()));
                        pw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
        });
        it2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                JOptionPane.showMessageDialog(null,stats.html_full_stats());
            }
        });
        it3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                System.exit(0);
            }
        });
        menu.add(it1);
        menu.add(it2);
        menu.add(it3);
        bar.add(menu);
    }
    private void panel1()
    {
        JLabel lb=new JLabel();
        lb.setSize((int)(0.98*this.getWidth()),(int)(0.4*this.getHeight()));
        ImageIcon ic1=new ImageIcon(new ImageIcon("complex.gif").getImage().getScaledInstance(lb.getWidth(),lb.getHeight(),Image.SCALE_DEFAULT));
        lb.setIcon(ic1);
        lb.setBorder(BorderFactory.createLineBorder(Color.black,2));
        this.add(lb);
    }
    private void panel2()
    {
        panel2=new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        JLabel lb=new JLabel();
        final int width=(int)(0.2*this.getWidth());
        final int height=(int)(0.1*this.getHeight());
        lb.setSize(width,height);
        lb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        lb.setText("1st Complex");
        r1=new JTextField(5);
        r1.setToolTipText("Real Part of first Complex");
        im1=new JTextField(4);
        im1.setToolTipText("Imaginary part of first Complex");
        JLabel lb2=new JLabel();
        lb2.setSize((int)(0.07*this.getWidth()),(int)(0.07)*this.getHeight());
        lb2.setText("i");
        JComboBox <String> combo=new JComboBox<String>(extra);
        //combo.addItem(e);
       combo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                final int choice=combo.getSelectedIndex();
                if(r1.getText().isEmpty() || im1.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Fill all the blanks");
                    return;
                }
                Complex c1=new Complex(Double.parseDouble(r1.getText()),Double.parseDouble(im1.getText()));
                Complex res=new Complex(Double.parseDouble(r1.getText()),Double.parseDouble(im1.getText()));;
                int power;
                switch(choice)
               {
                    case 0:
                        JOptionPane.showMessageDialog(null,"Abs("+res.to_Str()+"):"+String.valueOf(c1.Abs()));
                        break;
                    case 1:
                        power=Integer.parseInt(JOptionPane.showInputDialog("Give Power:"));
                        c1.Pow(power);
                        JOptionPane.showMessageDialog(null,"Power("+res.to_Str()+"):"+String.valueOf(c1.to_Str()));
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null,"Conj("+res.to_Str()+"):"+c1.conj().to_Str());
                        break;
               }
            }
        });
        panel2.add(lb);
        panel2.add(r1);
        panel2.add(im1);
        panel2.add(lb2);
        panel2.add(combo);
        this.add(panel2);
    }
    private void panel3()
    {
        panel3=new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        JLabel lb=new JLabel();
        final int width=(int)(0.2*this.getWidth());
        final int height=(int)(0.1*this.getHeight());
        lb.setSize(width,height);
        lb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        lb.setText("2nd Complex");
        r2=new JTextField(5);
        im2=new JTextField(3);
        r2.setToolTipText("Real Part of second Complex");
        JTextField im1=new JTextField(4);
        im2.setToolTipText("Imaginary part of second Complex");
        JLabel lb2=new JLabel();
        lb2.setSize((int)(0.07*this.getWidth()),(int)(0.07)*this.getHeight());
        lb2.setText("i");
        JComboBox combo=new JComboBox(extra);
        combo.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent ae)
            {
                final int choice=combo.getSelectedIndex();
                if(r2.getText().isEmpty() || im2.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Fill all the blanks");
                    return;
                }
                Complex c1=new Complex(Double.parseDouble(r1.getText()),Double.parseDouble(im1.getText()));
                switch(choice)
               {
                    case 0:
                        JOptionPane.showMessageDialog(null,"Abs("+c1.to_Str()+"):"+String.valueOf(c1.Abs()));
                        break;
                    case 1:
                        int power=Integer.parseInt(JOptionPane.showInputDialog("Give Power:"));
                        c1.Pow(power);
                        JOptionPane.showMessageDialog(null,"Power("+c1.to_Str()+"):"+String.valueOf(c1.to_Str()));
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null,"Conj("+c1.to_Str()+"):"+c1.conj().to_Str());
                        break;
               }
            }
        });
        panel3.add(lb);
        panel3.add(r2);
        panel3.add(im2);
        panel3.add(lb2);
        panel3.add(combo);
        this.add(panel3);
    }
    private void panel4()
    {
        panel4=new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        JLabel lb=new JLabel();
        final int width=(int)(0.2*this.getWidth());
        final int height=(int)(0.1*this.getHeight());
        lb.setSize(width,height);
        lb.setBorder(BorderFactory.createLineBorder(Color.black,2));
        lb.setText("Calculation Field");
        JComboBox combo=new JComboBox(ops);
        JButton b=new JButton("Calculate");
        JTextField res=new JTextField(18);
        res.setEditable(false);
        res.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
        b.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if(r1.getText().isEmpty() || im1.getText().isEmpty() || r2.getText().isEmpty() || im2.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Fill all the blanks");
                    return;
                }
                Complex c1=new Complex(Double.parseDouble(r1.getText()),Double.parseDouble(im1.getText()));
                Complex c2=new Complex(Double.parseDouble(r2.getText()),Double.parseDouble(im2.getText()));
                final int choice=combo.getSelectedIndex();
                String msg="";
                switch(choice)
                {
                    case 0:
                        msg="Adding:"+c1.add(c2).to_Str();
                        break;
                    case 1:
                        msg="Subing:"+c1.sub(c2).to_Str();
                        break;
                    case 2:
                        msg+="Multipling:"+c1.mul(c2).to_Str();
                        break;
                    case 3:
                        msg="Diving:"+c2.div(c2).to_Str();
                        break;
                }
                res.setText(msg);
            }
        });
        panel4.add(lb);
        panel4.add(combo);
        panel4.add(b);
        panel4.add(res);
        this.add(panel4);
    }
    public Window(final String title)
    {
        super(title);
        this.setSize(500,500);
        this.setResizable(false);
        this.setBackground(Color.CYAN);
        this.setLayout(new GridLayout(0,1));
        this.Make_menu();
        this.panel1();
        this.panel2();
        this.panel3();
        this.panel4();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
