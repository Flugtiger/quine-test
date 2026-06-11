// MR-2: Origin aggregate root

package quine.demo.model.origin;

import quine.demo.model.shared.AggregateRoot;
import java.util.Objects;

/**
 * Origin aggregate root representing where a Lead is coming from.
 * An Origin contains information about the source of a Lead (e.g., landing page, LinkedIn, etc.).
 * It has a name and a description.
 */
public class Origin extends AggregateRoot {
    private final OriginId originId;
    private final OriginName name;
    private final OriginDescription description;

    /**
     * Creates a new Origin with the given ID, name, and description.
     *
     * @param originId the unique identifier for the origin
     * @param name the name of the origin
     * @param description the description of the origin
     * @throws IllegalArgumentException if any parameter is null
     */
    public Origin(OriginId originId, OriginName name, OriginDescription description) {
        if (originId == null) {
            throw new IllegalArgumentException("Origin ID cannot be null");
        }
        if (name == null) {
            throw new IllegalArgumentException("Origin name cannot be null");
        }
        if (description == null) {
            throw new IllegalArgumentException("Origin description cannot be null");
        }
        this.originId = originId;
        this.name = name;
        this.description = description;
    }

    /**
     * Returns the unique identifier of this Origin.
     *
     * @return the origin ID
     */
    public OriginId getOriginId() {
        return originId;
    }

    /**
     * Returns the name of this Origin.
     *
     * @return the origin name
     */
    public OriginName getName() {
        return name;
    }

    /**
     * Returns the description of this Origin.
     *
     * @return the origin description
     */
    public OriginDescription getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Origin origin = (Origin) o;
        return Objects.equals(originId, origin.originId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originId);
    }
}
