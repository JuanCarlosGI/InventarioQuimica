<%@page import="models.Reactivo"%>
<%@page import="java.util.LinkedList"%>
<select required>
    <option selected disabled>Presentación</option>
    <%for (Reactivo reactivo : (LinkedList<Reactivo>)request.getAttribute("reactivos")) {%>
    <option><%= reactivo.getPresentacion() %></option>
    <%}%>
</select>