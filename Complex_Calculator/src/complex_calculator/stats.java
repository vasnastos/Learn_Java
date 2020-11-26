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
public class stats {
    public static String html_full_stats()
    {
        double rp1,imp1,rp2,imp2;
        Random r=new Random(20000);
        rp1=r.nextDouble()%400;
        imp1=r.nextDouble()%400;
        rp2=r.nextDouble()%400;
        imp2=r.nextDouble()%400;
        int power=r.nextInt()%10;
        Complex c1=new Complex(rp1,imp1);
        Complex c2=new Complex(rp2,imp2);
        String msg="<html><h3>Full Statistics of Random Numbers"+c1.to_Str()+"--"+c2.to_Str()+"</h3>";
        msg+="<hr><ul>";
        msg+="<li>1st Complex:"+c1.to_Str()+"</li>";
        msg+="<li>2nd Complex:"+c2.to_Str()+"</li>";
        msg+="<li>Add:"+(c1.add(c2)).to_Str()+"</li>";
        msg+="<li>Sub:"+(c1.sub(c2)).to_Str()+"</li>";
        msg+="<li>Mul:"+c1.mul(c2).to_Str()+"</li>";
        msg+="<li>Div:"+c1.div(c2).to_Str()+"</li>";
        msg+="<li>Abs(1st Complex):"+String.valueOf(c1.Abs())+"</li>";
        msg+="<li>Abs(2nd Complex):"+String.valueOf(c2.Abs())+"</li>";
        msg+="<li>Conj(1st Complex):"+String.valueOf(c1.conj())+"</li>";
        msg+="<li>Conj(2nd Complex):"+String.valueOf(c2.conj())+"</li>";
        c1.Pow(power);
        c2.Pow(power);
        msg+="<li>Pow(1st complex-"+String.valueOf(power)+"):"+String.valueOf(c1.to_Str())+"</li>";
        msg+="<li>Pow(2nd complex-"+String.valueOf(power)+"):"+String.valueOf(c2.to_Str())+"</li>";
        msg+="</ul></html>";
        return msg;
    }
}
