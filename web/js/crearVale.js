function agregarFila() {
	var table = document.getElementById('vale');
	var row = table.insertRow();
	var index = row.rowIndex + 1;
	row.id = "producto-" + index;

	var cellTipo = row.insertCell();

	var selectList = document.createElement("select");
	selectList.required = true;
	selectList.setAttribute("onchange", "escogerProducto(this, this.parentElement.parentElement.parentElement)");


	var option = document.createElement("option");
	option.disabled = true;
	option.text = "Tipo";
	selectList.appendChild(option);


	option = document.createElement("option");
	option.setAttribute("value", "Material");
	option.text = "Material";
	selectList.appendChild(option);

	option = document.createElement("option");
	option.setAttribute("value", "Equipo");
	option.text = "Equipo";
	selectList.appendChild(option);

	option = document.createElement("option");
	option.setAttribute("value", "Consumible");
	option.text = "Consumible";
	selectList.appendChild(option);

	option = document.createElement("option");
	option.setAttribute("value", "Reactivo");
	option.text = "Reactivo";
	selectList.appendChild(option);
	

	cellTipo.appendChild(selectList);
	$('select').material_select();
}

function escogerProducto(list, e) {
	var tipo = list.value;

	var primerCelda = e.childNodes[0];

	while (e.hasChildNodes()) {
    	e.removeChild(e.lastChild);
	}

	e.appendChild(primerCelda);
	
	switch(tipo) {
	    case "Material":
	        appendMaterial(e);
	        break;
	    case "Equipo":
	        appendEquipo(e);
	        break;
	    case "Consumible":
	        appendReactivo(e);
	        break;
	    case "Reactivo":
	        appendReactivo(e);
	        break;
	}
}

function appendMaterial(e) {
	//clave
	//nombre
	//marca
	//capacidad
	//cantidad
	//observaciones

	//-----------SELECT nombre material-----------
	//crear celda
	var cellNombre = e.insertCell();

	//crear select
	var selectNombre = document.createElement("select");
	selectNombre.required = true;

	//crear opcion default
	var option = document.createElement("option");
	option.disabled = true;
	option.text = "Nombre";
	selectNombre.appendChild(option);

	//for loop con datos de la base de datos
	option = document.createElement("option");
	option.setAttribute("value", "CODIGO");
	option.text = "NOMBRE MATERIAL";
	selectNombre.appendChild(option);

	//agregar select a celda
	cellNombre.appendChild(selectNombre);

	//-----------SELECT marca material
	//crear celda
	var cellMarca = e.insertCell();

	//crear select
	var selectMarca = document.createElement("select");
	selectMarca.required = true;

	//crear opcion default
	var option = document.createElement("option");
	option.disabled = true;
	option.text = "Marca";
	selectMarca.appendChild(option);

	//for loop con datos de la base de datos
	option = document.createElement("option");
	option.setAttribute("value", "marca");
	option.text = "NOMBRE MARCA";
	selectMarca.appendChild(option);

	//agregar select a celda
	cellMarca.appendChild(selectMarca);

	//-----------INPUT capacidad-----------
	//crear celda
	var cellCapacidad = e.insertCell();

	//crear input
	var input = document.createElement("input");
	input.setAttribute("type", "text");
	input.placeholder = "Capacidad";

	//agregar input a celda
	cellCapacidad.appendChild(input);

	//----------INPUT cantidad-----------
	//crear celda
	var cellCantidad = e.insertCell();

	input = document.createElement("input");
	input.setAttribute("type", "text");
	input.placeholder = "Cantidad";

	//agregar input a celda
	cellCantidad.appendChild(input);

	//----------INPUT observaciones-----------
	//crear celda
	var cellObservaciones = e.insertCell();

	input = document.createElement("input");
	input.setAttribute("type", "text");
	input.placeholder = "Observaciones";

	//agregar input a celda
	cellObservaciones.appendChild(input);

	//----------BUTTON delete-----------
	//crear celda
	var cellDelete = e.insertCell();

	var button = document.createElement("button");
	button.setAttribute("class", "btn waves-effect waves-light red");
	button.setAttribute("name", "action");
	button.setAttribute("onclick", "this.parentElement.parentElement.parentElement.deleteRow(this.parentElement.parentElement.rowIndex)");
	button.innerHTML = "<i class=" + "material-icons center" + ">delete</i>";

	//si es la primer fila no se puede eliminar
	if (e.rowIndex == 0) {
		button.disabled = true;
	}

	//agregar input a celda
	cellDelete.appendChild(button);

	$('select').material_select();
}

function appendEquipo(e) {
	//clave
	//nombre
	//marca
	//cantidad//observaciones

	//-----------SELECT nombre-----------
	//crear celda
	var cellNombre = e.insertCell();

	//crear select
	var selectNombre = document.createElement("select");
	selectNombre.required = true;

	//crear opcion default
	var option = document.createElement("option");
	option.disabled = true;
	option.text = "Nombre";
	selectNombre.appendChild(option);

	//for loop con datos de la base de datos
	option = document.createElement("option");
	option.setAttribute("value", "CODIGO");
	option.text = "NOMBRE MATERIAL";
	selectNombre.appendChild(option);

	//agregar select a celda
	cellNombre.appendChild(selectNombre);

	//-----------SELECT marca material
	//crear celda
	var cellMarca = e.insertCell();

	//crear select
	var selectMarca = document.createElement("select");
	selectMarca.required = true;

	//crear opcion default
	var option = document.createElement("option");
	option.disabled = true;
	option.text = "Marca";
	selectMarca.appendChild(option);

	//for loop con datos de la base de datos
	option = document.createElement("option");
	option.setAttribute("value", "marca");
	option.text = "NOMBRE MARCA";
	selectMarca.appendChild(option);

	//agregar select a celda
	cellMarca.appendChild(selectMarca);

	//----------INPUT cantidad-----------
	//crear celda
	var cellCantidad = e.insertCell();

	input = document.createElement("input");
	input.setAttribute("type", "text");
	input.placeholder = "Cantidad";

	//agregar input a celda
	cellCantidad.appendChild(input);

	//----------INPUT observaciones-----------
	//crear celda
	var cellObservaciones = e.insertCell();

	input = document.createElement("input");
	input.setAttribute("type", "text");
	input.placeholder = "Observaciones";

	//agregar input a celda
	cellObservaciones.appendChild(input);

	//----------BUTTON delete-----------
	//crear celda
	var cellDelete = e.insertCell();

	var button = document.createElement("button");
	button.setAttribute("class", "btn waves-effect waves-light red");
	button.setAttribute("name", "action");
	button.setAttribute("onclick", "this.parentElement.parentElement.parentElement.deleteRow(this.parentElement.parentElement.rowIndex)");
	button.innerHTML = "<i class=" + "material-icons center" + ">delete</i>";

	//si es la primer fila no se puede eliminar
	if (e.rowIndex == 0) {
		button.disabled = true;
	}

	//agregar input a celda
	cellDelete.appendChild(button);

	$('select').material_select();
}

function appendReactivo(e) {
	//-----------SELECT nombre-----------
	//crear celda
	var cellNombre = e.insertCell();

	//crear select
	var selectNombre = document.createElement("select");
	selectNombre.required = true;

	//crear opcion default
	var option = document.createElement("option");
	option.disabled = true;
	option.text = "Nombre";
	selectNombre.appendChild(option);

	//for loop con datos de la base de datos
	option = document.createElement("option");
	option.setAttribute("value", "CODIGO");
	option.text = "NOMBRE MATERIAL";
	selectNombre.appendChild(option);

	//agregar select a celda
	cellNombre.appendChild(selectNombre);

	//-----------SELECT marca
	//crear celda
	var cellMarca = e.insertCell();

	//crear select
	var selectMarca = document.createElement("select");
	selectMarca.required = true;

	//crear opcion default
	var option = document.createElement("option");
	option.disabled = true;
	option.text = "Marca";
	selectMarca.appendChild(option);

	//for loop con datos de la base de datos
	option = document.createElement("option");
	option.setAttribute("value", "marca");
	option.text = "NOMBRE MARCA";
	selectMarca.appendChild(option);

	//agregar select a celda
	cellMarca.appendChild(selectMarca);

	//----------INPUT cantidad-----------
	//crear celda
	var cellCantidad = e.insertCell();

	input = document.createElement("input");
	input.setAttribute("type", "text");
	input.placeholder = "Cantidad";

	//agregar input a celda
	cellCantidad.appendChild(input);

	//-----------SELECT presentacion-----------
	//crear celda
	var cellPresentacion = e.insertCell();

	//crear select
	var selectPresentacion = document.createElement("select");
	selectPresentacion.required = true;

	//crear opcion default
	var option = document.createElement("option");
	option.disabled = true;
	option.text = "Presentación";
	selectPresentacion.appendChild(option);

	//for loop con datos de la base de datos
	option = document.createElement("option");
	option.text = "NOMBRE PRESENTACION";
	selectPresentacion.appendChild(option);

	//agregar select a celda
	cellPresentacion.appendChild(selectPresentacion);

	//-----------SELECT contenido-----------
	//crear celda
	var cellContenido = e.insertCell();

	//crear select
	var selectContenido = document.createElement("select");
	selectContenido.required = true;

	//crear opcion default
	var option = document.createElement("option");
	option.disabled = true;
	option.text = "Contenido";
	selectContenido.appendChild(option);

	//for loop con datos de la base de datos
	option = document.createElement("option");
	option.text = "NOMBRE CONTENIDO";
	selectContenido.appendChild(option);

	//agregar select a celda
	cellContenido.appendChild(selectContenido);

	//----------INPUT observaciones-----------
	//crear celda
	var cellObservaciones = e.insertCell();

	input = document.createElement("input");
	input.setAttribute("type", "text");
	input.placeholder = "Observaciones";

	//agregar input a celda
	cellObservaciones.appendChild(input);

	//----------BUTTON delete-----------
	//crear celda
	var cellDelete = e.insertCell();

	var button = document.createElement("button");
	button.setAttribute("class", "btn waves-effect waves-light red");
	button.setAttribute("name", "action");
	button.setAttribute("onclick", "this.parentElement.parentElement.parentElement.deleteRow(this.parentElement.parentElement.rowIndex)");
	button.innerHTML = "<i class=" + "material-icons center" + ">delete</i>";

	//si es la primer fila no se puede eliminar
	if (e.rowIndex == 0) {
		button.disabled = true;
	}

	//agregar input a celda
	cellDelete.appendChild(button);

	$('select').material_select();
}
