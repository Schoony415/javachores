//package com.galvanize;
//import Cardsbutrenamedforlessconfusion.*;


public class Application {
    public static void main(String[] args){
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
        System.out.println(""+d.pickcard(15)+d.pickcard(34)+d.pickcard(48)+d.pickcard(5));
        System.out.println(d.dealcard());
        System.out.println(d.spilldeck());
        //System.out.println(""+(0+d.dealcard()+d.dealcard()));

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

    //i'm getting lazy and these can't just be imported with a shorter name
    public static void pln(String arg){System.out.println(arg);}
    public static void print(String arg){System.out.print(arg);}
}
