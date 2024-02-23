package parrot;

public class EuropeanParrot extends Parrot {
  public EuropeanParrot(ParrotTypeEnum type,
                        int numberOfCoconuts,
                        double voltage,
                        boolean isNailed) {
    super(type, numberOfCoconuts, voltage, isNailed);
  }

  @Override
  public double getSpeed() {
    return switch (type) {
      case EUROPEAN -> getBaseSpeed();
      case AFRICAN -> Math.max(0, getBaseSpeed() - getLoadFactor() * numberOfCoconuts);
      case NORWEGIAN_BLUE -> (isNailed) ? 0 : getBaseSpeed(voltage);
    };
  }
}
