import org.junit.Test;

import java.math.BigDecimal;
import java.util.Objects;

public class FacadeTest {

    @Test
    public void test1(){
        Long aLong = Long.valueOf(Objects.toString(new BigDecimal("35.85").multiply(new BigDecimal("100")).intValue(), "0"));
        System.out.println(aLong);
    }
}
