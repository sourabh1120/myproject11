<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color:blue; text-align:center">Employee edit form</h1>

<frm:form modelAttribute="emp">
<table  border="1" bgcolor="yellow" align="center">
	
	
	<tr>
		<td>Employee no::</td>
		<td><frm:input path="empno" readonly="true"/>	</td>
	</tr>
	
	<tr>
		<td>Employee name::</td>
		<td><frm:input path="ename"/>	</td>
	</tr>
	
	<tr>
		<td>Employee job::</td>
		<td><frm:input path="ejob"/>	</td>
	</tr>
	
	<tr>
		<td>Employee salary::</td>
		<td><frm:input path="esalary"/>	</td>
	</tr>
	
	<tr>
		<td>Employee department::</td>
		<td><frm:input path="edeptno"/>	</td>
	</tr>
	<tr>
		<td><input type="submit" value="edit employee"></td>
	</tr>
	
</table>
</frm:form>