# MR-4: This is just a test

from pydantic import BaseModel, field_validator


class TestMarker(BaseModel):
    """
    Value Object representing a test marker.
    This is a simple test implementation for MR-4.
    """
    label: str
    is_active: bool = True

    @field_validator('label')
    @classmethod
    def validate_label(cls, v: str) -> str:
        """Validates that label is not empty."""
        if not v or not v.strip():
            raise ValueError("Test marker label cannot be empty")
        return v