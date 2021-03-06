import java.util.Random;
public class Deck{
        private int decksize;//to help keep track
        private Card[] cards;
        private Random rand;

        //constructor
        public Deck(){
            //System.out.println(); System.out.print("deck initilized, this at in constructor");
            this.decksize = 0;
            this.cards = new Card[52];
            rand = new Random();

            //making cards
            int tempvalue=0;
            int tempsuite=1;
            //<=52 because we start by adding 1
            for(int i=1;i<=52;i++) {
                tempvalue++;
                if (tempvalue <= 13) {
                    Card tempcard = new Card();
                    tempcard.Value = tempvalue;
                    switch (tempsuite) {
                        case 1:
                            tempcard.Suite = "Hearts";
                            break;
                        case 2:
                            tempcard.Suite = "Club";
                            break;
                        case 3:
                            tempcard.Suite = "Spade";
                            break;
                        case 4:
                            tempcard.Suite = "Diamond";
                            break;
                    }
                    switch (tempvalue){
                        case 1:
                            tempcard.Face = "Ace";
                            break;
                        case 2:
                            tempcard.Face = "Two";
                            break;
                        case 3:
                            tempcard.Face = "Three";
                            break;
                        case 4:
                            tempcard.Face = "Four";
                            break;
                        case 5:
                            tempcard.Face = "Five";
                            break;
                        case 6:
                            tempcard.Face = "Six";
                            break;
                        case 7:
                            tempcard.Face = "Seven";
                            break;
                        case 8:
                            tempcard.Face = "Eight";
                            break;
                        case 9:
                            tempcard.Face = "Nine";
                            break;
                        case 10:
                            tempcard.Face = "Ten";
                            break;
                        case 11:
                            tempcard.Face = "Jack";
                            break;
                        case 12:
                            tempcard.Face = "Queen";
                            break;
                        case 13:
                            tempcard.Face = "King";
                            break;
                        default:
                            tempcard.Face = "Joker";
                            break;
                    }
                    this.cards[this.decksize] = tempcard;//using decksize because 0 base
                    this.decksize++;
                    //addcard(tempcard);
                    //System.out.print(this.decksize+",");
                }
                //this resets values after the king
                if(tempvalue==13){tempvalue=0;tempsuite++;}
            }//end of for loop

        //System.out.println("finished constructor");
        }//end of constructor

    //addcard //not working for me
    public void addcard(Card togive){
        Card[] temparry = new Card[decksize+1];
        for(int i= 0; i< (decksize); i++){
            temparry[i] = cards[i];
        }
        temparry[decksize]=togive;
        this.decksize++;
        this.cards = new Card[decksize];
        this.cards = temparry;
        //return this.decksize;
    }

    public Card pickcard(int arg){
        cards[arg-1].dealt=true;
        return cards[arg-1];
    }
    public Card dealcard(){
        boolean cont = false;
        for (Card tcard : cards){
            if(tcard.dealt == false){
                cont=true; break;
            }
        }

        while(cont){
            int tempnum= rand.nextInt(decksize);
            if(cards[tempnum].dealt == false){
                cards[tempnum].dealt=true;
                return cards[tempnum];
            }
        }
        return null;
    }
    public String spilldeck(){
        String tempstring = "";
        //foreach:
        for (Card tcard : cards){
                tempstring += tcard;
        }
        return tempstring;
    }
    public String status(){
            int dealt = 0;
            for(Card c : cards)
                if(c.dealt==true){dealt++;}
            return ("Deck of "+decksize+" / "+dealt+" dealt");
    }
    public void shuffle(){
        for(Card c : cards)
            if(c.dealt==true){c.dealt=false;}
    }
    //string overwrite
    public String toString(){
        return ("Deck of "+decksize);
    }

}
