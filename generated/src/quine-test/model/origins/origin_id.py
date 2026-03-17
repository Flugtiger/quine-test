# MR-2: Origin aggregate - ID Value Object

from pydantic import RootModel


class OriginId(RootModel[str]):
    """Value Object representing the unique identifier of an Origin."""
    root: str
