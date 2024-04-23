/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes;

import static com.sun.tools.javac.util.Constants.format;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author RUBEN
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String op = request.getParameter("op");
        Semi objper = new Semi();
        int id, pos;
        HttpSession ses = request.getSession();
        ArrayList<Semi> lista = (ArrayList<Semi>) ses.getAttribute("listaper");
        switch (op) {
            case "nuevo":
                //enivar un objeto vacio a editar
                request.setAttribute("miobjper", objper);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "Editar":
                //Enviar un objeto a editar pero con conternido
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request, id);
                objper = lista.get(pos);
                request.setAttribute("miobjper", objper);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar":
                //eliminar el registrp de la coleccion segun el id
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request, id);
                if (pos >= 0) {
                    lista.remove(pos);
                }
                request.setAttribute("listaper", lista);
                response.sendRedirect("index.jsp");
                ;
                break;
            default:

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession ses = request.getSession();
        ArrayList<Semi> lista = (ArrayList<Semi>) ses.getAttribute("listaper");
        Semi objper = new Semi();

        objper.setId(id);
        //Date fecha= new Date();
        //objper.setFecha (fecha);
        // Obtener la fecha del parámetro de solicitud
        String fechaStr = request.getParameter("fecha");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = sdf.parse(fechaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        objper.setFecha(fecha);

        objper.setNombre(request.getParameter("nombre"));
        objper.setApellidos(request.getParameter("apellidos"));
        //objper.setTurno(request.getParameter("turno"));
        String turno = request.getParameter("turno");
        System.out.println("Valor del turno: " + turno);
        objper.setTurno(turno);

        String[] seminariosSeleccionados = request.getParameterValues("seminarios[]");
        String seminariosConcatenados = String.join(",", seminariosSeleccionados);
        objper.setSeminarios(seminariosConcatenados);

        if (id == 0) {
            int idNuevo = obtenerId(request);
            objper.setId(idNuevo);
            lista.add(objper);

        } else {
            int pos = buscarPorIndice(request, id);
            lista.set(pos, objper);

        }
        request.setAttribute("listaper", lista);
        response.sendRedirect("index.jsp");

    }

    public int buscarPorIndice(HttpServletRequest request, int id) {
        HttpSession ses = request.getSession();
        ArrayList<Semi> lista = (ArrayList<Semi>) ses.getAttribute("listaper");
        int pos = -1;
        if (lista != null) {
            for (Semi ele : lista) {
                ++pos;
                if (ele.getId() == id) {
                    break;
                }

            }
        }
        return pos;
    }

    public int obtenerId(HttpServletRequest request) {
        HttpSession ses = request.getSession();
        ArrayList<Semi> lista = (ArrayList<Semi>) ses.getAttribute("listaper");
        int idn = 0;
        for (Semi ele : lista) {
            idn = ele.getId();
        }
        return idn + 1;
    }

}
