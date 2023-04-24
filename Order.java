package bevShop;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class stores a customer's order.
 * @author Daniel Kim
 */
public class Order implements OrderInterface, Comparable<Object> {
    private int orderNumber;
    private int orderTime;
    private DAY day;
    private Customer customer;
    ArrayList<Beverage> bev;

    /**
     * Generates a random order number.
     * @return A random integer representing the order number.
     */
    public int randomOrder() {
        Random r = new Random();
        int randomInt = r.nextInt(90000) + 10000;
        return randomInt;
    }

    /**
     * Constructs an Order object with the specified order time, day, customer name, and customer age.
     * @param orderTime The time the order was placed.
     * @param d The day the order was placed.
     * @param customerName The name of the customer who placed the order.
     * @param customerAge The age of the customer who placed the order.
     */
    public Order(int orderTime, DAY d, String customerName, int customerAge) {
        this.orderTime = orderTime;
        day = d;
        customer = new Customer(customerName, customerAge);
        orderNumber = randomOrder();
        bev = new ArrayList<>();
    }

    /**
     * Constructs an Order object with the specified order time, day, and Customer object.
     * @param orderTime The time the order was placed.
     * @param d The day the order was placed.
     * @param c The Customer object representing the customer who placed the order.
     */
    public Order(int orderTime, DAY d, Customer c) {
        this.orderTime = orderTime;
        day = d;
        customer = c;
        orderNumber = randomOrder();
        bev = new ArrayList<>();
    }

    /**
     * Compares this Order object to another object based on the order number.
     * @param o The object to compare this Order object to.
     * @return 0 if order numbers are equal, 1 if this order number is greater, -1 if this order number is smaller.
     */
    @Override
    public int compareTo(Object o) {
        Order order = (Order) o;

        if (order.orderNumber == orderNumber) {
            return 0;
        } else if (orderNumber > order.orderNumber) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Checks if the order was placed on a weekend.
     * @return True if the order was placed on a weekend, false otherwise.
     */
    public boolean isWeekend() {
        if (day == DAY.SATURDAY || day == DAY.SUNDAY) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the Beverage object at the specified index in the ArrayList.
     * @param itemNo The index of the Beverage object in the ArrayList.
     * @return The Beverage object at the specified index, or null if the ArrayList is empty.
     */
    public Beverage getBeverage(int itemNo) {
        if (bev.size() == 0) {
            return null;
        }
        return bev.get(itemNo);
    }

   


    /**
     * Adds a new Coffee beverage to the order.
     * @param bevName The name of the beverage.
     * @param size The size of the beverage.
     * @param extraShot True if the beverage should have an extra shot, false otherwise.
     * @param extraSyrup True if the beverage should have extra syrup, false otherwise.
     */
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		Coffee x = new Coffee(bevName, TYPE.COFFEE, size, extraShot, extraSyrup);
		bev.add(x);
	}

	/**
     * Adds a new Alcohol beverage to the order.
     * @param bevName The name of the beverage.
     * @param size The size of the beverage.
     */
	public void addNewBeverage(String bevName, SIZE size) {
		Alcohol x = new Alcohol(bevName, TYPE.ALCOHOL, size, isWeekend());
		bev.add(x);

	}

	/**
     * Adds a new Smoothie beverage to the order.
     * @param bevName The name of the beverage.
     * @param size The size of the beverage.
     * @param numOfFruits The number of fruits in the smoothie.
     * @param addPRotien True if the smoothie should have added protein, false otherwise.
     */
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotien) {
		Smoothie x = new Smoothie(bevName, TYPE.SMOOTHIE, size, numOfFruits, addPRotien);
		bev.add(x);

	}

	/**
     * Calculates the total price of the order.
     * @return The total price of all beverages in the order.
     */
	public double calcOrderTotal() {
		double total = 0;

		for (Beverage x : bev) {
			if (x.getType() == TYPE.ALCOHOL) {
				Alcohol a = (Alcohol) x;
				total += a.calcPrice();
			} else if (x.getType() == TYPE.COFFEE) {
				Coffee a = (Coffee) x;
				total += a.calcPrice();
			} else {
				Smoothie a = (Smoothie) x;
				total += a.calcPrice();
			}
		}

		return total;
	}

	/**
     * Finds the number of beverages of a certain type in the order.
     * @param type The type of beverage to count.
     * @return The number of beverages of the specified type in the order.
     */
	public int findNumOfBeveType(TYPE type) {

		int count = 0;

		for (Beverage x : bev) {
			if (x.getType() == type) {
				count++;
			}
		}

		return count;
	}
	/**
     * Returns a string representation of the order.
     * @return A string containing the order details.
     */
	public String toString() {
		String beverage = "";

		for (Beverage x : bev) {
			beverage += x.toString();
			beverage += "\n";

		}
		return "Order Number: " + orderNumber + " Time: " + orderTime + " Day: " + day + " " + customer.toString()
				+ " Total: "+calcOrderTotal()+"Beverages: " + beverage;
	}
	/**
     * Gets the Customer object associated with the order.
     * @return A copy of the Customer object associated with the order.
     */
	public Customer getCustomer() {
		Customer a = new Customer(customer);
		return a;
	}
	/**
     * Gets the time the order was placed.
     * @return The time the order was placed.
     */
	public int getOrderTime() {
		return orderTime;
	}
	/**
     * Gets the order number.
     * @return The order number.
     */
	public int getOrderNo() {
		return orderNumber;
	}
	/**
     * Gets the day the order was placed.
     * @return The day the order was placed.
     */
	public DAY getOrderDay() {
		return day;
	}
	/**
     * Gets the total number of items in the order.
     * @return The total number of items in the order.
    */
	public int getTotalItems() {
		return findNumOfBeveType(TYPE.ALCOHOL) + findNumOfBeveType(TYPE.COFFEE) + findNumOfBeveType(TYPE.SMOOTHIE);
	}
	
	

}