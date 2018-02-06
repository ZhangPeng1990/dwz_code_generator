<#include "/java_copyright.include"/>
<#include "/macro.include"/>
package ${basepackage}.business.vo;

import ${basepackage}.framework.object.BaseConditionVO;
import ${basepackage}.business.entity.${table.classNameBo};
import lombok.Getter;
import lombok.Setter;
<#assign po = table.classNameFirstLower>

<#include "/annotation.include"/>
@Getter
@Setter
public class ${table.classNameBo}ConditionVO extends BaseConditionVO {
	private ${table.classNameBo} ${table.classNameBo?uncap_first};
}

