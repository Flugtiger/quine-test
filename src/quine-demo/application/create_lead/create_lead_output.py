# CMD-1: CreateLead - Creates and saves a new Lead


class CreateLeadOutput:
    """Output DTO for the CreateLead command."""

    def __init__(self, lead_id: str):
        """
        Initialize CreateLeadOutput with the created lead's ID.

        Args:
            lead_id: The unique identifier of the newly created lead.
        """
        if not lead_id:
            raise ValueError("Lead ID cannot be empty")

        self.lead_id = lead_id
