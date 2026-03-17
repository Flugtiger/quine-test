# MR-2: Repository for Origin aggregate

from abc import ABC, abstractmethod
from typing import List
from quine_test.model.origins.origin import Origin
from quine_test.model.origins.origin_id import OriginId


class OriginRepository(ABC):
    """Abstract repository for managing Origin aggregates."""

    @abstractmethod
    def get_by_id(self, origin_id: OriginId) -> Origin:
        """Retrieves an Origin by its ID."""
        pass

    @abstractmethod
    def save(self, origin: Origin) -> None:
        """Saves an Origin. The ID is written to new Origin objects when saving them for the first time."""
        pass

    @abstractmethod
    def get_all(self) -> List[Origin]:
        """Retrieves all Origins."""
        pass