package SonarSweep;

import java.util.ArrayList;

import AdventUtility.ToAdd;
import AdventUtility.Utility;

public class SonarSweep {
    private static int part1(ArrayList<Integer> input){
        int timesIncreased = 0;
        for (int i = 0; i < input.size(); i++){
            if(i != 0 && input.get(i) > input.get(i-1)){
                timesIncreased += 1;
            }
        }
        return timesIncreased;
    }

    private static int part2(ArrayList<Integer> input){
        ArrayList<Integer> depths = new ArrayList<>();
        for (int i = 0; i < input.size(); i++){
            try{
                depths.add(input.get(i));
                depths.set(i, depths.get(i)+input.get(i+1));
                depths.set(i, depths.get(i)+input.get(i+2));
            }
            catch (IndexOutOfBoundsException e){
                break;
            }
        }
        return part1(depths);
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        Utility.importInput("src/SonarSweep/depths.txt", input, ToAdd.INTEGER);

        System.out.println(part1(input)); //answer: 1226
        System.out.println(part2(input)); //answer: 1252
    }
}
