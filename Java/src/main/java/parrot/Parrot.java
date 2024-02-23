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
      case EUROPEAN -> new EuropeanParrot();
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
