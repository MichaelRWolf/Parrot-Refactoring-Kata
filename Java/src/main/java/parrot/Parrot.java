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
      case EUROPEAN -> new EuropeanParrot(numberOfCoconuts, voltage);
      case AFRICAN -> new AfricanParrot(numberOfCoconuts, voltage);
      case NORWEGIAN_BLUE -> new NorwegianBlueParrot(voltage, isNailed);
    };
  }

  public abstract double getSpeed();

  protected double getBaseSpeed() {
    return 12.0;
  }

  public abstract String getCry();
}
