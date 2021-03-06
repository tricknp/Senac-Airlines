/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.model.database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yuri
 */
@Entity
@Table(name = "bagagens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bagagens.findAll", query = "SELECT b FROM Bagagens b")
    , @NamedQuery(name = "Bagagens.findById", query = "SELECT b FROM Bagagens b WHERE b.id = :id")
    , @NamedQuery(name = "Bagagens.findByClienteId", query = "SELECT b FROM Bagagens b WHERE b.clienteId = :clienteId")
    , @NamedQuery(name = "Bagagens.findByFoiEncaminhada", query = "SELECT b FROM Bagagens b WHERE b.foiEncaminhada = :foiEncaminhada")
    , @NamedQuery(name = "Bagagens.findByVooId", query = "SELECT b FROM Bagagens b WHERE b.vooId = :vooId")
    , @NamedQuery(name = "Bagagens.findByPeso", query = "SELECT b FROM Bagagens b WHERE b.peso = :peso")})
public class Bagagens implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "clienteId")
    private int clienteId;
    @Basic(optional = false)
    @Column(name = "foiEncaminhada")
    private boolean foiEncaminhada;
    @Basic(optional = false)
    @Column(name = "vooId")
    private int vooId;
    @Basic(optional = false)
    @Column(name = "peso")
    private double peso;

    public Bagagens() {
    }

    public Bagagens(Integer id) {
        this.id = id;
    }

    public Bagagens(Integer id, int clienteId, boolean foiEncaminhada, int vooId, double peso) {
        this.id = id;
        this.clienteId = clienteId;
        this.foiEncaminhada = foiEncaminhada;
        this.vooId = vooId;
        this.peso = peso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public boolean getFoiEncaminhada() {
        return foiEncaminhada;
    }

    public void setFoiEncaminhada(boolean foiEncaminhada) {
        this.foiEncaminhada = foiEncaminhada;
    }

    public int getVooId() {
        return vooId;
    }

    public void setVooId(int vooId) {
        this.vooId = vooId;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bagagens)) {
            return false;
        }
        Bagagens other = (Bagagens) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "local.model.database.Bagagens[ id=" + id + " ]";
    }
    
}
