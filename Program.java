import java.net.URI;
import java.time.LocalDateTime;
import java.util.*;
//import java.*;


class Program {
    public static void main(String[] args) {
        System.out.println("Look mom it's on one line, don't tell them big wigs");
        String[] mystringarray = {"ted","alpha","zulu","you mama"};
        System.out.println(sortArray(mystringarray));

        System.out.println(toSentence(mystringarray));

    }
    //the definition of small code?

    //trying to get this called from app
    public static void MyMethod() {
        System.out.println("-----");
        System.out.println("this is from my other file! Using a static method");
        System.out.println("-----");
    }

    // Implement the sortArray method below below
    public static ArrayList<String> sortArray(String[] inputArray) {
        ArrayList<String> mylist = new ArrayList<>();
        for(String insnip : inputArray){
            mylist.add(insnip);
        }
        mylist.sort(null);
        return mylist;
    }
    public HashMap<Integer, String> genHashMap() {
        /*
        For the given method signature, write an implementation that generates a HashMap,
        adds the following two items, and returns this new HashMap.
        The string, "Airplane", associated with key 747
        The string, "Laphroaig", associated with key 10
        Note: remember to attempt this challenge in your Java playground first and
        then paste your answer below. Do not write it directly in the editor.*/
         HashMap<Integer,String> myhash = new HashMap<>();
         myhash.put(747,"Airplane");
         myhash.put(10,"Laphroaig");
         return myhash;
    }


    /*
    In the space below, define and implement a method called toSentence.
    It takes as input an array of strings (String[]) and returns a string that contains
    all the elements of the array joined by a comma, with the last element joined by "and".

    Input [""] should return ""
    Input [] should return ""
    Input ["Alice", "Bob"] should return "Alice and Bob"
    Input ["Alice", "Bob", "Carol"] should return "Alice, Bob and Carol"
    Note: remember to attempt this challenge in your Java playground first and
    then paste your answer below. Do not write it directly in the editor.
     */
    public static String toSentence(String[] inputs){
        String tempString = "";
        if(inputs.length == 0 || inputs[0] == "") return tempString;
        for(String snipit : inputs)
            if(inputs[inputs.length-1]==snipit) tempString+=" and "+snipit;
            else if(inputs[0]==snipit)tempString+=snipit;
            else tempString+= ", "+snipit;
        return tempString;
    }
    public static int Dupes(String text){
        HashMap<String, Integer> myhash = new HashMap<>();
        String temp = "";
        for(int i = 0; i < text.length();i++){
            temp = text.substring(i,i+1).toLowerCase();
            if(myhash.containsKey(temp)){
                myhash.put(temp, myhash.get(temp)+1);
            }else{myhash.put(temp,1);}
        }
        int counter = 0;
        for(Integer valuetocount:myhash.values()){
            if(valuetocount>1){
                counter++;
            }
        }
        return counter;
    }
    public static int oddint(int[] a){
        HashMap<Integer, Integer> myhash = new HashMap<>();
        //String temp = "";
        for(int tocheck:a){
            //temp = text.substring(i,i+1).toLowerCase();
            if(myhash.containsKey(tocheck)){
                myhash.put(tocheck, myhash.get(tocheck)+1);
            }else{myhash.put(tocheck,1);}
        }
        for(Integer valuetofind:myhash.keySet()){
            if((myhash.get(valuetofind)%2)==1){
                return valuetofind;
            }
        }
        //Collections.max()
        return 0;
    }

    public static int[] sorttheodds(int[] array){
        int[] mask = new int[array.length];
        int oddlen = 0;
        for(int i=0;i<array.length;i++)
            mask[i] = array[i] % 2;
        for(int check:mask)
            if(check==1)
                oddlen++;
        //
        for(int i:mask)
            System.out.print(i+",");
        System.out.println();
        System.out.println(oddlen);
        //return mask;
        int[] odds = new int[oddlen];
        int keeptrack=0;
        for(int i=0;i<array.length;i++)
            if(mask[i]==1){
                odds[keeptrack]=array[i];
                keeptrack++;
            }
        keeptrack=0;
        Arrays.sort(odds);
        for(int i=0;i<array.length;i++)
            if(mask[i]==1){
                array[i]=odds[keeptrack];
                keeptrack++;
            }
        for(int i:odds)
            System.out.print(i+",");
        System.out.println();
        for(int i:array)
            System.out.print(i+",");
        return odds;
    }

    /*
    Symbol    Value
I          1
V          5
X          10
L          50
C          100
D          500
M          1,000
     */
    public static String romannumerals(int n){
        //int number; // = and int
        LinkedList<Integer> tstack = new LinkedList<Integer>();
        while (n > 0) {
            tstack.push( n % 10 );
            n = n / 10;
        }
        //--------
        /*while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }System.out.println();*/
        //--------
        String[] finalout = new String[]{"","","",""};
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(!tstack.isEmpty()){stack.push(tstack.pop());}
        if(!stack.isEmpty())
        switch (stack.pop()){
            case 1: finalout[3]="I";break;
            case 2: finalout[3]="II";break;
            case 3: finalout[3]="III";break;
            case 4: finalout[3]="IV";break;
            case 5: finalout[3]="V";break;
            case 6: finalout[3]="VI";break;
            case 7: finalout[3]="VII";break;
            case 8: finalout[3]="VIII";break;
            case 9: finalout[3]="IX";break;
            case 0: finalout[3]="";break;
        }
        if(!stack.isEmpty())
        switch (stack.pop()){
            case 1: finalout[2]="X";break;
            case 2: finalout[2]="XX";break;
            case 3: finalout[2]="XXX";break;
            case 4: finalout[2]="XL";break;
            case 5: finalout[2]="L";break;
            case 6: finalout[2]="LX";break;
            case 7: finalout[2]="LXX";break;
            case 8: finalout[2]="LXXX";break;
            case 9: finalout[2]="XC";break;
            case 0: finalout[2]="";break;
        }
        if(!stack.isEmpty())
        switch (stack.pop()){
            case 1: finalout[1]="C";break;
            case 2: finalout[1]="CC";break;
            case 3: finalout[1]="CCC";break;
            case 4: finalout[1]="CD";break;
            case 5: finalout[1]="D";break;
            case 6: finalout[1]="DC";break;
            case 7: finalout[1]="DCC";break;
            case 8: finalout[1]="DCCC";break;
            case 9: finalout[1]="CM";break;
            case 0: finalout[1]="";break;
        }
        if(!stack.isEmpty())
        switch (stack.pop()) {
            case 1: finalout[1] = "M";break;
            case 2: finalout[1] = "MM";break;
            case 3: finalout[1] = "MMM";break;
        }
        return (""+finalout[0]+finalout[1]+finalout[2]+finalout[3]);
    }
    //public static String romanelegant(int n){
    static final String R1[]    = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
    static final String R10[]   = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
    static final String R100[]  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
    static final String R1000[] = {"", "M", "MM", "MMM" };

    public String romanElegant(int n) {
        return R1000[n/1000]+R100[n%1000/100]+R10[n%100/10]+R1[n%10];
    }
    //}
    /*
//import java.util.*;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Collections;
*/
    //public class TopWords {
        public static ArrayList<String> top3(String s){
            HashMap<String, Integer> wordlist = new HashMap<>();
            int count=0;
            s=s.replaceAll("/"," ");
            s=s.replaceAll("\\."," ");
            s=s.replaceAll(":"," ");
            s=s.replaceAll("\\?"," ");
            s=s.replaceAll("\\\\"," ");
            s=s.replaceAll("-"," ");
            s=s.replaceAll(";"," ");
            s=s.replaceAll(","," ");
            s=s.replaceAll("_"," ");
            //s=s.replaceAll(" \'"," ");
            //s=s.replaceAll("\' "," ");
            s=s.replaceAll("    "," ");
            s=s.replaceAll("   "," ");
            s=s.replaceAll("  "," ");
            //s=s.replaceAll(" "," ");
            s= s.trim();
            s = s.toLowerCase();
            for(int i = 0; i<s.length();i++)
                if(s.charAt(i)==' ')count++;
            String[] babystr = new String[count];
            babystr=s.split(" ");
            for(String bs : babystr)
                if(wordlist.containsKey(bs))
                    wordlist.put(bs,wordlist.get(bs)+1);
                else wordlist.put(bs,1);

            ArrayList<String> finalout = new ArrayList<>();
            for(int i = 0; i<3;i++){
                int maxvalue = 0;
                if(!wordlist.isEmpty()) {
                    maxvalue = Collections.max(wordlist.values());
                    for (Map.Entry<String, Integer> E : wordlist.entrySet())
                        if (E.getValue() == maxvalue) {
                            finalout.add(E.getKey().trim());
                            wordlist.remove(E.getKey());
                            break;
                        }
                } }
            if(finalout.isEmpty()){
                //finalout=new ArrayList<>(Arrays.asList());
                return new ArrayList<>();
            }
            return finalout;
        }
    //}

    /*
        maxvalue = 0;
        if(!wordlist.isEmpty()) {
            maxvalue = Collections.max(wordlist.values());
            for (Map.Entry<String, Integer> E : wordlist.entrySet())
                if (E.getValue() == maxvalue) {
                    finalout.add(E.getKey());
                    wordlist.remove(E.getKey());
                    break;
                }
        }
        maxvalue = 0;
        if(!wordlist.isEmpty()) {
            maxvalue = Collections.max(wordlist.values());
            for (Map.Entry<String, Integer> E : wordlist.entrySet())
                if (E.getValue() == maxvalue) {
                    finalout.add(E.getKey());
                    wordlist.remove(E.getKey());
                    break;
                }
        }*/
      //return finalout;
//}
    public class Browser {
        private URI currentPage;
        private ArrayList<String> history;
        private LocalDateTime visitedAt;
        private HashMap<String, Integer> visitCount;
        private boolean on;
    }

}//end file

class Product {
    Product(String name, int valueInCents) {
        this.name = name;
        this.valueInCents = valueInCents;
    }

    private String name;
    private int valueInCents;

    public String getName() {
        return name;
    }

    public int getValueInCents() {
        return valueInCents;
    }

    //declare your class here
    static class Currency{
        public Currency(int iValueInCents){
            moneys=iValueInCents;
        }
        private int moneys;
        public String getUSD(){
            int top=(moneys/100);
            int bottom=moneys%100;
            if(bottom<10)
                return "$"+top+".0"+bottom;
            else
                return "$"+top+"."+bottom;
        }
    }
    public Currency getCurrency(){
        return new Currency(valueInCents);
    }
}