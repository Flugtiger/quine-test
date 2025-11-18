# MR-1: Email address for Lead

from pydantic import BaseModel, field_validator
import re


class EmailAddress(BaseModel):
    """Value Object representing an email address."""
    value: str

    @field_validator('value')
    @classmethod
    def validate_email(cls, v: str) -> str:
        """Validates that the email address has a valid format."""
        if not v or not isinstance(v, str):
            raise ValueError("Email address cannot be empty")
        
        # Basic email validation pattern
        email_pattern = r'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$'
        if not re.match(email_pattern, v):
            raise ValueError(f"Invalid email address format: {v}")
        
        return v
