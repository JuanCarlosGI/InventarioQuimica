<%@page import="models.Consumible"%>
<%@page import="java.util.LinkedList"%>
<select required onchange="ajaxConsumiblePresentacion(this.parentElement.parentElement.parentElement,this);">
    <option selected disabled >Presentación</option>
    <%for (Consumible consumible : (LinkedList<Consumible>)request.getAttribute("consumibles")) {%>
    <option><%= consumible.getPresentacion() %></option>
    <%}%>
</select>