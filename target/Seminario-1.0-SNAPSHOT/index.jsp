<%@page import="com.emergentes.Semi"%>
<%@page import="java.util.ArrayList"%>
<%
    if (session.getAttribute("listaper") == null) {
        ArrayList<Semi> lisaux = new ArrayList<Semi>();
        session.setAttribute("listaper", lisaux);
    }
    ArrayList<Semi> lista = (ArrayList<Semi>) session.getAttribute("listaper");
%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html long="es">
    <head>

        <meta charset="UTF-8">
        <title>LISTADO DE INSCRITOS</title>
        <link rel="stylesheet" href="css/estilo.css">
    </head>
    <body>
        <div class="header">
            <p>PRACTICA 4</p>
            <p>Nombre: Ruben Condori Cosme</p>
            <p>Carnet: 7092342 L.P</p>


        </div>
        <h1>Listado de inscritos</h1>
        <a href="MainServlet?op=nuevo">Nuevo</a>
        <table>
            <tr>
                <th>id</th>
                <th>fecha</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Turno</th>
                <th>Seminario</th>

                <th></th>
                <th></th>
            </tr>
            <%
                if (lista != null) {
                    for (Semi item : lista) {

            %>
            <tr>
                <td><%= item.getId()%></td>


                <td><%= new SimpleDateFormat("dd-MM-yyyy").format(item.getFecha())%></td>
                <td><%= item.getNombre()%></td>
                <td><%= item.getApellidos()%></td>
                <td><%= new String(item.getTurno().getBytes(), "UTF-8")%></td>
                <td><%= item.getSeminarios()%></td>
                <td>
                    <a href="MainServlet?op=Editar&id=<%=item.getId()%>">Editar</a>
                </td>
                <td>
                    <a href="MainServlet?op=eliminar&id=<%=item.getId()%>"
                       onclick="return(confirm('¿Está seguro de eliminar?'))"
                       >Eliminar</a>
                </td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </body>
</html>
