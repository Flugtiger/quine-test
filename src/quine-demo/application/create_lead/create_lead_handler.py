# CMD-1: CreateLead - Creates and saves a new Lead

import logging

from quine_demo.application.create_lead.create_lead_input import CreateLeadInput
from quine_demo.application.create_lead.create_lead_output import CreateLeadOutput

logger = logging.getLogger(__name__)


class CreateLeadHandler:
    """Handler for the CreateLead command."""

    def __init__(self, lead_repository):
        """
        Initialize CreateLeadHandler with required dependencies.

        Args:
            lead_repository: Repository for managing Lead aggregates.
        """
        self.lead_repository = lead_repository

    def handle(self, input_dto: CreateLeadInput) -> CreateLeadOutput:
        """
        Create and save a new Lead aggregate.

        Args:
            input_dto: The input DTO containing lead information.

        Returns:
            CreateLeadOutput: The output DTO containing the created lead's ID.
        """
        logger.info("Creating new lead with name: %s", input_dto.name)

        # Obtain a unique ID for the new lead
        lead_id = self.lead_repository.next_id()

        # Create the Lead aggregate (assuming Lead constructor exists in model)
        from quine_demo.model.lead import Lead

        lead = Lead(
            lead_id=lead_id,
            name=input_dto.name,
            email=input_dto.email,
            phone=input_dto.phone,
        )

        # Save the lead to the repository
        self.lead_repository.save(lead)

        logger.info("Lead created successfully with ID: %s", lead_id)

        return CreateLeadOutput(lead_id=lead_id)
