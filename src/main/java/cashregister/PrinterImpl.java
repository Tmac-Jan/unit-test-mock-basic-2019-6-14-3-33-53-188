package cashregister;

public class PrinterImpl extends Printer {

  private boolean isCalled = false;
  private String wantString;
  public PrinterImpl(){}
  public PrinterImpl(boolean isCalled) {
    this.isCalled = isCalled;
  }

  public boolean isCalled() {
    return isCalled;
  }

  public String getWantString() {
    return wantString;
  }

  @Override
  public void print(String printThis) {
    this.isCalled = true;
    wantString=printThis;
    System.out.println(printThis);
  }
}
