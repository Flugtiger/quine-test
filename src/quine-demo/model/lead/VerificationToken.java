// MR-1: Verification token value object

package quine.demo.model.lead;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Objects;

/**
 * Value object representing a verification token for a Lead.
 * The token is randomly generated with sufficient entropy to be non-guessable.
 * Two VerificationToken instances are equal if they contain the same token value.
 */
public class VerificationToken {
    private static final int TOKEN_BYTE_LENGTH = 32; // 256 bits of entropy
    private static final SecureRandom RANDOM = new SecureRandom();

    private final String token;

    /**
     * Creates a new VerificationToken with a randomly generated value.
     * The token is generated using a cryptographically secure random number generator
     * and encoded in Base64 for safe transmission.
     */
    public VerificationToken() {
        byte[] randomBytes = new byte[TOKEN_BYTE_LENGTH];
        RANDOM.nextBytes(randomBytes);
        this.token = Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }

    /**
     * Creates a new VerificationToken with the given token value.
     * This constructor is primarily used for reconstructing tokens from persistence.
     *
     * @param token the token value
     * @throws IllegalArgumentException if token is null or empty
     */
    public VerificationToken(String token) {
        if (token == null || token.trim().isEmpty()) {
            throw new IllegalArgumentException("Verification token cannot be null or empty");
        }
        this.token = token;
    }

    /**
     * Returns the token value.
     *
     * @return the verification token
     */
    public String getValue() {
        return token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VerificationToken that = (VerificationToken) o;
        return Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }

    @Override
    public String toString() {
        return token;
    }
}
