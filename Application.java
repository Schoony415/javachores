//package com.galvanize;
//import Cardsbutrenamedforlessconfusion.*;


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

        //for(int i =2; i<=6; i+=2){print(""+i);}pln("");





    }//end of main

    //i'm getting lazy and these can't just be imported with a shorter name
    public static void pln(String arg){System.out.println(arg);}
    public static void print(String arg){System.out.print(arg);}
}//end of file
