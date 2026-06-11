// MR-2: Origin description value object

package quine.demo.model.origin;

import java.util.Objects;

/**
 * Value object representing the description of an Origin.
 * Two OriginDescription instances are equal if they contain the same description value.
 */
public class OriginDescription {
    private final String description;

    /**
     * Creates a new OriginDescription with the given description.
     *
     * @param description the description of the origin
     * @throws IllegalArgumentException if description is null or empty
     */
    public OriginDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Origin description cannot be null or empty");
        }
        this.description = description.trim();
    }

    /**
     * Returns the origin description value.
     *
     * @return the origin description
     */
    public String getValue() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OriginDescription that = (OriginDescription) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return description;
    }
}
