package parrot;

public class AfricanParrot extends Parrot {
  protected final int numberOfCoconuts;

  public AfricanParrot(int numberOfCoconuts, double voltage, boolean isNailed) {
    super(numberOfCoconuts, voltage, isNailed);
    this.numberOfCoconuts = numberOfCoconuts;
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
