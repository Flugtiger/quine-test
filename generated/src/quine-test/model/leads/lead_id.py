# MR-1: Lead aggregate identity

from pydantic import RootModel


class LeadId(RootModel[str]):
    """Value Object representing the unique identifier of a Lead."""
    root: str
