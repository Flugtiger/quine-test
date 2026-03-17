# MR-2: Origin aggregate - Repository interface

from abc import ABC, abstractmethod
from typing import List
from quine-test.model.origins.origin import Origin
from quine-test.model.origins.origin_id import OriginId


class OriginRepository(ABC):
    """Abstract repository for Origin aggregate."""

    @abstractmethod
    def get_by_id(self, origin_id: OriginId) -> Origin:
        """
        Retrieves an Origin by its ID.
        
        Args:
            origin_id: The ID of the Origin to retrieve
            
        Returns:
            The Origin with the given ID
            
        Raises:
            Exception if Origin is not found
        """
        pass

    @abstractmethod
    def save(self, origin: Origin) -> None:
        """
        Saves an Origin to the repository.
        The ID is written to new Origin objects when saving them for the first time.
        
        Args:
            origin: The Origin to save
        """
        pass

    @abstractmethod
    def get_all(self) -> List[Origin]:
        """
        Retrieves all Origins.
        
        Returns:
            List of all Origins
        """
        pass
