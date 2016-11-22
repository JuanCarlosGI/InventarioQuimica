var queries = new Array();
queries[0] = new Array();

function beginAjax(row, select, cellIndex) {
	queries[row.rowIndex][0] = "tipo=" + (select.options[select.selectedIndex].innerHTML).toLowerCase();
	var url = queries[row.rowIndex][0];
	ajax(cellIndex, row, url);
}

function nextAjax(row, select, cellIndex, tag) {
	queries[row.rowIndex][cellIndex] = tag + (select.options[select.selectedIndex].innerHTML).toLowerCase();
	var url = "" ;

	for (var i = 0; i <= cellIndex; i++) {
		url += queries[row.rowIndex][0];
	}

	ajax(cellIndex, row, url);
}

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