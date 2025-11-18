# Application layer exceptions

class NotFoundException(Exception):
    """Exception raised when a requested entity cannot be found."""
    
    def __init__(self, message: str):
        self.message = message
        super().__init__(self.message)
