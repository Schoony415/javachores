//package com.galvanize;
//import Cardsbutrenamedforlessconfusion.*;

public class Application {
    public static void main(String[] args){
        System.out.println("fuuuuuuuuuuuuuuuuuuuuuuuuuck java");
        System.out.println("like for real what is this crap, why did i make like a thousand files just to print to a conesole awwwwwwwwwwwwwww");
        int bignum =10;
        for (int counter =0; counter < bignum; counter++) {
            System.out.print(counter);
        }
        System.out.println("#count from 0");
        //line added for version control
        //where is this bitch located in the files!
        //found them lovely jubly

        //calling another file's static method
        Program.MyMethod();
        Deck d = new Deck();
        System.out.println(""+d.pickcard(15)+d.pickcard(34)+d.pickcard(48)+d.pickcard(5));
        System.out.println(d.dealcard());
        System.out.println(d.spilldeck());
        //System.out.println(""+(0+d.dealcard()+d.dealcard()));
    }
}
