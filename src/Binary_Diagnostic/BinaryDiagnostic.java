package Binary_Diagnostic;

import AdventUtility.ToAdd;
import AdventUtility.Utility;

import java.util.ArrayList;

public class BinaryDiagnostic {
    private static String countBinary(String binaryCode){
        int zeros = 0;
        int ones = 0;

        for (int i = 0; i < binaryCode.length(); i++){
            if(String.valueOf(binaryCode.charAt(i)).equals("0")){
                zeros += 1;
            }
            else {
                ones += 1;
            }
        }

        if(zeros > ones){
            return "0";
        }

        if(ones > zeros){
            return "1";
        }

        return "equal";
    }

    private static ArrayList<String> corrPosBit(ArrayList<String> input){
        ArrayList<String> correspondingBits = new ArrayList<>();
        Utility.setInitialSize(correspondingBits, 12, ToAdd.STRING);

        for (String line:
                input) {
            for(int i = 0; i < 12; i++){
                correspondingBits.set(i, correspondingBits.get(i)+ line.charAt(i));
            }
        }

        return correspondingBits;
    }

    private static int part1(ArrayList<String> input){
        ArrayList<String> countedBinary = corrPosBit(input);

        StringBuilder gammaRate = new StringBuilder();
        StringBuilder epsilonRate = new StringBuilder();

        for (String binaryLine:
             countedBinary) {
            if(countBinary(binaryLine).equals("1")){
                gammaRate.append("1");
                epsilonRate.append("0");
            }
            else {
                gammaRate.append("0");
                epsilonRate.append("1");
            }
        }

        return Integer.parseInt(gammaRate.toString(), 2)*Integer.parseInt(epsilonRate.toString(), 2);
    }

    private static int part2(ArrayList<String> input){
        ArrayList<String> oxygenRating = new ArrayList<>(input);
        ArrayList<String> scrubberRating = new ArrayList<>(input);

        return Integer.parseInt(reduceBinary(oxygenRating, 0, "oxygen"), 2)*
                Integer.parseInt(reduceBinary(scrubberRating, 0, "scrubber"), 2);
    }

    private static String reduceBinary(ArrayList<String> input, int nextLetter, String rating){
        while(input.size() > 1){
            ArrayList<String> indBinaries = corrPosBit(input);

            int finalNextLetter = nextLetter;

            String determine = countBinary(indBinaries.get(finalNextLetter));

            if(rating.equals("oxygen")){
                switch (determine){
                    case "1", "equal" -> input.removeIf(element -> String.valueOf(element.charAt(finalNextLetter)).equals("0"));
                    case "0" -> input.removeIf(element -> String.valueOf(element.charAt(finalNextLetter)).equals("1"));
                }
            }

            if(rating.equals("scrubber")){
                switch (determine){
                    case "1", "equal" -> input.removeIf(element -> String.valueOf(element.charAt(finalNextLetter)).equals("1"));
                    case "0" -> input.removeIf(element -> String.valueOf(element.charAt(finalNextLetter)).equals("0"));
                }
            }

            nextLetter += 1;
        }

        return input.get(0);
    }

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();
        Utility.importInput("src/Binary_Diagnostic/diagnostics.txt", input, ToAdd.STRING);

        System.out.println(part1(input));
        System.out.println(part2(input));
    }
}
