package generalresources;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * OutputWriter  holds a BufferedWriter and is uses to write the output.
 */
public class OutputWriter {
    private BufferedWriter bufferedWriter;

    /**
     * Constructor initialises.
     *
     * @param fileName name of File.
     * @throws IOException throw exception if fails.
     */
    public OutputWriter(String fileName) throws IOException {
        // The name of the file to open.
        // Assume default encoding.
        FileWriter fileWriter = new FileWriter(fileName);
        // Wrap FileWriter in BufferedWriter.
        bufferedWriter = new BufferedWriter(fileWriter);
    }

    /**
     * Method writes string to output.
     *
     * @param string String to be written.
     * @throws IOException Throw exception if writing fails.
     */
    public void write(String string) throws IOException {
        try {
            bufferedWriter.write(string);
        } catch (IOException e) {
            e.printStackTrace();
            bufferedWriter.close();
        }
    }

    /**
     * Close BufferedWriter.
     *
     * @throws IOException Thrpw exception if closing fails.
     */
    public void close() throws IOException {
        bufferedWriter.close();
    }

}
