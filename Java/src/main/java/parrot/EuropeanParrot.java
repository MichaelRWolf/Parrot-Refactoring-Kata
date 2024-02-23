package parrot;

public class EuropeanParrot extends Parrot {

  public EuropeanParrot(int numberOfCoconuts, double voltage, boolean isNailed) {
    super(0, voltage, isNailed);
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
