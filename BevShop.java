package bevShop;

import java.util.ArrayList;

/**
 * This class represents the software behind the store's purchases
 * and keeps track of all the order info.
 * 
 * @author Daniel Kim
 * @version 1.0
 */
public class BevShop implements BevShopInterface {
    // Number of alcoholic drinks
    public int numA;
    ArrayList<Order> orders = new ArrayList<>();
    final int AGE = 21;
    // Current order
    Order curr;

    /**
     * Returns the string representation of the BevShop.
     *
     * @return A string representation of the BevShop.
     */
    @Override
    public String toString() {
        String string = "";

        for (Order o : orders) {
            string += o.toString();
        }

        return string + " Total Monthly Sales: " + totalMonthlySale();
    }

    /**
     * Checks if the provided time is within the valid operation hours.
     *
     * @param time The time to be checked.
     * @return True if the time is within the valid operation hours, false otherwise.
     */
    public boolean validTime(int time) {
        if (time >= 8 && time <= 23) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the minimum age for purchasing alcoholic beverages.
     *
     * @return The minimum age for purchasing alcoholic beverages.
     */
    public int getMinAgeForAlcohol() {
        return AGE;
    }

    /**
     * Checks if the provided number of fruits exceeds the maximum allowed for smoothies.
     *
     * @param numOfFruits The number of fruits to be checked.
     * @return True if the number of fruits exceeds the maximum allowed, false otherwise.
     */
    public boolean isMaxFruit(int numOfFruits) {
        if (numOfFruits > 5) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the maximum number of alcoholic beverages allowed per order.
     *
     * @return The maximum number of alcoholic beverages allowed per order.
     */
    public int getMaxOrderForAlcohol() {
        return 3;
    }

    /**
     * Checks if the current order is eligible for more alcoholic beverages.
     *
     * @return True if the current order is eligible for more alcoholic beverages, false otherwise.
     */
    public boolean eligibleForMore() {
        if (numA >= 3) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Gets the number of alcoholic beverages in the current order.
     *
     * @return The number of alcoholic beverages in the current order.
     */
    public int getNumOfAlcoholDrink() {
        return numA;
    }

    /**
     * Checks if the provided age is valid for purchasing alcoholic beverages.
     *
     * @param age The age to be checked.
     * @return True if the age is valid for purchasing alcoholic beverages, false otherwise.
     */
    public boolean validAge(int age) {
        if (age >= 21) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Starts a new order with the provided details and adds it to the list of orders.
     *
     * @param time The time the order was placed.
     * @param day The day the order was placed.
     * @param customerName The name of the customer placing the order.
     * @param customerAge The age of the customer placing the order.
     */
    public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
        numA = 0;
        curr = new Order(time, day, customerName, customerAge);
        orders.add(curr);
    }

    /**
     * Processes a coffee order and adds it to the current order.
     *
     * @param bevName The name of the coffee beverage.
     * @param size The size of the coffee beverage.
     * @param extraShot Indicates if an extra shot should be added.
     * @param extraSyrup Indicates if extra syrup should be added.
     */
    public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
        curr.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    /**
     * Processes an alcohol order and adds it to the current order.
     *
     * @param bevName The name of the alcoholic beverage.
     * @param size The size of the alcoholic beverage.
     */
    public void processAlcoholOrder(String bevName, SIZE size) {
        numA++;
        curr.addNewBeverage(bevName, size);
    }

    /**
     * Processes a smoothie order and adds it to the current order.
     *
     * @param bevName The name of the smoothie.
     * @param size The size of the smoothie.
     * @param numOfFruits The number of fruits in the smoothie.
     * @param addProtien Indicates if protein should be added.
     */
    public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
        curr.addNewBeverage(bevName, size, numOfFruits, addProtien);
    }

    /**
     * Finds the index of an order in the list of orders based on the order number.
     *
     * @param orderNo The order number to search for.
     * @return The index of the order in the list, or -1 if the order is not found.
     */
    public int findOrder(int orderNo) {
        int index = -1;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                index = i;
                return index;
            }
        }
        return index;
    }

    /**
     * Calculates the total price of a specific order.
     *
     * @param orderNo The order number to calculate the total price for.
     * @return The total price of the order, or -1 if the order is not found.
     */
    public double totalOrderPrice(int orderNo) {
        double total = -1;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                total = orders.get(i).calcOrderTotal();
                return total;
            }
        }
        return total;
    }
    /**
     * Calculates the total sales of all orders placed.
     *
     * @return The total sales of all orders placed.
	 */
    public double totalMonthlySale() {
        double total = 0;
        for (Order o : orders) {
            total += o.calcOrderTotal();
        }
        return total;
    }

    /**
     * Calculates the total number of orders placed.
     *
     * @return The total number of orders placed.
     */
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    /**
     * Gets the current order being processed.
     *
     * @return The current order being processed.
     */
    public Order getCurrentOrder() {
        return curr;
    }

    /**
     * Gets the order at a specific index in the list of orders.
     *
     * @param index The index of the desired order.
     * @return The order at the specified index.
     */
    public Order getOrderAtIndex(int index) {
        return orders.get(index);
    }

    /**
     * Sorts the list of orders based on selection sort.
     */
    public void sortOrders() {
        for (int i = 0; i < orders.size() - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < orders.size(); j++) {
                if (orders.get(j).compareTo(orders.get(min_idx)) == -1)
                    min_idx = j;

                Order temp = orders.get(min_idx);
                orders.set(min_idx, orders.get(i));
                orders.set(i, temp);
            }
        }
    }
}