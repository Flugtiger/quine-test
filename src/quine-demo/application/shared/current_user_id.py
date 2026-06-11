# Shared DTO for current user identity
class CurrentUserId:
    """Wraps the identifier of the currently authenticated caller."""

    def __init__(self, value: str):
        """
        Initialize CurrentUserId with a user identifier.

        Args:
            value: The identifier of the currently authenticated caller.
        """
        if not value:
            raise ValueError("User ID value cannot be empty")
        self.value = value
