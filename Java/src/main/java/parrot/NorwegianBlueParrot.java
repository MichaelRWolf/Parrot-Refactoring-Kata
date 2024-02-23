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


  //  NorwegianBlueParrot does not have a fixed base speed.  It is dependent on the voltage.
  protected double getBaseSpeed(double voltage) {
    return Math.min(24.0, voltage * getBaseSpeed());
  }

  @Override
  public String getCry() {
    return voltage > 0 ? "Bzzzzzz" : "...";
  }
}
