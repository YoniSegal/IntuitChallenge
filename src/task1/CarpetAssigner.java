package task1;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * CarpetAssigner receives a bufferedReader, carpet dimensions, number of hunters & boxes and a MagicCarpet and
 * assigns hunters & boxes to each Quadrant in the carpet.
 */
public class CarpetAssigner {
    protected int n;
    private int b;
    private int h;
    private BufferedReader bufferedReader;
    protected MagicCarpet magicCarpet;

    /**
     * Constructor initialises.
     *
     * @param bufferedReader BufferedReader to read input.
     * @param n              Length & Width of MagicCarpet.
     * @param b              Number of boxes.
     * @param h              number of hunters.
     * @param magicCarpet    MagicCarpet.
     */
    public CarpetAssigner(BufferedReader bufferedReader, int n, int b, int h, MagicCarpet magicCarpet) {
        this.bufferedReader = bufferedReader;
        this.n = n;
        this.b = b;
        this.h = h;
        this.magicCarpet = magicCarpet;
    }

    /**
     * Method calls methods to assign boxes and hunters.
     */
    public void assignBoxesAndHunters() {
        try {
            assignBoxes();
            assignHunters();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method goes assigns hunters/weight to their respective Quadrants.
     *
     * @throws IOException Throw exception if reading fails.
     */
    protected void assignHunters() throws IOException {
        String line = null;
        for (int i = 0; i < h; i++) {
            line = bufferedReader.readLine();
            String[] hunterString = line.split(" ");
            // Get rows & columns.
            int column = Integer.parseInt(hunterString[0]) - 1;
            int row = Integer.parseInt(hunterString[1]) - 1;
            // Add weight to relevant Quadrant.
            getQuadrant(row, column).addWeight();
        }
    }

    /**
     * Method goes assigns boxes to their respective Quadrants.
     *
     * @throws IOException Throw exception if reading fails.
     */
    protected void assignBoxes() throws IOException {
        String line = null;
        for (int i = 0; i < b; i++) {
            line = bufferedReader.readLine();
            String[] boxString = line.split(" ");
            // Get rows & Columns.
            int column = Integer.parseInt(boxString[0]) - 1;
            int row = Integer.parseInt(boxString[1]) - 1;
            // Add box to relevant Quadrant.
            getQuadrant(row, column).addBox();
        }
    }

    protected Quadrant getQuadrant(int row, int column) {
        if (isQ1(row, column)) {
            return magicCarpet.getQ1();
        } else if (isQ2(row, column)) {
            return magicCarpet.getQ2();
        } else if (isQ3(row, column)) {
            return magicCarpet.getQ3();
        } else {
            return magicCarpet.getQ4();
        }
    }

    /**
     * Method returns true if a position is in the first Quadrant.
     *
     * @param row    int.
     * @param column int.
     * @return boolean.
     */
    protected boolean isQ1(int row, int column) {
        return column >= n / 2 && row < n / 2;
    }

    /**
     * Method returns true if a position is in the second Quadrant.
     *
     * @param row    int.
     * @param column int.
     * @return boolean.
     */
    protected boolean isQ2(int row, int column) {
        return column < n / 2 && row < n / 2;
    }

    /**
     * Method returns true if a position is in the third Quadrant.
     *
     * @param row    int.
     * @param column int.
     * @return boolean.
     */
    protected boolean isQ3(int row, int column) {
        return column < n / 2 && row >= n / 2;
    }
}
