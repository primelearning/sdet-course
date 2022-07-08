package Assignments;
import java.util.Scanner;

public class FitnessUserDetails {
   static Scanner scanner = new Scanner(System.in);

 /*  while(!scanner.hasNext("[A-Za-z]*"))
        {
            System.out.println(" enter valid name");
            scanner.nextLine();
        }
        name= scanner.nextLine();*/
    //  System.out.println(name);
    //  FitnessUserDetails obj =new FitnessUserDetails();

    // personAge = obj.ageCheckIfInteger();

     public String nameCheck(){
        String name;
         System.out.println("Enter the name :");

         while(!scanner.hasNext("[A-Za-z]*"))
         {
             System.out.println(" enter valid name");
             scanner.nextLine();
         }
         name= scanner.nextLine();
         return name;
     }
    public byte ageCheckIfInteger() {
        byte age;
        boolean temp=true;
        System.out.println("Enter age :");
        while ((!scanner.hasNextByte())) {
            System.out.println("Please enter valid age");
            scanner.next();
        }
         age = scanner.nextByte();
        while(temp){
            if (age>0) {
                temp = false;
            }
            else {
                System.out.println("please enter positive age");
               // scanner.next();
                age = ageCheckIfInteger();

            }
        }
        //System.out.println(age);
        return age;
    }

    public byte weightCheckIfInteger() {
        byte weight;
        boolean temp=true;
        System.out.println("Enter Weight :");
        while ((!scanner.hasNextByte())) {
            System.out.println("Please enter valid Weight");
            scanner.next();
        }
        weight = scanner.nextByte();
        while(temp){
            if (weight>0) {
                temp = false;
            }
            else {
                System.out.println("please enter positive Weight");
                // scanner.next();
                weight = weightCheckIfInteger();
            }
        }
        return weight;
    }

    public boolean isAbleToRun(){
        boolean tempVariable = false;
        String userInput=null;
        System.out.println("can the person run 5km ?");

        while(!scanner.hasNext("[A-Za-z]*"))
        {
            System.out.println("Please enter Yes or No");
            userInput= scanner.nextLine();

        }
        userInput= scanner.nextLine();

        if (userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("y")){
            tempVariable=true;
        }else if (userInput.equalsIgnoreCase("no") || userInput.equalsIgnoreCase("n")){
            //tempVariable=false;
        }else {
            //System.out.println("please enter Yes or No");
            tempVariable = isAbleToRun();
        }
        return tempVariable;
    }
}

