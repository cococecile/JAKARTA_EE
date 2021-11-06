package poei.persistance.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class UserDo {
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "nom", length = 128, nullable = false)
	private String nom;
	
	@Column(name = "prenom", length = 128, nullable = false)
	private String prenom;
	
	@Column(name = "adresse", length = 400, nullable = true)
	private String adresse;
	
	@Column(name = "email", length = 128, nullable = false)
	private String email;
	
	@Column(name = "", length = 128, nullable = false)
	private String mot_de_passe;

	public UserDo() {
		// TODO Auto-generated constructor stub
	}


	public UserDo(Integer id, String nom, String prenom, String adresse, String email, String mot_de_passe) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.mot_de_passe = mot_de_passe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public static UserDo buildUserDo(Integer id, String name, String prenom, String adresse, String mot_de_passe,
			String email) {
		final UserDo userDo = new UserDo();
		userDo.id = id;
		userDo.nom = name;
		userDo.prenom = prenom;
		userDo.adresse = adresse;
		userDo.mot_de_passe = mot_de_passe;
		userDo.email = email;
		return userDo;
	}

}
