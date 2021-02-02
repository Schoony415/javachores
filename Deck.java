import java.util.Random;
public class Deck{
        private int decksize;
        private Card[] cards;

        //constructor
        public Deck(){
            System.out.println("deck initilized, this at in constructor");
            this.decksize = 0;
            this.cards = new Card[52];

            //making cards
            int tempvalue=0;
            int tempsuite=1;

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
                    this.cards[this.decksize] = tempcard;
                    this.decksize++;
                    //addcard(tempcard);
                    System.out.print(this.decksize+",");
                }
                if(tempvalue==13){tempvalue=0;tempsuite++;}

            }//end of for loop


        System.out.println("finished constructor");
        }//end of constructor
/*
        //addcard
        public void addcard(card togive){
            this.cards[this.decksize] = togive;
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
        for (Card tcard : cards){
                tempstring+= tcard;
        }
        return tempstring;
    }

}

    //-------------

    //-------------

/*    public static void main(String[] args){
        Deck thisolddeck = createdeck();

    }

*/
    /*
    public static Deck createdeck(){
        Deck TempDeck = new Deck();

        int tempvalue=0;
        int tempsuite=1;

        for(int i=1;i<=52;i++){
            tempvalue++;
            if (tempvalue <=13){
                card tempcard = new card();
                tempcard.face=tempvalue;
                switch (tempsuite){
                    case 1:
                        tempcard.Suite="Hearts";
                        break;
                    case 2:
                        tempcard.Suite="Club";
                        break;
                    case 3:
                        tempcard.Suite="Spade";
                        break;
                    case 4:
                        tempcard.Suite="Diamond";
                        break;
                }
            System.out.println(TempDeck.addcard(tempcard));




            }

        }

    }

     */


