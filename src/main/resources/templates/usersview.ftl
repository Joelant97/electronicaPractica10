<!doctype html>
<html class="fixed">
<#include "header.ftl">
<body>

<section class="body">
	<#include "body_header.ftl">

	<div class="inner-wrapper">
		<#include "sidebar.ftl">
		<section role="main" class="content-body">
			<header class="page-header">
				<h2>Usuarios</h2>
				<div class="right-wrapper pull-right">
					<ol class="breadcrumbs">
						<li>
							<a href="index.html">
								<i class="fa fa-home"></i>
							</a>
						</li>
						<li><span>Tables</span></li>
						<li><span>Editable</span></li>
					</ol>
					<a class="sidebar-right-toggle" data-open="sidebar-right"><i class="fa fa-chevron-left"></i></a>
				</div>
			</header>

			<!-- start: page -->
			<section class="panel">
				<header class="panel-heading">
					<div class="panel-actions">
						<a href="#" class="fa fa-caret-down"></a>
						<a href="#" class="fa fa-times"></a>
					</div>

					<h2 class="panel-title">Usuarios</h2>
				</header>
				<div class="panel-body">
					<div class="row">
						<div class="col-sm-6">
							<div class="mb-md">
								<a class="popup-with-form btn btn-primary" href="#demo-form">Agregar <i class="fa fa-plus"></i></a>
							</div>
						</div>
						<!-- Cliente Form -->
						<form id="demo-form" class="white-popup-block mfp-hide form-horizontal"
							  action="/usuarios/crear/" method="post" enctype='multipart/form-data'>
							<div class="row">
								<div class="col-sm-12">
									<h3>Nuevo Usuario</h3>
								</div>
							</div>
							<div class="form-group mt-lg">
								<label class="col-sm-3 control-label">nombre de usuario</label>
								<div class="col-sm-9">
									<input type="text" name="username" class="form-control"  required />
								</div>
							</div>
							<div class="form-group mt-lg">
								<label class="col-sm-3 control-label">contraseña</label>
								<div class="col-sm-9">
									<input type="password" name="password" class="form-control"  required />
								</div>
							</div>
							<div class="form-group mt-lg">
								<label class="col-sm-3 control-label">Email</label>
								<div class="col-sm-9">
									<input type="text" name="email" class="form-control"  required />
								</div>
							</div>
							<div class="form-group mt-lg">
								<label class="col-sm-3 control-label">Rol</label>
								<div class="col-sm-9">
									<select id="rol" name="rol" class="form-control select2 select2-hidden-accessible" required>
										<#list roles as rol>
											<option value="${rol.getNombreRol()}">${rol.getNombreRol()}</option>
										</#list>
									</select>
								</div>
							</div>
							<div class="row mb-lg">
								<div class="col-sm-9 col-sm-offset-3">
									<button class="btn btn-primary">Guardar</button>
									<button type="reset" class="btn btn-default">Reset</button>
								</div>
							</div>

						</form>
						<!-- <form id="edit-form" class="white-popup-block mfp-hide form-horizontal"
                              action="edit/{cliente.getId()}" method="post" enctype='multipart/form-data'>
                            <div class="row">
                                <div class="col-sm-12">
                                    <h3>Formulario Cliente</h3>
                                </div>
                            </div>
                            <div class="form-group mt-lg">
                                <label class="col-sm-3 control-label">Nombre</label>
                                <div class="col-sm-9">
                                    <input type="text" name="nombre" class="form-control" value="{cliente.getNombre()}" required />
                                </div>
                            </div>
                            <div class="form-group mt-lg">
                                <label class="col-sm-3 control-label">Cédula</label>
                                <div class="col-sm-9">
                                    <input type="text" name="cedula" class="form-control" value="{cliente.getCedula()}"  required />
                                </div>
                            </div>
                            <div class="form-group mt-lg">
                                <label class="col-sm-3 control-label">Telefono</label>
                                <div class="col-sm-9">
                                    <input type="text" name="telefono" class="form-control" value="{cliente.getTelefono()}"  required />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Email</label>
                                <div class="col-sm-9">
                                    <input type="email" name="correo" class="form-control" value="{cliente.getCorreo()}" required />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Foto de perfil</label>
                                <div class="col-sm-9">
                                    <input type="file" accept="image/png, image/jpeg" id="foto" name="foto" value="{cliente.getCorreo()}">
                                </div>
                            </div>
                            <div class="row mb-lg">
                                <div class="col-sm-9 col-sm-offset-3">
                                    <button class="btn btn-primary">Modificar</button>
                                    <button type="reset" class="btn btn-default">Reset</button>
                                </div>
                            </div>

                        </form>  -->
					</div>
					<table class="table table-bordered table-striped mb-none" id="datatable-editable">
						<thead>
						<tr>
							<th class="text-center">Nombre de Usuario</th>
							<th class="text-center">Contraseña</th>
							<th class="text-center">E-Mail</th>
							<th class="text-center">Opciones</th>

						</tr>
						</thead>
						<tbody>
						<#list usuarios as usuario>
							<tr class="gradeX">
								<td>${usuario.getUsername()}</td>
								<td>${usuario.getPassword()}</td>
								<td>${usuario.getEmail()}</td>
								<td class="actions">
									<a href="/profile/${usuario.getId()}" class="hidden on-editing save-row"><i class="fa fa-eye"></i></a>
									<a href="#" class="hidden on-editing cancel-row"><i class="fa fa-times"></i></a>
									<a href="#edit-form" class="on-default edit-row"><i class="fa fa-pencil"></i></a>
									<a href="/usuarios/eliminar/${usuario.getId()}"  class="on-default remove-row"><i class="fa fa-trash-o"></i></a>
								</td>
							</tr>
						</#list>
						</tbody>
					</table>
				</div>
			</section>
			<!-- end: page -->
		</section>
	</div>
	<#include "sidebar-right.ftl">
</section>

<#include "footer.ftl">
<script src="/assets/javascripts/ui-elements/examples.lightbox.js" type="text/javascript"></script>

</body>
</html>