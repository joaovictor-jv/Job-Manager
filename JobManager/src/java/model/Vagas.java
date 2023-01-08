/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmira
 */
@Entity
@Table(name = "vagas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vagas.findAll", query = "SELECT v FROM Vagas v"),
    @NamedQuery(name = "Vagas.findByNome", query = "SELECT v FROM Vagas v WHERE v.nome = :nome"),
    @NamedQuery(name = "Vagas.findByRamo", query = "SELECT v FROM Vagas v WHERE v.ramo = :ramo"),
    @NamedQuery(name = "Vagas.findByEnvio", query = "SELECT v FROM Vagas v WHERE v.envio = :envio"),
    @NamedQuery(name = "Vagas.findByLink", query = "SELECT v FROM Vagas v WHERE v.link = :link"),
    @NamedQuery(name = "Vagas.findByMotivo", query = "SELECT v FROM Vagas v WHERE v.motivo = :motivo"),
    @NamedQuery(name = "Vagas.findByData", query = "SELECT v FROM Vagas v WHERE v.data = :data"),
    @NamedQuery(name = "Vagas.findBySiteRecrutamento", query = "SELECT v FROM Vagas v WHERE v.siteRecrutamento = :siteRecrutamento")})
public class Vagas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Ramo")
    private String ramo;
    @Column(name = "Envio")
    private String envio;
    @Column(name = "Link")
    private String link;
    @Column(name = "Motivo")
    private String motivo;
    @Column(name = "Data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "siteRecrutamento")
    private String siteRecrutamento;

    public Vagas() {
    }

    public Vagas(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public String getEnvio() {
        return envio;
    }

    public void setEnvio(String envio) {
        this.envio = envio;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getSiteRecrutamento() {
        return siteRecrutamento;
    }

    public void setSiteRecrutamento(String siteRecrutamento) {
        this.siteRecrutamento = siteRecrutamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nome != null ? nome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vagas)) {
            return false;
        }
        Vagas other = (Vagas) object;
        if ((this.nome == null && other.nome != null) || (this.nome != null && !this.nome.equals(other.nome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vagas[ nome=" + nome + " ]";
    }
    
}
