# eddbf72e-8ac8-43ce-b246-d79f1a3c7f36: Customer ID value object for the Customer aggregate
from dataclasses import dataclass


@dataclass(frozen=True)
class CustomerId:
    """Value object representing a Customer's unique identifier."""
    
    value: str = ""
    
    def __post_init__(self):
        """Validate the customer ID value."""
        if self.value is None:
            raise ValueError("Customer ID value cannot be None")
        if not isinstance(self.value, str):
            raise ValueError("Customer ID value must be a string")
    
    def is_empty(self) -> bool:
        """Check if this is an empty ID (for new aggregates not yet saved)."""
        return self.value == ""