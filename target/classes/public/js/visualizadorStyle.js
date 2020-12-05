// Al cargar la pagina, oculto los 3 divs
$( document).ready(function() {
	$("#egresos").hide();
	$("#ingresos").hide();
	$("#proyectos").hide();
});

// Funcion para tratar los cambios en el dropdown selector
$("#selector").change(function() {
	switch ($("#selector").val()) {
		case "e": // Muestra egresos
			$("#egresos").show();
			$("#ingresos").hide();
			$("#proyectos").hide();
			break;
		case "i": // Muestra ingresos
			$("#egresos").hide();
			$("#ingresos").show();
			$("#proyectos").hide();
			break;
		case "p": // Muestra proyectos
			$("#egresos").hide();
			$("#ingresos").hide();
			$("#proyectos").show();
			break;
		case "default": // Oculta todo
			$("#egresos").hide();
			$("#ingresos").hide();
			$("#proyectos").hide();
			break;
	}
});
