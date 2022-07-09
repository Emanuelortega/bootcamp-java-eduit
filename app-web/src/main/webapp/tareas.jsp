<!DOCTYPE html>
<html lang="en">
	<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clase JS</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<!--tag html que permite escribir codigo JS-->
	<script>
		function agregarTarea(){

			//capturo el input por su id
			let InputTarea = document.getElementById('tarea');

			console.log(InputTarea);

			//tomo el valor del input
			let valorDelInput= InputTarea.value;
			console.log(valorDelInput);

			//alert('funciona: ' + valorDelInput);
			// alt+96 > `
			//alert(`funciona: ${valorDelInput}`);

			//guardar en el local Storage
			//localStorage.setItem('tarea',valorDelInput);//guardo bajo el nombre de "tarea" el valor
			//localStorage.setItem('tarea', '10'); reemplaza el valor existente

			//guardo un array de tares
			//let tareas = []; array de cualquier cosa

			//JSON
			let tareas = localStorage.getItem('tareas');

			if(!tareas){
				tareas = [];
			}else{
				tareas = JSON.parse(tareas);
			}

			tareas.push(valorDelInput);
			//antes de guardar
			localStorage.setItem('tareas',JSON.stringify(tareas));

			//limpiar el input
			InputTarea.value = '';
			InputTarea.focus();

			//render
			render();
		}
	</script>
	</head>
	<body onload="render()">
		<main>
			<div class="container">
				<div class="row">
					<div class = "col">
						<label>Tarea:</label>
						<input type="text" id="tarea">

						<button id="btnAgregar" onclick="agregarTarea()">
							Agregar tarea
						</button>

						<div id = "tareas">vacio</div>	    
					</div>	
				</div>
			</div>
		</main>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	</body>
	<script>
		/*
		const divTareas = document.getElementById('tareas');
		let tareasInLocalStorage = localStorage.getItem('tareas');
		divTareas.innerHTML = tareasInLocalStorage;
		*/
		function render(){
			const divTareas = document.getElementById('tareas');
			divTareas.innerHTML = 'ya no esta vacio';

			let tareasInLocalStorage = localStorage.getItem('tareas');
			//let text = '';
			let ul = '<ul>'

			if(tareasInLocalStorage !== null)	{
				tareasInLocalStorage = JSON.parse(tareasInLocalStorage);
				for(let i = 0; i<tareasInLocalStorage.length; i++){

					ul+=`<li>${tareasInLocalStorage[i]}`;
				}
			}

			divTareas.innerHTML = ul;


		}

	</script>
</html>