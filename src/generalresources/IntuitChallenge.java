package generalresources;

import task1.CarpetAssigner;
import task1.MagicCarpet;
import task2.OddCarpetAssigner;
import task2.OddMagicCarpet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * IntuitChallenge reads from file "task-1.txt" or "task-2.txt", reads the size of a magic carpet. initial setup of
 * boxes and already seated treasure hunters and finds the maximum number of additional treasure hunters that can be
 * seated while ensuring that the magic carpet is stable.
 */
public class IntuitChallenge {
    /**
     * Main Function.
     *
     * @param args Receives no arguments.
     * @throws IOException Throws Exception if reading/writing to files fails.
     */
    public static void main(String[] args) throws IOException {
        runChallenge(1);
        runChallenge(2);
    }

    /**
     * Method runs the challenge from a given test number challenge.
     *
     * @throws IOException Throw Exception if reading/writing fails.
     */
    private static void runChallenge(int test) throws IOException {
        String filename;
        String outputName;
        if (test == 1) {
            filename = "task-1.txt";
            outputName = "output-1.txt";
        } else {
            filename = "task-2.txt";
            outputName = "output-2.txt";
        }
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        OutputWriter outputWriter = new OutputWriter(outputName);
        String line = null;
        // Get number of test cases.
        int cases = Integer.parseInt(bufferedReader.readLine());
        for (int c = 1; c <= cases; c++) {
            line = bufferedReader.readLine();
            String[] params = line.split(" ");
            // Get dimensions, number of boxes & hunters.
            int n = Integer.parseInt(params[0]);
            int b = Integer.parseInt(params[1]);
            int h = Integer.parseInt(params[2]);
            // Create new MagicCarpet.
            MagicCarpet magicCarpet;
            CarpetAssigner carpetAssigner;
            if (test == 1) {
                magicCarpet = new MagicCarpet(n);
                carpetAssigner = new CarpetAssigner(bufferedReader, n, b, h, magicCarpet);
            } else {
                magicCarpet = new OddMagicCarpet(n);
                carpetAssigner = new OddCarpetAssigner(bufferedReader, n, b, h, magicCarpet);
            }
            // Create new CarpetAssigner and assign boxes & hunters.
            carpetAssigner.assignBoxesAndHunters();
            // Add additional hunters.
            magicCarpet.addHunters();
            // Write output to file.
            outputWriter.write("Case #" + c + ": " + magicCarpet.getHuntersAdded() + "\n");
        }
        // Close FileReader & OutputWriter.
        outputWriter.close();
        fileReader.close();
    }
}
