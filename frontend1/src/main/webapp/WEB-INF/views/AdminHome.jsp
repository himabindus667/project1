<%@include file="Header.jsp"%>

<h3 align="center">Admin Home Page</h3>
<pre><h1 align="center"><font face="Vinner hand Itc" color="blue" size=6>
		Welcome To Online Shopping
			</font>
	</h1>
</pre>

<div class = "row">

<c:forEach items="${productList}" var="product">

   
   <div class = "col-sm-5 col-sm-5">
            <img src = "<c:url value="/resources/images/${product.proId}.jpg"/>" alt = "Generic placeholder thumbnail">
   
    <p> ${product.proName}</p>
    <p> Price:  ${product.proprice}/-</p>
    <p> Stock: ${product.stock} /-</p>

    </div>  


</c:forEach>
</div>
</body>
</html>


</body>
</html>