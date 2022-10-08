package Dive;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import AdventUtility.ToAdd;
import AdventUtility.Utility;

public class Dive {
    private static int part1(List<String> input){
        int horPos = 0;
        int verPos = 0;

        for (String line:
             input) {
            String[] divInput = line.split(" ");
            int units = Integer.parseInt(divInput[1]);
            switch (divInput[0]) {
                case "forward" -> horPos += units;
                case "down" -> verPos += units;
                case "up" -> verPos -= units;
            }
        }

        return verPos*horPos;
    }

    private static int part2(List<String> input){
        int horPos = 0;
        int verPos = 0;
        int aim = 0;

        for (String line:
                input) {
            String[] divInput = line.split(" ");
            int units = Integer.parseInt(divInput[1]);
            switch (divInput[0]) {
                case "forward" -> {
                    horPos += units;
                    verPos += aim * units;
                }
                case "down" -> aim += units;
                case "up" -> aim -= units;
            }
        }

        return verPos*horPos;
    }

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();
        Utility.importInput("src/Dive/directions.txt", input, ToAdd.STRING);


        System.out.println(part1(input)); //answer: 1499229
        System.out.println(part2(input)); //answer: 1340836560
    }
}
