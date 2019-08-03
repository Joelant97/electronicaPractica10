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
                                  action="/equipos/crear/" method="post" enctype='multipart/form-data'>
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
                                                class="form-control select2 select2-hidden-accessible"
                                                required>
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
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <button type="button" id="add" name="agregar" onclick="setup()"
                                                class="btn btn-primary form-control">+
                                        </button>
                                    </div>
                                </div>
                            </form>

                            <div class="row">
                                <div id="foto" name="foto"></div>
                            </div>
                            <br>

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
                                <td>${equipo.getFamilia()}</td>
                                <td>${equipo.getSubFamilia()}</td>
                                <td class="actions">
                                    <a href="#" class="hidden on-editing save-row"><i class="fa fa-save"></i></a>
                                    <a href="#" class="hidden on-editing cancel-row"><i class="fa fa-times"></i></a>
                                    <a href="#edit-form" class="on-default edit-row"><i class="fa fa-pencil"></i></a>
                                    <a href="delete/${equipo.getId()}" class="on-default remove-row"><i
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

    var id = [];
    var nombre = [];
    var precio = [];
    var nombrealq = [];
    var precioalq = [];
    var existencias = [];
    var ids = [];
    var imgs = [];

    <#list equipos as equipo>

    id.push(${equipo.getId()});
    imgs.push('${equipo.getImagen()}');
    nombre.push('${equipo.getNombreEquipo()}');
    precio.push('${equipo.getPrecio()}');
    existencias.push(${equipo.getExistencia()});

    </#list>
    $(function () {
        $('#add').prop('disabled', true);
    });
    $("#equipo").change(function () {
        $('#foto').html("");

        for (var i = 0; i < id.length; i++) {
            if (id[i] == document.getElementById("equipo").value) {
                var picture = '<img src="data:image/jpeg;base64,' + imgs[i] + '" class="img-thumbnail" style="height:200px;width:auto; max-width:200px;">';
                $('#foto').html(picture);

                if (existencias[i] == 0) {
                    $('#add').prop('disabled', true);
                } else {
                    $('#add').prop('disabled', false);
                }
            }
        }
    });

    (function setup() {
        "use strict";
        var cliente = document.getElementById("cliente");
        var fecha = document.getElementById("fecha");
        var equipo_nombre = equipo.options[equipo.selectedIndex].value;
        var equipo_id = equipo.options[equipo.selectedIndex].text;

        document.getElementById("add").addEventListener("click", function () {
            if(equipo_id in id) {
                ids.push(equipo_id);
                existencias[i] -= 1;
                var markup = "<tr><td>" + equipo_id + "</td><td>" + equipo_nombre + "</td><td>" + precio[precio.indexOf(equipo_id)] + "</td></tr>";
                console.log(markup)
                $("#carrito tbody").append(markup);
                console.log($("#carrito tbody"));
            }
            equipo.selectedIndex = 0;
            document.getElementById('ids[]').value = ids;
            $('#foto').html("");
            $('#add').prop('disabled', true);

        }
        });
    })();

</script>
</body>
</html>