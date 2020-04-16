package cn.edu.csu.dyp.Dto.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UsernameDto {
    @NotEmpty
    private String oldUsername;
    @NotEmpty
    private String newUsername;
    @NotNull
    private String password;
}
