<#include "/java_copyright.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.${persistence}.mapper;

import ${basepackage}.business.vo.${table.classNameBo}ConditionVO;
import ${basepackage}.${persistence}.beans.${className};
import ${basepackage}.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

<#include "/annotation.include"/>
@Repository
public interface ${className}Mapper extends BaseMapper<${className}>{

    /**
     * 分页查询
     * @param vo
     *
     * @return
     */
    List<${className}> findPageBreakByCondition(${table.classNameBo}ConditionVO vo);
}
