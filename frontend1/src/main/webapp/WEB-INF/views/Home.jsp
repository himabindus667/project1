<%@include file="Header.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<body>

<center><h3><strong>Welcome to the Home Page</strong></h3></center>

<spring:url var="css" value="/assets/css" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<div class="container text-center"> 
  <h3>Trending Fashions</h3><br>
  <div class="row">
    <div class="col-sm-4">
      <img src="${images}/128.jpg" class="img-responsive" style="width:100%" alt="Image">
      
      <h3>&#x20B9;1500-2000</h3>
      <h4 class="h"><strong>Sport Shoes</strong></h4>
    </div>
    <div class="col-sm-4"> 
      <img src="${images}/155.jpg" class="img-responsive" style="width:100%" alt="Image">
       
      <h3>&#x20B9;399-1599</h3> 
      <h4 class="h"><strong>Skirts</strong></h4>  
    </div>
   <div class="col-sm-4">
      <img src="${images}/129.jpg" class="img-responsive" style="width:100%" alt="Image">
      
      <h3>&#x20B9;2000-10,000</h3>
      <h4 class="h"><strong>Jackets</strong></h4>
    </div>
    <div class="col-sm-4"> 
      <img src="${images}/143.jpg" class="img-responsive" style="width:100%" alt="Image">
       
      <h3>&#x20B9;799-2000</h3>   
      <h4 class="h"><strong>Frocks</strong></h4>
    </div>
    <br>
    <div class="col-sm-4">
      <img src="${images}/144.jpg" class="img-responsive" style="width:100%" alt="Image">
    
      <h3>&#x20B9;399-9,999</h3>
      <h4 class="h"><strong>Lehenga</strong></h4>
    </div>
    <div class="col-sm-4"> 
      <img src="${images}/147.jpg" class="img-responsive" style="width:100%" alt="Image">
       
      <h3>&#x20B9;500-5000</h3>   
      <h4 class="h"><strong>Watches</strong></h4>
    </div>
    <div class="col-sm-4">
      <img src="${images}/156.jpg" class="img-responsive" style="width:100%" alt="Image">
     
      <h3>&#x20B9;399-999</h3>
      <h4 class="h"><strong>TShirts</strong></h4>
    </div>
    
    <br>
	</div>
	</div>
</body>
</html>