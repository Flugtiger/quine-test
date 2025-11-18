# MR-1: Lead aggregate with email, verification token, and verification status

from pydantic import BaseModel, Field
from datetime import datetime
from typing import Optional
from quine_test.model.leads.lead_id import LeadId
from quine_test.model.leads.email_address import EmailAddress
from quine_test.model.leads.verification_token import VerificationToken


class Lead(BaseModel):
    """Aggregate Root representing a Lead with email address and verification capabilities."""
    id: LeadId = Field(default_factory=lambda: LeadId(""))
    email_address: EmailAddress
    verification_token: VerificationToken
    verified_at: Optional[datetime] = None

    @staticmethod
    def create(email_address: EmailAddress) -> 'Lead':
        """Creates a new Lead with the given email address and a randomly generated verification token."""
        return Lead(
            email_address=email_address,
            verification_token=VerificationToken.generate()
        )

    def is_verified(self) -> bool:
        """Returns whether this Lead has been verified."""
        return self.verified_at is not None

    def verify(self) -> None:
        """Verifies this Lead and records the verification time."""
        if self.is_verified():
            raise ValueError("Lead is already verified")
        
        self.verified_at = datetime.utcnow()
