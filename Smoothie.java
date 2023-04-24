package bevShop;

/**
 * This class stores the info for a smoothie in the shop 
 * @author Daniel Kim
 *
 */
public class Smoothie extends Beverage {
	private boolean gains;
	private int fruits;
	/**
     * Constructs a Smoothie object with the specified name, size, number of fruits, and protein powder.
     * @param name The name of the smoothie.
     * @param size The size of the smoothie.
     * @param f The number of fruits in the smoothie.
     * @param g True if the smoothie should have added protein powder, false otherwise.
     */
	public Smoothie(String name, TYPE type, SIZE size, int f, boolean g) {
		super(name, type, size);
		fruits = f;
		gains = g;
	}
	public Smoothie(String name, SIZE size, int f, boolean g) {
		super(name, TYPE.SMOOTHIE, size);
		fruits = f;
		gains = g;
	}
	/**
     * Returns a string representation of the smoothie.
     * @return A string containing the smoothie details.
     */
	@Override
	public String toString() {
		return super.toString() + " Protein Powder: " + gains + " Nuber of Fruits: " + fruits + " Price: "
				+ calcPrice();

	}
	/**
     * Compares this smoothie to another object for equality.
     * @param x The object to compare to.
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

		Smoothie a = (Smoothie) x;
		return (super.equals(x) && a.gains == gains && a.fruits == fruits);

	}
	/**
     * Calculates the price of the smoothie.
     * @return The price of the smoothie.
     */
	@Override
	public double calcPrice() {
		double total = 0;

		if (gains) {
			total += 1.5;
		}
		if (fruits != 0) {

			total += (fruits * .50);
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
     * Gets the number of fruits in the smoothie.
     * @return The number of fruits in the smoothie.
     */
	public int getNumOfFruits() {
		return fruits;
	}
	 /**
     * Determines if the smoothie has added protein powder.
     * @return True if the smoothie has added protein powder, false otherwise.
     */
	public boolean getAddProtein() {
		return gains;
	}
}