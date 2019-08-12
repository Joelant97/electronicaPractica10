<html class="fixed">
<#include "header.ftl">
<body>

<section class="body">

    <#include "body_header.ftl">

    <div class="inner-wrapper">
        <#include "sidebar.ftl">
        <section role="main" class="content-body">
            <header class="page-header">
                <h2>User Profile</h2>

                <div class="right-wrapper pull-right">
                    <ol class="breadcrumbs">
                        <li>
                            <a href="index.html">
                                <i class="fa fa-home"></i>
                            </a>
                        </li>
                        <li><span>Pages</span></li>
                        <li><span>User Profile</span></li>
                    </ol>

                    <a class="sidebar-right-toggle" data-open="sidebar-right"><i class="fa fa-chevron-left"></i></a>
                </div>
            </header>

            <!-- start: page -->

            <div class="row">
                <div class="col-md-4 col-lg-3">

                    <section class="panel">
                        <div class="panel-body">
                            <div class="thumb-info mb-md">
                                <img src="data:image/jpeg;base64,${cliente.getImagen()}" class="rounded img-responsive"
                                     alt="John Doe">
                                <div class="thumb-info-title">
                                    <span class="thumb-info-inner">${cliente.getNombre()} ${cliente.getApellido()}</span>
                                </div>
                            </div>
                            <div class="widghaet-toggle-expand mb-md">
                                <div class="widget-header">
                                    <h4>Informacion</h4>
                                </div>

                                <div class="widget-content-expanded">
                                    <ul class="simple-todo-list">
                                        <li>Cedula: ${cliente.getCedula()}</li>
                                        <li>Fecha Nacimiento: ${cliente.getFechaNacimiento()}</li>
                                    </ul>
                                </div>
                            </div>

                            <hr class="dotted short">

                        </div>
                    </section>
                </div>
                <div class="col-md-8 col-lg-6">

                    <div class="tabs">
                        <ul class="nav nav-tabs tabs-primary">
                            <li class="active">
                                <a href="#overview" data-toggle="tab">Overview</a>
                            </li>
                            <li>
                                <a href="#edit" data-toggle="tab">Edit</a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div id="overview" class="tab-pane active">
                                <h4 class="mb-md">Historial</h4>

                                <div class="timeline timeline-simple mt-xlg mb-md">
                                    <div class="tm-body">
                                        <div class="tm-title">
                                            <h3 class="h5 text-uppercase">November 2013</h3>
                                        </div>
                                        <#list historial?sort_by(fechaInicioAlquiler) as alquiler >

                                            <ol class="tm-items">
                                                <li>
                                                    <div class="tm-box">
                                                        <p class="text-muted mb-none">${alquiler.getFechaInicioAlquiler()?string.medium} </p>
                                                        <p>
                                                            <span class="text-bold">ID: </span> ${alquiler.getId()}
                                                            <span class="text-bold">Fecha de entrega: </span> ${alquiler.getFechaFinAlquiler()?string.medium}
                                                            <#if alquiler.getEstado()  == "Pendiente">
                                                                <span class="text-primary">Pendiente</span>
                                                            <#elseif alquiler.getEstado()  == "Entregado" >
                                                                <span class="text-Secondary">Entregado</span>
                                                            </#if>
                                                        </p>
                                                    </div>
                                                </li>
                                            </ol>
                                        </#list>
                                    </div>
                                </div>
                            </div>
                            <div id="edit" class="tab-pane">

                                <form class="form-horizontal" method="get">
                                    <h4 class="mb-xlg">Personal Information</h4>
                                    <fieldset>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" for="profileFirstName">First
                                                Name</label>
                                            <div class="col-md-8">
                                                <input type="text" class="form-control" id="profileFirstName">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" for="profileLastName">Last
                                                Name</label>
                                            <div class="col-md-8">
                                                <input type="text" class="form-control" id="profileLastName">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" for="profileAddress">Address</label>
                                            <div class="col-md-8">
                                                <input type="text" class="form-control" id="profileAddress">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" for="profileCompany">Company</label>
                                            <div class="col-md-8">
                                                <input type="text" class="form-control" id="profileCompany">
                                            </div>
                                        </div>
                                    </fieldset>
                                    <hr class="dotted tall">
                                    <h4 class="mb-xlg">About Yourself</h4>
                                    <fieldset>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" for="profileBio">Biographical
                                                Info</label>
                                            <div class="col-md-8">
                                                <textarea class="form-control" rows="3" id="profileBio"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-3 control-label mt-xs pt-none">Public</label>
                                            <div class="col-md-8">
                                                <div class="checkbox-custom checkbox-default checkbox-inline mt-xs">
                                                    <input type="checkbox" checked="" id="profilePublic">
                                                    <label for="profilePublic"></label>
                                                </div>
                                            </div>
                                        </div>
                                    </fieldset>
                                    <hr class="dotted tall">
                                    <h4 class="mb-xlg">Change Password</h4>
                                    <fieldset class="mb-xl">
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" for="profileNewPassword">New
                                                Password</label>
                                            <div class="col-md-8">
                                                <input type="text" class="form-control" id="profileNewPassword">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" for="profileNewPasswordRepeat">Repeat
                                                New Password</label>
                                            <div class="col-md-8">
                                                <input type="text" class="form-control" id="profileNewPasswordRepeat">
                                            </div>
                                        </div>
                                    </fieldset>
                                    <div class="panel-footer">
                                        <div class="row">
                                            <div class="col-md-9 col-md-offset-3">
                                                <button type="submit" class="btn btn-primary">Submit</button>
                                                <button type="reset" class="btn btn-default">Reset</button>
                                            </div>
                                        </div>
                                    </div>

                                </form>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-12 col-lg-3">

                    <h4 class="mb-md">Sale Stats</h4>
                    <ul class="simple-card-list mb-xlg">
                        <li class="primary">
                            <h3>488</h3>
                            <p>Nullam quris ris.</p>
                        </li>
                    </ul>
                </div>

            </div>
            <!-- end: page -->
        </section>
    </div>

    <#include "sidebar-right.ftl">
</section>

<#include "footer.ftl">

</body>
</html>