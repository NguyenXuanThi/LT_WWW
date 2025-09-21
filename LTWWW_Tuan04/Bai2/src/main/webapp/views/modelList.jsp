<%--
  Created by IntelliJ IDEA.
  User: Xuan Thi
  Date: 21/09/2025
  Time: 08:53 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<head>
    <title>Danh sách sản phẩm</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.3/css/bootstrap.min.css"
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        body {
            padding: 20px;
        }
        .product-card img {
            height: 200px;
            width: 150px;
            object-fit: cover;
            border-radius: 6px;
            align-self: center;

        }
    </style>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato; padding-left: 100px">
        <div class="navbar-brand">
            <a href="<%=request.getContextPath()%>" class="nav-link">Sample Shopping</a>
        </div>
    </nav>
</header>

<div class="container mt-4">
    <h3 class="text-center mb-4">Danh sách sản phẩm</h3>

    <div class="row row-cols-1 row-cols-md-3 g-4">
        <c:forEach var="product" items="${products}">
            <div class="col">
                <div class="card h-100 product-card">
                    <img src="${pageContext.request.contextPath}/${product.imgURL}" class="card-img-top" alt="${product.model}">
                    <div class="card-body">
                        <h5 class="card-title">${product.model}</h5>
                        <p class="card-text">
                            <fmt:formatNumber value="${product.price}" type="currency" currencySymbol="₫"/>
                        </p>
                    </div>
                    <div class="card-footer text-center">
                        <a href="${pageContext.request.contextPath}/cart?action=buy&id=${product.id}"
                           class="btn btn-success btn-sm">Mua</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>


