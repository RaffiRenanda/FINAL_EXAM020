/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FINAL_EXAM;

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
 * @author TUF GAMING
 */
@Entity
@Table(name = "surat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Surat.findAll", query = "SELECT s FROM Surat s"),
    @NamedQuery(name = "Surat.findById", query = "SELECT s FROM Surat s WHERE s.id = :id"),
    @NamedQuery(name = "Surat.findByNoSurat", query = "SELECT s FROM Surat s WHERE s.noSurat = :noSurat"),
    @NamedQuery(name = "Surat.findByJudul", query = "SELECT s FROM Surat s WHERE s.judul = :judul"),
    @NamedQuery(name = "Surat.findByTembusan", query = "SELECT s FROM Surat s WHERE s.tembusan = :tembusan"),
    @NamedQuery(name = "Surat.findByFile", query = "SELECT s FROM Surat s WHERE s.file = :file"),
    @NamedQuery(name = "Surat.findByTs", query = "SELECT s FROM Surat s WHERE s.ts = :ts")})
public class Surat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "noSurat")
    private String noSurat;
    @Column(name = "Judul")
    private String judul;
    @Column(name = "Tembusan")
    private String tembusan;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "File")
    private Float file;
    @Basic(optional = false)
    @Column(name = "TS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ts;

    public Surat() {
    }

    public Surat(Integer id) {
        this.id = id;
    }

    public Surat(Integer id, Date ts) {
        this.id = id;
        this.ts = ts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoSurat() {
        return noSurat;
    }

    public void setNoSurat(String noSurat) {
        this.noSurat = noSurat;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTembusan() {
        return tembusan;
    }

    public void setTembusan(String tembusan) {
        this.tembusan = tembusan;
    }

    public Float getFile() {
        return file;
    }

    public void setFile(Float file) {
        this.file = file;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
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
        if (!(object instanceof Surat)) {
            return false;
        }
        Surat other = (Surat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FINAL_EXAM.Surat[ id=" + id + " ]";
    }
    
}
