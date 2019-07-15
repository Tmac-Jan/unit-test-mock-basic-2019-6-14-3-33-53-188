package cashregister;

public class PurchaseImpl extends Purchase {
  private String wantString;
  private boolean isCalled =false;

  public PurchaseImpl(Item[] items) {
    super(items);
  }

  public boolean isCalled() {
    return isCalled;
  }

  public void setCalled(boolean called) {
    isCalled = called;
  }

  public String getWantString() {
    return wantString;
  }

  public void setWantString(String wantString) {
    this.wantString = wantString;
  }

  @Override
  public String asString() {
    isCalled = true;
    return wantString;
  }
}
