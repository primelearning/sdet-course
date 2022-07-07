package assignment.fitness;

import java.util.Scanner;

public class checkfitnesslevel {
    //Assignment by Shobana
    String name;
    int age;
    float weight;
    static Scanner input = new Scanner(System.in);

    public void findFitness(String yourname, int yourage, float yourwt) {
        System.out.println("Can you run 5k?: true/false");
        boolean run5k = input.nextBoolean();
        if (yourage > 15 && yourage < 40 && yourwt > 30 && yourwt < 70 && run5k) {
            System.out.println(yourage + " " + yourwt + " " + run5k);
            System.out.println("Youre perfectly fit");
        } else if (yourage > 15 && yourage < 40 && yourwt < 30 && run5k) {
            System.out.println(yourage + " " + yourwt + " " + run5k);
            System.out.println("You are Fit but you need to be healthier");
        } else if (yourage > 15 && yourage < 40 && yourwt > 80 && !run5k) {
            System.out.println(yourage + " " + yourwt + " " + run5k);
            System.out.println("You are at RISK, improve your fitness level and reduce weight");
        } else {
            System.out.println(yourage + " " + yourwt + " " + run5k);
            System.out.println("Invalid Data ");
        }

    }
    public static void main (String[] args) {
        System.out.println("Enter Your name, age, weight:");
        checkfitnesslevel cf = new checkfitnesslevel();
        cf.name = input.next();
        cf.age = input.nextInt();
        cf.weight = input.nextFloat();
        cf.findFitness(cf.name, cf.age, cf.weight);
    }
}