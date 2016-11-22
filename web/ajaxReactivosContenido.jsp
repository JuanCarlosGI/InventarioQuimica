<%@page import="models.Reactivo"%>
<%@page import="java.util.LinkedList"%>
<select required>
    <option selected disabled name="reactivoId">Contenido</option>
    <%for (Reactivo reactivo : (LinkedList<Reactivo>)request.getAttribute("reactivos")) {%>
    <option value="<%=reactivo.getClave()%>"><%= reactivo.getContenido() %></option>
    <%}%>
</select>