import org.example.models.Cuenta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CuentaTest {


    @Test
    void testNombreCuenta(){

        Cuenta cuenta = new Cuenta("Juan" , new BigDecimal(1000.12345));
        //cuenta.setPersona("Juan");
        String valorEsperado = "Juan";
        String valorActual= cuenta.getPersona();

        Assertions.assertEquals(valorEsperado, valorActual);



    }


}
