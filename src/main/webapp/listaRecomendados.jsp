<%@ page import="Beans.Reproduccion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Reproduccion>" scope="request" id="listaRecomendados"/>
<html>
<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Recomendados :D"/>
</jsp:include>
<head>

</head>
<body>
<div class='container'>
    <jsp:include page="/includes/navbar.jsp">
        <jsp:param name="page" value="Recomendados"/>
    </jsp:include>
    <div class="pb-5 pt-4 px-3 titlecolor">
        <div class="col-lg-6">
            <h1 class='text-light'>Lista de Recomendaciones</h1>
        </div>
    </div>
    <div class="tabla">
        <table class="table table-dark table-transparent table-hover">
            <thead>
            <th>ID</th>
            <th>Cancion</th>
            <th>Banda</th>
            <th>Ver</th>
            </thead>
            <%
                for (Reproduccion recom : listaRecomendados) {
            %>
            <tr>
                <td><%=recom.getIdreproduccion()%>
                </td>
                <td><%=recom.getCancion()%>
                </td>
                <td><%=recom.getBanda()%>
                </td>



            </tr>
            <%
                }
            %>
        </table>
    </div>
</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>
