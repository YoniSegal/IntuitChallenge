package task1;

/**
 * Quadrant holds it's weight (no pun intended), it's amount of free space and number of hunters added after
 * initialisation.
 */
public class Quadrant {
    private long weight;
    protected long freeSpaces;
    private long extraHuntersAdded;

    /**
     * Constructor initialises.
     *
     * @param n Length/Width of MagicCarpet.
     */
    public Quadrant(int n) {
        this.weight = 0;
        this.extraHuntersAdded = 0;
        this.freeSpaces = Long.valueOf(n) * Long.valueOf(n);
    }

    /**
     * Method adds weight and subtracts free space in Quadrant.
     */
    public void addWeight() {
        this.weight++;
        freeSpaces--;
    }

    /**
     * Method subtracts free space in Quadrant.
     */
    public void addBox() {
        freeSpaces--;
    }

    /**
     * Method adds another hunter (only called after initialisation).
     */
    public void addExtraHunter() {
        addWeight();
        extraHuntersAdded++;
    }

    /**
     * Method sets the amount of free space.
     *
     * @param freeSpaces long.
     */
    public void setFreeSpaces(long freeSpaces) {
        this.freeSpaces = freeSpaces;
    }

    /**
     * Method sets the number of hunters needed.
     *
     * @param huntersAdded long - number of hunters needed.
     */
    public void setExtraHuntersAdded(long huntersAdded) {
        this.extraHuntersAdded = huntersAdded;
    }

    /**
     * @return long - number of hunters added after initialisation..
     */
    public long getExtraHuntersAdded() {
        return extraHuntersAdded;
    }

    /**
     * @return Weight of Quadrant.
     */
    public long getWeight() {
        return weight;
    }

    /**
     * @return amount of free space in Quadrant.
     */
    public long getFreeSpaces() {
        return freeSpaces;
    }
}
