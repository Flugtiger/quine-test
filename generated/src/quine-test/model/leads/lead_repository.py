# MR-1: Lead aggregate - Repository interface

from abc import ABC, abstractmethod
from typing import List
from quine-test.model.leads.lead import Lead
from quine-test.model.leads.lead_id import LeadId


class LeadRepository(ABC):
    """Abstract repository for Lead aggregate."""

    @abstractmethod
    def get_by_id(self, lead_id: LeadId) -> Lead:
        """
        Retrieves a Lead by its ID.
        
        Args:
            lead_id: The ID of the Lead to retrieve
            
        Returns:
            The Lead with the given ID
            
        Raises:
            Exception if Lead is not found
        """
        pass

    @abstractmethod
    def save(self, lead: Lead) -> None:
        """
        Saves a Lead to the repository.
        The ID is written to new Lead objects when saving them for the first time.
        
        Args:
            lead: The Lead to save
        """
        pass

    @abstractmethod
    def get_all(self) -> List[Lead]:
        """
        Retrieves all Leads.
        
        Returns:
            List of all Leads
        """
        pass
