<%@page import="models.Equipo"%>
<%@page import="java.util.LinkedList"%>
<select required>
    <option selected disabled name="equipoId">Marca</option>
    <%for (Equipo equipo : (LinkedList<Equipo>)request.getAttribute("equipos")) {%>
    <option value="<%= equipo.getClave() %>"><%= equipo.getMarca() %></option>
    <%}%>
</select>