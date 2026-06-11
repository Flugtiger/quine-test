// MR-3: Customer address value object

package quine.demo.model.customer;

import java.util.Objects;

/**
 * Value object representing the address of a Customer.
 * Two CustomerAddress instances are equal if they contain the same address value.
 */
public class CustomerAddress {
    private final String address;

    /**
     * Creates a new CustomerAddress with the given address.
     *
     * @param address the address of the customer
     * @throws IllegalArgumentException if address is null or empty
     */
    public CustomerAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer address cannot be null or empty");
        }
        this.address = address.trim();
    }

    /**
     * Returns the customer address value.
     *
     * @return the customer address
     */
    public String getValue() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerAddress that = (CustomerAddress) o;
        return Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    @Override
    public String toString() {
        return address;
    }
}
