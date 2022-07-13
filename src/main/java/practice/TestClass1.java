package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestClass1 extends MyFirstClass {

    public static Integer age = 20;
    public static int d = 30;
    private int accountBalance = 20000;



    public static void main(String[] args) {
       List<String> list = new ArrayList<>();
       ArrayList<String> ar = new ArrayList<>();
       list = new LinkedList<>();




//       List<String> list2 = new List<String>();


       list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        for(String avishek : list){

            System.out.println(avishek);
        }
        for(int i=1;i<=list.size();i++){

        }

        String name = "Avishek";
        char[] n ={'w','d'};

        for(char s :n){

        }



    }

    public static MyFirstClass myFirstClass = new MyFirstClass();



     public void method1(int a){
         classM();
    }


}
