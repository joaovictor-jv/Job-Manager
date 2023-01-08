<%@page import="model.Vagas"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Altera data</title>
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <%
            String data = "";
            Vagas vaga = (Vagas) request.getAttribute("vaga");

            SimpleDateFormat formata = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.US);

            try {
                Date dAntiga = vaga.getData();
                data = formata.format(dAntiga);
                //Date dataSaida = formata.parse(request.getParameter("entradaCliente"));
            } catch (Exception ex) {
                out.print(ex.getMessage());
            }

        %>    


        <form method="post" action="Controle" class="row g-0 py-1">
            <input type="hidden" name="flag" value="alteraVag">
            <!--
            <p>
                <label for="nomeEmpresa">Nome da Empresa:</label>
                <input type="text" size="50" name="nomeEmpresa" maxlength="50"  value="<%= vaga.getNome() %>" id="nomeEmpresa" required>
            </p>
            <p>
                <label for="ramoEmpresa">Ramo da Empresa:</label>
                <input type="text" size="40" maxlength="40" name="ramoEmpresa" value="<%= vaga.getRamo() %>" id="ramoEmpresa">
            </p>
            <p>
                <label for="envioCurriculo">Envio:</label>
                <input type="text" size="5" maxlength="5" name="envioCurriculo" value="<%= vaga.getEnvio() %>" id="envioCurriculo" >
            </p>
            <p>
                <label for="link">Link:</label>
                <input type="text" size="144" maxlength="256" name="link" value="<%= vaga.getLink() %>" id="link" >
            </p>
            <p>
                <label for="motivo">Motivo:</label><br>
                <textarea id="motivo" name="motivo" rows="4" cols="50" value="<%= vaga.getMotivo() %>"></textarea>
            </p>
            <p>
                <label for="data">Data:</label>
                <input type="datetime-local" size="45" maxlength="45" name="data" value="<%= vaga.getData() %>" id="data" >
            </p>
            <p>
                <input type="submit" value="Salvar" id="btnSaida">
            </p>
            -->
            
            <div class="col-md-6">
                <label for="inputEmail4" class="form-label">Nome da Empresa</label>
                <input type="text" class="form-control" name="nomeEmpresa" value="<%= vaga.getNome() %>" required>
            </div>
            <div class="col-md-4 px-1">
                <label for="inputPassword4" class="form-label">Ramo da Empresa</label>
                <input type="text" class="form-control" name="ramoEmpresa" value="<%= vaga.getRamo() %>">
            </div>
            <div class="col-md-2">
                <label for="inputAddress" class="form-label">Curriculo foi enviado ?</label>
                <input type="text" class="form-control" name="envioCurriculo" value="<%= vaga.getEnvio() %>" placeholder="Sim ou Não" required>
            </div>
            <div class="col-md-12 py-1">
                <label for="inputAddress2" class="form-label">Link</label>
                <input type="text" class="form-control" name="link" value="<%= vaga.getLink() %>" placeholder="Coloque o link da vaga" required>
            </div>
            <div class="col-md-12 py-1">
                <label for="validationTextarea" class="form-label">Motivo(Caso não tenha enviado o curriculo)</label>
                <textarea class="form-control" name="motivo" value="<%= vaga.getMotivo() %>"></textarea>
            </div>
            <div class="col-md-2 py-1">
                <label for="validationCustom04" class="form-label">Site de Recrutamento</label>
                <select class="form-select" id="validationCustom04" name="siteRecrutamento" required>
                    <option selected disabled value="<%= vaga.getSiteRecrutamento() %>">Selecione...</option>
                    <option>99jobs</option>
                    <option>Catho</option>
                    <option>Ciee</option>
                    <option>Empregos.com</option>
                    <option>Glassdoor</option>
                    <option>Gupy.io</option>
                    <option>Indeed</option>
                    <option>InfoJobs</option>
                    <option>Programathor</option>
                    <option>Nenhum</option>
                </select>
            </div>
            <div class="col-md-2 py-1 px-1">
                <label for="inputAddress2" class="form-label">Data</label>
                <input type="datetime-local" class="form-control" name="data" value="<%= vaga.getData() %>" required>
            </div>
            <div class="col-12 py-1">
                <button type="submit" class="btn btn-primary">Salvar</button>
            </div>

        </form>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    </body>
</html>