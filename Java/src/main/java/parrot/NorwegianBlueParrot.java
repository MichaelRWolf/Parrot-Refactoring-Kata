package parrot;

public class NorwegianBlueParrot extends Parrot {
  public NorwegianBlueParrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage,
                             boolean isNailed) {
    super(type, numberOfCoconuts, voltage, isNailed);
  }

  @Override
  public double getSpeed() {
    return (isNailed) ? 0 : getBaseSpeed(voltage);
  }

  protected double getBaseSpeed(double voltage) {
    return Math.min(24.0, voltage * getBaseSpeed());
  }
}
