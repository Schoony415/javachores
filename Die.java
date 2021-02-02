import java.util.Random;
public class Die {
    int sides;
    int onTop;
    Random rand;
    public Die(int aSides){
        sides = aSides;
        onTop = 0;
        rand = new Random();
    }
    public int roll(){
        onTop = rand.nextInt(sides)+1;
        return onTop;
    }
    public int lastRoll() {
        return onTop;
    }
    public String toString(){return(""+onTop);}
}
