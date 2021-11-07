package poei.persistance.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "article")
@SequenceGenerator(name = "article_id_seq", initialValue = 1, allocationSize = 1)
public class ArticleDo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_id_seq")
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "designation", length = 128, nullable = false)
	private String designation;
	
	@Column(name = "description", length = 128, nullable = false)
	private String description;
	
	@Column(name = "quantite", length = 128, nullable = false)
	private int quantite;

	public ArticleDo() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
