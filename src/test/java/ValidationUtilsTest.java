import com.example.weather.dto.UserRequestDto;
import com.example.weather.commons.exception.InvalidParameterException;
import com.example.weather.commons.util.ValidationUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidationUtilsTest {
@Test
    public void checkLogin() {
//Presence of Cyrillic alphabet
    String login1 = "ЫQwe123";

//Empty login
    String login2 = "";

//Short login
    String login3 = "Qw";

//Presence of prohibited characters
    String login4 = "!Qwerty1234";

    String password = "Qw123wdwewrbghet!";

    UserRequestDto userDto1 = new UserRequestDto(login1,password);
    UserRequestDto userDto2 = new UserRequestDto(login2,password);
    UserRequestDto userDto3 = new UserRequestDto(login3,password);
    UserRequestDto userDto4 = new UserRequestDto(login4,password);

    assertThrows(InvalidParameterException.class, () -> ValidationUtil.validate(userDto1));
    assertThrows(InvalidParameterException.class, () -> ValidationUtil.validate(userDto2));
    assertThrows(InvalidParameterException.class, () -> ValidationUtil.validate(userDto3));
    assertThrows(InvalidParameterException.class, () -> ValidationUtil.validate(userDto4));
}

@Test
    public void checkPassword() {
    String login = "Qwerty123";

//Short password
    String password1 = "Qw12!";
//Missing special characters
    String password2 = "Qw123wdwewrbghet";
//Missing uppercase letter
    String password3 = "qw123wdwewrbghet!";
//Missing lowercase letter
    String password4 = "QW123HYBJGFYV!";
//Missing numbers
    String password5 = "Qwwdwewrbghet!";

    UserRequestDto userDto1 = new UserRequestDto(login,password1);
    UserRequestDto userDto2 = new UserRequestDto(login,password2);
    UserRequestDto userDto3 = new UserRequestDto(login,password3);
    UserRequestDto userDto4 = new UserRequestDto(login,password4);
    UserRequestDto userDto5 = new UserRequestDto(login,password5);

    assertThrows(InvalidParameterException.class, () -> ValidationUtil.validate(userDto1));
    assertThrows(InvalidParameterException.class, () -> ValidationUtil.validate(userDto2));
    assertThrows(InvalidParameterException.class, () -> ValidationUtil.validate(userDto3));
    assertThrows(InvalidParameterException.class, () -> ValidationUtil.validate(userDto4));
    assertThrows(InvalidParameterException.class, () -> ValidationUtil.validate(userDto5));


}
}
