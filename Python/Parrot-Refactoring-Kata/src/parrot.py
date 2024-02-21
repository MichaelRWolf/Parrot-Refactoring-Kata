from abc import ABC, abstractmethod
from enum import Enum  # Enum is introduced in Python 3.4.


class ParrotType(Enum):  # If it is not available, just remove it.
    EUROPEAN = 1
    AFRICAN = 2
    NORWEGIAN_BLUE = 3


class Parrot(ABC):
    def __init__(self) -> None:
        pass

    @staticmethod
    def create_parrot(type_of_parrot: ParrotType, number_of_coconuts: int, voltage: float, nailed: bool) -> 'Parrot':
        match type_of_parrot:
            case ParrotType.EUROPEAN:
                parrot = EuropeanParrot()
            case ParrotType.AFRICAN:
                parrot = AfricanParrot(number_of_coconuts)
            case ParrotType.NORWEGIAN_BLUE:
                parrot = NorwegianBlueParrot(voltage, nailed)
            case _:
                raise ValueError(f"Illegal type {type_of_parrot}")
        return parrot

    @abstractmethod
    def speed(self) -> float:
        pass

    @abstractmethod
    def cry(self) -> str:
        pass

    def _compute_base_speed_for_voltage(self, voltage):
        return min([24.0, voltage * self._base_speed()])

    @staticmethod
    def _load_factor() -> float:
        return 9.0

    @staticmethod
    def _base_speed() -> float:
        return 12.0


class EuropeanParrot(Parrot):
    def __init__(self) -> None:
        pass

    def speed(self) -> float:
        return self._base_speed()

    def cry(self) -> str:
        return "Sqoork!"


class AfricanParrot(Parrot):
    def __init__(self, number_of_coconuts: int) -> None:
        self._number_of_coconuts = number_of_coconuts

    def speed(self) -> float:
        return max(0.0, self._base_speed() - self._load_factor() * self._number_of_coconuts)

    def cry(self) -> str:
        return "Sqaark!"


class NorwegianBlueParrot(Parrot):
    def __init__(self, voltage: float, nailed: bool) -> None:
        self._voltage = voltage
        self._nailed = nailed

    def speed(self) -> float:
        if self._nailed:
            return 0
        else:
            return self._compute_base_speed_for_voltage(self._voltage)

    def cry(self) -> str:
        if self._voltage > 0:
            return "Bzzzzzz"
        else:
            return "..."
