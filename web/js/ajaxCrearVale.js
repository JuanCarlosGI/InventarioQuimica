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


function AjaxMaterialNombre(row, select) {
	queries[row.rowIndex] = "tipo=materiales&nombre=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.parentElement.cellIndex, row, url);
}

function AjaxMaterialMarca(row, select) {
	queries[row.rowIndex] += "&marca=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.parentElement.cellIndex, row, url);
}

//---------Equipo------------

function AjaxEquipoNombre(row, select) {
	queries[row.rowIndex] = "tipo=equipos&nombre=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.parentElement.cellIndex, row, url);
}

//---------Reactivo------------
function AjaxReactivoNombre(row, select) {
	queries[row.rowIndex] = "tipo=reactivos&nombre=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.parentElement.cellIndex, row, url);
}

function AjaxReactivoMarca(row, select) {
	queries[row.rowIndex] += "&marca=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.parentElement.cellIndex, row, url);
}

function AjaxReactivoPresentacion(row, select) {
	queries[row.rowIndex] += "&presentacion=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.parentElement.cellIndex, row, url);
}

//---------Consumible------------

function AjaxConsumibleNombre(row, select) {
	queries[row.rowIndex] = "tipo=consumibles&nombre=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.parentElement.cellIndex, row, url);
}

function AjaxConsumibleMarca(row, select) {
	queries[row.rowIndex] += "&marca=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.parentElement.cellIndex, row, url);
}

function AjaxConsumiblePresentacion(row, select) {
	queries[row.rowIndex] += "&presentacion=" + select.options[select.selectedIndex].innerHTML;
	var url = queries[row.rowIndex];
	ajax(select.parentElement.parentElement.cellIndex, row, url);
}

