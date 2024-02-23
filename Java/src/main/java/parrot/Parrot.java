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
      case EUROPEAN -> createEuropeanParrot(type, numberOfCoconuts, voltage, isNailed);
      case AFRICAN -> createAfricanParrot(numberOfCoconuts);
      case NORWEGIAN_BLUE -> createNorwegianBlueParrot(voltage, isNailed);
    };
  }

  private static NorwegianBlueParrot createNorwegianBlueParrot(double voltage, boolean isNailed) {
    return new NorwegianBlueParrot(voltage, isNailed);
  }

  private static AfricanParrot createAfricanParrot(int numberOfCoconuts) {
    return new AfricanParrot(numberOfCoconuts);
  }

  private static EuropeanParrot createEuropeanParrot(ParrotTypeEnum type, int numberOfCoconuts,
                                                  double voltage, boolean isNailed) {
    if (numberOfCoconuts != 0) {
      throw new IllegalArgumentException(
          String.format("numberOfCoconuts must be 0 for %s", type));
    }
    if (voltage != 0.0) {
      throw new IllegalArgumentException(
          String.format("voltage must be 0.0 for %s", type));
    }
    if (isNailed) {
      throw new IllegalArgumentException(
          String.format("isNailed must be false for %s", type));
    }
    return new EuropeanParrot();
  }

  public abstract double getSpeed();

  public abstract String getCry();

  protected double getBaseSpeed() {
    return 12.0;
  }
}
