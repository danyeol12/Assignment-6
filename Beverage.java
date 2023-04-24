package bevShop;


/**
 * This abstract class represents a general beverage.
 * It serves as a base for all specific types of beverages.
 *
 * @author Daniel Kim
 * @version 1.0
 */
public abstract class Beverage {
    private String bevName;
    private TYPE type;
    private SIZE size;
    private final double BASE = 2.0;
    private final double PRICE_SIZE = 1.0;

    /**
     * Constructor for a general beverage.
     *
     * @param name The name of the beverage.
     * @param type The type of the beverage.
     * @param size The size of the beverage.
     */
    public Beverage(String name, TYPE type, SIZE size) {
        bevName = name;
        this.type = type;
        this.size = size;
    }

    /**
     * Calculates the price for the specific type of beverage.
     *
     * @return The price for the specific type of beverage.
     */
    public abstract double calcPrice();

    /**
     * Returns the string representation of this beverage.
     *
     * @return A string representation of the beverage.
     */
    @Override
    public String toString() {
        return "Name: " + bevName + " Size: " + size;
    }

    /**
     * Determines whether this beverage is equal to another object.
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

        Beverage a = (Beverage) x;
        return (a.bevName.equals(bevName) && type == a.type && a.size == size);
    }

    /**
     * Gets the name of the beverage.
     *
     * @return The name of the beverage.
     */
    public String getBevName() {
        return bevName;
    }

    /**
     * Gets the type of the beverage.
     *
     * @return The type of the beverage.
     */
    public TYPE getType() {
        return type;
    }

    /**
     * Gets the size of the beverage.
     *
     * @return The size of the beverage.
     */
    public SIZE getSize() {
        return size;
    }

    /**
     * Gets the base price of the beverage.
     *
     * @return The base price of the beverage.
     */
    public double getBasePrice() {
        return BASE;
    }

    /**
     * Gets the price for the size of the beverage.
     *
     * @return The price for the size of the beverage.
     */
    public double getSizePrice() {
        return PRICE_SIZE;
    }
}
