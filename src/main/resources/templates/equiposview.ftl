<!doctype html>
<html class="fixed">
	<#include "header.ftl">
	<body>
		<section class="body">
			<!-- start: header -->
			<#include "body_header.ftl">
			<!-- end: header -->

			<div class="inner-wrapper">
				<!-- start: sidebar -->
				<#include "sidebar.ftl">
				<!-- end: sidebar -->

				<section role="main" class="content-body">
					<header class="page-header">
						<h2>Clientes</h2>
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

                            <h2 class="panel-title">Equipos</h2>
                        </header>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="mb-md">
                                        <a class="popup-with-form btn btn-primary" href="#equipo-form">Agregar <i class="fa fa-plus"></i></a>
                                    </div>
                                </div>
                                <!-- Equipos Form -->
                                <form id="equipo-form" class="white-popup-block mfp-hide form-horizontal"
							  	action="/equipos/crear/" method="post" enctype='multipart/form-data'>
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <h3>Formulario Equipos</h3>
                                        </div>
                                    </div>
                                    <div class="form-group mt-lg">
                                        <label class="col-sm-3 control-label">Nombre</label>
                                        <div class="col-sm-9">
                                            <input type="text" name="nombre" class="form-control"  required />
                                        </div>
                                    </div>
                                    <div class="form-group mt-lg">
                                        <label class="col-sm-3 control-label">Existencia</label>
                                        <div class="col-sm-9">
                                            <input type="number" name="existencia" class="form-control"  required />
                                        </div>
                                    </div>
                                    <div class="form-group mt-lg">
                                        <label class="col-sm-3 control-label">Tarifa</label>
                                        <div class="col-sm-9">
                                            <input type="number" name="tarifa" class="form-control" required />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Familia</label>
                                        <div class="col-sm-9">
                                            <input type="text" name="familia" class="form-control"  required />
                                        </div>
                                    </div>
									<div class="form-group">
										<label class="col-sm-3 control-label">SubFamilia</label>
										<div class="col-sm-9">
											<input type="text" name="subfamilia" class="form-control"  required />
										</div>
									</div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Foto de equipo</label>
                                        <div class="col-sm-9">
                                            <input type="file" accept="image/png, image/jpeg" id="foto" name="foto">
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
                                    <th>Nombre</th>
                                    <th>Existencia</th>
                                    <th>Tarifa</th>
                                    <th>Activo</th>
									<th>Famiilia</th>
									<th>SubFamilia</th>
                                </tr>
                                </thead>
                                <tbody>

									<#list equipos as equipo>
									<tr class="gradeX">
										<td>${equipo.getNombre()}</td>
										<td>${equipo.getCantidad()}</td>
										<td>${equipo.getTarifa()}</td>
										<td>${equipo.getActivo()?c}</td>
										<td>${equipo.getFamilia()}</td>
										<td>${equipo.getSubFamilia()}</td>
										<td class="actions">
											<a href="#" class="hidden on-editing save-row"><i class="fa fa-save"></i></a>
											<a href="#" class="hidden on-editing cancel-row"><i class="fa fa-times"></i></a>
											<a href="#edit-form" class="on-default edit-row"><i class="fa fa-pencil"></i></a>
											<a href="delete/${equipo.getId()}"  class="on-default remove-row"><i class="fa fa-trash-o"></i></a>
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

		<div id="dialog" class="modal-block mfp-hide">
			<section class="panel">
				<header class="panel-heading">
					<h2 class="panel-title">Are you sure?</h2>
				</header>
				<div class="panel-body">
					<div class="modal-wrapper">
						<div class="modal-text">
							<p>Are you sure that you want to delete this row?</p>
						</div>
					</div>
				</div>
				<footer class="panel-footer">
					<div class="row">
						<div class="col-md-12 text-right">
							<button id="dialogConfirm" class="btn btn-primary">Confirm</button>
							<button id="dialogCancel" class="btn btn-default">Cancel</button>
						</div>
					</div>
				</footer>
			</section>
		</div>

<#include "footer.ftl">
		<!-- Examples -->
		<script src="/assets/javascripts/tables/examples.datatables.editable.js"></script>
        <script src="/assets/javascripts/ui-elements/examples.lightbox.js"></script>
	</body>
</html>