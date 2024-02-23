package parrot;

public class NorwegianBlueParrot extends Parrot {

  protected final double voltage;

  public NorwegianBlueParrot(double voltage, boolean isNailed) {
    super(isNailed);
    this.voltage = voltage;
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
