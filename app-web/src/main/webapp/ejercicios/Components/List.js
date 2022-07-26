function List(items){
    let List = '<ul>';
    for(let i = 0; i<items.length; i++){
        List += Item(items[i]);
    }
    List += '</ul>';

    return List;	
}

//funciones

function agregarItem(){

    //capturo el input por su id
    let InputTarea = document.getElementById('tarea');

    //tomo el valor del input
    let valorDelInput= InputTarea.value;
    
    if(!valorDelInput){
        return;
    }

    //JSON
    let tareas = getTareas();

    //crear objeto
    const item = {
        id:Math.random(),
        value: valorDelInput

    };

    //tareas.push(valorDelInput);
    tareas.push(item);

    //antes de guardar
    setTareas(tareas);

    //limpiar el input
    InputTarea.value = '';
    InputTarea.focus();

    //render
    render();
}

function eliminarItem (id){
    if(confirm('confirmar?')){
        //debo recorrer el array de tareas y buscar el id enviado por parametro
        let tareas = getTareas();
        let tareasAux = []
        for(let i=0;i<tareas.length;i++ ){
            if(tareas[i].id !== id){	
            tareasAux.push(tareas[i])
            }
        }

        //update del localStorage
        setTareas(tareasAux);

        render();
    }
}

function eliminarTodos(){
    //scanner
    const confirma = confirm('Confirmar?');
    if(confirma){
        localStorage.removeItem('tareas');
        render();
    }
    
}