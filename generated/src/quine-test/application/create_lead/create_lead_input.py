# CMD-1: CreateLead - Creates and saves new Lead
# Input DTO for creating a new Lead

from pydantic import BaseModel, Field


class CreateLeadInput(BaseModel):
    """Input data for creating a new Lead."""
    emailAddress: str = Field(..., description="Email address of the lead")
