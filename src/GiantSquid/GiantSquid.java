package GiantSquid;

import java.util.ArrayList;
import java.util.Collections;

import AdventUtility.ToAdd;
import AdventUtility.Utility;

public class GiantSquid {
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();
        Utility.importInput("src/GiantSquid/boards", input, ToAdd.STRING);

        String[] bingoInputs = input.get(0).split(",");

        input.remove(0);
        input.remove(0);

        ArrayList<ArrayList<String>> bingoNumbers = new ArrayList<>();
        bingoNumbers.add(new ArrayList<String>());

        int newBoard = 0;

        for (String line:
             input) {
            if(line.isEmpty()){
                bingoNumbers.add(new ArrayList<String>());
                newBoard += 1;
                continue;
            }
            bingoNumbers.get(newBoard).add(line);
        }

        ArrayList<String[][]> temp = new ArrayList<>();
        temp.add(new String[5][5]);
        int newGameBoard = 0;
        int newGameLine = 0;
        for (S:
             ) {
            
        }
        System.out.println(bingoNumbers);
    }
}

