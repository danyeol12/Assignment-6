package bevShop;

/**
 * This class makes a customer and stores their name and age.
 * @author Daniel Kim
 */
public class Customer {
    private String name;
    private int age;

    /**
     * Constructs a Customer object with the specified name and age.
     * @param name The name of the customer.
     * @param age The age of the customer.
     */
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Constructs a Customer object by copying the attributes of another Customer object.
     * @param x The Customer object to copy.
     */
    public Customer(Customer x) {
        this.name = x.name;
        this.age = x.age;
    }

    /**
     * Returns a string representation of the Customer object.
     * @return A string representation of the Customer object.
     */
    @Override
    public String toString() {
        return "Age: " + age + " Name: " + name;
    }

    /**
     * Gets the name of the customer.
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     * @param n The new name for the customer.
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * Gets the age of the customer.
     * @return The age of the customer.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the customer.
     * @param a The new age for the customer.
     */
    public void setAge(int a) {
        age = a;
    }
}
