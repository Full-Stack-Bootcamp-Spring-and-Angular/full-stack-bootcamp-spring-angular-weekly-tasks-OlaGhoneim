package main.com.myApp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Component
@Setter
@Getter
public class UserModel
{
    @NotNull(message="Username is required")
    private String username;

    @Pattern(
            regexp = "^(.+)@(\\S+)$",
            message = "Enter a valid email, please!"
    )
    @NotNull(message="Email is required !")
    private String email;
    @NotNull(message="password is required !")
    private String password;
    @NotNull(message=" confirmPassword is required !")
    private String confirmPassword;
}
/**
 * 1- define UserModel inside the model object (/showForm)
 * 2- linking between the fields inside the jsp page and attributes inside the jsp page
 * 3- recieve the UserModel object inside the /process after filling it in the form page
 */
