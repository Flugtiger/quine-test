# MR-3: Customer aggregate - Repository interface

from abc import ABC, abstractmethod
from typing import List
from quine-test.model.customers.customer import Customer
from quine-test.model.customers.customer_id import CustomerId


class CustomerRepository(ABC):
    """Abstract repository for Customer aggregate."""

    @abstractmethod
    def get_by_id(self, customer_id: CustomerId) -> Customer:
        """
        Retrieves a Customer by its ID.
        
        Args:
            customer_id: The ID of the Customer to retrieve
            
        Returns:
            The Customer with the given ID
            
        Raises:
            Exception if Customer is not found
        """
        pass

    @abstractmethod
    def save(self, customer: Customer) -> None:
        """
        Saves a Customer to the repository.
        The ID is written to new Customer objects when saving them for the first time.
        
        Args:
            customer: The Customer to save
        """
        pass

    @abstractmethod
    def get_all(self) -> List[Customer]:
        """
        Retrieves all Customers.
        
        Returns:
            List of all Customers
        """
        pass