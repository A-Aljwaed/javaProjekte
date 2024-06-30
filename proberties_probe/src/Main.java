import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws Exception {


//        Properties p=new Properties();
//
//        p.setProperty("hersteller","Asus");
//        p.setProperty("prozessor","Amd");
//        p.setProperty("Netzteil","69W");
//        p.setProperty("Grafikkarte","keine");

//        p.storeToXML(new FileOutputStream("/Users/ahmad/Desktop/vom_alten_pc.xml"),"das sind dein pc daten");
//
//        p.load(new FileInputStream("/Users/ahmad/Desktop/vom_alten_pc.txt"));
//        System.out.println(p.getProperty("hersteller"));
//

FileInputStream fis=new FileInputStream("/Users/ahmad/Desktop/vom_alten_pc.txt");
byte []b=new byte[fis.available()];
fis.read(b);

String data=new String(b);


//        String data="name=ahmad\nnachname=aljwaed\nland=Deutschland\nstrasse=kapellenst";

        StringTokenizer stk=new StringTokenizer(data,"=");
String s;

while(stk.hasMoreTokens()){

    s=stk.nextToken();

    System.out.println(s);

}

    }
}