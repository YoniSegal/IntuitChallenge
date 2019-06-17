package task2;

import task1.CarpetAssigner;
import task1.MagicCarpet;
import task1.Quadrant;

import java.io.BufferedReader;

public class OddCarpetAssigner extends CarpetAssigner {
    /**
     * Constructor initialises.
     *
     * @param bufferedReader BufferedReader to read input.
     * @param n              Length & Width of MagicCarpet.
     * @param b              Number of boxes.
     * @param h              number of hunters.
     * @param magicCarpet    MagicCarpet.
     */
    public OddCarpetAssigner(BufferedReader bufferedReader, int n, int b, int h, MagicCarpet magicCarpet) {
        super(bufferedReader, n, b, h, magicCarpet);
    }

    @Override
    protected Quadrant getQuadrant(int row, int column) {
        if (isQ1(row, column)) {
            return magicCarpet.getQ1();
        } else if (isQ2(row, column)) {
            return magicCarpet.getQ2();
        } else if (isQ3(row, column)) {
            return magicCarpet.getQ3();
        } else if (isQ4(row, column)) {
            return magicCarpet.getQ4();
        } else if (isTopCentre(row, column)) {
            return magicCarpet.getTopCentre();
        } else if (isBottomCentre(row, column)) {
            return magicCarpet.getBottomCentre();
        } else if (isRightCentre(row, column)) {
            return magicCarpet.getRightCentre();
        } else if (isLeftCentre(row, column)) {
            return magicCarpet.getLeftCentre();
        } else {
            return magicCarpet.getOrigin();
        }
    }

    /**
     * Method returns true if a position is in the first Quadrant.
     *
     * @param row    int.
     * @param column int.
     * @return boolean.
     */
    @Override
    protected boolean isQ1(int row, int column) {
        return column > n / 2 && row < n / 2;
    }

    /**
     * Method returns true if a position is in the second Quadrant.
     *
     * @param row    int.
     * @param column int.
     * @return boolean.
     */
    @Override
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
    @Override
    protected boolean isQ3(int row, int column) {
        return column < n / 2 && row > n / 2;
    }

    /**
     * Method returns true if a position is in the fourth Quadrant.
     *
     * @param row    int.
     * @param column int.
     * @return boolean.
     */
    private boolean isQ4(int row, int column) {
        return column > n / 2 && row > n / 2;
    }

    /**
     * Method returns true if a position is in the topCentre Quadrant.
     *
     * @param row    int.
     * @param column int.
     * @return boolean.
     */
    private boolean isTopCentre(int row, int column) {
        return column == n / 2 && row < n / 2;
    }

    /**
     * Method returns true if a position is in the bottomCentre Quadrant.
     *
     * @param row    int.
     * @param column int.
     * @return boolean.
     */
    private boolean isBottomCentre(int row, int column) {
        return column == n / 2 && row > n / 2;
    }

    /**
     * Method returns true if a position is in the rightCentre Quadrant.
     *
     * @param row    int.
     * @param column int.
     * @return boolean.
     */
    private boolean isRightCentre(int row, int column) {
        return column > n / 2 && row == n / 2;
    }

    /**
     * Method returns true if a position is in the leftCentre Quadrant.
     *
     * @param row    int.
     * @param column int.
     * @return boolean.
     */
    private boolean isLeftCentre(int row, int column) {
        return column < n / 2 && row == n / 2;
    }
}
