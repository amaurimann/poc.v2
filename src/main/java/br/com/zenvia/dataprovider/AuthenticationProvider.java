package br.com.zenvia.dataprovider;

import br.com.zenvia.model.User;
import org.testng.annotations.DataProvider;

public class AuthenticationProvider {

    @DataProvider(name = "authenticateUserProvider")
    public Object[][] getAuthentication() {
        User user1 = User.builder().email("anderson.mann@zenvia.com").password("Minhasenha123").build();
        return new Object[][]{
                {
                        user1
                }
        };
    }
}