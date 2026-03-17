# MR-2: Origin aggregate with name and description

from pydantic import BaseModel, Field, field_validator
from quine-test.model.origins.origin_id import OriginId


class Origin(BaseModel):
    """
    Aggregate Root representing an Origin.
    An Origin contains information about where a Lead is coming from
    (e.g. landingpage, LinkedIn, ...).
    It has a name and a description.
    """
    id: OriginId = Field(default_factory=lambda: OriginId(""))
    name: str
    description: str

    @field_validator('name')
    @classmethod
    def validate_name(cls, v: str) -> str:
        """Validates that name is not empty."""
        if not v or not v.strip():
            raise ValueError("Origin name cannot be empty")
        return v

    @field_validator('description')
    @classmethod
    def validate_description(cls, v: str) -> str:
        """Validates that description is not empty."""
        if not v or not v.strip():
            raise ValueError("Origin description cannot be empty")
        return v
