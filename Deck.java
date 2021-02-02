import java.util.Random;
public class Deck{
        private int decksize;//to help keep track
        private Card[] cards;

        //constructor
        public Deck(){
            System.out.println(); System.out.print("deck initilized, this at in constructor");
            this.decksize = 0;
            this.cards = new Card[52];

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
                    System.out.print(this.decksize+",");
                }
                //this resets values after the king
                if(tempvalue==13){tempvalue=0;tempsuite++;}
            }//end of for loop

        System.out.println("finished constructor");
        }//end of constructor
/*
    //addcard //not working for me
    public void addcard(Card togive){
        this.cards[] += [togive];
        this.decksize++;
        //return this.decksize;
    }
*/
    public Card pickcard(int arg){
        return cards[arg];
    }
    public Card dealcard(){
        Random rand = new Random();
        return cards[rand.nextInt(decksize-1)];
    }
    public String spilldeck(){
        String tempstring = "";
        //foreach:
        for (Card tcard : cards){
                tempstring += tcard;
        }
        return tempstring;
    }
    //string overwrite
    public String toString(){
        return ("Deck of "+decksize);
    }

}
