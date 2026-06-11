// MR-1: Lead aggregate root

package quine.demo.model.lead;

import quine.demo.model.shared.AggregateRoot;
import java.time.Instant;
import java.util.Objects;

/**
 * Lead aggregate root representing a potential customer.
 * A Lead has an email address and a verification token.
 * The token is randomly generated when a Lead is created.
 * A Lead is initially unverified and can be verified at a later time.
 * When verified, the verification timestamp is recorded.
 */
public class Lead extends AggregateRoot {
    private final LeadId leadId;
    private final Email email;
    private final VerificationToken verificationToken;
    private boolean verified;
    private Instant verificationTime;

    /**
     * Creates a new Lead with the given ID and email address.
     * The verification token is randomly generated.
     * The Lead is initially unverified.
     *
     * @param leadId the unique identifier for the lead
     * @param email the email address of the lead
     * @throws IllegalArgumentException if leadId or email is null
     */
    public Lead(LeadId leadId, Email email) {
        if (leadId == null) {
            throw new IllegalArgumentException("Lead ID cannot be null");
        }
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }
        this.leadId = leadId;
        this.email = email;
        this.verificationToken = new VerificationToken();
        this.verified = false;
        this.verificationTime = null;
    }

    /**
     * Creates a Lead from persisted data.
     * This constructor is used when reconstructing a Lead from storage.
     *
     * @param leadId the unique identifier for the lead
     * @param email the email address of the lead
     * @param verificationToken the verification token
     * @param verified whether the lead is verified
     * @param verificationTime the time of verification (null if not verified)
     */
    public Lead(LeadId leadId, Email email, VerificationToken verificationToken,
                boolean verified, Instant verificationTime) {
        if (leadId == null) {
            throw new IllegalArgumentException("Lead ID cannot be null");
        }
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }
        if (verificationToken == null) {
            throw new IllegalArgumentException("Verification token cannot be null");
        }
        if (verified && verificationTime == null) {
            throw new IllegalArgumentException("Verification time must be set when lead is verified");
        }
        this.leadId = leadId;
        this.email = email;
        this.verificationToken = verificationToken;
        this.verified = verified;
        this.verificationTime = verificationTime;
    }

    /**
     * Returns the unique identifier of this Lead.
     *
     * @return the lead ID
     */
    public LeadId getLeadId() {
        return leadId;
    }

    /**
     * Returns the email address of this Lead.
     *
     * @return the email
     */
    public Email getEmail() {
        return email;
    }

    /**
     * Returns the verification token of this Lead.
     *
     * @return the verification token
     */
    public VerificationToken getVerificationToken() {
        return verificationToken;
    }

    /**
     * Returns whether this Lead is verified.
     *
     * @return true if verified, false otherwise
     */
    public boolean isVerified() {
        return verified;
    }

    /**
     * Returns the time when this Lead was verified.
     *
     * @return the verification time, or null if not verified
     */
    public Instant getVerificationTime() {
        return verificationTime;
    }

    /**
     * Verifies this Lead and records the verification time.
     * MR-1: When a Lead gets verified, the time of verification is also saved.
     *
     * @param verificationTime the time of verification
     * @throws IllegalArgumentException if verificationTime is null
     * @throws IllegalStateException if the lead is already verified
     */
    public void verify(Instant verificationTime) {
        if (verificationTime == null) {
            throw new IllegalArgumentException("Verification time cannot be null");
        }
        if (verified) {
            throw new IllegalStateException("Lead is already verified");
        }
        this.verified = true;
        this.verificationTime = verificationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lead lead = (Lead) o;
        return Objects.equals(leadId, lead.leadId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leadId);
    }
}
