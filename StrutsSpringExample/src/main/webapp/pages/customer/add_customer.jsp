<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html>
<head>
<script>
function showResult(){
	
	if('${result}'!=''){
		alert('${result}');	
	}
}
</script>
</head>
<body onload="showResult();">
<h1>Struts + Spring + Hibernate example</h1>

<h2>${methodName} Customer</h2>
<div style="color:red">
	<html:errors/>
</div>

<html:form action="/HandleCustomer.do?method=save${methodName}">

<div style="padding:16px">
	<div style="float:left;width:100px;">
		<bean:message key="customer.label.name" /> : 
	</div> 
 
	<html:text property="name" size="40" maxlength="20" value="${name}"/>
</div>

<div style="padding:16px">
	<div style="float:left;width:100px;">
		<bean:message key="customer.label.address" /> : 
	</div> 
 
	<html:textarea property="address" cols="50" rows="10" value="${address}"/>
</div>
 
<div style="padding:16px">
	<div style="float:left;padding-right:8px;">
		<html:submit>
             <bean:message key="customer.label.button.submit" />
        </html:submit>
	</div>
	<html:reset>
          <bean:message key="customer.label.button.reset" />
     </html:reset>
</div>
<input type="hidden" name="customerId" value="${customerId}"/>
<input type="hidden" name="createdDate" value="${createdDate}"/>
</html:form>
 
</body>
</html>