package src;

public class Person {

    public boolean checkUser(String user) {
        if (user == null || user.length() < 8) {
            return false;
        }
        // Verifica se há caracter especial
        // Aceita apenas letras e números
        return user.matches("^[A-Za-z0-9]+$");
    }

    public boolean checkPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        // Pelo menos uma letra maiúscula
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        // Pelo menos um número
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        // Pelo menos um caractere especial
        if (!password.matches(".*[^A-Za-z0-9].*")) {
            return false;
        }
        return true;
    }
}