package bevShop;

/**
 * The Alcohol class represents an alcoholic beverage.
 * It extends the Beverage class and holds additional attributes
 * specific to alcoholic beverages, such as whether it is a weekend or not.
 * 
 * @author Daniel Kim
 * @version 1.0
 */
public class Alcohol extends Beverage {
    private boolean offer;

    /**
     * Constructor for alcoholic beverages.
     *
     * @param name  The name of the alcoholic beverage.
     * @param type  The type of beverage (ALCOHOL).
     * @param size  The size of the beverage.
     * @param offer Whether the beverage has a special offer or not.
     */
    public Alcohol(String name, TYPE type, SIZE size, boolean offer) {
        super(name, type, size);
        this.offer = offer;
    }

    /**
     * Constructor for alcoholic beverages with type set to ALCOHOL.
     *
     * @param name  The name of the alcoholic beverage.
     * @param size  The size of the beverage.
     * @param offer Whether the beverage has a special offer or not.
     */
    public Alcohol(String name, SIZE size, boolean offer) {
        super(name, TYPE.ALCOHOL, size);
        this.offer = offer;
    }

    /**
     * Returns the string representation of this alcoholic beverage.
     *
     * @return A string representation of the alcoholic beverage.
     */
    @Override
    public String toString() {
        return super.toString() + " Offer: " + offer + " Price: " + calcPrice();
    }

    /**
     * Determines whether this alcoholic beverage is equal to another object.
     *
     * @param x The object to be compared.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object x) {
        if (this == x) {
            return true;
        }

        if (!(x instanceof Beverage)) {
            return false;
        }

        Alcohol a = (Alcohol) x;
        return (super.equals(x) && a.offer == offer);
    }

    /**
     * Calculates the price for the alcoholic beverage.
     *
     * @return The price for the alcoholic beverage.
     */
    @Override
    public double calcPrice() {
        double total = 0;

        if (offer) {
            total += .60;
        }

        if (getSize() == SIZE.SMALL) {
            return total + getBasePrice();
        } else if (getSize() == SIZE.MEDIUM) {
            return total + getBasePrice() + 1;
        } else if (getSize() == SIZE.LARGE) {
            return total + getBasePrice() + 2;
        }

        return 0;
    }

    /**
     * Gets the offer status of the alcoholic beverage.
     *
     * @return True if the beverage has a special offer, false otherwise.
     */
    public boolean getOffer() {
        return offer;
    }
}
