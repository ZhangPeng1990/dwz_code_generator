<#include "/java_copyright.include"/>
<#include "/macro.include"/>
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${persistence}.beans;

import ${basepackage}.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

<#include "/annotation.include"/>
@Data
@EqualsAndHashCode(callSuper = false)
public class ${className} extends AbstractDO{
	<#list table.columns as column>
	<#if column.columnNameFirstLower != 'id' && column.columnNameFirstLower != 'insertTime' && column.columnNameFirstLower != 'updateTime'>
	private ${column.possibleShortJavaType} ${column.columnNameFirstLower};
	</#if>
	</#list>
}
