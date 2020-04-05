package cn.edu.csu.dyp.Util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel(description = "一个通用响应类")
public class BaseResponse{
    @ApiModelProperty(value = "返回的值，通常是一个User类,CartItem列表等")
    private Object data;
}
