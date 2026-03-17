# MR-2: Origin aggregate with name and description

from pydantic import BaseModel, Field, field_validator
from quine_test.model.origins.origin_id import OriginId


class Origin(BaseModel):
    """Aggregate Root representing an Origin that describes where a Lead is coming from."""
    id: OriginId = Field(default_factory=lambda: OriginId(""))
    name: str
    description: str

    @field_validator('name')
    @classmethod
    def validate_name(cls, v: str) -> str:
        """Validates that the name is not empty."""
        if not v or not isinstance(v, str):
            raise ValueError("Origin name cannot be empty")
        if not v.strip():
            raise ValueError("Origin name cannot be empty or whitespace only")
        return v

    @field_validator('description')
    @classmethod
    def validate_description(cls, v: str) -> str:
        """Validates that the description is not empty."""
        if not v or not isinstance(v, str):
            raise ValueError("Origin description cannot be empty")
        if not v.strip():
            raise ValueError("Origin description cannot be empty or whitespace only")
        return v