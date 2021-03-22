//package com.galvanize;
//import Cardsbutrenamedforlessconfusion.*;
// Java program to demonstrate working of Scanner in Java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
//import static org.junit.Assert.assertEquals;

public class Application {
    public static void main(String[] args) {
        pln("--running main--");
        //------------------
        //initialTests(args);
        //randomCode();
        //testDeck();
        //testDice();
        //playCards();
        //testChess();
        //playChess();
        //PokerHandTests.pokerHandSortTest();
        //-----------------------
        //Board locations = new Board(false);
        //pln(""+locations);
        //pln(""+Program.characterCount("Hello World"));

        //max int              2,147,483,647
        //max long 9,223,372,036,854,775,807
        long n = 6854775807l;//1140179656;
        //long n = 1237696198; //bad case expected:<1237696819> but was:<1237696577>
        //long n = 1154359022; //bad case
        //long n = 415;
        //long n = 59884848459853l; //huge number test
        pln("f:"+(Program.factorial(Long.toString(n).length())));
        long startTime = System.nanoTime();
        System.out.print(n+":");
        pln(""+n+" next "+Program.nextBiggerNumberManipulation(n));

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println((timeElapsed /1000000)+"ms");


         //n = 771;//1140179656;
         startTime = System.nanoTime();
        //System.out.print(n+":");
        pln(""+n+" next "+Program.nextBiggerNumberArray(n));

         endTime = System.nanoTime();
         timeElapsed = endTime - startTime;
        System.out.println((timeElapsed /1000000)+"ms");

        pln("--finished main--");
    }//end of main

    public static void initialTests(String[] args){

        System.out.println(args);

        System.out.println("fuuuuuuuuuuuuuuuuuuuuuuuuuck java");
        //for loop test
        int bignum = 10;
        for (int counter = 0; counter < bignum; counter++) {
            print("" + counter);//using my print command
        }
        System.out.println("#count from 0");
        //line added for version control
        //where is this bitch located in the files!
        //found them lovely jubly

        //calling another file's static method
        Program.MyMethod();


        //for(int i =2; i<=6; i+=2){print(""+i);}pln("");

        pln("12345");
        pln("" + Integer.parseInt("12345"));
        pln("d 1234");
        pln("" + Integer.parseInt("d 1234".substring(2)));
    }//end of initial tests
    public static void randomCode(){
        String str = "ABCDEFG";
        pln(str);
        String substr = "";String finstr="";
        for(int i = 0; i < str.length();i++){
            substr = str.substring(i,i+1);
            if(substr.toLowerCase().contains("a")){substr="";}
            else if(substr.toLowerCase().contains("e")){substr="";}
            else if(substr.toLowerCase().contains("i")){substr="";}
            else if(substr.toLowerCase().contains("o")){substr="";}
            else if(substr.toLowerCase().contains("u")){substr="";}

            finstr+=substr;
        }
        pln(finstr);


        pln("");
        pln("");
        pln("");
        pln(""+Program.Dupes("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));

        pln("");
        pln("");
        pln("9,8,7,6,5,4,3,2,1");
        pln(""+Program.sorttheodds(new int[]{9,8,7,6,5,4,3,2,1}));
        pln("");
        pln("1234");
        pln(Program.romannumerals(1234)+"");
        pln("");
        pln("aa bb cc aa bb cc ee dd");
        pln(Program.top3("aa bb cc aa bb cc ee dd")+"");
        pln("erg re re w wq t g aa bb cc aa bb cc ee dd a sd fg aer re bgs er ge ert a e ");
        pln(Program.top3("erg re re w wq t g aa bb cc aa bb cc ee dd a sd fg aer re bgs er ge ert a e ")+"");
        pln("a a a  b  c c  d d d d  e e e e e");
        pln(Program.top3("a a a  b  c c  d d d d  e e e e e")+"");
        pln("  , e   .. ");
        pln(Program.top3("  , e   .. ")+"");
        pln("long, answer: a of on");
        pln(Program.top3("In a village of La Mancha, the name of which I have no desire to call to mind, there lived not long since one of those gentlemen that keep a lance in the lance-rack, an old buckler, a lean hack, and a greyhound for coursing. An olla of rather more beef than mutton, a salad on most nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra on Sundays, made away with three-quarters of his income")+"");
        pln("airgjaergj. arigjvaksdlj airejgvoe aio43 sjgv 3poiojgae posijd f3049 sadkjgaskj dfgjb dijqa, a'gkq :gk gjkpor fjsp epo erojg fsdpodfgs spgof dsj ");
        pln(Program.top3("airgjaergj. arigjvaksdlj airejgvoe aio43 sjgv 3poiojgae posijd f3049 sadkjgaskj dfgjb dijqa, a'gkq :gk gjkpor fjsp epo erojg fsdpodfgs spgof dsj ")+"");
        pln("djwhqgsn, toijuovq, liscsi'");
        pln(Program.top3("xJAwyWXpSt,v'K lFbOssUmkX,QspHgXJw'w toijuOvQ HAbGke JYuz QspHgXJw'w/toijuOvQ SHG_xJAwyWXpSt-JYuz/xJAwyWXpSt!gDLMGcYhMe;JCGjRQ/gDLMGcYhMe SHG.DjwHqgSn v'K liscsI':HAbGke DjwHqgSn HAbGke;xJAwyWXpSt SHG xJAwyWXpSt lFbOssUmkX:bHRcNwcN!v'K?liscsI' TxnOTRBbS/gDLMGcYhMe/gDLMGcYhMe lFbOssUmkX_liscsI' toijuOvQ.lFbOssUmkX:xJAwyWXpSt:toijuOvQ DjwHqgSn liscsI'_lFbOssUmkX.SHG!v'K JCGjRQ liscsI' v'K;v'K DjwHqgSn JCGjRQ/lFbOssUmkX gDLMGcYhMe SHG;DjwHqgSn JCGjRQ liscsI'-bHRcNwcN/xJAwyWXpSt_JCGjRQ!HAbGke DjwHqgSn,gDLMGcYhMe liscsI' xJAwyWXpSt/QspHgXJw'w?bHRcNwcN JCGjRQ/SHG HAbGke/toijuOvQ DjwHqgSn liscsI' HAbGke lFbOssUmkX,QspHgXJw'w lFbOssUmkX xJAwyWXpSt_SHG toijuOvQ!toijuOvQ?liscsI' xJAwyWXpSt?GieN toijuOvQ.SHG:gDLMGcYhMe;SHG JCGjRQ!v'K:v'K DjwHqgSn QspHgXJw'w:toijuOvQ JCGjRQ DjwHqgSn;xJAwyWXpSt:JCGjRQ DjwHqgSn SHG xJAwyWXpSt/DjwHqgSn;liscsI'/liscsI':liscsI' toijuOvQ.lFbOssUmkX/toijuOvQ liscsI'-lFbOssUmkX_HAbGke JCGjRQ xJAwyWXpSt/liscsI' xJAwyWXpSt QspHgXJw'w bHRcNwcN-JYuz SHG;toijuOvQ.JCGjRQ,DjwHqgSn bHRcNwcN v'K!gDLMGcYhMe JYuz?gDLMGcYhMe liscsI'.QspHgXJw'w!xJAwyWXpSt JCGjRQ DjwHqgSn QspHgXJw'w DjwHqgSn-TxnOTRBbS v'K liscsI'_bHRcNwcN;toijuOvQ:xJAwyWXpSt-toijuOvQ HAbGke/v'K;lFbOssUmkX lFbOssUmkX:QspHgXJw'w;liscsI' bHRcNwcN DjwHqgSn JYuz lFbOssUmkX,toijuOvQ SHG:lFbOssUmkX v'K xJAwyWXpSt,xJAwyWXpSt QspHgXJw'w QspHgXJw'w v'K;lFbOssUmkX SHG SHG:HAbGke SHG lFbOssUmkX TxnOTRBbS gDLMGcYhMe DjwHqgSn HAbGke gDLMGcYhMe.liscsI'_QspHgXJw'w/SHG QspHgXJw'w QspHgXJw'w JCGjRQ!v'K:HAbGke JYuz gDLMGcYhMe lFbOssUmkX;xJAwyWXpSt QspHgXJw'w HAbGke DjwHqgSn-gDLMGcYhMe gDLMGcYhMe DjwHqgSn!bHRcNwcN xJAwyWXpSt gDLMGcYhMe,toijuOvQ-DjwHqgSn lFbOssUmkX:DjwHqgSn-toijuOvQ.xJAwyWXpSt v'K toijuOvQ;lFbOssUmkX v'K,DjwHqgSn-bHRcNwcN?liscsI' DjwHqgSn v'K xJAwyWXpSt TxnOTRBbS-liscsI' HAbGke,GieN lFbOssUmkX_DjwHqgSn;bHRcNwcN toijuOvQ/toijuOvQ JYuz!xJAwyWXpSt:HAbGke toijuOvQ JYuz xJAwyWXpSt:GieN-QspHgXJw'w_xJAwyWXpSt;HAbGke SHG xJAwyWXpSt v'K gDLMGcYhMe SHG/v'K!liscsI' lFbOssUmkX.QspHgXJw'w/v'K xJAwyWXpSt SHG-JCGjRQ v'K?QspHgXJw'w v'K GieN/JCGjRQ JYuz HAbGke/QspHgXJw'w QspHgXJw'w toijuOvQ DjwHqgSn_TxnOTRBbS bHRcNwcN:SHG:v'K_SHG SHG.toijuOvQ!DjwHqgSn liscsI' bHRcNwcN.lFbOssUmkX?DjwHqgSn_TxnOTRBbS SHG-SHG-bHRcNwcN JCGjRQ:HAbGke HAbGke/QspHgXJw'w?toijuOvQ.toijuOvQ?liscsI' v'K liscsI'/TxnOTRBbS DjwHqgSn QspHgXJw'w,DjwHqgSn v'K;GieN lFbOssUmkX;bHRcNwcN:liscsI' toijuOvQ DjwHqgSn QspHgXJw'w liscsI'/toijuOvQ_v'K.toijuOvQ v'K.SHG:HAbGke SHG_liscsI'!liscsI';DjwHqgSn")+"");
        pln("");
        pln((true==true)+"");
        List al1= Arrays.asList();
        List al2= Arrays.asList();
        pln(""+al1+al2);
        pln(""+(al1==al2));
        pln((Arrays.asList()==Arrays.asList())+"");
        //pln(((Arrays)Arrays.asList()==(Arrays)Arrays.asList())+"");
        //assertEquals();
    }//end of random code

    public static void testChess(){

        pln("----Working on chess board----");
        Board chessboard = new Board(true);
        pln("--Initial Chess Board");
        pln(""+chessboard);
        pln(""+chessboard.pieceAt("D8"));
        pln(""+chessboard.pieceAt("a4"));
        pln(""+chessboard.pieceAt("E1"));
        pln("-------------------");
        pln("--testing true move");
        chessboard.movePiece("A1","A4");
        pln(""+chessboard);

        pln("--testing bad move");
        chessboard.movePiece("h1","d4");
        pln(""+chessboard);
        pln("--testing bad diagonal move");
        chessboard.movePiece("h8","f6");
        pln(""+chessboard);

        pln("--testing bishop move");
        chessboard.movePiece("c8","e6");
        pln(""+chessboard);
        pln("--testing bishop bad move");
        chessboard.movePiece("f8","f4");
        pln(""+chessboard);
        pln("--testing queen move");
        chessboard.movePiece("d1","d5");
        pln(""+chessboard);
        pln("--testing queen bad move");
        chessboard.movePiece("d8","G7");
        pln(""+chessboard);
        pln("--testing queen second move");
        chessboard.movePiece("d5","f3");
        pln(""+chessboard);

        //pawn move checks
        pln("--testing pawn move");
        chessboard.movePiece("a2","a3");
        pln(""+chessboard);
        pln("--testing pawn first move");
        chessboard.movePiece("b2","b4");
        pln(""+chessboard);
        pln("--testing pawn attack move");
        chessboard.movePiece("c2","d3");
        pln(""+chessboard);
        pln("--testing pawn bad move");
        chessboard.movePiece("d3","e3");
        pln(""+chessboard);
        pln("--testing pawn bad first move");
        chessboard.movePiece("d3","d5");
        pln(""+chessboard);

        //king moves not caring whos in the way
        pln("--testing king side move");
        chessboard.movePiece("e1","d1");
        pln(""+chessboard);
        pln("--testing king diagonal move");
        chessboard.movePiece("d1","c2");
        pln(""+chessboard);
        pln("--testing king forward move");
        chessboard.movePiece("c2","c3");
        pln(""+chessboard);
        pln("--testing king bad move");
        chessboard.movePiece("e8","f4");
        pln(""+chessboard);

        //knight testing
        pln("--testing Knight move up");
        chessboard.movePiece("g1","h3");
        pln(""+chessboard);
        pln("--testing Knight second move side");
        chessboard.movePiece("h3","f4");
        pln(""+chessboard);
        pln("--testing Knight move down");
        chessboard.movePiece("g8","f6");
        pln(""+chessboard);
        pln("--testing Knight bad move one");
        chessboard.movePiece("f6","f7");
        pln(""+chessboard);
        pln("--testing Knight bad move long");
        chessboard.movePiece("f6","a1");
        pln(""+chessboard);
        pln("--testing Knight bad move square");
        chessboard.movePiece("f6","d4");
        pln(""+chessboard);
/*
        //lets get this castle thing done
        //black short side-----------------------
        pln("--getting castle black short done--");
        pln("--moving knight out of the way");
        chessboard.movePiece("g8","f6");
        pln("--moving bishop out of the way");
        chessboard.movePiece("f8","h6");
        pln("attempting castle");
        chessboard.movePiece("e8","H8",true);
        pln(""+chessboard);
        //attempting double castle wierdness-----
        pln("--Attempting bad castle");
        chessboard.movePiece("g8","a8",true);
        pln(""+chessboard);
        //black long side-------------------------
        pln("--getting castle black long done--");
        pln("--moving knight out of the way");
        chessboard.movePiece("b8","c6");
        pln("--moving bishop out of the way");
        chessboard.movePiece("c8","a6");
        pln("attempting castle");
        chessboard.movePiece("E8","A8",true);
        pln(""+chessboard);
*//*
        //white short side-----------------------
        pln("--getting castle white short done--");
        pln("--moving knight out of the way");
        chessboard.movePiece("g1","f3");
        pln("--moving bishop out of the way");
        chessboard.movePiece("f1","h3");
        pln("attempting castle");
        chessboard.movePiece("e1","H1",true);
        pln(""+chessboard);
*//*
        //white long side-------------------------
        pln("--getting castle white long done--");
        pln("--moving knight out of the way");
        chessboard.movePiece("b1","c3");
        pln("--moving bishop out of the way");
        chessboard.movePiece("C1","a3");
        pln("attempting castle");
        chessboard.movePiece("E1","A1",true);
        pln(""+chessboard);*/

    }
    public static void testDeck(){

        Deck d = new Deck();
        System.out.println(""+d);
        print("Specific cards:");
        System.out.println(""+d.pickcard(15)+d.pickcard(34)+d.pickcard(48)+d.pickcard(5));
        print("Random cards:");
        System.out.print(d.dealcard());
        print(""+d.dealcard());print(""+d.dealcard());print(""+d.dealcard());print(""+d.dealcard());pln("");
        //System.out.println(d.spilldeck()); //all the cards
        //System.out.println(""+(0+d.dealcard()+d.dealcard()));

        pln("-------");
        d.addcard(new Card("joker","club",0));
        pln(""+d.pickcard(53));
        System.out.println(d.spilldeck()); //all the cards
        pln("--");
        pln("");pln("testing hands");
        PokerHand myHand = new PokerHand(new Card[]{
                new Card("9","club",9),
                new Card("8","club",8),
                new Card("7","club",7),
                new Card("6","spade",6),
                new Card("2","club",2)});

        pln(""+myHand);
        //myHand.sortHand();
        //pln(""+myHand);
        //myHand.flipHand();
        //pln(""+myHand);
        //myHand.evaluateHand();
        pln(""+myHand.getHandType());
        pln("--");
        PokerHand otherHand=new PokerHand("9H 8H 7H 6H 3C");
        pln(""+otherHand);
        //otherHand.sortHand();
        //pln(""+otherHand);
        //otherHand.flipHand();
        //pln(""+otherHand);
        //otherHand.evaluateHand();
        pln(""+otherHand.getHandType());
        pln("--");
        pln("myhand.compare(otherhand)");
        pln("my hand better:1, my hand worse:-1");
        pln(""+myHand.compareTo(otherHand));
        PokerHand test2 = new PokerHand("3D 3H 3S KC KH");
        PokerHand test1 = new PokerHand("3D 3H 3S 2C 2H");
        pln("--");
        pln(test1+"");
        pln(""+test2);
        pln("1:"+test1.getHandType()+"|2:"+test2.getHandType());
        pln("test1.compare(test2)");
        pln(""+test1.compareTo(test2));



    }
    public static void playCards(){

        // Using Scanner for Getting Input from User
        Scanner inC = new Scanner(System.in);
        /*
        String s = in.nextLine();
        System.out.println("You entered string "+s);

        int a = in.nextInt();
        System.out.println("You entered integer "+a);

        float b = in.nextFloat();
        System.out.println("You entered float "+b);
        */

        //-------------
        //Board locations = new Board(false);
        //pln(""+locations);
        Deck playtest = new Deck();
        pln(playtest+"");
        String input = "";
        while(true) {
            pln("Your move: ");
            input = inC.nextLine().toLowerCase();
            if (input.contains("q")) {
                pln("exit");
                break;
            } else if (input.contains("quit")) {
                pln("exit");
                break;
            } else if (input.contains("exit")) {
                pln("exit");
                break;
            } else if (input.contains("help")) {
                pln("q,quit,exit,help,deal,status,shuffle");
            }else if (input.contains("deal ")){
                for(int i = 1; i<= Integer.parseInt(input.substring(5));i++){
                    print(""+playtest.dealcard());
                }pln("");
            }else if (input.contains("deal")){
                pln(playtest.dealcard()+"");
            }else if (input.contains("status")){
                pln(playtest.status());
            }else if(input.contains("shuffle")){
                playtest.shuffle();pln("done");
            }
            //if(input.length()<5){pln("idiot");break;}else
            /*if(input.toLowerCase().contains("location")){pln(""+locations);}else{
                //pln(input);
                playtest.movePiece(input.substring(0,2),input.substring(input.length()-2));
                pln(playtest+"");}*/
            //break;
        }

    }
    public static void testDice(){

        //playing with the die
        pln("playing with the die");
        Die six = new Die(6);
        pln(""+six.roll());
        six.roll();pln(""+six);
        Die ten = new Die(20);//,18,65,64);
        pln("twenty sided");
        for(int i = 0; i < 20; i++){
            print(","+ten.roll());
        }
        pln("");
        //ten.roll(); pln(""+ten);
        pln("");
    }
    public static void playChess(){

        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);
        /*
        String s = in.nextLine();
        System.out.println("You entered string "+s);

        int a = in.nextInt();
        System.out.println("You entered integer "+a);

        float b = in.nextFloat();
        System.out.println("You entered float "+b);
        */

        //-------------
        Board locations = new Board(false);
        //pln(""+locations);
        Board playtest = new Board(true);
        pln(playtest+"");
        String input = "";
        while(true){
            pln("Your move: ");
            input = in.nextLine().toLowerCase();
            if(input.toLowerCase().contains("q")){pln("exit");break;}else
            if(input.toLowerCase().contains("quit")){pln("exit");break;}else
            if(input.toLowerCase().contains("exit")){pln("exit");break;}else
            if(input.toLowerCase().contains("help")){pln("q,quit,exit,help,location,piece destination");}else
            if(input.length()<5){pln("idiot");break;}else
            if(input.toLowerCase().contains("location")){pln(""+locations);}else{
            //pln(input);
            playtest.movePiece(input.substring(0,2),input.substring(input.length()-2));
            pln(playtest+"");}
            //break;
        }



    }


    //i'm getting lazy and these can't just be imported with a shorter name
    public static void pln(String arg){System.out.println(arg);}
    public static void print(String arg){System.out.print(arg);}
}//end of file
