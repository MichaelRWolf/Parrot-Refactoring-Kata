package parrot;

public class NorwegianBlueParrot extends Parrot {

  protected final double voltage;
  protected final boolean isNailed;

  public NorwegianBlueParrot(double voltage, boolean isNailed) {
    super();
    this.voltage = voltage;
    this.isNailed = isNailed;
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
