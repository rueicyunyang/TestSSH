<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
 
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
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

<h2>List All Customers</h2>
	<div class="container">
	  	<div class="row">
			<table class="table table-striped">
			<thead>
			<tr align="center"><td>Customer Name</td><td>Address</td></tr>
			</thead>

			<logic:iterate id="customer" name="customerList">
			<tr align="center">	
			<td width="40%"><bean:write name="customer" property="name"/></td>
			<td width="40%"><bean:write name="customer" property="address"/></td>
			<td width="20%">
				<html:form action="/AddCustomer.do?method=edit">
					<button type="submit" class="btn btn-success">
						edit
					</button>
					<input type="hidden" name="customerId" value="<bean:write name="customer" property="customerId"/>"/>
					<input type="hidden" name="name" value="<bean:write name="customer" property="name"/>"/>
					<input type="hidden" name="address" value="<bean:write name="customer" property="address"/>"/>
					<!-- 原本還有createdDate，其型別是Date，但表單內的createdDate，型別會變成字串，
					這樣要將createdDate寫入ActionForm時就會因為型別沒對到而出錯 -->
				</html:form>
				<html:form action="/HandleCustomer.do?method=delete">
					<button type="submit" class="btn btn-danger">
						delete
					</button>
					<input type="hidden" name="customerId" value="<bean:write name="customer" property="customerId"/>"/>
					<input type="hidden" name="name" value="<bean:write name="customer" property="name"/>"/>
					<input type="hidden" name="address" value="<bean:write name="customer" property="address"/>"/>
				</html:form>
			</td>
			</tr>
			</logic:iterate> 
			
			</table>
			
			<br/>
			<br/>
			<html:link action="/AddCustomer.do?method=add">
				<button type="button" class="btn btn-primary">
					Add Customer
				</button>
			</html:link>

		</div>
	</div> 
</body>
</html>