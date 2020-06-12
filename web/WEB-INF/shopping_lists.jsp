<%--
  Created by IntelliJ IDEA.
  User: vanes
  Date: 12/06/2020
  Time: 09:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Listes de courses</title>

        <!-- Bootstrap core CSS -->
        <link href="../../../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="../../../css/4-col-portfolio.css" rel="stylesheet">

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

            <!--[if gte mso 9]><xml>
        <mso:CustomDocumentProperties>
        <mso:_dlc_DocId msdt:dt="string">Z5HNVW24N33T-678105430-3966</mso:_dlc_DocId>
        <mso:_dlc_DocIdItemGuid msdt:dt="string">029a8575-4aad-4138-b05d-5f86afb8c356</mso:_dlc_DocIdItemGuid>
        <mso:_dlc_DocIdUrl msdt:dt="string">http://inet/eni-transverse/ecole-numérique/_layouts/15/DocIdRedir.aspx?ID=Z5HNVW24N33T-678105430-3966, Z5HNVW24N33T-678105430-3966</mso:_dlc_DocIdUrl>
        </mso:CustomDocumentProperties>
        </xml><![endif]-->

    </head>
    <body class="container">

    <header class="py-3 bg-dark header-demodule fixed-top">
        <div class="container text-center text-white">
            <h1>Courses</h1>
        </div>
    </header>

    <div class="col-12">
        <h2 class="my-5 text-center">Listes prÃ©dÃ©finies</h2>

        <div class="row">
            <ul class="list-group col-12">
                <li class="list-group-item d-flex justify-content-between align-items-center">Liste bio
                    <div>
                        <a href="panier.html" class="badge" title="Commencer ses courses"><i class="material-icons">shopping_cart</i></a>
                        <a href="#supprimer" class="badge text-danger" title="Supprimer"><i class="material-icons">delete</i></a>
                    </div>

                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center">Liste grande surface
                    <div>
                        <a href="panier.html" class="badge" title="Commencer ses courses"><i class="material-icons">shopping_cart</i></a>
                        <a href="#supprimer" class="badge text-danger" title="Supprimer"><i class="material-icons">delete</i></a>
                    </div>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center">Liste surgelÃ©s
                    <div>
                        <a href="panier.html" class="badge" title="Commencer ses courses"><i class="material-icons">shopping_cart</i></a>
                        <a href="#supprimer" class="badge text-danger" title="Supprimer"><i class="material-icons">delete</i></a>
                    </div>
                </li>
            </ul>
        </div>

        <!-- Footer -->
        <footer class="row bg-dark footer-demodule fixed-bottom py-1">
            <div class="col-lg-4 offset-lg-4 text-center">
                <a class="btn" href="nouvelle_liste.html" title="CrÃ©er une nouvelle liste"><i class="material-icons">add</i></a>
            </div>
            <!-- /.container -->
        </footer>

        <!-- Bootstrap core JavaScript -->
        <script src="../../../vendor/jquery/jquery.min.js"></script>
        <script src="../../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
