package cn.edu.csu.dyp.Dto.order;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CartDto {
    @NotEmpty
    private String username;
    @NotEmpty
    @Valid
    private CartItem[] cart;

    @Data
    public static class CartItem{
        @NotNull
        private Integer itemId;
        @NotNull
        private Integer quantity;
    }
}
