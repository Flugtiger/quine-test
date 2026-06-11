// MR-1: Email value object

package quine.demo.model.lead;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Value object representing an email address.
 * Two Email instances are equal if they contain the same email value.
 */
public class Email {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );

    private final String email;

    /**
     * Creates a new Email with the given address.
     *
     * @param email the email address
     * @throws IllegalArgumentException if email is null, empty, or invalid format
     */
    public Email(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        String trimmedEmail = email.trim();
        if (!EMAIL_PATTERN.matcher(trimmedEmail).matches()) {
            throw new IllegalArgumentException("Email format is invalid: " + trimmedEmail);
        }
        this.email = trimmedEmail;
    }

    /**
     * Returns the email address value.
     *
     * @return the email address
     */
    public String getValue() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return email;
    }
}
