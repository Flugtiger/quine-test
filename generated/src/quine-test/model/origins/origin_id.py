# MR-2: Origin aggregate identity

from pydantic import RootModel


class OriginId(RootModel[str]):
    """Value Object representing the unique identifier of an Origin."""
    root: str