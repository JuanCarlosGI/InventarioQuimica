function agregarFila() {
	var table = document.getElementById('vale');
	var row = table.insertRow();
	var index = row.rowIndex + 1;
	row.id = "producto-" + index;

	var cellTipo = row.insertCell();

	var selectList = document.createElement("select");
	selectList.required = true;
	selectList.setAttribute("onchange", "escogerProducto(this)");


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
	$('select').trigger('contentchanged');
}

function escogerProducto(e) {
	var tipo = e.value;
	alert(tipo);
}

function appendMaterial() {

}

function appendEquipo() {
	
}

function appendReactivo() {
	
}

function appendConsumible() {
	
}
