<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<head>
    <title>Shopping Cart</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.3/css/bootstrap.min.css"
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
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
        .cart-footer {
            display: flex;
            justify-content: space-between;
            align-items: center;
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
    <h3 class="text-center mb-4">Giỏ hàng của bạn</h3>

    <c:set var="total" value="0"/>
    <div class="row row-cols-1 row-cols-md-3 g-4">
        <c:forEach var="item" items="${sessionScope.cart}">
            <c:set var="total" value="${total + item.product.price * item.quantity}"/>
            <div class="col">
                <div class="card h-100 cart-card">
                    <img src="${pageContext.request.contextPath}/${item.product.imgURL}" class="card-img-top" alt="${item.product.model}">
                    <div class="card-body">
                        <h5 class="card-title">${item.product.model}</h5>
                        <p class="card-text">
                            Giá: <fmt:formatNumber value="${item.product.price}" type="currency" currencySymbol="₫"/><br/>
                            Số lượng: ${item.quantity}<br/>
                            Thành tiền: <fmt:formatNumber value="${item.product.price * item.quantity}" type="currency" currencySymbol="₫"/>
                        </p>
                    </div>
                    <div class="card-footer cart-footer">
                        <a href="${pageContext.request.contextPath}/cart?action=remove&id=${item.product.id}"
                           class="btn btn-danger btn-sm"
                           onclick="return confirm('Bạn có chắc muốn xóa sản phẩm này?')">Xóa</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <div class="mt-4 text-end">
        <h5>Tổng tiền: <fmt:formatNumber value="${total}" type="currency" currencySymbol="₫"/></h5>
        <a href="${pageContext.request.contextPath}/products" class="btn btn-primary mt-2">Tiếp tục mua sắm</a>
    </div>
</div>

</body>
</html>
