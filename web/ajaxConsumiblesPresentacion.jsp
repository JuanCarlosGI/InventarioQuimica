<%@page import="models.Consumible"%>
<%@page import="java.util.LinkedList"%>
<select required>
    <option selected disabled onchange="ajaxConsumiblePresentacion(this.parentElement.parentElement.parentElement,this);">Presentaci�n</option>
    <%for (Consumible consumible : (LinkedList<Consumible>)request.getAttribute("consumibles")) {%>
    <option><%= consumible.getPresentacion() %></option>
    <%}%>
</select>