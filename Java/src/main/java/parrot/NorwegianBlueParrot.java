package parrot;

public class NorwegianBlueParrot extends Parrot {
  public NorwegianBlueParrot(int numberOfCoconuts, double voltage, boolean isNailed) {
    super(ParrotTypeEnum.NORWEGIAN_BLUE, numberOfCoconuts, voltage, isNailed);
  }

  @Override
  public double getSpeed() {
    return (isNailed) ? 0 : getBaseSpeed(voltage);
  }

  protected double getBaseSpeed(double voltage) {
    return Math.min(24.0, voltage * getBaseSpeed());
  }

  @Override
  public String getCry() {
    return voltage > 0 ? "Bzzzzzz" : "...";
  }
}
