<form id="pagerForm" method="post" action="/${table.classNameFirstLowerBo}/list">
    <input type="hidden" name="keywords" value="$\{model.keywords}" />
    <input type="hidden" name="pageNum" value="$\{model.pageNum}" />
    <input type="hidden" name="pageSize" value="$\{model.pageSize}" />
</form>
<form method="post"  action="/${table.classNameFirstLowerBo}/list" onsubmit="return navTabSearch(this)">
    <div class="pageHeader" style="margin: 0">
        <div class="searchBar">
            <ul class="searchContent">
                <li>
                    <label>关键字：</label>
                    <input type="text" name="keywords" value="$\{model.keywords}"/>
                </li>
                <li>
                    <div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div>

                    <div class="buttonActive"><div class="buttonContent"><button type="button" onclick="resetForm(this, false)">重置搜索</button></div></div>
                </li>
            </ul>
        </div>
    </div>
</form>
<div class="pageContent">

    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" rel="newsLiNav" target="dialog" href="/${table.classNameFirstLowerBo}/toAdd" mask="true" height="550" width="820" title="添加通知" ><span>添加</span></a></li>
            <li><a class="delete" href="/${table.classNameFirstLowerBo}/remove/{selectedObjId}" target="ajaxTodo" warn="请选择一条记录" title="确认删除该条通知？操作不可逆！"
                   callback="function delCallback(json){reload(json);}"><span>删除</span></a></li>
            <li><a class="edit" href="/${table.classNameFirstLowerBo}/toUpdate/{selectedObjId}" mask="true" height="550" width="820" target="dialog" rel="userNav" warn="请选择一条记录"><span>编辑</span></a></li>
        </ul>
    </div>
    <table class="table" layoutH="111">
        <thead>
        <tr>
             <#list table.columns as column>
                 <#if column.columnNameFirstLower != 'id' && column.columnNameFirstLower != 'insertTime' && column.columnNameFirstLower != 'updateTime'>
                <th width="150">$\{item.${column.columnNameFirstLower}\}</th>
                 </#if>
             </#list>
        </tr>
        </thead>
        <tbody>
        <\#if page.list?exists && (page.size > 0)>
            <\#list page.list as item>
            <tr target="selectedObjId" rel="\\$\\{item.id\\}">
                <#list table.columns as column>
                    <#if column.columnNameFirstLower != 'id' && column.columnNameFirstLower != 'insertTime' && column.columnNameFirstLower != 'updateTime'>
                <td>$\{item.${column.columnNameFirstLower}}</td>
                    </#if>
                </#list>
                <td><\#if item.insertTime?exists>$\{item.insertTime?string("yyyy-MM-dd")}<\/#if></td>
                <td><\#if item.updateTime?exists>$\{item.updateTime?string("yyyy-MM-dd")}<\/#if></td>
            </tr>
            <\/#list>
        <\/#if>
        </tbody>
    </table>
<\#include "/common/pageBar.ftl"/>
</div>