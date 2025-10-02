
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonTest {

    private Person person;

    @BeforeAll
    public void setup() {
        person = new Person();
    }

    // Usuários válidos
    @ParameterizedTest
    @ValueSource(strings = {"PaulMcCartney2", "NeilArms2"})
    public void check_user_valid(String username) {
        assertTrue(person.checkUser(username));
    }

    // Usuários inválidos por conter caractere especial
    @ParameterizedTest
    @ValueSource(strings = {"Paul#McCartney", "Neil@Arms"})
    public void check_user_not_valid(String username) {
        assertFalse(person.checkUser(username));
    }

    // Senhas que não possuem letras
    @ParameterizedTest
    @ValueSource(strings = {"123456789", "#$%1234"})
    public void does_not_have_letters(String password) {
        assertFalse(person.checkPassword(password));
    }

    // Senhas que não possuem números
    @ParameterizedTest
    @ValueSource(strings = {"Abcabcdefgh@", "#hbtn@%tc"})
    public void does_not_have_numbers(String password) {
        assertFalse(person.checkPassword(password));
    }

    // Senhas com menos de 8 caracteres
    @ParameterizedTest
    @ValueSource(strings = {"Abc@123", "12$@hbt"})
    public void does_not_have_eight_chars(String password) {
        assertFalse(person.checkPassword(password));
    }

    // Senhas válidas
    @ParameterizedTest
    @ValueSource(strings = {"abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123"})
    public void check_password_valid(String password) {
        assertTrue(person.checkPassword(password));
    }
}