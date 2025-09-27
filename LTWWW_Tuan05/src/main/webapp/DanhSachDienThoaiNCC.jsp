<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>

<div class="content" style="padding:20px">
    <h2>Danh sách điện thoại</h2>

    <!-- Form tìm kiếm -->
    <form action="${pageContext.request.contextPath}/DanhSachDienThoaiNCCServlet" method="get">
        <label>Nhập mã NCC: </label>
        <input type="text" name="maNCC"/>
        <button type="submit">Tìm</button>
        <a href="${pageContext.request.contextPath}/DanhSachDienThoaiNCCServlet">Xem tất cả</a>
    </form>
    <br/>

    <table border="1" cellpadding="5" cellspacing="0">
        <tr style="background:#ddd">
            <th>Mã</th><th>Tên</th><th>Năm SX</th><th>Cấu hình</th><th>Nhà CC</th><th>Hình ảnh</th>
        </tr>
        <c:forEach var="dt" items="${listDT}">
            <tr>
                <td>${dt.maDT}</td>
                <td>${dt.tenDT}</td>
                <td>${dt.namSX}</td>
                <td>${dt.cauHinh}</td>
                <td>${dt.maNCC}</td>
                <td>
                    <c:if test="${not empty dt.hinhAnh}">
                        <img src="${pageContext.request.contextPath}/images/${dt.hinhAnh}" width="100"/>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<%@ include file="footer.jsp" %>
