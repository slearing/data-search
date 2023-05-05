package vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 下拉框的统一返回值
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DropdownVo {
    //下拉框的代码值
    private String codeValue;
    //下拉框的显示值
    private String codeName;
}
