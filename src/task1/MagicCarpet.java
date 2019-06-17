package task1;

import generalresources.WeightComparator;

import java.util.Arrays;


/**
 * MagicCarpet holds 4 Quadrants. Can balance it's diagonal Quadrants and calculate the number of hunters added.
 */
public class MagicCarpet {
    protected Quadrant q1;
    protected Quadrant q2;
    protected Quadrant q3;
    protected Quadrant q4;

    /**
     * Constructor initialises Quadrants.
     *
     * @param n Length/Width of MagicCarpet.
     */
    public MagicCarpet(int n) {
        this.q1 = new Quadrant(n / 2);
        this.q2 = new Quadrant(n / 2);
        this.q3 = new Quadrant(n / 2);
        this.q4 = new Quadrant(n / 2);
    }

    /**
     * Method calls method to balance out weight along diagonals.
     */
    public void addHunters() {
        balanceDiagonals(q1, q3);
        balanceDiagonals(q2, q4);
    }

    /**
     * Method received 2 Quadrants, adds hunters to the lighter one until balanced.
     *
     * @param quadrantA Some Quadrant.
     * @param quadrantB Another Quadrant.
     */
    protected void balanceDiagonals(Quadrant quadrantA, Quadrant quadrantB) {
        // If all spaces are available, then fill them all up.
        if (quadrantA.getWeight() == quadrantB.getWeight() && (quadrantA.getFreeSpaces() == quadrantB.getFreeSpaces() && quadrantA.getFreeSpaces() != 0)) {
            quadrantA.setExtraHuntersAdded(quadrantA.getFreeSpaces());
            quadrantB.setExtraHuntersAdded(quadrantB.getFreeSpaces());
            return;
        }
        Quadrant[] quadrants = new Quadrant[2];
        quadrants[0] = quadrantA;
        quadrants[1] = quadrantB;
        // Sort Quadrants by weight and extract the lighter & heavier ones.
        Arrays.sort(quadrants, new WeightComparator());
        Quadrant lighter = quadrants[0];
        Quadrant heavier = quadrants[1];
        // Add hunters to the lighter Quadrant until balanced with heavier Quadrant or until full.
        while (lighter.getFreeSpaces() != 0 && lighter.getWeight() != heavier.getWeight()) {
            lighter.addExtraHunter();
        }
        // Once balanced, add additional hunters.
        addAdditionalHunters(lighter, heavier);
    }

    /**
     * Method is called once diagonal Quadrants are balanced and continues to add hunters until full.
     *
     * @param lighter Lighter Quadrant.
     * @param heavier Heavier Quadrant.
     */
    private void addAdditionalHunters(Quadrant lighter, Quadrant heavier) {
        // If one of the Quadrants is full, return.
        if (lighter.getFreeSpaces() == 0 || heavier.getFreeSpaces() == 0) {
            return;
        }
        // Continue to add hunters to both Quadrants until one of them is full.
        while (lighter.getFreeSpaces() != 0 && heavier.getFreeSpaces() != 0) {
            lighter.addExtraHunter();
            heavier.addExtraHunter();
        }
    }

    /**
     * Method calculates the number of additional hunters that have been added.
     *
     * @return long - Number of additional hunters added.
     */
    public long getHuntersAdded() {
        // If diagonal Quadrants aren't balanced, return -1;
        if (q1.getWeight() != q3.getWeight() || q2.getWeight() != q4.getWeight()) {
            return -1;
        }
        // Calculate total hunters added.
        long huntersAdded = 0;
        huntersAdded += q1.getExtraHuntersAdded();
        huntersAdded += q2.getExtraHuntersAdded();
        huntersAdded += q3.getExtraHuntersAdded();
        huntersAdded += q4.getExtraHuntersAdded();
        return huntersAdded;
    }

    /**
     * @return Quadrant -> First.
     */
    public Quadrant getQ1() {
        return q1;
    }

    /**
     * @return Quadrant -> Second.
     */
    public Quadrant getQ2() {
        return q2;
    }

    /**
     * @return Quadrant -> Third.
     */
    public Quadrant getQ3() {
        return q3;
    }

    /**
     * @return Quadrant -> Fourth.
     */
    public Quadrant getQ4() {
        return q4;
    }

    /**
     * Method returns null in abstract class and is overridden in inherited classes.
     *
     * @return TopCentreQuadrant.
     */
    public Quadrant getTopCentre() {
        return null;
    }

    /**
     * Method returns null in abstract class and is overridden in inherited classes.
     *
     * @return BottomCentreQuadrant.
     */
    public Quadrant getBottomCentre() {
        return null;
    }

    /**
     * Method returns null in abstract class and is overridden in inherited classes.
     *
     * @return LeftCentreQuadrant.
     */
    public Quadrant getLeftCentre() {
        return null;
    }

    /**
     * Method returns null in abstract class and is overridden in inherited classes.
     *
     * @return RightCentreQuadrant.
     */
    public Quadrant getRightCentre() {
        return null;
    }

    /**
     * Method returns null in abstract class and is overridden in inherited classes.
     *
     * @return OriginQuadrant.
     */
    public Quadrant getOrigin() {
        return null;
    }
}
