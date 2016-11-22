<%@page import="models.Consumible"%>
<%@page import="java.util.LinkedList"%>
<select required>
    <option selected disabled onchange="ajaxConsumibleMarca(this.parentElement.parentElement.parentElement,this);">Marca</option>
    <%for (Consumible consumible : (LinkedList<Consumible>)request.getAttribute("consumibles")) {%>
    <option><%= consumible.getMarca() %></option>
    <%}%>
</select>
