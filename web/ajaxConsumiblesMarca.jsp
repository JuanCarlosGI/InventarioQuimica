<%@page import="models.Consumible"%>
<%@page import="java.util.LinkedList"%>
<select required onchange="ajaxConsumibleMarca(this.parentElement.parentElement.parentElement,this);">
    <option selected disabled>Marca</option>
    <%for (Consumible consumible : (LinkedList<Consumible>)request.getAttribute("consumibles")) {%>
    <option><%= consumible.getMarca() %></option>
    <%}%>
</select>
