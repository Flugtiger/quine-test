# MR-3: Customer aggregate - ID Value Object

from pydantic import RootModel


class CustomerId(RootModel[str]):
    """Value Object representing the unique identifier of a Customer."""
    root: str