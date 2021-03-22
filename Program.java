import java.net.URI;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
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
            if(!finalout.isEmpty()&&(finalout.get(0).isEmpty())){
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


    //codewars ----------------- nextbigger number-------------------------
    public static long nextBiggerNumber(long n)
    {
        if(n<10){
            return -1;
        }

        String orign = String.valueOf( n);
        List<Character> intarry = new ArrayList<>();
        for(char cha:orign.toCharArray())
            intarry.add(cha);

        List<String> answers = new ArrayList<>();
        rec(new ArrayList<>(), intarry, answers);

        System.out.println("--"+answers.size());//+"--"+factorial(orign.length()));
        //for(String str : answers)
        //    System.out.println(str);
        //System.out.println("--");

        List<Long> numlist = new ArrayList<>();
        for(String str : answers){
            numlist.add(Long.parseLong(str));
        }
        //this is removing duplicates
        //numlist = numlist.stream().distinct().collect(Collectors.toList());
        numlist = new ArrayList<>(new HashSet<>(numlist));
        //sort this bad boy
        Collections.sort(numlist);

        System.out.println("--"+numlist.size()+"--");
        //for(Long lnm : numlist)
        //    System.out.println(lnm);
        //System.out.println("--");
        try {
            int place = numlist.indexOf(n);
            if (numlist.get(place + 1) != n) {
                return numlist.get(place + 1);
            }
        }catch(IndexOutOfBoundsException e){
            return -1;
        }
        return -1;

        //return n;
    }
    public static void rec(List<Character> leads, List<Character> left, List<String> finals){
        if(left.size()==2){
            String tempstr = "";
            for(char cha : leads){
                tempstr= tempstr.concat(Character.toString(cha));
            }
            if(!finals.isEmpty()){
                if(!finals.contains(tempstr+left.get(0)+left.get(1)))
                    finals.add(tempstr+left.get(0)+left.get(1));
                if(!finals.contains(tempstr+left.get(1)+left.get(0)))
                    finals.add(tempstr+left.get(1)+left.get(0));}else{
                finals.add(tempstr+left.get(0)+left.get(1));
                finals.add(tempstr+left.get(1)+left.get(0));
            }
            //System.out.println((tempstr+left.get(0)+left.get(1))+" , "+(tempstr+left.get(1)+left.get(0)));
        }else{
            for(int i = 0; i < left.size();i++){
                List<Character> templeads = new ArrayList<>();
                deepCopy(leads, templeads);
                List<Character> templeft = new ArrayList<>();
                deepCopy(left, templeft);
                templeads.add(templeft.get(i));
                templeft.remove(i);
                rec(templeads,templeft ,finals);
            }
        }
    }
    public static void deepCopy(List<Character> original, List<Character> intended){
        for(char cha : original){
            intended.add(cha);
        }
    }
    public static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
    //---with arrays----------------------------------------
    public static long nextBiggerNumberArray(long n)
    {
        if(n<10){
            return -1;
        }

        String orign = String.valueOf( n);
        //char[] intarry = orign.toCharArray();

        long[] answers = new long[(int)factorial(orign.length())];
        int[] index = new int[]{0};
        //recArray(new char[0], intarry, answers,index);
        recArray(new char[0], orign.toCharArray(), answers,index,orign.toCharArray());

        System.out.println("--"+answers.length+" ,i: "+index[0]);//+"--"+factorial(orign.length()));

        Arrays.sort(answers);
        int newlength = removeDuplicateElements(answers,answers.length);
        long[] finals = new long[newlength];
        deepCopyArray(answers, finals);

        System.out.println("--"+newlength+"--"+finals.length);

        try {
            int place = Arrays.binarySearch(finals, n);

            if (finals[place + 1] != n) {
                return finals[place + 1];
            }
        }catch(IndexOutOfBoundsException e){
            return -1;
        }
        return -1;

        //return n;
    }
    public static void recArray(char[] leads, char[] left, long[] finals, int[] index, char[] original) throws NumberFormatException{
        if(left.length==2){
//            String tempstr = "";
//            for(char cha : leads){
//                tempstr= tempstr.concat(Character.toString(cha));
//            }
//            finals[index[0]] = Long.parseLong(tempstr + left[0] + left[1]);
//            index[0]++;
//            finals[index[0]] = Long.parseLong(tempstr + left[1] + left[0]);
//            index[0]++;


            int result = 0;
            for (int i = 0; i < leads.length; i++)
            {
                int digit = (int)leads[i] - (int)'0';
                if ((digit < 0) || (digit > 9)) throw new NumberFormatException();
                result *= 10;
                result += digit;
            }
            //result= (result*100)+(((int)almostlast-(int)'0')*10)+((int)last-(int)'0');
            int zero = (int)left[0]-(int)'0';
            if ((zero < 0) || (zero > 9)) throw new NumberFormatException();
            int one =  (int)left[1]-(int)'0';
            if ((one < 0) || (one > 9)) throw new NumberFormatException();
            finals[index[0]]=(result*100)+(zero*10)+one;
            index[0]++;
            finals[index[0]]=(result*100)+(one*10)+zero;
            index[0]++;


        }else{
            for(int i = 0; i < left.length;i++){
                char[] templeads = new char[leads.length + 1];
                deepCopyArray(leads, templeads);
                templeads[templeads.length - 1] = left[i];
                char[] templeft = ArrayCopyWithoutIndex(left, i);


//                System.out.println("--+");
//                System.out.println(templeads.length);
//                System.out.println(original);
//                System.out.println(String.valueOf(original));
//                System.out.println(String.valueOf(original).substring(0,templeads.length));
//                System.out.println((templeads.toString()));
//                System.out.println(String.valueOf(templeads));
//                System.out.println(Long.parseLong(String.valueOf(templeads)));
//                System.out.println((templeads[templeads.length - 1]>=original[templeads.length - 1])+""+String.valueOf(templeads)+","+String.valueOf(original));
                //System.out.println((Long.parseLong(String.valueOf(templeads))>=Long.parseLong(String.valueOf(original).substring(0,templeads.length)))+","+Long.parseLong(String.valueOf(templeads))+" : "+Long.parseLong(String.valueOf(original).substring(0,templeads.length)));
                //if(Long.parseLong(String.valueOf(templeads))>=Long.parseLong(String.valueOf(original).substring(0,templeads.length)))
                //if(templeads[templeads.length - 1]>=original[templeads.length - 1])
//                System.out.println(original);
//                System.out.println(templeads.length-1);
//                System.out.println(Arrays.copyOfRange(original,0,(templeads.length)));
//                System.out.println(String.valueOf(Arrays.copyOfRange(original,0,templeads.length)));
//                System.out.println(Long.parseLong(String.valueOf(Arrays.copyOfRange(original,0,templeads.length))));
                //if(Long.parseLong(String.valueOf(templeads))>=Long.parseLong(String.valueOf(Arrays.copyOfRange(original,0,templeads.length))))
                if(Arrays.compare(templeads, Arrays.copyOfRange(original,0,templeads.length))>=0)
                    recArray(templeads,templeft ,finals,index, original);
            }
        }
    }
//    public static boolean check(long comp, long original){
//        return original>comp;
//    }
    public static int removeDuplicateElements(long arr[], int n){
        if (n==0 || n==1){
            return n;
        }
        long[] temp = new long[n];
        int j = 0;
        for (int i=0; i<n-1; i++){
            if (arr[i] != arr[i+1]){
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[n-1];
        // Changing original array
        for (int i=0; i<j; i++){
            arr[i] = temp[i];
        }
        return j;
    }
    public static void deepCopyArray(char[] original, char[] intended){
        int smallest = 0;
        if(original.length<intended.length){
            smallest=original.length;
        }else{
            smallest=intended.length;
        }
        for(int i = 0; i< smallest;i++){
            intended[i]=original[i];
        }
    }
    public static void deepCopyArray(long[] original, long[] intended){
        int smallest = 0;
        if(original.length<intended.length){
            smallest=original.length;
        }else{
            smallest=intended.length;
        }
        for(int i = 0; i< smallest;i++){
            intended[i]=original[i];
        }
    }
    public static char[] ArrayCopyWithoutIndex(char[] original, int index){
        char[] temparr = new char[original.length-1];
        int mod = 0;
        for(int i=0; i<original.length;i++){
            if(i==index){
                mod = -1;
                continue;
            }
            temparr[i+mod] = original[i];
        }
        return temparr;
    }
    public static long charArrayTolong(char [] data,char almostlast,char last) throws NumberFormatException
    {
        int result = 0;
        for (int i = 0; i < data.length; i++)
        {
            int digit = (int)data[i] - (int)'0';
            if ((digit < 0) || (digit > 9)) throw new NumberFormatException();
            result *= 10;
            result += digit;
        }
        result= (result*100)+(((int)almostlast-(int)'0')*10)+((int)last-(int)'0');
        return result;
    }
//--------------with manipulations-----------------------------------------
    public static long nextBiggerNumberManipulation(long n)
    {
        if(n<10){
            return -1;
        }

        char[] orign = String.valueOf(n).toCharArray();
        for(int i = orign.length-1; i >=0; i--)
        {//stepping backwards through my array
            long[] answers;
            int[] index = new int[]{0};
            //calculate variations of the places i to end
            long variations = factorial(orign.length - i+1);
            if(variations>2) {
                answers = new long[(int) variations];
            }else{
                answers = new long[2];
            }
            if(i>0) {
                recManip(ArrayCopyBetweenIndex(orign, 0, i -1),
                        ArrayCopyBetweenIndex(orign, i -1, orign.length),
                        answers, index, orign);
            }else{
                recManip(new char[0],
                        orign,
                        answers, index, orign);
            }
            //recManip(char[] leads, char[] left, long[] finals, int[] index, char[] original)
            //recArray(new char[0], orign.toCharArray(), answers,index,orign.toCharArray());
            //sort variations

            //compare variations to original

            //return a winning variation

            System.out.println("--"+answers.length+" ,i: "+index[0]);//+"--"+factorial(orign.length()));

            Arrays.sort(answers);
            int newlength = removeDuplicateElements(answers,answers.length);
            long[] finals = new long[newlength];
            deepCopyArray(answers, finals);

            System.out.println("--"+newlength+"--"+finals.length);

//            try {
//                int place = Arrays.binarySearch(finals, n);
//
//                if (finals[place + 1] > n) {
//                    return finals[place + 1];
//                }
//            }catch(IndexOutOfBoundsException e){
//                return -1;
//            }
            for(long f : finals){
                if(f>n){
                    return f;
                }
            }



        }



        return -1;
    }
    public static void recManip(char[] leads, char[] left, long[] finals, int[] index, char[] original) throws NumberFormatException
        {
        if(left.length==2){
            //when number goes past maxint, this is the perfered method
//            String tempstr = "";
//            for(char cha : leads){
//                tempstr= tempstr.concat(Character.toString(cha));
//            }
//            finals[index[0]] = Long.parseLong(tempstr + left[0] + left[1]);
//            index[0]++;
//            finals[index[0]] = Long.parseLong(tempstr + left[1] + left[0]);
//            index[0]++;

            //breaks past max int
            long result = 0;
            if(leads.length>0){
            for (int i = 0; i < leads.length; i++)
            {
                int digit = (int)leads[i] - (int)'0';
                if ((digit < 0) || (digit > 9)) throw new NumberFormatException();
                result *= 10;
                result += digit;
            }}
            //result= (result*100)+(((int)almostlast-(int)'0')*10)+((int)last-(int)'0');
            int zero = (int)left[0]-(int)'0';
            if ((zero < 0) || (zero > 9)) throw new NumberFormatException();
            int one =  (int)left[1]-(int)'0';
            if ((one < 0) || (one > 9)) throw new NumberFormatException();
            finals[index[0]]=(result*100)+(zero*10)+one;
            index[0]++;
            finals[index[0]]=(result*100)+(one*10)+zero;
            index[0]++;


        }else{
            for(int i = 0; i < left.length;i++){
                char[] templeads = new char[leads.length + 1];
                deepCopyArray(leads, templeads);
                templeads[templeads.length - 1] = left[i];
                char[] templeft = ArrayCopyWithoutIndex(left, i);

                if(Arrays.compare(templeads, Arrays.copyOfRange(original,0,templeads.length))>=0)
                    recManip(templeads,templeft ,finals,index, original);
            }
        }
    }
    public static char[] ArrayCopyBetweenIndex(char[] original, int start, int stop){
        char[] temparr = new char[Math.abs(stop-start)];
        int mod = 0-start;
        for(int i=start; i<stop;i++){
            temparr[i+mod] = original[i];
        }
        return temparr;
    }


    //-----from java test----------------------------------------------------------
    // Make sure you read the instructions above carefully.
    public void printEachElement(int[] arr) {

        // Your Code Here
        // System.out.println();
        for(int i = 0; i < arr.length;i++)
            System.out.println(arr[i]);
    }
    public void printEachElement() {

        String[][] rowsOfletters = {
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"},
                {"J", "K"},
                {"L"},
        };

        // Your Code Here
        // System.out.println();
        for(int r = 0; r<rowsOfletters.length;r++)
            for(int c = 0; c<rowsOfletters[r].length;c++)
                System.out.println(rowsOfletters[r][c]);
    }

    // Make sure you read the instructions above carefully.
    public static HashMap<String, Integer> characterCount(String letters){
        HashMap<String, Integer> myhash = new HashMap<>();
        for(String l : letters.split("")){
            if(myhash.containsKey(l)){
                myhash.put(l,myhash.get(l)+1);
            }else{
                myhash.put(l,1);
            }
        }
        return myhash;
    }





}//end file

/*Create a new class called Book with default access.
 It should have 2 fields, String title and String author that are
  updated when a new instance of Book is created. Book should
  also have a class method called contents that is only accessible
   within the Book class itself - the contents method should return
    the String "Hello Reader!".

Please ignore the tests results, your answer will be manually graded

Try to answer as best as you can, the closer to the solution you can get,
the more points you will receive
 */
class Book{
    String title;
    String author;
    public Book(String newTitle, String newAuthor){
        this.title=newTitle;
        this.author=newAuthor;
    }
    private String contents(){
        return "Hello Reader!";
    }
}


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



}//end of file