package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Login;
import model.PersistenceDao;
import model.Vagas;

@WebServlet(name = "Controle", urlPatterns = {"/Controle"})
public class Controle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String email, senha, flag, emailUsuario;
        Date data = null;
        String mensagem;
        int retorno;
        PersistenceDao dao;
        Login dadosLoginUsuario;
        Vagas vag;
        String nomeEmpresa, ramoEmpresa, envioCurriculo, link, motivo, siteRecrutamento;

        flag = request.getParameter("flag");
        if (flag.equalsIgnoreCase("login")) {

            email = request.getParameter("user");
            senha = request.getParameter("senha");

            Login log = new Login();
            log.setEmail(email);
            log.setSenha(senha);

            dao = new PersistenceDao();
            dadosLoginUsuario = dao.validarUsuario(email, senha);

            if (dadosLoginUsuario == null) {
                mensagem = "Usuário e/ou senhas inválidos";

                request.setAttribute("mensagem", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
                disp.forward(request, response);
            } else {
                emailUsuario = dadosLoginUsuario.getEmail();
                response.sendRedirect("restrito.jsp?nome=" + emailUsuario);
            }

        } else if (flag.equalsIgnoreCase("cadVag")) {
            nomeEmpresa = request.getParameter("nomeEmpresa");
            ramoEmpresa = request.getParameter("ramoEmpresa");
            envioCurriculo = request.getParameter("envioCurriculo");
            link = request.getParameter("link");
            motivo = request.getParameter("motivo");
            siteRecrutamento = request.getParameter("siteRecrutamento");
            SimpleDateFormat formata = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.US);

            try {
                data = formata.parse(request.getParameter("data"));
            } catch (Exception ex) {
                out.print(ex.getMessage());
            }
            try {
            } catch (Exception ex) {
                out.print(ex.getMessage());
            }

            vag = new Vagas();
            vag.setNome(nomeEmpresa);
            vag.setRamo(ramoEmpresa);
            vag.setEnvio(envioCurriculo);
            vag.setLink(link);
            vag.setMotivo(motivo);
            vag.setData(data);
            vag.setSiteRecrutamento(siteRecrutamento);

            dao = new PersistenceDao();
            retorno = dao.cadastrarVaga(vag);
            if (retorno == 1) {
                mensagem = nomeEmpresa + " salvo com sucesso";
            } else if (retorno == 2) {
                mensagem = "Esta empresa já foi cadastrada";
            } else {
                mensagem = "Erro: Entre em contato com o admin";
            }
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
            disp.forward(request, response);

        } else if (flag.equalsIgnoreCase("excluirVaga")) {
            nomeEmpresa = request.getParameter("nomeEmpresa");
            dao = new PersistenceDao();
            retorno = dao.excluirVaga(nomeEmpresa);
            if (retorno == 1) {
                mensagem = "Empresa: " + nomeEmpresa + " excluido com sucesso";
            } else {
                mensagem = "Erro ao tentar excluir a empresa: " + nomeEmpresa;
            }
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
            disp.forward(request, response);

        } else if (flag.equalsIgnoreCase("consultarVaga")) {
            nomeEmpresa = request.getParameter("nomeEmpresa");
            dao = new PersistenceDao();
            List<Vagas> vaga = dao.consultarVaga(nomeEmpresa);
            if (vaga == null) {
                mensagem = "Esta vaga não foi encontrada";
                request.setAttribute("mensagem", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
                disp.forward(request, response);
            } else {
                request.setAttribute("vagas", vaga);
                RequestDispatcher disp = request.getRequestDispatcher("consultaVag.jsp");
                disp.forward(request, response);
            }

        } else if (flag.equalsIgnoreCase("listarVaga")) {
            dao = new PersistenceDao();
            List<Vagas> vaga = dao.listarVagas();
            if (vaga == null) {
                mensagem = "Nenhuma vaga foi encontrado";
                request.setAttribute("mensagem", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
                disp.forward(request, response);
            } else {
                request.setAttribute("vagas", vaga);
                RequestDispatcher disp = request.getRequestDispatcher("listagemVag.jsp");
                disp.forward(request, response);
            }

        } else if (flag.equalsIgnoreCase("altVag")) {
            nomeEmpresa = request.getParameter("nomeEmpresa");
            dao = new PersistenceDao();
            Vagas vaga = dao.consultarNome(nomeEmpresa);
            request.setAttribute("vaga", vaga);
            RequestDispatcher disp = request.getRequestDispatcher("alteraVag.jsp");
            disp.forward(request, response);

        } else if (flag.equalsIgnoreCase("alteraVag")) {
            nomeEmpresa = request.getParameter("nomeEmpresa");
            envioCurriculo = request.getParameter("envioCurriculo");
            
            //Pega a data saida e converte para poder cadastrar
            SimpleDateFormat formata = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.US);
            
            try{
                data = formata.parse(request.getParameter("data"));
            } catch(Exception e){
                
            }
            
            dao = new PersistenceDao();
            retorno = dao.alterarVaga(nomeEmpresa, data, envioCurriculo);
            if (retorno == 1) {
                mensagem = "Alteração realizada com sucesso";
            } else {
                mensagem = "Erro na alteração";
            }
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
            disp.forward(request, response);

        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}