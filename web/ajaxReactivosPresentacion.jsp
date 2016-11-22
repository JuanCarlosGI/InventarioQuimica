<%@page import="models.Reactivo"%>
<%@page import="java.util.LinkedList"%>
<select required>
    <option selected disabled onchange="ajaxReactivoPresentacion(this.parentElement.parentElement.parentElement,this);">Presentación</option>
    <%for (Reactivo reactivo : (LinkedList<Reactivo>)request.getAttribute("reactivos")) {%>
    <option><%= reactivo.getPresentacion() %></option>
    <%}%>
</select>