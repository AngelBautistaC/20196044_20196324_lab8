
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

                        <% if (canciones.getLike()==0){  %>
                        <form method="POST" action="<%=request.getContextPath()%>/listaCanciones?a=likear">
                        <input type="hidden" name="idcancion" value="<%=canciones.getIdreproduccion()%>" />
                        <input type="hidden" name="cancion" value="<%=canciones.getCancion()%>" />
                        <input type="hidden" name="banda" value="<%=canciones.getBanda()%>" />
                        <input type="hidden" class="form-control" name="like" id="like" value="<%=canciones.getLike()%>">
                        <button type="submit" class="btn btn-success"> Me gusta 👍</button>
                        </form>
                        <% } %>
                        <% if (canciones.getLike()==1){  %>
                        <form method="POST" action="<%=request.getContextPath()%>/listaCanciones?a=dislike">
                            <input type="hidden" name="idcancion1" value="<%=canciones.getIdreproduccion()%>" />
                            <input type="hidden" name="cancion1" value="<%=canciones.getCancion()%>" />
                            <input type="hidden" name="banda1" value="<%=canciones.getBanda()%>" />
                        <input type="hidden" class="form-control" name="like1" id="like1" value="<%=canciones.getLike()%>">
                        <button type="submit" class="btn btn-danger">Ya no me gusta</button>
                        </form>
                        <% } %>



                </td>

            </tr>
            <% } %>
        </table>
    </div>
</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>