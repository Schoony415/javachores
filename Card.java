public class Card {
    String Face;
    String Suite;
    int Value;
    //constructor
    public Card(){
        this.Face = "";
        this.Suite = "";
        this.Value = 0;
    }
    public  Card(String tface, String tSuite, int tvalue){
        this.Face = tface;
        this.Suite = tSuite;
        this.Value = tvalue;
    }
    //output methods
    public String getFace(){
        return Face;
    }
    public String getSuite(){
        return Suite;
    }
    //not an overwrite
    public String toStringShort(){
        return (""+Value+Suite);
    }
    //string over write
    public String toString(){
        return (" ["+getFace()+" of "+getSuite()+"] ");
    }
    //int over write?
    public int toInt(){
        return Value;
    }
}
