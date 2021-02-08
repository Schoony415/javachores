import java.util.ArrayList;

public class Koala {
    boolean aSleep;
    int age;
    String color;
    String name;
    enum diet{};
    private ArrayList<String> records;

    //default age is 21
    public Koala(){
        this.aSleep = true;
        this.age = 21;
    }
    //in main you would say:
    //Koala myK = new Koala(18);
    //print(myK.age); // 18
    public Koala(int newAge){
        this.aSleep = true;
        this.age = newAge;
    }

    public void birthday(){this.age++;}
    public void movingToNewLocation(){this.aSleep=false;}
    public void arrivedToNewLocation(){this.aSleep=true;}

    //getter
    public ArrayList<String> getRecord(){
        return this.records;
    }

    //setter
    public void setRecords(String newRecord){
        this.records.add(newRecord);
    }
}
