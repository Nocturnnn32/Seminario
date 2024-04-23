
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.emergentes.Semi"%>
<%
    Semi reg = (Semi) request.getAttribute("miobjper");
%>

<%@ page contentType="text/html; charset=UTF-8" %>


<!DOCTYPE html>
<html long="es">
    <head>
        <meta charset="UTF-8">
        <title>REGISTRO DE SEMINARIOS</title>
        <link rel="stylesheet" href="css/estilo2.css">
    </head>
    <body>
        <div class="header">
            <p>PRACTICA 4</p>
            <p>Nombre: Ruben Condori Cosme</p>
            <p>Carnet: 7092342 L.P</p>
        </div>
        <h1>Registro de Seminarios</h1>
        <form action="MainServlet" method="post" accept-charset="UTF-8">
            <section class="datos">
                <h2>Tus datos</h2>
                <label for="id">ID:</label>
                <input type="text" name="id" value="<%= reg.getId()%>" size="2" readonly>

                <label for="fecha">Fecha:</label>
                <input type="date" id="fecha" name="fecha" value="<%= reg.getFecha() != null ? new SimpleDateFormat("dd-MM-yyyy").format(reg.getFecha()) : ""%>" required>

                <label for="nombre">Nombre:</label>
                <input type="text" name="nombre" value="<%= reg.getNombre()%>" required>
                <label for="apellidos">Apellidos:</label>
                <input type="text" name="apellidos" value="<%= reg.getApellidos()%>" required>

                <label for="turno">Turno:</label>
                <div  style="display: flex; justify-content: center;">
                    <label>
                        <input type="radio" name="turno" value="Mañana"  required> Mañana
                    </label><br>
                    <label>
                        <input type="radio" name="turno" value="Tarde"> Tarde
                    </label><br>
                    <label>
                        <input type="radio" name="turno" value="Noche"> Noche
                    </label><br>
                </div>
                

            </section>
            <section class="seminarios">
                <h2>Seminarios disponibles</h2>
                <ul>
                    <li>
                        <input type="checkbox" id=" inteligencia artificial " name="seminarios[]" value=" inteligencia artificial ">
                        <label for=" inteligencia artificial ">Inteligencia Artificial</label>
                    </li>
                    <li>
                        <input type="checkbox" id=" machine learning " name="seminarios[]" value=" machine learning ">
                        <label for=" machine learning ">Machine Learning</label>
                    </li>
                    <li>
                        <input type="checkbox" id=" simulacion con arena " name="seminarios[]" value=" simulacion con arena ">
                        <label for="simulacion con arena">Simulación con Arena</label>
                    </li>
                    <li>
                        <input type="checkbox" id=" robotica educativa " name="seminarios[]" value=" robotica educativa ">
                        <label for=" robotica educativa ">Robótica Educativa</label>
                    </li>
                </ul>
            </section>
            <button type="submit">Enviar Registro</button>
        </form>
    </body>
</html>
