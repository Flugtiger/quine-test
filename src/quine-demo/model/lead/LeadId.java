// MR-1: Lead ID value object

package quine.demo.model.lead;

import java.util.Objects;

/**
 * Value object representing the unique identifier of a Lead aggregate.
 * Two LeadId instances are equal if they contain the same leadId value.
 */
public class LeadId {
    private final String leadId;

    /**
     * Creates a new LeadId with the given identifier.
     *
     * @param leadId the unique identifier for the lead
     * @throws IllegalArgumentException if leadId is null or empty
     */
    public LeadId(String leadId) {
        if (leadId == null || leadId.trim().isEmpty()) {
            throw new IllegalArgumentException("Lead ID cannot be null or empty");
        }
        this.leadId = leadId;
    }

    /**
     * Returns the lead identifier value.
     *
     * @return the lead ID
     */
    public String getValue() {
        return leadId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeadId leadId1 = (LeadId) o;
        return Objects.equals(leadId, leadId1.leadId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leadId);
    }

    @Override
    public String toString() {
        return leadId;
    }
}
