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

                    <h2 class="panel-title">Alquileres</h2>
                </header>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="mb-md">
                                <a class="popup-with-form btn btn-primary" href="#shop">Agregar <i
                                            class="fa fa-plus"></i></a>
                            </div>
                        </div>
                        <!-- Equipos Form -->
                        <div id="shop" class="white-popup-block mfp-hide">
                            <form id="alquiler-form" class=" form-horizontal"
                                  action="/alquileres/despachar/" method="post" enctype='multipart/form-data'>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <h3>Alquileres</h3>
                                    </div>
                                </div>
                                <div class="form-group mt-lg">
                                    <label class="col-sm-3 control-label">Cliente</label>
                                    <div class="col-sm-9">
                                        <select id="client" name="client" class="form-control"
                                                style="width: 100%;" tabindex="-1" aria-hidden="true"
                                                required>
                                            <option selected="selected">Seleccionar Cliente</option>
                                            <#list clientes as cliente>
                                                <option value="${cliente.getId()}">${cliente.getNombre()}</option>
                                            </#list>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group mt-lg">
                                    <label class="col-sm-3 control-label">Fecha de entrega</label>
                                    <div class="col-sm-9">
                                        <div class="">
                                            <input id="datepicker" name="fechaentrega"
                                                   class="form-control pull-right" type="date" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Equipo</label>
                                    <div class="col-sm-9">
                                        <select id="equipo" name="equipos"
                                                class="select2 select2-hidden-accessible form-control">
                                            <option value="">Seleccionar equipo</option>
                                            <#list equipos as equipo>
                                                <option value="${equipo.getId()}">${equipo.getNombreEquipo()}</option>
                                            </#list>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group mt-lg">
                                    <input type="hidden" id="cant[]" name="cant[]">
                                    <input type="hidden" id="ids[]" name="ids[]">
                                </div>
                                <div class="col-md-12 my-2">
                                    <div class="form-group">
                                        <button type="button" id="add" name="agregar" onclick="setup()"
                                                class="btn btn-primary form-control">+
                                        </button>
                                    </div>
                                </div>
                                <div class="row">
                                    <div id="foto" name="foto"></div>
                                </div>
                                <div class="table-responsive table-bordered card">
                                    <table id="carrito" name="carrito" class="table">
                                        <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Nombre De Equipo</th>
                                            <th>Precio por dia</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">
                                        Cancelar
                                    </button>
                                    <button type="submit" class="btn btn-info" data-backdrop="true">
                                        Despachar
                                    </button>
                                </div>
                            </form>
                        </div
                    </div>
                    <table class="table table-bordered table-striped mb-none" id="datatable-editable">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Cliente</th>
                            <th>Equipo</th>
                            <th>Estado</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list alquileres as alquiler>
                            <tr class="gradeX">
                                <td class="text-center">${alquiler.getId()}</td>
                                <td class="text-center">${alquiler.getCliente().getNombre()} ${alquiler.getCliente().getApellido()}</td>
                                <td class="text-center">${alquiler.getEquipo().getNombreEquipo()}</td>
                                <td class="text-center">${alquiler.getEstado()}</td>
                                <td class="actions">
                                    <a href="/alquileres/entrega/${alquiler.getId()}" class="on-editing save-row" title="Marcar como entregado"><i class="fa fa-check-circle"></i></a>
                                    <a href="/alquileres/factura/" class="on-editing cancel-row"><i class="fa fa-table"></i></a>
                                    <a href="#edit-form" class="on-default edit-row"><i class="fa fa-pencil"></i></a>
                                    <a href="/alquileres/eliminar/${alquiler.getId()}" class="on-default remove-row"><i
                                                class="fa fa-trash-o"></i></a>
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
<script>
    var equipoActual;
    var equipo;
    var ids = [];

    $(function () {
        $('#add').prop('disabled', true);
    });

    $("#equipo").change(function () {
        equipo = document.getElementById("equipo");
        var equipo_value = equipo.options[equipo.selectedIndex].value;
        var url = "/equipos/" + equipo_value + "/"
        $.getJSON(url, function (data) {
            if (data != null)
                equipoActual = data;

        }).done(function () {
            var picture = '<img src="data:image/jpeg;base64,' + equipoActual.imagen
                + '" class="rounded mx-auto d-block" style="' +
                'height: 200px;' +
                'max-width: 200px;' +
                'margin: auto;' +
                'display: block;">';
            $('#foto').html(picture);

        }).fail(function () {
            console.log("error al recibir equipo");
        });

        if (equipoActual.existencia == 0) {
            $('#add').prop('disabled', true);
        } else {
            $('#add').prop('disabled', false);
        }
    });

    function setup() {
        "use strict";
        if (equipoActual !== null) {
            var markup = "<tr><td>" + equipoActual.id + "</td><td>" + equipoActual.nombreEquipo + "</td><td>" + equipoActual.precio + "</td></tr>";
            $("#carrito tbody").append(markup);
            equipo.selectedIndex = 0;
            ids.push(equipoActual.id);
            $('#foto').html("");
            $('#add').prop('disabled', true);
            document.getElementById('ids[]').value = ids;
        }
    }

</script>
</body>
</html>