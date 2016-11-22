<%@page import="models.Material"%>
<%@page import="java.util.LinkedList"%>
<select required>
    <option selected disabled>Marca</option>
    <%for (Material material : (LinkedList<Material>)request.getAttribute("materiales")) {%>
    <option><%= material.getMarca() %></option>
    <%}%>
</select>
