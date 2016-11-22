<%@page import="models.Reactivo"%>
<%@page import="java.util.LinkedList"%>
<select required name="reactivoId">
    <option selected disabled>Contenido</option>
    <%for (Reactivo reactivo : (LinkedList<Reactivo>)request.getAttribute("reactivos")) {%>
    <option value="<%=reactivo.getClave()%>"><%= reactivo.getContenido() %></option>
    <%}%>
</select>