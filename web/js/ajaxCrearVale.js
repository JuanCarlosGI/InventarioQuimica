var queries = new Array();

function ajax(cellIndex, row, url) {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     	row.cells[cellIndex+1].innerHTML = this.responseText;
     	$('select').material_select();
    }
  };
  xhttp.open("POST", "getFiltro?" + url, true);
  xhttp.send();
}


function ajaxMaterialNombre(row, select) {
	queries[row.rowIndex] = "tipo=materiales&nombre=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.parentElement.cellIndex, row, url);
}

function ajaxMaterialMarca(row, select) {
	queries[row.rowIndex] += "&marca=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.parentElement.cellIndex, row, url);
}

//---------Equipo------------

function ajaxEquipoNombre(row, select) {
	queries[row.rowIndex] = "tipo=equipos&nombre=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.parentElement.cellIndex, row, url);
}

//---------Reactivo------------
function ajaxReactivoNombre(row, select) {
	queries[row.rowIndex] = "tipo=reactivos&nombre=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.parentElement.cellIndex, row, url);
}

function ajaxReactivoMarca(row, select) {
	queries[row.rowIndex] += "&marca=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.parentElement.cellIndex, row, url);
}

function ajaxReactivoPresentacion(row, select) {
	queries[row.rowIndex] += "&presentacion=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.parentElement.cellIndex, row, url);
}

//---------Consumible------------

function ajaxConsumibleNombre(row, select) {
	queries[row.rowIndex] = "tipo=consumibles&nombre=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.parentElement.cellIndex, row, url);
}

function ajaxConsumibleMarca(row, select) {
	queries[row.rowIndex] += "&marca=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.parentElement.cellIndex, row, url);
}

function ajaxConsumiblePresentacion(row, select) {
	queries[row.rowIndex] += "&presentacion=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.parentElement.cellIndex, row, url);
}

