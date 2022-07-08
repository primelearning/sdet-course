package Assignments;

public class FitnessCheck extends FitnessUserDetails {
    public static void main(String[] args) {

        byte age;
        String name;
        byte weight;
        boolean isAbleToRun;
        FitnessCheck obj = new FitnessCheck();
        name=obj.nameCheck();
        age=obj.ageCheckIfInteger();
        weight= obj.weightCheckIfInteger();
        isAbleToRun= obj.isAbleToRun();

        validation(name, age, weight, isAbleToRun);




    }



    public static void validation(String name,byte age,byte weight,boolean canRun5km) {
        int minAge=15;
        int maxAge=40;
        if (age > minAge && age < maxAge) {
            if (weight >30 && weight< 70) {
                if ( canRun5km ) {
                    System.out.println(name + " You are perfectly Fit person");
                }
                else

                    System.out.println("Condition does not exist");
            }

            else if (weight < 30){
                if (canRun5km)
                    System.out.println(name + " You are Fit but you need to be healthier");
                else
                    System.out.println("condition does not exist");
            }
            else if (weight > 80){
                if(!canRun5km)
                    System.out.println(name + " You are at RISK, improve your fitness level and reduce weight.");
                else
                    System.out.println("condition does not exist ");
            }

        }
        else {
            System.out.println("Condition does not exists for age group");
        }
    }
}




