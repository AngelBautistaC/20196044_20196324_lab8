
<%@ page import="Beans.Reproduccion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Reproduccion>" scope="request" id="listaCompleta"/>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">


<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value=" :D"/>
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
            <h1 class='text-light'>Lista de canciones</h1>
        </div>
    </div>
    <div class="tabla">
        <table class="table table-dark table-transparent table-hover">
            <thead>
            <th>ID</th>
            <th>Cancion</th>
            <th>Banda</th>

            </thead>
            <%
                for (Reproduccion canciones : listaCompleta) {
            %>
            <tr>
                <td><%=canciones.getIdreproduccion()%>
                </td>
                <td><%=canciones.getCancion()%>
                </td>
                <td><%=canciones.getBanda()%>
                </td>
                <td>

                    <button type="button" class="btn btn-success" data-toggle="button" aria-pressed="false" autocomplete="off">
                        👍
                    </button>
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