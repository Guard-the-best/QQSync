package cn.edu.csu.dyp.Dto.order;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DeleteItemDto {
    @NotNull
    private Integer cartItemId;
}
