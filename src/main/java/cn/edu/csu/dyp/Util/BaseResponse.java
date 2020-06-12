package cn.edu.csu.dyp.Util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@ApiModel(description = "一个通用响应类")
public class BaseResponse{
    private Timestamp timestamp;
    private Integer status;
    @ApiModelProperty(value = "返回的值，通常是一个User类,CartItem列表等")
    private Object data;

    public BaseResponse(Object data) {
        this.timestamp=new Timestamp(System.currentTimeMillis());
        this.status=200;
        this.data = data;
    }
}
