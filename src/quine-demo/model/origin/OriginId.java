// MR-2: Origin ID value object

package quine.demo.model.origin;

import java.util.Objects;

/**
 * Value object representing the unique identifier of an Origin aggregate.
 * Two OriginId instances are equal if they contain the same originId value.
 */
public class OriginId {
    private final String originId;

    /**
     * Creates a new OriginId with the given identifier.
     *
     * @param originId the unique identifier for the origin
     * @throws IllegalArgumentException if originId is null or empty
     */
    public OriginId(String originId) {
        if (originId == null || originId.trim().isEmpty()) {
            throw new IllegalArgumentException("Origin ID cannot be null or empty");
        }
        this.originId = originId;
    }

    /**
     * Returns the origin identifier value.
     *
     * @return the origin ID
     */
    public String getValue() {
        return originId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OriginId originId1 = (OriginId) o;
        return Objects.equals(originId, originId1.originId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originId);
    }

    @Override
    public String toString() {
        return originId;
    }
}
