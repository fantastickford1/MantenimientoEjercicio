# **Action plan:**

- [ ] Create table <Task> in data base
- [ ] Create <modelo> in src/edu/uag/iidis/scec/modelo/ and named Tarea.hbm.xml
- [ ] Create java file for the Tarea.hbm.xml in src/edu/uag/iidis/scec/modelo/ and named Tarea.java
- [ ] Create java file for Tarea persistence layer in src/edu/uag/iidis/scec/persistencia/ and named TareaDAO.java
- [ ] Modify or edit src/edu/uag/iidis/scec/control/MCUListarPaises.java -> MCUListarTareas.java
- [ ] Modify or edit src/edu/uag/iidis/scec/servicios/ManejadorPaises.java -> ManejadorTareas.java
- [ ] Modify or edit src/edu/uag/iidis/scec/vista/FormaListadoPaises.java -> FormaListadoTareas,java
- [ ] Edit or modify web/WEB-INF/vista/pantallas/formaListadoPaises.jsp -> formaListadoPaises.jsp
- [ ] Add hbm.xml reference  to hibernate.cfg.xml
- [ ] Modify struts-config.xml



### Karlos:

Modelo de la tabla tarea en la BD:

```html
src/edu/uag/iidis/scec/modelo/Tarea.hbm.xml
src/edu/uag/iidis/scec/modelo/Tarea.java
```

Capa de persistencia:

```html
src/edu/uag/iidis/scec/persistencia/TareaDAO.java
```

Servicios:

```
src/edu/uag/iidis/scec/servicios/ManejadorTareas.java
```

Vista:

```
src/edu/uag/iidis/scec/vista/FormaListadoTareas.java
```

Controlador:

```
src/edu/uag/iidis/scec/control/MCUListarTareas.java
```

Vista:

```
web/WEB-INF/vista/pantallas/formaListadoTareas.jsp
```