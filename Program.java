import java.util.ArrayList;
import java.util.HashMap;

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

}