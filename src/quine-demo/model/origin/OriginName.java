// MR-2: Origin name value object

package quine.demo.model.origin;

import java.util.Objects;

/**
 * Value object representing the name of an Origin.
 * Two OriginName instances are equal if they contain the same name value.
 */
public class OriginName {
    private final String name;

    /**
     * Creates a new OriginName with the given name.
     *
     * @param name the name of the origin
     * @throws IllegalArgumentException if name is null or empty
     */
    public OriginName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Origin name cannot be null or empty");
        }
        this.name = name.trim();
    }

    /**
     * Returns the origin name value.
     *
     * @return the origin name
     */
    public String getValue() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OriginName that = (OriginName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
