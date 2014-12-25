package fizzbuzz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VIRAL
 */
public class FizzBuzz {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int[] values = new int[3];
        int counter;
        File fileRead = new File(args[0]);
        BufferedReader bufferRead = new BufferedReader(new FileReader(fileRead));

        File fileWrite = new File(args[1]);
        FileOutputStream out = new FileOutputStream(fileWrite);

        String line;
        try {
            while ((line = bufferRead.readLine()) != null) {
                counter = 0;
                line = line.trim();
                String[] lineSplit = line.split("\\s");
                for (String lineSplit1 : lineSplit) {
                    values[counter] = Integer.parseInt(lineSplit1);
                    counter++;
                }

                for (int tempCounter = 1; tempCounter <= values[2]; tempCounter++) {
                    String tempString;
                    if (tempCounter % values[0] == 0) {
                        if (tempCounter % values[1] == 0) {
                            tempString = "FB";
                        } else {
                            tempString = "F";
                        }
                    } else if (tempCounter % values[1] == 0) {
                        tempString = "B";
                    } else {
                        tempString = Integer.toString(tempCounter);
                    }
                    out.write(tempString.getBytes());
                    out.write(" ".getBytes());
                }
                out.write("\n".getBytes());
            }

        } catch (IOException ex) {
            Logger.getLogger(FizzBuzz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
