<%-- 
    Document   : listagemDeps
    Created on : 23 de set. de 2022, 10:34:30
    Author     : joao.vmgonso
--%>

<%@page import="model.Vagas"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de clientes</title>
        <link rel="stylesheet" type="text/css" href="lista.css">
    </head>
    <body>
        <%
            List<Vagas> vagas = (List<Vagas>) request.getAttribute("vagas");
        %>
        
        <table id="tabela">
            <tr>
                <th>Nome</th>
                <th>Ramo</th>
                <th>Envio</th>
                <th>Link</th>
                <th>Motivo</th>
                <th>Site de Recrutamento</th>
                <th>Data</th>
                <th>Excluir vaga</th>
            </tr>
            <%
               for(Vagas vaga: vagas){
            %>
            
            <tr>
                <td> <%= vaga.getNome() %> </td>
                <td> <%= vaga.getRamo() %> </td>
                <td> <%= vaga.getEnvio() %> </td>
                <td> <a target="_blank" href="<%= vaga.getLink() %>">Acessar</a> </td>
                <td> <%= vaga.getMotivo() %> </td>
                <td> <%= vaga.getSiteRecrutamento() %> </td>
                <td> <%= vaga.getData() %> </td>
                <td> <a href="Controle?flag=excluirVaga&nomeEmpresa=<%= vaga.getNome() %>">Excluir</a> </td>
            </tr>
            
            <%
                }  
            %>
        </table>
        
    </body>
</html>
