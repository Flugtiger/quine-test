# Application layer exceptions


class NotFoundException(Exception):
    """Raised when a requested item cannot be found in a repository."""

    pass


class UnauthorizedException(Exception):
    """Raised when the current user is not authorized to perform an operation."""

    pass
