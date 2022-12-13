package Repository.Games;

import Repository.Games.Gamble;

import java.lang.Object;
import java.lang.Character;
import java.util.Random;
import java.util.Scanner;

public class Roulette extends Gamble {
    private int currentMoney;
    private int wonMoney;
    private int lostMoney;
    private int wonGames;
    private int lostGames;

    public Roulette(int currentMoney, int wonMoney, int lostMoney, int wonGames, int lostGames) {
        this.currentMoney = currentMoney;
        this.wonMoney = wonMoney;
        this.lostMoney = lostMoney;
        this.wonGames = wonGames;
        this.lostGames = lostGames;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    public int getWonMoney() {
        return wonMoney;
    }

    public void setWonMoney(int wonMoney) {
        this.wonMoney += wonMoney;
    }

    public int getLostMoney() {
        return lostMoney;
    }

    public void setLostMoney(int lostMoney) {
        this.lostMoney += lostMoney;
    }

    public int getWonGames() {
        return wonGames;
    }

    public void setWonGames(int wonGames) {
        this.wonGames += wonGames;
    }

    public int getLostGames() {
        return lostGames;
    }

    public void setLostGames(int lostGames) {
        this.lostGames += lostGames;
    }

    public void play() {
        Scanner keyboard = new Scanner(System.in);
        Random generator = new Random();
        int total = this.getCurrentMoney();
        int amount;
        int choice, win = 0, lose = 0, spin = 0;
        int number;
        int rouletteNum;
        int result;
        char response = 'y';
        int[] resultArr = new int[36];

        while (response == 'y' || response == 'Y' && total <= 0)
        {
            System.out.print("Enter your bet amount: ");
            amount = keyboard.nextInt();
            System.out.print("0 - Even\n1 - Odd\n2 - Number\n");
            choice = -1;
            while (choice < 0 || choice > 2) {
                System.out.print("Place your bet on: ");
                choice = keyboard.nextInt();
            }
            number = 0;
            if (choice == 2) {
                while (number < 1 || number > 36) {
                    System.out.print("Place your bet on number(1-36): ");
                    number = keyboard.nextInt();
                }
            }
            rouletteNum = generator.nextInt(37);
            spin++;
            System.out.println("Roulette number: " + rouletteNum);

            if (choice == 2) {
                if (rouletteNum == number)
                    result = 35;
                else
                    result = 0;
            } else {
                if (rouletteNum == 0 || rouletteNum % 2 != choice)
                    result = 0;
                else
                    result = 1;
            }

            //Print out game result, win/lose amount
            if (result > 0) {
                System.out.println("Congratulations! You win!");
                System.out.printf("You have won $%d%n \n", result * amount);
                System.out.printf("Here's your money back: $%d%n \n",
                        (result + 1) * amount);
                total = (result + 1) * amount + total;
                this.setWonMoney((result+1) * amount);
                win++;
                resultArr[rouletteNum]++;

            } else {
                System.out.println("You lose. Better luck next time!");
                System.out.printf("You have lost $%d%n \n",
                        (result + 1) * amount);
                total = total - (result + 1) * (amount);
                this.setLostMoney((result+1) * amount);
                lose++;
                resultArr[rouletteNum]++;

                if (total <= 0) {
                    break;
                }

            }

            //Ask for another game
            for (int totals = 1; totals < 36; totals++) {
                if (resultArr[totals] > 0) {
                    System.out.println("The number " + totals + " won " + resultArr[totals] + " times.");
                }
            }
            this.setCurrentMoney(total);
            System.out.println("You have $" + total + " remaining.");
            System.out.println("You have won " + win + " games.");
            System.out.println("You have lost " + lose + " games.");
            System.out.println("The wheel has been spun " + spin + " times.");
            System.out.print("\nWould you like to play another game? (y/n) ");
            response = keyboard.next().charAt(0);

        }
        this.setLostGames(lose);
        this.setWonGames(win);
    }
}
