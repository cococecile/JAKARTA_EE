package poei.persistance.bean;

public class User {
	
	private Integer id;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String mot_de_passe;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return nom;
	}

	public void setName(String name) {
		this.nom = name;
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

	public static User buildUserDo(Integer id, String name, String prenom, String adresse, String mot_de_passe,
			String email) {
		final User userDo = new User();
		userDo.id = id;
		userDo.nom = name;
		userDo.prenom = prenom;
		userDo.adresse = adresse;
		userDo.mot_de_passe = mot_de_passe;
		userDo.email = email;
		return userDo;
	}

}
