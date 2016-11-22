<%@page import="models.Material"%>
<%@page import="java.util.LinkedList"%>
<select required name="materialId">
    <option selected disabled>Capacidad</option>
    <%for (Material material : (LinkedList<Material>)request.getAttribute("materiales")) {%>
    <option value="<%= material.getClave() %>"><%= material.getCapacidad() %></option>
    <%}%>
</select>