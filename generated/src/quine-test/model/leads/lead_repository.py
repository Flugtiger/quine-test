# MR-1: Repository for Lead aggregate

from abc import ABC, abstractmethod
from typing import List
from quine_test.model.leads.lead import Lead
from quine_test.model.leads.lead_id import LeadId


class LeadRepository(ABC):
    """Abstract repository for managing Lead aggregates."""

    @abstractmethod
    def get_by_id(self, lead_id: LeadId) -> Lead:
        """Retrieves a Lead by its ID."""
        pass

    @abstractmethod
    def save(self, lead: Lead) -> None:
        """Saves a Lead. The ID is written to new Lead objects when saving them for the first time."""
        pass

    @abstractmethod
    def get_all(self) -> List[Lead]:
        """Retrieves all Leads."""
        pass
