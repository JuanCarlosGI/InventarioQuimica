<%@page import="models.Consumible"%>
<%@page import="java.util.LinkedList"%>
<select required>
    <option selected disabled name="consumibleId">Marca</option>
    <%for (Consumible consumible : (LinkedList<Consumible>)request.getAttribute("consumibles")) {%>
    <option value="<%= consumible.getClave()%>"><%= consumible.getContenido() %></option>
    <%}%>
</select>