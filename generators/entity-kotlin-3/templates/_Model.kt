package <%= groupCases.splitByDot %>.<%= nameCases.splitByDot %>.model

<%_ for (var e of enums) { _%>
import <%= groupCases.splitByDot %>.<%= nameCases.splitByDot %>.enums.<%= e.enumClass %>
<%_ } _%>
import io.swagger.annotations.ApiModelProperty
import com.baomidou.mybatisplus.annotation.FieldFill
import com.baomidou.mybatisplus.annotation.TableField

<%_ if (imports.isNullable) { _%>
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.IdType
<%_ } _%>
import javax.persistence.*

<%_ if (imports.BigDecimal) { _%>
import java.math.BigDecimal
<%_ } _%>
<%_ if (imports.Date) { _%>
import java.util.Date
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
@Table(name = "<%= tableName %>")
data class <%= entityClass %> (

    <%_ for (var i = 0; i < columns.length; i++) { _%>
        <%_ const column = columns[i] _%>
        <%_ if ('id' === column.COLUMN_NAME) { _%>
            <%_ if ('Int' === column.fieldType) { _%>
        @field:TableId(type = IdType.AUTO) 
            <%_ } else { _%> 
        @field:TableId(type = IdType.UUID) 
            <%_ } _%>
        var id: <%= column.fieldType %>? = null,
        <%_ } else { _%>
        @field:ApiModelProperty(value = "<%- column.COLUMN_COMMENT %>")
            <%_ if ('create_time' === column.COLUMN_NAME) { _%>
        @TableField(fill = FieldFill.INSERT)
            <%_ } _%>  
            <%_ if ('update_time' === column.COLUMN_NAME) { _%>
        @TableField(fill = FieldFill.INSERT_UPDATE)
            <%_ } _%>  
        var <%= column.fieldName%>: <%= column.fieldType %>? = null<%= comma(i, columns.length) _%>

        <%_ } _%>

    <%_ } _%>
)
