public class TestCustomer {
    public static void main(String[] args) {
        // Create new Customer object
        Customer customer = new Customer(1, "John", 30);
        // Print the object
        System.out.println(customer);
    }
}

/**
 * The code will not compile because the Customer class is not public.
 * 
 */
