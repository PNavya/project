<%@ include file="header.jsp"%>
<br>
<center>
<div class="container shadow" style="background-color:white;min-width:860px">
<c:if test="${!empty billingmessage}">
<p style="margin-top:10px;background-color:#F3E690">${billingmessage}</p>
</c:if>
<c:choose>
<c:when test="${!empty billingaddresses}">
<p style="margin-top:10px"><b style="font-size:17px">Delivery Address</b></p>
 <div class="row" style="width:810px;margin-top:8px">
 <c:forEach items="${billingaddresses}" var="address">
  <div class="col-md-4">
  <span style="float:right;margin-bottom:5px"><a href="editaddress${address.id}" style="margin-right:25px"><span class="glyphicon glyphicon-pencil"></span></a>
  <a href="removeaddress${address.id}"><span class="glyphicon glyphicon-trash"></span></a></span>
    <hr class="style14" style="margin-bottom:5px"> 
    <a href="" class="thumbnail w" style="text-align:left;color:black;background-color:white">
      <p>${address.houseno}<br>${address.street}<br>${address.city}<br>${address.state}<br>${address.country}<br>${address.zip}</p> 
    <%--  <p><span style="font-size:16px">${address.name}</span><br><hr class="style14">H.No:${address.houseno},${address.street}<br>${address.zip},${address.city}<br>${address.state},${address.country}<hr class="style14"><span style="font-size:16px">${address.contact}</span></p>
   --%>
    </a>

  </div>
  
  </c:forEach>
</div>
<hr class="style14">
<a href="#" class="btn btn-link shadow" style="text-decoration:none;background-color:#FAF9F5;height:37px">+ ADD NEW ADDRESS</a>
<br><br>
</c:when>

</c:choose>

</div>
</center>
<br>


<%@ include file="footer.jsp"%>