<%@page import="models.Equipo"%>
<%@page import="java.util.LinkedList"%>
<select required name="equipoId">
    <option selected disabled>Marca</option>
    <%for (Equipo equipo : (LinkedList<Equipo>)request.getAttribute("equipos")) {%>
    <option value="<%= equipo.getClave() %>"><%= equipo.getMarca() %></option>
    <%}%>
</select>