/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.entity;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Embeddable;

/**
 *
 * @author Administrateur
 */
@Embeddable

public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Short num;

    private String rue;

    private String localite;

    private Long codepostal;
    private String pays;

	public Adresse(){
	}
	
    public Adresse(Short num, String rue, String localite, Long codepostal, String pays) {
		super();
		this.num = num;
		this.rue = rue;
		this.localite = localite;
		this.codepostal = codepostal;
		this.pays = pays;
	}

	public Short getNum() {
        return num;
    }

    public void setNum(Short num) {
        this.num = num;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public Long getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(Long codepostal) {
		this.codepostal = codepostal;
	}

	public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }   
}
