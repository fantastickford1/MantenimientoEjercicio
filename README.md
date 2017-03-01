# Team Manager

**<u>Git</u>**

*No hacer commit de build.xml y la carpeta dist*
*No hacer commit de hibernate.cfg.xml*

Clonar

```shell
$~ git clone https://github.com/fantastickford1/MantenimientoEjercicio.git
$~ cd MantenimientoEjercicio
```

Despues de hacer cambios

```shell
$~ git branch Issue#00<NAME>
$~ git checkout Issue#00<NAME>
$~ git add <Files>
$~ git commit -m "Mensaje"
$~ git push
//Se revisa la branch
//Branch aceptada
$~ git checkout master
//si alguien hizo cambios antes
$~ git pull
//si no
$~ git merge Issue#00<NAME>
$~ git branch -d Issue#00<NAME>
$~ git push
```

Alguien hizo cambios

```shell
$~ git branch Issue#00<NAME>
$~ git checkout Issue#00<NAME>
$~ git add <Files>
$~ git commit -m "Mensaje"
$~ git push
//Se revisa la branch
//Branch aceptada
$~ git checkout master
$~ git merge Issue#00<NAME>
$~ git branch -d Issue#00<NAME>
$~ git push
```

*Hacer un branch si se modifica algo y no estas seguro de si afecta a los demas*

Essential requirements:

- apache-tomcat
- apache-ant
- mysql
- hibernate


App structure:

```HTML
/build
	-/css
	-/images
	-/js
	-/WEB-IF
	-index.html
/data
	-bdscec.log
	-bdscec.properties
	-bdscec.script
/dist
	-/docs
	-{{generatedWAR}}.war
/docs **no important**
/src
	-/edu
		-/uag
			-/iidis
				-/scec
					-/control
						-MCUEliminarRol.java
						-MCUListarCiudades.java
						-MCUListarEstados.java
						-MCUListarLugares.java
						-MCUListarPaises.java
						-MCUListarRecomendaciones.java
						-MCUListarRoles.java
						-MCULogin.java
						-MCURegistrarCiudad.java
						-MCURegistrarEstado.java
						-MCURegistrarLugar.java
						-MCURegistrarPais.java
						-MCURegistrarRecomendacion.java
						-MCURegistrarRol.java
						-MCURegistrarUsuario.java
					-/excepciones
						-ExcepcionDAO.java
						-ExcepcionInfraestructura.java
						-ExcepcionNegocio.java
						-ExcepcionSeguridad.java
						-ExcepcionServicio.java
					-/filter
						-AuthorizationFilter.java
					-/modelo
						-Ciudad.hbm.xml
						-Ciudad.java
						-ClaseBase.java
						-Credencial.java
						-Estado.hbm.xml
						-Estado.java
						-Lugar.hbm.xml
						-Lugar.java
						-NombrePersona.java
						-Pais.hbm.xml
						-Pais.java
						-Persona.java
						-Recomendacion.hbm.xml
						-Recomendacion.java
						-Rol.hbm.xml
						-Rol.java
						-User.java
						-Usuario.hbm.xml
						-Usuario.java
					-/persistencia
						-/hibernate
						-CiudadDAO.java
                        -EstadoDAO.java
                        -LoginDAO.java
                        -LugarDAO.java
                        -PaisDAO.java
                        -RecomendacionDAO.java
                        -RolDAO.java
                        -UsuarioDAO.java
					-/pruebas
						-AllTests.java
						-RollDOATest.java
						-UsuarioDAOTest.java
					-/servicios
						-net/webservicex
                        -DataService.java
                        -ManejadorCiudades.java
                        -ManejadorEstados.java
                        -ManejadorLogin.java
                        -ManejadorLugares.java
                        -ManejadorPaises.java
                        -ManejadorRecomendaciones.java
                        -ManejadorRoles.java
                        -ManejadorUsuarios.java
					-/vistas
						-FormaEliminarRol.java
                        -FormaListadoCiudades.java
                        -FormaListadoEstados.java
                        -FormaListadoLugares.java
                        -FormaListadoPaises.java
                        -FormaListadoRecomendaciones.java
                        -FormaListadoRoles.java
                        -FormaLogin.java
                        -FormaNuevaPersona.java
                        -FormaNuevoCiudad.java
                        -FormaNuevoEstado.java
                        -FormaNuevoLugar.java
                        -FormaNuevoPais.java
                        -FormaNuevoRecomendacion.java
                        -FormaNuevoRol.java
                        -_verPersonas.jsp
                        -scecRB.properties
	-hibernate.cfg.xml
	-log4j.properties
/testout
/web
	-/WEB-INF
		-/lib
		-/tld
		-/vista
		-struts-config.xml
		-validation.xml
		-validator-rules.xml
		-web.xml
	-/css
	-/images
	-/js
	-index.html
-build.xml
-build__.xml
-esquema.sql
-hs_err_pid2300.log
-README.md
```

Las vistas se encuentran en la carpeta /web/WEB-INF/vista, editar las vistas correspondientes



***Editar este README si tienen algo que documentar***