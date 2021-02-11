import java.util.Random;
//import java.awt.Color;
public class Die {
    int sides;
    int onTop;
    //Color dColor;
    Random rand;
    public Die(int aSides){
        sides = aSides;
        onTop = 0;
        //dColor = new Color(0);
        rand = new Random();
    }
    public Die(int aSides, int rColor, int gColor, int bColor){
        sides = aSides;
        onTop = 0;
        //dColor = new Color(rColor,gColor,bColor);
        rand = new Random();
    }
    public int roll(){
        onTop = rand.nextInt(sides)+1;
        return onTop;
    }
    public int lastRoll() {
        return onTop;
    }
    public String toString(){return(""+onTop);}//dColor+":"+onTop);}
}
