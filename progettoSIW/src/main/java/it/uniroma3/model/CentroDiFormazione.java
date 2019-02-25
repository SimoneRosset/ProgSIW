package it.uniroma3.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="centro")
public class CentroDiFormazione {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String indirizzo;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String tel;
	@Column(nullable=false)
	private String capienzaMassima;
	@OneToMany(mappedBy="centroDiFormazione")
	private List<Attivita> attivita;

	public CentroDiFormazione(String nome, String indirizzo, String email, String tel, String capienzaMassima) {
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.email = email;
		this.tel = tel;
		this.capienzaMassima = capienzaMassima;
	}

	public CentroDiFormazione() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCapienzaMassima() {
		return capienzaMassima;
	}

	public void setCapienzaMassima(String capienzaMassima) {
		this.capienzaMassima = capienzaMassima;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capienzaMassima == null) ? 0 : capienzaMassima.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((indirizzo == null) ? 0 : indirizzo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CentroDiFormazione other = (CentroDiFormazione) obj;
		if (capienzaMassima == null) {
			if (other.capienzaMassima != null)
				return false;
		} else if (!capienzaMassima.equals(other.capienzaMassima))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CentroDiFormazione [nome=" + nome + ", indirizzo=" + indirizzo + ", email=" + email + ", tel=" + tel
				+ ", capienzaMassima=" + capienzaMassima + "]";
	}
	
	
	

}
