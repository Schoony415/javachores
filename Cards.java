public class Cards {
    private class Deck{
        private static int decksize;
        private static card[] cards;
    }
    private class card{
        private static String Face;
        private static String Suite;
    }
    public static void main(String[] args){


    }
    private void createdeck(){
        int tempvalue=0;
        int tempsuite=1;

        for(int i=1;i<=52;i++){
            tempvalue++;
            if (tempvalue <=13){
                card tempcard = new;
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
                


            }

        }

    }

}
