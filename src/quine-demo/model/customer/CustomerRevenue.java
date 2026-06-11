// MR-3: Customer revenue value object

package quine.demo.model.customer;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Value object representing the revenue of a Customer.
 * Two CustomerRevenue instances are equal if they contain the same revenue value.
 */
public class CustomerRevenue {
    private final BigDecimal revenue;

    /**
     * Creates a new CustomerRevenue with the given revenue amount.
     *
     * @param revenue the revenue of the customer
     * @throws IllegalArgumentException if revenue is null or negative
     */
    public CustomerRevenue(BigDecimal revenue) {
        if (revenue == null) {
            throw new IllegalArgumentException("Customer revenue cannot be null");
        }
        if (revenue.signum() < 0) {
            throw new IllegalArgumentException("Customer revenue cannot be negative");
        }
        this.revenue = revenue;
    }

    /**
     * Returns the customer revenue value.
     *
     * @return the customer revenue
     */
    public BigDecimal getValue() {
        return revenue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerRevenue that = (CustomerRevenue) o;
        return Objects.equals(revenue, that.revenue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(revenue);
    }

    @Override
    public String toString() {
        return revenue.toString();
    }
}
