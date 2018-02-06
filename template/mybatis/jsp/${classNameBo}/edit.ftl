<#macro mapperEl value>${r"${"}${value}}</#macro>
<div class="pageContent">
<form method="post" action="${table.classNameFirstLowerBo}/update?callbackType=closeCurrent&navTabId=websiteLiNav" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
	<div class="pageFormContent" layoutH="56">
		<#list table.columns as column>
			<#if column.columnName != "Id">
		<p>
			<label>${column.columnName}: </label>
			<input type="text" name="${column.columnNameFirstLower}" value="<@mapperEl table.classNameFirstLowerBo+'.'+column.columnNameFirstLower/>"/>
		</p>
			</#if>
		</#list>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>