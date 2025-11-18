# MR-1: Verification token with sufficient entropy

from pydantic import BaseModel, field_validator
import secrets


class VerificationToken(BaseModel):
    """Value Object representing a verification token with sufficient bits to not be guessable."""
    value: str

    @field_validator('value')
    @classmethod
    def validate_token(cls, v: str) -> str:
        """Validates that the token is not empty."""
        if not v or not isinstance(v, str):
            raise ValueError("Verification token cannot be empty")
        return v

    @staticmethod
    def generate() -> 'VerificationToken':
        """Generates a new verification token with 256 bits of entropy (32 bytes = 64 hex characters)."""
        token_value = secrets.token_hex(32)
        return VerificationToken(value=token_value)
