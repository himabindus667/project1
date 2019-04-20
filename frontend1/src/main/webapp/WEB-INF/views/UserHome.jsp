<%@include file="Header.jsp"%>

<h3 align="center"><strong>Welcome TO The Online Shopping</strong></h3>

<div class = "row">

<c:forEach items="${productList}" var="product">

   
   <div class = "col-sm-5 col-sm-5">
   <a href="<c:url value="/productDetailDisplay/${product.proId}"/>" class = "thumbnail">
         <img src = "<c:url value="/resources/images/${product.proId}.jpg"/>" alt = "Generic placeholder thumbnail">
    </a>
    <p><strong> ${product.proName}</strong></p>
    <p> Price: Rs ${product.proprice}/-</p>
    <p> Stock: ${product.stock}</p>

    </div>  


</c:forEach>
</div>


</body>
</html>