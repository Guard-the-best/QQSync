package cn.edu.csu.dyp.Dto.user;

import cn.edu.csu.dyp.model.user.Address;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AddressDto {
    @NotEmpty
    private String username;
    @NotNull
    @Valid
    private Address address;
}
