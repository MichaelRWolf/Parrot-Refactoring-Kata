from enum import Enum  # Enum is introduced in Python 3.4.


class ParrotType(Enum):  # If it is not available, just remove it.
    EUROPEAN = 1
    AFRICAN = 2
    NORWEGIAN_BLUE = 3


class Parrot:
    def __init__(self, type_of_parrot: ParrotType, number_of_coconuts: int, voltage: float, nailed: bool) -> None:
        self._type = type_of_parrot
        self._number_of_coconuts = number_of_coconuts
        self._voltage = voltage
        self._nailed = nailed

    @staticmethod
    def create_parrot(type_of_parrot: ParrotType, number_of_coconuts: int, voltage: float, nailed: bool) -> 'Parrot':
        match type_of_parrot:
            case ParrotType.EUROPEAN:
                parrot = EuropeanParrot(number_of_coconuts, voltage, nailed)
            case ParrotType.AFRICAN:
                parrot = Parrot(ParrotType.AFRICAN, number_of_coconuts, voltage, nailed)
            case ParrotType.NORWEGIAN_BLUE:
                parrot = Parrot(ParrotType.NORWEGIAN_BLUE, number_of_coconuts, voltage, nailed)
            case _:
                raise ValueError(f"Illegal type {type_of_parrot}")
        return parrot

    def speed(self):
        if self._type == ParrotType.EUROPEAN:
            return self._base_speed()
        if self._type == ParrotType.AFRICAN:
            return max(0.0, self._base_speed() - self._load_factor() * self._number_of_coconuts)
        if self._type == ParrotType.NORWEGIAN_BLUE:
            if self._nailed:
                return 0
            else:
                return self._compute_base_speed_for_voltage(self._voltage)

        raise ValueError("should be unreachable")

    def cry(self):
        if self._type == ParrotType.EUROPEAN:
            return "Sqoork!"
        if self._type == ParrotType.AFRICAN:
            return "Sqaark!"
        if self._type == ParrotType.NORWEGIAN_BLUE:
            if self._voltage > 0:
                return "Bzzzzzz"
            else:
                return "..."

        raise ValueError("should be unreachable")

    def _compute_base_speed_for_voltage(self, voltage):
        return min([24.0, voltage * self._base_speed()])

    @staticmethod
    def _load_factor() -> float:
        return 9.0

    @staticmethod
    def _base_speed() -> float:
        return 12.0


class EuropeanParrot(Parrot):
    def __init__(self, number_of_coconuts: int, voltage: float, nailed: bool) -> None:
        super().__init__(ParrotType.EUROPEAN, number_of_coconuts, voltage, nailed)
