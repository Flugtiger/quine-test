# CMD-1: CreateLead - Creates and saves new Lead
# Handler for creating a new Lead

from quine_test.model.leads.lead import Lead
from quine_test.model.leads.email_address import EmailAddress
from quine_test.model.leads.lead_repository import LeadRepository
from quine_test.application.create_lead.create_lead_input import CreateLeadInput
from quine_test.application.create_lead.create_lead_output import CreateLeadOutput


class CreateLeadHandler:
    """Handler for creating a new Lead."""
    
    def __init__(self, lead_repository: LeadRepository):
        """
        Initializes the CreateLeadHandler.
        
        Args:
            lead_repository: Repository for managing Lead aggregates
        """
        self.lead_repository = lead_repository
    
    def handle(self, input_data: CreateLeadInput) -> CreateLeadOutput:
        """
        Creates and saves a new Lead.
        
        Args:
            input_data: Input data containing the email address
            
        Returns:
            CreateLeadOutput containing the lead ID and verification token
        """
        # Create email address value object (validation happens here)
        email_address = EmailAddress(value=input_data.emailAddress)
        
        # Create the Lead aggregate (generates verification token automatically)
        lead = Lead.create(email_address=email_address)
        
        # Save the Lead (ID will be assigned by the repository)
        self.lead_repository.save(lead)
        
        # Return the output with lead ID and verification token
        return CreateLeadOutput(
            leadId=lead.id.root,
            verificationToken=lead.verification_token.value
        )
