package model;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

public class PersistenceDao {

    private EntityManagerFactory conn;
    private EntityManager manager;
    private Login dadosLoginUsuario;

    public void conectar() {
        conn = Persistence.createEntityManagerFactory("JobManagerPU");
        manager = conn.createEntityManager();
    }

    public void desconectar() {
        manager.close();
        conn.close();
    }

    public Login validarUsuario(String email, String senha) {
        conectar();
        try {
            TypedQuery<Login> query = manager.createNamedQuery("Login.findByEmailSenha", Login.class);
            query.setParameter("email", email);
            query.setParameter("senha", senha);
            Login usuario = query.getSingleResult();
            return usuario;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();

        }
    }

    public int cadastrarVaga(Vagas vag) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(vag);
            manager.getTransaction().commit();
            return 1;
        } catch (EntityExistsException | RollbackException e) {
            return 2;
        } catch (Exception e) {
            return 3;
        } finally {
            desconectar();
        }
    }
    
    public int excluirVaga(String nomeEmpresa) {
        conectar();
        try {
            //Localiza o cliente que queremos excluir
            Vagas vaga = new Vagas();
            vaga = manager.find(Vagas.class, nomeEmpresa);
            //Exclui o cliente localizado
            manager.getTransaction().begin();
            manager.remove(vaga);
            manager.getTransaction().commit();
            return 1;
        } catch (Exception ex) {
            return 2;
        } finally {
            desconectar();
        }
    }

    //Consulta a vaga por completa
    public List<Vagas> consultarVaga(String vaga) {
        conectar();
        try {
            TypedQuery<Vagas> query = manager.createNamedQuery("Vagas.findByNome", Vagas.class);
            query.setParameter("nome", vaga);
            List<Vagas> vagas = query.getResultList();
            return vagas;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();

        }
    }

    //Consulta nome para alterações
    public Vagas consultarNome(String n) {
        conectar();
        try {
            TypedQuery<Vagas> query = manager.createNamedQuery("Vagas.findByNome", Vagas.class);
            query.setParameter("nome", n);
            Vagas vaga = query.getSingleResult();
            return vaga;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();

        }
    }

    public List<Vagas> listarVagas() {
        conectar();
        try {
            TypedQuery<Vagas> query = manager.createNamedQuery("Vagas.findAll", Vagas.class);
            List<Vagas> vagas = query.getResultList();
            return vagas;
        } catch (NoResultException ex) {
            return null;
        } finally {
            desconectar();

        }
    }
    
    public int alterarVaga(String nomeEmpresa, Date data, String envioCurriculo) {
        conectar();
        Vagas vaga = manager.find(Vagas.class, nomeEmpresa);
        vaga.setData(data);
        vaga.setEnvio(envioCurriculo);
        try {
            manager.getTransaction().begin();
            manager.merge(vaga);
            manager.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            desconectar();
        }
    }

}
