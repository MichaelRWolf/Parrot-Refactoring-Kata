package parrot;

public abstract class Parrot {

  protected final double voltage;
  protected final boolean isNailed;

  Parrot(int numberOfCoconuts, double voltage, boolean isNailed) {
    this.voltage = voltage;
    this.isNailed = isNailed;
  }

  static Parrot createParrot(ParrotTypeEnum type,
                             int numberOfCoconuts,
                             double voltage,
                             boolean isNailed) {
    return switch (type) {
      case EUROPEAN -> new EuropeanParrot(numberOfCoconuts, voltage, isNailed);
      case AFRICAN -> new AfricanParrot(numberOfCoconuts, voltage, isNailed);
      case NORWEGIAN_BLUE -> new NorwegianBlueParrot(numberOfCoconuts, voltage, isNailed);
    };
  }

  public abstract double getSpeed();

  protected double getBaseSpeed() {
    return 12.0;
  }

  public abstract String getCry();
}
