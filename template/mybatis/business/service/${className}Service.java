<#include "/java_copyright.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.business.service;


import ${basepackage}.framework.object.AbstractService;
import ${basepackage}.business.entity.${table.classNameBo};
import ${basepackage}.business.vo.${table.classNameBo}ConditionVO;
import com.github.pagehelper.PageInfo;

<#include "/annotation.include"/>
public interface ${className}Service extends AbstractService<${table.classNameBo}, Integer> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<${table.classNameBo}> findPageBreakByCondition(${table.classNameBo}ConditionVO vo);
}
