public class Card implements Comparable<Object>{
    String Face;
    String Suite;
    int Value;
    boolean dealt;
    //constructor
    public Card(){
        this.Face = "";
        this.Suite = "";
        this.Value = 0;
        this.dealt = false;
    }
    public  Card(String tface, String tSuite, int tvalue){
        this.Face = tface;
        this.Suite = tSuite;
        this.Value = tvalue;
        this.dealt = false;
    }
    //output methods
    public String getFace(){
        return Face;
    }
    public String getSuite(){
        return Suite;
    }
    public int getValue(){return Value;}
    //not an overwrite
    public String toStringShort(){
        return (""+Value+Suite.substring(0,1));
    }
    //for comparable
    public int compareTo(Object o){
        Card c = (Card) o;
        return (this.Value-c.Value);
    }/*
    @Override
    public boolean equals(Object o){
        Card c = (Card) o;
        if(this.Value==c.getValue()){
            if(0==this.Suite.compareTo(c.getSuite())){
                return true;
            }
        }
        return false;
    }*/
    //string over write
    @Override
    public String toString(){
        return (" ["+getFace()+" of "+getSuite()+"] ");
    }
    //int
    public int toInt(){
        return Value;
    }
}
