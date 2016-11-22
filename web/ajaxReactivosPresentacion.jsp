<%@page import="models.Reactivo"%>
<%@page import="java.util.LinkedList"%>
<select required onchange="ajaxReactivoPresentacion(this.parentElement.parentElement.parentElement,this);">
    <option selected disabled >Presentación</option>
    <%for (Reactivo reactivo : (LinkedList<Reactivo>)request.getAttribute("reactivos")) {%>
    <option><%= reactivo.getPresentacion() %></option>
    <%}%>
</select>