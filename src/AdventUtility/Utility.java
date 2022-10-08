package AdventUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Scanner;

public class Utility {
    public static void importInput(String filepath, Collection entries, ToAdd type){
        try {
            File file = new File(filepath);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();

                if(type.equals(ToAdd.INTEGER)){
                    entries.add(Integer.parseInt(data));
                }

                if(type.equals(ToAdd.STRING)){
                    entries.add(data);
                }
            }
            reader.close();
        } catch (ClassCastException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setInitialSize(Collection receivedCollection, int length, ToAdd type){
        if(type.equals(ToAdd.INTEGER)){
            while (receivedCollection.size() < length) {receivedCollection.add(0);}
        }

        if(type.equals(ToAdd.STRING)){
            while (receivedCollection.size() < length) {receivedCollection.add("");}
        }
    }
}
