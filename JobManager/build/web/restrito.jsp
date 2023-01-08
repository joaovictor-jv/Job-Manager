<%-- 
    Document   : restrito
    Created on : 2 de set. de 2022, 10:29:08
    Author     : joao.vmgonso
--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sistema</title>
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="config.css">
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <header>

            <div class="logo"> <img src="logoJobManager.png"> </div>

            <div class="acesso">

                <%
                    String nomeUsu;
                    nomeUsu = request.getParameter("nome");
                %>

                <p>
                    <b>Bem-vindo</b> <font color="white"><%=nomeUsu%> </font>
                </p>

            </div>

        </header>


        <!--
        <div class="menu">
            <button class="botao"><a href="abertura.html" target="centro" id="home">Home</a></button>
        </div>

        <div class="menu">

            <button class="botao">Funções</button>
            <div class="submenu">
                <a href="cadVag.html" target="centro">Cadastro de Vagas</a>
                <a href="conVag.html" target="centro">Consulta de Vagas</a>
                <a href="listVag.html" target="centro">Listagem de Vagas</a>
                <a href="altVag.html" target="centro">Alterar Vaga</a>
                <a href="excVag.html" target="centro">Exclusão da Vaga</a>
            </div>
        </div>
        -->


        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <div class="container-fluid mx-auto" style="width:900px;">
                <a class="navbar-brand" href="abertura.html" target="centro">Job Manager</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active mx-auto" style="width: 70px;" aria-current="page" href="abertura.html" target="centro" id="home">Home</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle active" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Funções
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="cadVag.html" target="centro">Cadastro de Vagas</a></li>
                                <li><a class="dropdown-item" href="conVag.html" target="centro">Consulta de Vagas</a></li>
                                <li><a class="dropdown-item" href="listVag.html" target="centro">Listagem de Vagas</a></li>
                                <li><a class="dropdown-item" href="altVag.html" target="centro">Alterar Vaga</a></li>
                                <li><a class="dropdown-item" href="excVag.html" target="centro">Exclusão da Vaga</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>



        <section>

            <iframe src="abertura.html" name="centro"></iframe>

        </section>
        <footer>

        </footer>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    </body>
</html>
