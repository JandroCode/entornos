
import org.example.models.Banco;
import org.example.models.Cuenta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CuentaTest {


    @Test
    void testNombreCuenta() {

        Cuenta cuenta = new Cuenta("Juan", new BigDecimal(1000.12345));
        //cuenta.setPersona("Juan");
        String valorEsperado = "Juan";
        String valorActual = cuenta.getPersona();

        Assertions.assertEquals(valorEsperado, valorActual);
    }

    @Test
    void testTransferirDineroCuentas() {
        Cuenta cuenta1 = new Cuenta("Juan", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Eva", new BigDecimal("1500.8989"));

        Banco banco = new Banco();
        banco.setNombre("Banco Sabadell");
        banco.transferir(cuenta2, cuenta1, new BigDecimal("500"));
        Assertions.assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());
        Assertions.assertEquals("3000", cuenta1.getSaldo().toPlainString());
    }

    @Test
    void testRelacionBancoCuentas() {
        Cuenta cuenta1 = new Cuenta("Juan", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Eva", new BigDecimal("1500.8989"));

        Banco banco = new Banco();


        banco.setNombre("Banco Sabadell");

        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);

        Assertions.assertEquals(2, banco.getCuentas().size());

        Assertions.assertEquals("Banco Sabadell", cuenta1.getBanco().getNombre());


    }

}
