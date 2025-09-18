# eddbf72e-8ac8-43ce-b246-d79f1a3c7f36: Customer aggregate root with firstname, lastname and email address
from dataclasses import dataclass
import re
from .customer_id import CustomerId


@dataclass
class Customer:
    """Customer aggregate root in the CRM domain."""
    
    id: CustomerId
    firstname: str
    lastname: str
    email: str
    
    def __init__(self, firstname: str, lastname: str, email: str, id: CustomerId = None):
        """Initialize a new Customer with the given details."""
        if id is None:
            id = CustomerId()
        
        self.id = id
        self.firstname = firstname
        self.lastname = lastname
        self.email = email
        
        self._validate()
    
    def _validate(self):
        """Validate the customer data according to business rules."""
        if not self.firstname or not isinstance(self.firstname, str):
            raise ValueError("Customer firstname must be a non-empty string")
        
        if not self.lastname or not isinstance(self.lastname, str):
            raise ValueError("Customer lastname must be a non-empty string")
        
        if not self.email or not isinstance(self.email, str):
            raise ValueError("Customer email must be a non-empty string")
        
        # Basic email validation
        email_pattern = r'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$'
        if not re.match(email_pattern, self.email):
            raise ValueError("Customer email must be a valid email address")
        
        if not isinstance(self.id, CustomerId):
            raise ValueError("Customer ID must be a CustomerId instance")
    
    def update_firstname(self, firstname: str):
        """Update the customer's firstname."""
        if not firstname or not isinstance(firstname, str):
            raise ValueError("Customer firstname must be a non-empty string")
        self.firstname = firstname
    
    def update_lastname(self, lastname: str):
        """Update the customer's lastname."""
        if not lastname or not isinstance(lastname, str):
            raise ValueError("Customer lastname must be a non-empty string")
        self.lastname = lastname
    
    def update_email(self, email: str):
        """Update the customer's email address."""
        if not email or not isinstance(email, str):
            raise ValueError("Customer email must be a non-empty string")
        
        email_pattern = r'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$'
        if not re.match(email_pattern, email):
            raise ValueError("Customer email must be a valid email address")
        
        self.email = email
    
    def get_full_name(self) -> str:
        """Get the customer's full name."""
        return f"{self.firstname} {self.lastname}"