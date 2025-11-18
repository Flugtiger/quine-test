# CMD-2: VerifyLead - Verifies a Lead using verification token
# Handler for verifying a Lead

from quine_test.model.leads.lead_id import LeadId
from quine_test.model.leads.lead_repository import LeadRepository
from quine_test.application.verify_lead.verify_lead_input import VerifyLeadInput
from quine_test.application.exceptions import NotFoundException


class VerifyLeadHandler:
    """Handler for verifying a Lead."""
    
    def __init__(self, lead_repository: LeadRepository):
        """
        Initializes the VerifyLeadHandler.
        
        Args:
            lead_repository: Repository for managing Lead aggregates
        """
        self.lead_repository = lead_repository
    
    def handle(self, input_data: VerifyLeadInput) -> None:
        """
        Verifies a Lead by matching the verification token.
        
        Args:
            input_data: Input data containing the lead ID and verification token
            
        Raises:
            NotFoundException: If the lead with the given ID cannot be found
            ValueError: If the verification token doesn't match or lead is already verified
        """
        # Create LeadId value object
        lead_id = LeadId(input_data.leadId)
        
        # Retrieve the Lead from repository
        try:
            lead = self.lead_repository.get_by_id(lead_id)
        except Exception:
            raise NotFoundException(f"Lead with ID '{input_data.leadId}' not found")
        
        # Verify the token matches
        if lead.verification_token.value != input_data.verificationToken:
            raise ValueError("Verification token does not match")
        
        # Verify the Lead (this will raise ValueError if already verified)
        lead.verify()
        
        # Save the updated Lead
        self.lead_repository.save(lead)
