package cn.edu.csu.dyp.Dto.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LoginDto {
    @NotEmpty
    private String username;
    @NotNull
    private String password;
}
