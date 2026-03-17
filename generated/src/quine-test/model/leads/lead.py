# MR-1: Lead aggregate with email, verification token, and verification status

from datetime import datetime
from typing import Optional
import secrets
from pydantic import BaseModel, Field, field_validator
from quine-test.model.leads.lead_id import LeadId


class Lead(BaseModel):
    """
    Aggregate Root representing a Lead.
    A Lead has an email address and a verification token.
    The token is randomly generated when a Lead is created.
    A Lead is initially unverified.
    When verified, the time of verification is saved.
    """
    id: LeadId = Field(default_factory=lambda: LeadId(""))
    email: str
    verification_token: str = Field(default_factory=lambda: secrets.token_urlsafe(32))
    is_verified: bool = False
    verified_at: Optional[datetime] = None

    @field_validator('email')
    @classmethod
    def validate_email(cls, v: str) -> str:
        """Validates that email is not empty."""
        if not v or not v.strip():
            raise ValueError("Email address cannot be empty")
        if '@' not in v:
            raise ValueError("Email address must contain @")
        return v

    def verify(self) -> None:
        """
        Verifies the Lead and records the verification time.
        """
        if self.is_verified:
            raise ValueError("Lead is already verified")
        
        self.is_verified = True
        self.verified_at = datetime.utcnow()
