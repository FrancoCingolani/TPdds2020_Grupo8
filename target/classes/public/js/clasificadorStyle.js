  
// Al cargar la pagina, oculto los 2 divs
$( document).ready(function() {
	$("#egresos").hide();
	$("#presupuestos").hide();
});

// Funcion para tratar los cambios en el dropdown selector
$("#selector").change(function() {
	switch ($("#selector").val()) {
		case "e": // Muestra egresos
			$("#egresos").show();
			$("#presupuestos").hide();
			break;
		case "p": // Muestra presupuestos
			$("#egresos").hide();
			$("#presupuestos").show();
			break;
		case "default": // Oculta todo
			$("#egresos").hide();
			$("#presupuestos").hide();
			break;
	}
});