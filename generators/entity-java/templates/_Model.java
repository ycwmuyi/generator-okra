package <%= groupCases.splitByDot %>.<%= nameCases.splitByDot %>.model;

<%_ for (var e of enums) { _%>
import <%= groupCases.splitByDot %>.<%= nameCases.splitByDot %>.enums.<%= e.enumClass %>;
<%_ } _%>
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
<%_ if (imports.isNullable) { _%>
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiParam;
<%_ } _%>
<%_ if (imports.BigDecimal) { _%>
import java.math.BigDecimal;
<%_ } _%>
<%_ if (imports.Date) { _%>
import java.util.Date;
<%_ } _%>
<%_
// CreateTime, UpdateTime 取消 @NotNull 注解
function isIgnoreNotNull(columnName) {
  return columnName === 'create_time' || columnName === 'update_time'
}
// 逗号，i 是当前循环次数，limit 是最大循环次数，最后一次不加逗号
function comma(i, limit) {
  if (i < limit - 1) {
    return ','
  } else {
    return ''
  }
}
_%>

/**
 * Entity <%= entityClass %>. <%= tableComment %>
 *
 * @author duiker(generated)
 */
@Data
public class <%= entityClass %> {

    <%_ for (var i = 0; i < columns.length; i++) { _%>
        <%_ const column = columns[i] _%>
        <%_ if ('id' === column.COLUMN_NAME) { _%>
            <%_ if ('Int' === column.fieldType) { _%>
        @TableId(type = IdType.AUTO)
            <%_ } else { _%> 
        @TableId(type = IdType.UUID)
            <%_ } _%>
        private <%= column.fieldType %> id;    
        <%_ } else { _%>
            <%_ if ('NO' === column.IS_NULLABLE && !isIgnoreNotNull(column.COLUMN_NAME)) { _%>
        @NotNull
        @ApiParam(required = true)
            <%_ } _%>  
        @ApiModelProperty(value = "<%- column.COLUMN_COMMENT %>")
            <%_ if ('create_time' === column.COLUMN_NAME) { _%>
        @TableField(fill = FieldFill.INSERT)
            <%_ } _%>  
            <%_ if ('update_time' === column.COLUMN_NAME) { _%>
        @TableField(fill = FieldFill.INSERT_UPDATE)
            <%_ } _%>  
        private <%= column.fieldType %> <%= column.fieldName%>;
        <%_ } _%>

    <%_ } _%>
}
