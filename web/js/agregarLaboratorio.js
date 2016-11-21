function nuevosAlumnos(e) {
	var elem = document.getElementById("alumnos");

	while (elem.hasChildNodes()) {
    	elem.removeChild(elem.lastChild);
	}

	var num = e.value;

	for (var i = 0; i < num; i++) {
		var input = document.createElement("input");
		input.required = true;
		input.placeholder = "A00000000";
		input.type = "text";
		input.class = "validate";
		input.id = "matricula-" + i;
		input.name = "matricula";
		elem.appendChild(input);
	}
}