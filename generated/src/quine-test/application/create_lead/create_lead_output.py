# CMD-1: CreateLead - Creates and saves new Lead
# Output DTO for creating a new Lead

from pydantic import BaseModel, Field


class CreateLeadOutput(BaseModel):
    """Output data after creating a new Lead."""
    leadId: str = Field(..., description="ID of the created lead")
    verificationToken: str = Field(..., description="Verification token for the lead")
