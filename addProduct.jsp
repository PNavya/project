
<%@include file="admin.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div align="center">
<div class="col-sm-9">
	<form:form action="addprod" method="POST" commandName="product"
		enctype="multipart/form-data">
		<table>
			<h2>Add Product</h2>
			<tr>
				<td>Product Id:</td>
				<c:choose>
					<c:when test="${!empty product.prodid}">
						<td><form:input path="prodid" disabled="true" readonly="true" /></td>
					</c:when>
					<c:otherwise>
						<td><form:input path="prodid" pattern="{4,7}" required="true"
								title="id should contain 4 to 7 characters" /></td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input type="text" path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="description">description</form:label></td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td><form:label path="price">price</form:label></td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td><form:label path="quantity">quantity</form:label></td>
				<td><form:input path="quantity" /></td>
			</tr>
			<tr>
				<td>Category Id:</td>
				<td><form:select path="category.catid" items="${categoryList}"
						itemValue="catid" itemLabel="catid"></form:select></td>
			</tr>
			<tr>
				<td>Supplier Id:</td>
				<td><form:select path="supplier.supId" items="${supplierList}"
						itemValue="supId" itemLabel="supId"></form:select></td>
			</tr>
			<tr>
				<td>ProductImage:</td>
				<td><form:input type="file" path="image" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /> <input
					type="submit" value="Cancel" /></td>
			</tr>
		</table>
	</form:form>
<br>
<h2>Product List</h2>
<c:if test="${!empty productList}">
	<table class="table table-striped">
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Description</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>category ID</th>
			<th>Supplier ID</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.prodid}</td>
				<td>${product.name}</td>
				<td>${product.description}</td>
				<td>${product.price}</td>
				<td>${product.quantity}</td>
				<td>${product.category.catid}</td>
				<td>${product.supplier.supId}</td>
				<td><a href="<c:url value='pupdate${product.prodid}'/>">Edit</a></td>
				<td><a href="<c:url value='proddelete${product.prodid}'/>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

</div>
</body>
</html>