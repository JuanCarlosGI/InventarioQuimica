<%@page import="models.Consumible"%>
<%@page import="java.util.LinkedList"%>
<select required name="consumibleId">
    <option selected disabled>Contenido</option>
    <%for (Consumible consumible : (LinkedList<Consumible>)request.getAttribute("consumibles")) {%>
    <option value="<%= consumible.getClave()%>"><%= consumible.getContenido() %></option>
    <%}%>
</select>