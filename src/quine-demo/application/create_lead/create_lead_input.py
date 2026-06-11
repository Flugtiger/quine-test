# CMD-1: CreateLead - Creates and saves a new Lead


class CreateLeadInput:
    """Input DTO for the CreateLead command."""

    def __init__(self, name: str, email: str, phone: str = None):
        """
        Initialize CreateLeadInput with lead information.

        Args:
            name: The name of the lead.
            email: The email address of the lead.
            phone: Optional phone number of the lead.
        """
        if not name:
            raise ValueError("Lead name cannot be empty")
        if not email:
            raise ValueError("Lead email cannot be empty")

        self.name = name
        self.email = email
        self.phone = phone
