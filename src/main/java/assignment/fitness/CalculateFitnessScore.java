package assignment.fitness;

import java.util.Scanner;

public class CalculateFitnessScore {

    public static void main(String[] ergs) {
        Scanner scanner = new Scanner(System.in);
        //TODO: Validate the data type as String only
        System.out.print("Enter the name");
        String name = scanner.next(); //Unused variable

        System.out.print("Enter Age");
        byte age = scanner.nextByte();

        System.out.print("Enter Weight");
        byte weight = scanner.nextByte();

//        System.out.print("can you run 5 km ? true/false");
        //TODO: Accept as Yes/No and convert it to true/false
        boolean canRun5Kms = scanner.nextBoolean(); //Name is not meaningful
        System.out.println("Some changes");

        if (checkAgeRange(age)) {
            if (canRun5Kms = true) {
                if (checkWeightRange(weight))
                    System.out.println("You are perfectly fit person");
                else
                    System.out.println("You are Fit but you need to be healthier");
            } else if (weight > 70)
                System.out.println("You are at RISK, improve your fitness level and reduce weight.");

        } else {
            System.out.println("Invalid input, Please start again and enter your age, between 15 -- 40");
        }

    }

    public static boolean checkAgeRange(byte userAge) {
        byte minAge = 15;
        byte maxAge = 40;
        boolean status = false;
        if (userAge > minAge && userAge < maxAge) {
            status = true;
        }
        return status;
    }

    public static boolean checkWeightRange(byte userWeight) {
        byte minWeight = 30;
        byte maxWeight = 70;
        boolean status = false;
        if (userWeight > minWeight && userWeight < maxWeight) {
            status = true;
        }
        return status;
    }


}
