var queries = new Array();

function ajax(cellIndex, row, url) {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     	row[cellIndex+1] = this.responseText;
    }
  };
  xhttp.open("POST", "getFiltro?" + url, true);
  xhttp.send();
}


//---------MATERIAL------------
function beginAjaxMaterial(row) {
	queries[row.rowIndex] = "tipo=materiales";
	var url = queries[row.rowIndex];
	ajax(select.parentElement.cellIndex, row, url);
}

function AjaxMaterialNombre(row, select) {
	queries[row.rowIndex] += "&nombre=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.cellIndex, row, url);
}

function AjaxMaterialMarca(row, select) {
	queries[row.rowIndex] += "&marca=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.cellIndex, row, url);
}

//---------Equipo------------
function beginAjaxEquipo(row) {
	queries[row.rowIndex] = "tipo=equipos";
	var url = queries[row.rowIndex];
	ajax(select.parentElement.cellIndex, row, url);
}

function AjaxEquipoNombre(row, select) {
	queries[row.rowIndex] += "&nombre=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.cellIndex, row, url);
}

//---------Reactivo------------
function beginAjaxReactivo(row) {
	queries[row.rowIndex] = "tipo=reactivos";
	var url = queries[row.rowIndex];
	ajax(select.parentElement.cellIndex, row, url);
}

function AjaxReactivoNombre(row, select) {
	queries[row.rowIndex] += "&nombre=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.cellIndex, row, url);
}

function AjaxReactivoMarca(row, select) {
	queries[row.rowIndex] += "&marca=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.cellIndex, row, url);
}

function AjaxReactivoPresentacion(row, select) {
	queries[row.rowIndex] += "&presentacion=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.cellIndex, row, url);
}

//---------Consumible------------
function beginAjaxConsumible(row) {
	queries[row.rowIndex] = "tipo=consumibles";
	var url = queries[row.rowIndex];
	ajax(select.parentElement.cellIndex, row, url);
}

function AjaxConsumibleNombre(row, select) {
	queries[row.rowIndex] += "&nombre=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.cellIndex, row, url);
}

function AjaxConsumibleMarca(row, select) {
	queries[row.rowIndex] += "&marca=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.cellIndex, row, url);
}

function AjaxConsumiblePresentacion(row, select) {
	queries[row.rowIndex] += "&presentacion=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.cellIndex, row, url);
}

