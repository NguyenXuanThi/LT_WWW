<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>

<div class="content" style="padding:20px">
  <h2>Quản lý sản phẩm (xóa)</h2>

  <table border="1" cellpadding="5" cellspacing="0">
    <tr style="background:#ddd">
      <th>Mã</th><th>Tên</th><th>Năm SX</th><th>Hành động</th>
    </tr>
    <c:forEach var="dt" items="${listDT}">
      <tr>
        <td>${dt.maDT}</td>
        <td>${dt.tenDT}</td>
        <td>${dt.namSX}</td>
        <td>
          <form action="${pageContext.request.contextPath}/QuanLyFormServlet" method="post" style="margin:0">
            <input type="hidden" name="maDT" value="${dt.maDT}"/>
            <button type="submit" onclick="return confirm('Xóa ${dt.tenDT}?')">Xóa</button>
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>

<%@ include file="footer.jsp" %>
