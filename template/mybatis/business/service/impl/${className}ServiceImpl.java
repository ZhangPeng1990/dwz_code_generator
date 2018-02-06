<#include "/java_copyright.include"/>
<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ${basepackage}.business.entity.${table.classNameBo};
import ${basepackage}.business.service.${className}Service;
import ${basepackage}.business.vo.${table.classNameBo}ConditionVO;
import ${basepackage}.persistence.beans.${className};
import ${basepackage}.persistence.mapper.${className}Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

<#include "/annotation.include"/>
@Service
public class ${className}ServiceImpl implements ${className}Service{

    @Autowired
    private ${className}Mapper ${classNameLower}Mapper;

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    @Override
    public PageInfo<${table.classNameBo}>findPageBreakByCondition(${table.classNameBo}ConditionVO vo){
        PageHelper.startPage(vo.getPageNumber(),vo.getPageSize());
        List<${className}>list=${classNameLower}Mapper.findPageBreakByCondition(vo);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        List<${table.classNameBo}> boList = new ArrayList<>();
        for(${className} ${className?uncap_first} : list){
            boList.add(new ${table.classNameBo}(${className?uncap_first}));
        }
        PageInfo bean = new PageInfo<${className}>(list);
        bean.setList(boList);
        return bean;
    }

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     *
     * @param entity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ${table.classNameBo} insert(${table.classNameBo} entity){
        Assert.notNull(entity, "${table.classNameBo}不可为空！");
        entity.setUpdateTime(new Date());
        entity.setInsertTime(new Date());
        ${classNameLower}Mapper.insertSelective(entity.get${className}());
        return entity;
    }

    /**
     * 批量插入，支持批量插入的数据库可以使用，例如MySQL,H2等，另外该接口限制实体包含id属性并且必须为自增列
     *
     * @param entities
     */
    @Override
    public void insertList(List<${table.classNameBo}> entities){
        Assert.notNull(entities, "${table.classNameBo}s不可为空！");
        List<${className}> list = new ArrayList<>();
        for (${table.classNameBo} entity : entities) {
            entity.setUpdateTime(new Date());
            entity.setInsertTime(new Date());
        }
        ${classNameLower}Mapper.insertList(list);
    }

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     *
     * @param primaryKey
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeByPrimaryKey(Integer primaryKey){
        return ${classNameLower}Mapper.deleteByPrimaryKey(primaryKey) > 0;
    }

    /**
     * 根据主键更新实体全部字段，null值会被更新
     *
     * @param entity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(${table.classNameBo} entity){
        Assert.notNull(entity, "${table.classNameBo}不可为空！");
        entity.setUpdateTime(new Date());
        return ${classNameLower}Mapper.updateByPrimaryKey(entity.get${className}()) > 0;
    }

    /**
     * 根据主键更新属性不为null的值
     *
     * @param entity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateSelective(${table.classNameBo} entity){
        Assert.notNull(entity, "${table.classNameBo}不可为空！");
        entity.setUpdateTime(new Date());
        return ${classNameLower}Mapper.updateByPrimaryKeySelective(entity.get${className}()) > 0;
    }

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     * @param primaryKey
     * @return
     */
    @Override
    public ${table.classNameBo} getByPrimaryKey(Integer primaryKey){
        Assert.notNull(primaryKey, "PrimaryKey不可为空！");
        ${className} entity = ${classNameLower}Mapper.selectByPrimaryKey(primaryKey);
        return null == entity ? null : new ${table.classNameBo}(entity);
    }

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果时抛出异常，查询条件使用等号
     *
     * @param entity
     * @return
     */
    @Override
    public ${table.classNameBo} getOneByEntity(${table.classNameBo} entity){
        Assert.notNull(entity, "${table.classNameBo}不可为空！");
        ${className} bo = ${classNameLower}Mapper.selectOne(entity.get${className}());
        return null == bo ? null : new ${table.classNameBo}(bo);
    }

    /**
     * 查询全部结果，listByEntity(null)方法能达到同样的效果
     *
     * @return
     */
    @Override
    public List<${table.classNameBo}> listAll(){
        List<${className}> entityList = ${classNameLower}Mapper.selectAll();

        if (CollectionUtils.isEmpty(entityList)) {
            return null;
        }
        List<${table.classNameBo}> list = new ArrayList<>();
        for (${className} entity : entityList) {
            list.add(new ${table.classNameBo}(entity));
        }
        return list;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     *
     * @param entity
     * @return
     */
    @Override
    public List<${table.classNameBo}> listByEntity(${table.classNameBo} entity){
        Assert.notNull(entity, "${table.classNameBo}不可为空！");
        List<${className}> entityList = ${classNameLower}Mapper.select(entity.get${className}());
        if (CollectionUtils.isEmpty(entityList)) {
            return null;
        }
        List<${table.classNameBo}> list = new ArrayList<>();
        for (${className} po : entityList) {
            list.add(new ${table.classNameBo}(po));
        }
        return list;
    }
}
