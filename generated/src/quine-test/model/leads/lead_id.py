# MR-1: Lead aggregate - ID Value Object

from pydantic import RootModel


class LeadId(RootModel[str]):
    """Value Object representing the unique identifier of a Lead."""
    root: str
