<%@page import="models.Material"%>
<%@page import="java.util.LinkedList"%>
<select required onchange="ajaxMaterialMarca(this.parentElement.parentElement.parentElement,this);">
    <option selected disabled >Marca</option>
    <%for (Material material : (LinkedList<Material>)request.getAttribute("materiales")) {%>
    <option><%= material.getMarca() %></option>
    <%}%>
</select>
