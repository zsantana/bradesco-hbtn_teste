import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.Date;

public class PersonTest {
    private Person person;

    @Before
    public void setup() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2000);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date birthDate = cal.getTime();

        person = new Person("Paul", "McCartney", birthDate, true, true, true);
    }

    @Test
    public void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    public void test_calculateYearlySalary() {
        person.setSalary(1200);
        assertEquals(14400, person.calculateYearlySalary(), 0.0);
    }

    @Test
    public void person_is_MEI() {
        // Correção dos atributos para habilitar como MEI
        person.setAnotherCompanyOwner(false);
        person.setPensioner(false);
        person.setPublicServer(false);
        person.setSalary(10000); // 10_000 * 12 = 120_000
        assertTrue(person.isMEI());
    }

    @Test
    public void person_is_not_MEI() {
        // Colocando como sócio de empresa, por exemplo
        person.setAnotherCompanyOwner(true);
        person.setPensioner(false);
        person.setPublicServer(false);
        person.setSalary(10000);
        assertFalse(person.isMEI());
    }
}