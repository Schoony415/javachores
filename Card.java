public class Card {
        String Face;
        String Suite;
        int Value;
        public Card(){
            this.Face = "";
            this.Suite = "";
            this.Value = 0;
        }
        public String getFace(){
            return Face;
        }
        public String getSuite(){
            return Suite;
        }
        //string over write
        public String toString(){
            return (" ["+getFace()+" of "+getSuite()+"] ");
        }
        //int over write?
    public int toInt(){
            return Value;
    }
        public String toStringshort(){
            return (""+Value+Suite);
        }
}
