package parrot;

public class AfricanParrot extends Parrot {
  public AfricanParrot(int numberOfCoconuts, double voltage, boolean isNailed) {
    super(numberOfCoconuts, voltage, isNailed);
  }

  @Override
  public double getSpeed() {
    return Math.max(0, getBaseSpeed() - getLoadFactor() * numberOfCoconuts);
  }

  protected double getLoadFactor() {
    return 9.0;
  }

  @Override
  public String getCry() {
    return "Sqaark!";
  }
}
