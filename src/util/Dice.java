package util;


import java.util.Random;

public class Dice {
    private String dice;
    private int rolls;
    private int nSides;
    private int rollResult = 0;

    public Dice() {
    }

    public int calculateRollVerbose(String diceRoll) {
        int result = 0;
        Random r = new Random();
        String dr = diceRoll.toLowerCase();
        String[] parts = dr.split("[d|D]");
        System.out.println(dr);
        this.rolls = Integer.parseInt(parts[0]);
        this.nSides = Integer.parseInt(parts[1]);
        System.out.println("rolling a " + this.nSides + " sided dice " + this.rolls + " times. ");

        for(int i = 0; i < this.rolls; ++i) {
            this.rollResult = r.nextInt(this.nSides) + 1;
            System.out.println("roll is: " + this.rollResult);
            result += this.rollResult;
        }

        System.out.println("Total: " + result);
        return result;
    }

    // TODO: 4/7/2020 detect and announce critical roles 
    public StringBuilder calculateRollStringBuilder(String diceRoll) {
        StringBuilder result = new StringBuilder();
        int total = 0;
        Random r = new Random();
        String[] parts = diceRoll.split("d|D");
        this.rolls = Integer.parseInt(parts[0]);
        this.nSides = Integer.parseInt(parts[1]);
        System.out.println("rolling a " + this.nSides + " sided dice " + this.rolls + " times. ");
    result.append("\n" +"Rolling a " + this.nSides + " sided dice " + this.rolls + " times. ");
        for(int i = 0; i < this.rolls; ++i) {
            this.rollResult = r.nextInt(this.nSides) + 1;
            result.append( "\n" + this.rollResult);
            System.out.println("roll is: " + this.rollResult);
            total += this.rollResult;

        }
        result.append("\n" + "Total: " + total);
        System.out.println("Total: " + total);
        return result;
    }
    public int calculateRoll(String diceRoll) {
        int result = 0;
        Random r = new Random();
        String[] parts = diceRoll.split("d");
        this.rolls = Integer.parseInt(parts[0]);
        this.nSides = Integer.parseInt(parts[1]);

        for(int i = 0; i < this.rolls; ++i) {
            this.rollResult = r.nextInt(this.nSides) + 1;
            result += this.rollResult;
        }

        return result;
    }

    public int calculateMaxRoll(String diceRoll) {
        String[] parts = diceRoll.split("d");
        this.rolls = Integer.parseInt(parts[0]);
        this.nSides = Integer.parseInt(parts[1]);
        return this.rolls * this.nSides;
    }
}