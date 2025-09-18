# eddbf72e-8ac8-43ce-b246-d79f1a3c7f36: Abstract repository for Customer aggregate
from abc import ABC, abstractmethod
from typing import List, Optional
from .customer import Customer
from .customer_id import CustomerId


class CustomerRepository(ABC):
    """Abstract repository for managing Customer aggregates."""
    
    @abstractmethod
    def get_by_id(self, customer_id: CustomerId) -> Optional[Customer]:
        """Get a customer by their ID."""
        pass
    
    @abstractmethod
    def save(self, customer: Customer) -> None:
        """Save a customer. The ID is written to new Customer objects when saving them for the first time."""
        pass
    
    @abstractmethod
    def get_all(self) -> List[Customer]:
        """Get all customers."""
        pass