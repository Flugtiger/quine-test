# MR-3: Customer aggregate with metadata (name, address, revenue) and creation from Lead

from decimal import Decimal
from pydantic import BaseModel, Field, field_validator
from quine-test.model.customers.customer_id import CustomerId
from quine-test.model.leads.lead_id import LeadId
from quine-test.model.leads.lead import Lead


class Customer(BaseModel):
    """
    Aggregate Root representing a Customer.
    A Customer has metadata like name, address, and revenue.
    A Customer can be created from a Lead.
    """
    id: CustomerId = Field(default_factory=lambda: CustomerId(""))
    name: str
    address: str
    revenue: Decimal
    lead_id: LeadId

    @field_validator('name')
    @classmethod
    def validate_name(cls, v: str) -> str:
        """Validates that name is not empty."""
        if not v or not v.strip():
            raise ValueError("Customer name cannot be empty")
        return v

    @field_validator('address')
    @classmethod
    def validate_address(cls, v: str) -> str:
        """Validates that address is not empty."""
        if not v or not v.strip():
            raise ValueError("Customer address cannot be empty")
        return v

    @field_validator('revenue')
    @classmethod
    def validate_revenue(cls, v: Decimal) -> Decimal:
        """Validates that revenue is not negative."""
        if v < 0:
            raise ValueError("Customer revenue cannot be negative")
        return v

    @staticmethod
    def create_from_lead(lead: Lead, name: str, address: str, revenue: Decimal) -> 'Customer':
        """
        Creates a new Customer from a Lead.
        
        Args:
            lead: The Lead to create the Customer from
            name: The name of the Customer
            address: The address of the Customer
            revenue: The revenue of the Customer
            
        Returns:
            A new Customer instance
            
        Raises:
            ValueError: If the Lead is not verified
        """
        if not lead.is_verified:
            raise ValueError("Cannot create Customer from unverified Lead")
        
        return Customer(
            name=name,
            address=address,
            revenue=revenue,
            lead_id=lead.id
        )