
import org.example.models.Banco;
import org.example.models.Cuenta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    @DisplayName("Probando la relación entre banco y cuenta")
    void testRelacionBancoCuentas() {
        Cuenta cuenta1 = new Cuenta("Juan", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Eva", new BigDecimal("1500.8989"));

        Banco banco = new Banco();
        banco.setNombre("Banco Sabadell");

        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);


        Assertions.assertAll( () -> {

        },
                () ->  Assertions.assertEquals(1, banco.getCuentas().size(), () -> "Error en el número de cuentas !"),
                () -> Assertions.assertEquals("Banco Sabadell", cuenta1.getBanco().getNombre()),
                ()-> Assertions.assertTrue(banco.getCuentas().stream().anyMatch( c -> c.getPersona().equals("Juan")))

        );



        /*
                Assertions.assertEquals(2, banco.getCuentas().size());
                Assertions.assertEquals("Banco Sabadel", cuenta1.getBanco().getNombre());
                Assertions.assertTrue(banco.getCuentas().stream().anyMatch( c -> c.getPersona().equals("Mario")));
         */






    }

}
