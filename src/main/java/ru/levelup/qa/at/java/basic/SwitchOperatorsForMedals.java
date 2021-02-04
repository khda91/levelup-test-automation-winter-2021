package ru.levelup.qa.at.java.basic;

public class SwitchOperatorsForMedals {

    public static void main(String[] args) {

        String medal = "";
        int place = 1;

        switch (place) {
            case 1:
                medal = "Gold";
                break;
            case 2:
                medal = "Silver";
                break;
            case 3:
                medal = "Bronze";
                break;
            case 4:
                medal = "Lemon";
                break;
            default:
                medal = "No medal";
                break;
        }

        System.out.println(medal);

        place = 3;
        if (place == 1) {
            medal = "Gold";
        } else if (place == 2) {
            medal = "Silver";
        } else if (place == 3) {
            medal = "Bronze";
        } else {
            medal = "No medal";
        }

        System.out.println(medal);
    }

}
