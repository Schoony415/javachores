import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.HashMap;

public class PokerHand implements Comparable<Object>{

    Card[] Hand;//public for testing
    private int HandType;
    //private int pairprimary;//might make array
    //private int pairsecondary;
    int[] mask;

    public PokerHand(String shand){
        Hand= new Card[5];
        int i = 0;
        String Suite="";
        String Face="";
        int Value=0;
        for(String s : shand.split(" ")){
            Face=s.substring(0,1);
            switch (s.substring(1)){
                case "C":Suite="Club";break;
                case "H":Suite="Hearts";break;
                case "D":Suite="Diamond";break;
                case "S":Suite="Spade";break;
            }
            /*
            if (Face.contains("K"))
                Value = 13;
            else if (Face.contains("Q"))
                Value = 12;
            else if (Face.contains("J"))
                Value = 11;
            else if (Face.contains("T"))
                Value = 10;
            else if (Face.contains("A"))
                Value = 1;
            else Value = Integer.parseInt(Face);
             */
            switch (Face){
                case "A": Face="Ace";Value=14; break;
                case "K": Face="King";Value=13; break;
                case "Q": Face="Queen";Value=12; break;
                case "J": Face="Jack";Value=11; break;
                case "T": Face="10";Value=10; break;
                default: Value = Integer.parseInt(Face);
            }

            Hand[i]=new Card(Face, Suite, Value);


            //Hand[i]=new Card(s.substring(1,1),s.substring(2,2),Integer.parseInt(s.substring(1,1)));
            i++;
        }
        this.sortHand();
        this.flipHand();
        this.evaluateHand();
    }
    public PokerHand(Card[] ahand){
        Hand= new Card[5];
        Hand=ahand;
        int i = 0;
        this.sortHand();
        this.flipHand();
        this.evaluateHand();

    }
    public PokerHand(Card[] ahand,int itype){
        Hand= new Card[ahand.length];
        Hand=ahand;
        int i = 0;
        HandType=itype;
        /*
        this.sortHand();
        this.flipHand();
        this.evaluateHand();
        */
    }

    public void evaluateHand(){//only public for testing
        //hand types will be
        //1 royal flush
        //2 straight flush
        //3 four of a kind
        //4 full house
        //5 flush
        //6 straight
        //7 three of a kind
        //8 two pair
        //9 pair
        //10 high card
        //hand secondary values will have to some how account for
        //the lead card of a flush or straight or the bigger pair
        //
        HandType = 0;

        //----------checking flush----------
        boolean flush = true;//will flip the vriable when proven wrong
        //if Hand.suites all equal
        for(Card c : Hand) {
            if (!c.getSuite().contains(Hand[0].getSuite())) {
                flush = false;
            }
        }
        //--Handtype = 5//flush
        if(flush){
            HandType=5;
        }

        //----------checking pair, two pair, boat,three of a kind, four of a kind----------
        int countmatches=0;
        HashMap<Integer, ArrayList<Card>> maskd = new HashMap<>();
        int[] mask = new int[5];
        int currentmask=1;
        maskd.put(0, new ArrayList<>());
        mask[0]=0;
        maskd.get(0).add(this.Hand[0]);
        //if any two hand.value equal
        for(int comp = 0; comp<Hand.length;comp++){//comparitor
            for(int check = comp+1; check<Hand.length;check++) {//checker
                //System.out.print("{"+comp+check+"}");
                if(0==Hand[comp].compareTo(Hand[check])){
                    //System.out.println("pair"+Hand[comp]+Hand[check]);
                    countmatches++;
                    /*if(pairprimary==0&&!(pairprimary==Hand[check].getValue())){
                        pairprimary=Hand[check].getValue();
                    }else if(pairsecondary==0){
                        pairsecondary=Hand[check].getValue();
                    }//this wont work for boats
                    */
                    //create mask?
                    if(mask[comp]==0){
                        mask[comp]=currentmask;
                        maskd.put(currentmask,new ArrayList<>());
                        maskd.get(currentmask).add(this.Hand[comp]);
                        currentmask++;
                        if(maskd.get(0).contains(this.Hand[comp])){
                            maskd.get(0).remove(this.Hand[comp]);
                        }
                    }
                    mask[check]=mask[comp];
                    if(!maskd.get(mask[comp]).contains(this.Hand[check])) {
                        if(maskd.get(0).contains(this.Hand[check]))
                            maskd.get(0).remove(this.Hand[check]);
                        maskd.get(mask[comp]).add(this.Hand[check]);
                    }
                    continue;
                }
                if(!maskd.get(0).contains(this.Hand[check]))
                    maskd.get(0).add(this.Hand[check]);
            }
        }

        //for(int m:maskd.keySet())
        //    System.out.print(""+m+":"+maskd.get(m));
        //System.out.println("");

        if(HandType==0)
        switch (countmatches){ //basically i'm counting the collisions
            case 1: HandType=9;break;//one pair
            case 2: HandType=8;break;//two pair
            case 3: HandType=7;break;//triple
            case 4: HandType=4;break;//boat
            case 6: HandType=3;break;//four of  a kind
            case 10: HandType=-1;break;//five of a kind
        }//reorder cards by mask?
        if(countmatches>0){
            Card[] newhand = new Card[5];
            int bigger = 0;
            if(currentmask==3) {//two pair boat
                //two pair
                if (maskd.get(1).get(0).getValue()
                        > maskd.get(2).get(0).getValue()) {
                    bigger = 1;
                } else {
                    bigger = 2;
                }

                //boat
                if (maskd.get(1).size() == 3) {
                    bigger = 1;
                }
                if (maskd.get(2).size() == 3) {
                    bigger = 2;
                }
            }else {
                //one pair???
                bigger = 1;
            }

                for(int i = 0; i<5;i++){
                    //if(maskd.containsKey(bigger)) {
                        if(!maskd.get(bigger).isEmpty()) {
                            newhand[i] = maskd.get(bigger).get(0);
                            //if (maskd.get(bigger).size() > 0) {
                            maskd.get(bigger).remove(0);
                            //} else {
                            //    bigger = Math.abs(bigger - 3);
                            //}
                        }else{
                            if(maskd.containsKey(Math.abs(bigger-3))){
                                if(!maskd.get(Math.abs(bigger-3)).isEmpty()){
                                    bigger = Math.abs(bigger-3);
                                }else{
                                    bigger = 0;
                                }
                            }else{
                                bigger = 0;
                            }
                            i--;
                        }
                    //}

                }//end for loop

            //end pair bits

        //System.out.println(newhand);
        this.Hand=newhand;
        }//end reshuffle hand if statement
        //----------checking for straight----------
        //if first card is ace and second card is a 5, treat ace as one
        if(Hand[0].getValue()==14&&Hand[1].getValue()==5) {
            Hand[0] = new Card("Ace", Hand[0].getSuite(), 1);
            //Hand[0].Value=1;
            this.sortHand();
            this.flipHand();
        }
        //go through hand and see if all 5 values are consecutive
        int n = Hand[0].getValue();
        boolean straight = true;
        for(int i = 1;i<Hand.length; i++){
            n--;
            if(!(Hand[i].getValue()==n)){
                straight=false;
            }
        }
        if(straight){
            //if above true
            //--if handtype = 5
            if(HandType==5) {
                //----if card1 is ace
                if (Hand[0].getValue() == 14) {
                    //------handtype = 1 //royal flush
                    HandType = 1;
                } else {
                    //----else
                    HandType=2;
                    //------handtype = 2 //straight flush
                }
            }else {
                //--else //not a flush
                HandType=6;
                //----handtype = 6 //straight
            }
        }

        //----------checking high card----------
        //if handtype = 0
        if(HandType==0) {
            HandType=10;
            //--hand card = 10
        }
    }

    //only public for testing
    public void sortHand(){
        Arrays.sort(Hand);
    }
    //only public for testing
    public void flipHand(){
        int up = 0;
        int down = Hand.length-1;
        Card[] temp = new Card[Hand.length];
        for(int i=0;i<Hand.length;i++){
            temp[down]=Hand[up];
            up++;down--;
        }
        Hand=temp;
    }
    public int getHandType(){return this.HandType;}
    public int compareTo(Object o){
        PokerHand other = (PokerHand) o;
        return -(compareToHelper(other));
    }
    private int compareToHelper(PokerHand other) {
        //PokerHand other = (PokerHand) o;
        //if(this.equals( new PokerHand("3D 3H 3S 13C 13H")))
        //    System.out.print("");
        //System.out.print("C"+this.Hand[0]+other.Hand[0]);
        //System.out.print(",C");
        int output=0;
        if (this.HandType > other.getHandType()){
            //System.out.println("");
            output = -1;
        }else if (this.HandType < other.getHandType()) {
            //System.out.println("");
            output = 1;
        } else{
            //this is the trouble case
            if(this.Hand[0].getValue()==other.Hand[0].getValue()) {
                /*
                if((this.HandType==9)||(this.HandType==8)||(this.HandType==7)||(this.HandType==4)||(this.HandType==3)){
                    //if you have paris, compare pair primary ans secondary
                    if(this.pairprimary==other.pairprimary){
                        if(this.pairsecondary==other.pairsecondary){

                        }
                    }
                }else{
                */
                    if(this.Hand.length==1){
                        //System.out.println("");
                        output = 0;
                    }else{//same exact hand
                        PokerHand thisCopy = new PokerHand(
                                Arrays.copyOfRange(this.Hand,1,this.Hand.length),this.HandType);
                        output = -(thisCopy.compareTo(new PokerHand(
                                Arrays.copyOfRange(other.Hand,1,other.Hand.length),other.getHandType())));
                    }
                //}
            }else{
                //System.out.println("");
                output = (this.Hand[0].getValue()-other.Hand[0].getValue());
            }

        }
        //System.out.print(output+",");
        return output;
    }
    public enum Result { TIE, WIN, LOSS }

    public Result compareWith(PokerHand hand) {
        int comp = this.compareTo(hand);
        if(comp>0){
            return Result.WIN;
        }
        if(comp<0){
            return Result.LOSS;
        }
        return Result.TIE;
    }
    public boolean equals(Object o){
        PokerHand other = (PokerHand) o;
        //System.out.println("Compare"+this.Hand[0]+other.Hand[0]);
        //System.out.print("E");
        return 0==this.compareTo(other);
    }
    public String toString(){
        String temp = "";
        for(Card c : Hand){
            temp+=c;
        }
        return temp;
    }
    public String toStringShort(){
        String temp = "";
        for(Card c : Hand){
            temp+=c.toStringShort()+" ";
        }
        return temp;
    }
}
