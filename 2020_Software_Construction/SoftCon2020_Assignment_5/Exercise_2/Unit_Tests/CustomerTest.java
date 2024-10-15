import Vehicles.SuperCar;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

 Customer testCustomer = new Customer();
SuperCar testCar = new SuperCar();
 @Test
    void CustomerHasRideMethod() throws NoSuchMethodException {

         String methodName = "ride";
         Method testMethod = Customer.class.getMethod(methodName, int.class);
         assertNotNull(testMethod);
         assertEquals(testMethod.getName(), methodName);


     }

     @Test
    void CustomerRideTest(){

     assertEquals("Supercar; 1 small and 1 largeBags; fast speed; 30 CHF/h",testCustomer.ride(testCar) );
     }
 }


