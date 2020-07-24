package inheritance;

import java.util.Vector;

import javax.swing.JOptionPane;

public class start_prog {

	public static void main(String[] args) {
		Vector <book> books=new Vector<book>();
        Ebook bk1=new Ebook("2er47","Ebook1","Author1",150.0,"www.book1_ex.com",22.56);
        Ebook bk2=new Ebook("2er98","Ebook2","Author2",75.0,"www.book2_ex.com",19.45);
        Paperbook pb1=new Paperbook("6er38","PaperBook1","Author3",89.0,12.56,true);
        Paperbook pb2=new Paperbook("6er59","PaperBook2","Author1",81.0,9.32,false);
        books.add(bk1);
        books.add(bk2);
        books.add(pb1);
        books.add(pb2);
        String info="";
        for(book b:books)
        {
        	info+=b.to_str();
        }
        JOptionPane.showMessageDialog(null, info);
	}

}
