package fr.diginamic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name="pays")
public class Pays {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	private String nom;
	
	public Pays() {

	}
	public Pays(String nom) {
		super();
		this.nom = nom;
	}
	
	@ManyToMany(mappedBy = "pays")
	private List<Film> film = new ArrayList<Film>();
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(nom).toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Pays)) {
			return false;
		}
		Pays autre = (Pays)obj;
		return new EqualsBuilder().append(nom, autre.getNom()).isEquals();
	}
	
	public List<Film> getFilm() {
		return film;
	}
	public void setFilm(List<Film> film) {
		this.film = film;
	}
	/** Getter
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/** Setter
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	

}