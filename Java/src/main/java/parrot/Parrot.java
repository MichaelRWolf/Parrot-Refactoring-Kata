package parrot;

public abstract class Parrot {

  Parrot() {
    // Do nothing.
  }

  static Parrot createParrot(ParrotTypeEnum type,
                             int numberOfCoconuts,
                             double voltage,
                             boolean isNailed) {
    return switch (type) {
      case EUROPEAN -> {
        if (numberOfCoconuts != 0) {
          throw new IllegalArgumentException(
              String.format("numberOfCoconuts must be 0 for %s", type));
        }
        if (voltage != 0.0) {
          throw new IllegalArgumentException(
              String.format("voltage must be 0 for %s", type));
        }
        yield new EuropeanParrot();
      }
      case AFRICAN -> new AfricanParrot(numberOfCoconuts);
      case NORWEGIAN_BLUE -> new NorwegianBlueParrot(voltage, isNailed);
    };
  }

  public abstract double getSpeed();

  public abstract String getCry();

  protected double getBaseSpeed() {
    return 12.0;
  }
}
