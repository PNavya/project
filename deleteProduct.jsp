<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
</head>
<body>
<h2>Deleting Product</h2>
  <form:form method="POST" action="removeprod" commandName="product">
      <table>
       <tr>
           <td>Product ID:</td>
           <td><form:input type="text" path="prodid" /></td>
       </tr>
       <tr>
        <td>&nbsp;</td>
         <td><input type="submit" value="Submit"/></td>
         </tr>
   </table> 
 </form:form>
</body>
</html>