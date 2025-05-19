package ec.edu.monster.modelo;

public class AuthModelo {
    private static final String VALID_USERNAME = "MONSTER";
    private static final String VALID_PASSWORD = "MONSTER9";

    public boolean validateCredentials(String username, String password) {
        return VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password);
    }
}
