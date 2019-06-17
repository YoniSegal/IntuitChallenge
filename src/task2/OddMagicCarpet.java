package task2;

import task1.MagicCarpet;
import task1.Quadrant;

/**
 * OddMagicCarpet is a MagicCarpet with additional Quadrants and slight variation in method implementations.
 */
public class OddMagicCarpet extends MagicCarpet {
    private Quadrant topCentre;
    private Quadrant bottomCentre;
    private Quadrant leftCentre;
    private Quadrant rightCentre;
    private Quadrant origin;

    /**
     * Constructor initialises Quadrants.
     *
     * @param n Length/Width of MagicCarpet.
     */
    public OddMagicCarpet(int n) {
        super(n);
        this.origin = new Quadrant(1);
        this.topCentre = new Quadrant(0);
        this.bottomCentre = new Quadrant(0);
        this.leftCentre = new Quadrant(0);
        this.rightCentre = new Quadrant(0);
        setCentreStripsFreeSpace(n);
    }

    /**
     * Set all free spaces in centre strips.
     *
     * @param n dimensions.
     */
    private void setCentreStripsFreeSpace(int n) {
        this.topCentre.setFreeSpaces(n / 2);
        this.bottomCentre.setFreeSpaces(n / 2);
        this.leftCentre.setFreeSpaces(n / 2);
        this.rightCentre.setFreeSpaces(n / 2);
    }

    /**
     * Method calls method to balance out weight along diagonals.
     */
    @Override
    public void addHunters() {
        super.balanceDiagonals(q1, q3);
        super.balanceDiagonals(q2, q4);
        super.balanceDiagonals(topCentre, bottomCentre);
        super.balanceDiagonals(rightCentre, leftCentre);
        super.balanceDiagonals(origin, origin);
    }

    /**
     * Method calculates the number of additional hunters that have been added.
     *
     * @return long - Number of additional hunters added.
     */
    @Override
    public long getHuntersAdded() {
        // If diagonal Quadrants aren't balanced, return -1;
        if (rightCentre.getWeight() != leftCentre.getWeight() || topCentre.getWeight() != bottomCentre.getWeight()) {
            return -1;
        }
        // Calculate total hunters added.
        long huntersAdded = 0;
        huntersAdded += super.getHuntersAdded();
        if (huntersAdded == -1) {
            return -1;
        }
        huntersAdded += rightCentre.getExtraHuntersAdded();
        huntersAdded += leftCentre.getExtraHuntersAdded();
        huntersAdded += topCentre.getExtraHuntersAdded();
        huntersAdded += bottomCentre.getExtraHuntersAdded();
        huntersAdded += origin.getExtraHuntersAdded();
        return huntersAdded;
    }

    /**
     * Method returns null in abstract class and is overridden in inherited classes.
     *
     * @return TopCentreQuadrant.
     */
    @Override
    public Quadrant getTopCentre() {
        return topCentre;
    }

    /**
     * Method returns null in abstract class and is overridden in inherited classes.
     *
     * @return BottomCentreQuadrant.
     */
    @Override
    public Quadrant getBottomCentre() {
        return bottomCentre;
    }

    /**
     * Method returns null in abstract class and is overridden in inherited classes.
     *
     * @return LeftCentreQuadrant.
     */
    @Override
    public Quadrant getLeftCentre() {
        return leftCentre;
    }

    /**
     * Method returns null in abstract class and is overridden in inherited classes.
     *
     * @return RightCentreQuadrant.
     */
    @Override
    public Quadrant getRightCentre() {
        return rightCentre;
    }

    /**
     * Method returns null in abstract class and is overridden in inherited classes.
     *
     * @return OriginQuadrant.
     */
    @Override
    public Quadrant getOrigin() {
        return origin;
    }
}
