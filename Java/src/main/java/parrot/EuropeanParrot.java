package parrot;

public class EuropeanParrot extends Parrot {

  protected final double voltage;

  public EuropeanParrot(int numberOfCoconuts, double voltage, boolean isNailed) {
    super(isNailed);
    this.voltage = voltage;
  }

  @Override
  public double getSpeed() {
    return getBaseSpeed();
  }

  @Override
  public String getCry() {
    return "Sqoork!";
  }
}
