//package com.galvanize;
//import Cardsbutrenamedforlessconfusion.*;
// Java program to demonstrate working of Scanner in Java
import java.util.Scanner;

public class Application {
    public static void main(String[] args){
        System.out.println(args);

        System.out.println("fuuuuuuuuuuuuuuuuuuuuuuuuuck java");
        //for loop test
        int bignum =10;
        for (int counter =0; counter < bignum; counter++) {
            print(""+counter);//using my print command
        }
        System.out.println("#count from 0");
        //line added for version control
        //where is this bitch located in the files!
        //found them lovely jubly

        //calling another file's static method
        Program.MyMethod();


        //for(int i =2; i<=6; i+=2){print(""+i);}pln("");

        testDeck();
        testDice();
        testChess();
        playChess();

        //-----------------------





    }//end of main

    //i'm getting lazy and these can't just be imported with a shorter name
    public static void pln(String arg){System.out.println(arg);}
    public static void print(String arg){System.out.print(arg);}
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

    }
    public static void testDice(){

        //playing with the die
        pln("playing with the die");
        Die six = new Die(6);
        pln(""+six.roll());
        Die ten = new Die(20);
        pln("twenty sided");
        for(int i = 0; i < 20; i++){
            print(","+ten.roll());
        }
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
        Board playtest = new Board(true);
        String input = "";
        while(true){
            pln(playtest+"");
            pln("Your move: ");
            input = in.nextLine();
            if(input.toLowerCase().contains("q")){pln("exit");break;}
            if(input.length()<4){pln("idiot");break;}
            if(input.toLowerCase().contains("quite")){pln("exit");break;}
            if(input.toLowerCase().contains("exit")){pln("exit");break;}
            //pln(input);
            playtest.movePiece(input.substring(0,2),input.substring(input.length()-2));
            //break;
        }



    }
}//end of file
