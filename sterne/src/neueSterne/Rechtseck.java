package neueSterne;

public class Rechtseck
{

    private Integer laenge;
    private Integer breite;
     private Integer höhe;



    Rechtseck(Integer lang,Integer breite){
        this.breite=breite;
        this.laenge=lang;
    }




    protected Integer flaeche(){
        return 2*(laenge*breite);
    }
 void vertauche(){

        Integer helfe=laenge;
        laenge=breite;
        breite=helfe;
        System.out.println(breite);

}


public boolean dreieck (Integer breite,Integer laenge,Integer höhe){


       if((laenge+breite)>höhe&&(laenge+höhe)>breite&&(breite+höhe)>laenge){
        System.out.println("das entspricht ein Dreieck");
        return true;
    }else {System.out.println("das entspricht kein Dreieck!!!!!");
       return false;}
}

public Integer vervielfacher(int viel){

    laenge*=viel;
    breite*=viel;
    höhe*=viel;
    return laenge+breite+höhe;

}

}
