<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>

<div class="content" style="padding:20px">
    <h2>Thêm điện thoại mới</h2>

    <form action="${pageContext.request.contextPath}/DienThoaiFormServlet"
          method="post" enctype="multipart/form-data">
        <label>Mã ĐT:</label><br/>
        <input type="text" name="maDT" required/><br/><br/>

        <label>Tên ĐT:</label><br/>
        <input type="text" name="tenDT" required/><br/><br/>

        <label>Năm SX:</label><br/>
        <input type="text" name="namSX" pattern="[0-9]{4}" title="Nhập năm 4 chữ số" required/><br/><br/>

        <label>Cấu hình:</label><br/>
        <input type="text" name="cauHinh" maxlength="255" required/><br/><br/>

        <label>Mã NCC:</label><br/>
        <input type="text" name="maNCC" required/><br/><br/>

        <label>Hình ảnh:</label><br/>
        <input type="file" name="hinhAnh" accept=".png,.jpg,.jpeg" required/><br/><br/>

        <button type="submit">Thêm</button>
    </form>

    <c:if test="${not empty error}">
        <p style="color:red">${error}</p>
    </c:if>
</div>

<%@ include file="footer.jsp" %>
