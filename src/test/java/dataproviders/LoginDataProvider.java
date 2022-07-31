package dataproviders;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

public final class LoginDataProvider {

    //If one or two Tests need data then its recommended to keep in same Test class
    // just above the Test to make better readability

    @DataProvider(name = "invalidUsernamesAndValidPasswords")
    public Object[][] invalidUsernamesAndValidPasswords(){
        return new Object[][]{
                {"invalidUsername1","validPassword1"},
                {"invalidUsername2","validPassword2"}
        };
    }

    @DataProvider(name = "validUsernamesAndinvalidPasswords")
    public Object[][] validUsernamesAndinvalidPasswords(){
        return new Object[][]{
                {"validUsername1","invalidPassword1"},
                {"validUsername2","invalidPassword2"}
        };
    }
    //Using dynamic data faker library
    private static Faker FAKER = new Faker();

    @DataProvider(name = "invalidUsernamesAndvalidPasswordsFromFaker")
    public Object[][] invalidUsernamesAndvalidPasswordsFromFaker(){
        return new Object[][]{
                {FAKER.random().hex(8),"validPassword1"},
                {FAKER.random().hex(8),"validPassword2"}
        };
    }
}
