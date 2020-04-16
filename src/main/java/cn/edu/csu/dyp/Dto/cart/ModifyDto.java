package cn.edu.csu.dyp.Dto.cart;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ModifyDto {
    @NotEmpty
    private String username;
    @NotNull
    private Integer delta;
}
