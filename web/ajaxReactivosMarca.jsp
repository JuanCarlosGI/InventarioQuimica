<%@page import="models.Reactivo"%>
<%@page import="java.util.LinkedList"%>
<select required>
    <option selected disabled onchange="ajaxReactivoMarca(this.parentElement.parentElement.parentElement,this);">Marca</option>
    <%for (Reactivo reactivo : (LinkedList<Reactivo>)request.getAttribute("reactivos")) {%>
    <option><%= reactivo.getMarca() %></option>
    <%}%>
</select>