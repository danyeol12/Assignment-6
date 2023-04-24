package bevShop;

/** 
 * This class is a class for making Coffee objects.
 * @author Daniel Kim
 */
public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;

    /**
     * Constructs a Coffee object with specified name, type, size, extra shot, and extra syrup.
     * @param name The name of the coffee.
     * @param type The type of the coffee.
     * @param size The size of the coffee.
     * @param extraShot Whether the coffee has an extra shot.
     * @param extraS Whether the coffee has extra syrup.
     */
    public Coffee(String name, TYPE type, SIZE size, boolean extraShot, boolean extraS) {
        super(name, type, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraS;
    }

    /**
     * Constructs a Coffee object with specified name, size, extra shot, and extra syrup.
     * @param name The name of the coffee.
     * @param size The size of the coffee.
     * @param extraShot Whether the coffee has an extra shot.
     * @param extraS Whether the coffee has extra syrup.
     */
    public Coffee(String name, SIZE size, boolean extraShot, boolean extraS) {
        super(name, TYPE.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraS;
    }

    /**
     * Returns a string representation of the coffee object.
     * @return A string representation of the coffee object.
     */
    @Override
    public String toString() {
        return super.toString() + " Extra Shot: " + extraShot + " Extra Syrup: " + extraSyrup + " Price: "
                + calcPrice();
    }

    /**
     * Compares if two coffee objects are equal.
     * @param x The object to compare.
     * @return True if the objects are equal, otherwise false.
     */
    @Override
    public boolean equals(Object x) {
        if (this == x) {
            return true;
        }

        if (!(x instanceof Beverage)) {
            return false;
        }

        Coffee a = (Coffee) x;
        return (super.equals(x) && a.extraSyrup == extraSyrup && a.extraShot == extraShot);
    }

    /**
     * Calculates the price of the coffee.
     * @return The price of the coffee.
     */
    @Override
    public double calcPrice() {
        double total = 0;

        if (extraShot) {
            total += 0.5;
        }
        if (extraSyrup) {
            total += 0.5;
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
     * Gets the value of the extra shot attribute.
     * @return True if the coffee has an extra shot, otherwise false.
     */
    public boolean getExtraShot() {
        return extraShot;
    }

    /**
     * Gets the value of the extra syrup attribute.
     * @return True if the coffee has extra syrup, otherwise false.
     */
    public boolean getExtraSyrup() {
        return extraSyrup;
    }
}
