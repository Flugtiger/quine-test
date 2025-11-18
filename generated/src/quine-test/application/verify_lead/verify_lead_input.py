# CMD-2: VerifyLead - Verifies a Lead using verification token
# Input DTO for verifying a Lead

from pydantic import BaseModel, Field


class VerifyLeadInput(BaseModel):
    """Input data for verifying a Lead."""
    leadId: str = Field(..., description="ID of the lead to verify")
    verificationToken: str = Field(..., description="Verification token to match")
