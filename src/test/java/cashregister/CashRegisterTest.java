package cashregister;


import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class CashRegisterTest {


  @Test
  public void should_print_the_real_purchase_when_call_process() {
    //given
    Item[] items = {new Item("sss", 20), new Item("aaa", 30)};
    PurchaseImpl purchase = new PurchaseImpl(items);
    CashRegister cashRegister = new CashRegister(new PrinterImpl());

    //when
    cashRegister.process(purchase);
    //then
    Assertions.assertEquals(true,purchase.isCalled());
  }

  @Test
  public void should_print_the_stub_purchase_when_call_process() {
    //given
    Item[] items = {new Item("sss", 20), new Item("aaa", 30)};
    PrinterImpl printer = new PrinterImpl();
    CashRegister cashRegister = new CashRegister(printer);
    PurchaseImpl purchase = new PurchaseImpl(items);
    purchase.setWantString("TEST");
    //when
    cashRegister.process(purchase);
    //then
    Assertions.assertEquals(purchase.getWantString(), printer.getWantString());
  }

  @Test
  public void should_verify_with_process_call_with_mockito() {
    //given
    Purchase purchase = mock(Purchase.class);
    Printer printer = mock(Printer.class);
    CashRegister cashRegister = new CashRegister(printer);
    //when
    when(purchase.asString()).thenReturn("TEST");
    // Mockito.doNothing().when(cashRegister).process(purchase);
    //then
    cashRegister.process(purchase);
    Assertions.assertEquals("TEST", purchase.asString());
    verify(printer, times(1)).print(purchase.asString());
  }

}
