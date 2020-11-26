/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complex_calculator;

import java.util.Random;

/**
 *
 * @author nasto
 */
public class Complex {
    private double re;
    private double im;
    public Complex(double r,double im) {
         this.re=r;
         this.im=im;
    }
    /*public Complex(){
        this.re=0.0;
        this.im=0.0;
    }*/
    public double real() {return this.re;}
    public double imaginary() {return this.im;}
    public Complex add(final Complex c)
    {
        return new Complex(this.re+c.re,this.im+c.im);
    }
    public Complex sub(final Complex c)
    {
        return new Complex(this.re-c.re,this.im-c.im);
    }
    public Complex mul(final Complex c)
    {
        double temp_re=this.re*c.re-this.im*c.im;
        double temp_im=this.re*c.im+this.im*c.re;
        return new Complex(temp_re,temp_im);
    }
    public Complex div(final Complex c)
    {
        double temp_re=(this.re*c.re+this.im*c.im)/Math.pow(c.re, 2)+Math.pow(c.im,2);
        double temp_im=(this.im*c.re-this.re*c.im)/Math.pow(c.re,2)+Math.pow(c.im,2);
        return new Complex(temp_re,temp_im);
    }
    public void Pow(int power)
    {
        Complex c=new Complex(this.re,this.im);
        Complex res=new Complex(this.re,this.im);
        for(int i=1;i<power;i++)
        {
            res=this.mul(c);
        }
        this.re=res.re;
        this.im=res.im;
    }
    public Complex conj()
    {
        return new Complex(this.re,(this.im)*-1.0);
    }
    public double Abs()
    {
        return Math.sqrt((Math.pow(this.re,2)+Math.pow(this.im,2)));
    }
    public boolean equals(Complex c)
    {
        return this.re==c.re && this.im==c.im;
    }
    public String to_Str()
    {
        return String.valueOf(this.re)+(this.im<0?"":"+")+String.valueOf(this.im)+"i";
    }
}
