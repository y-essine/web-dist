package twin.microservice.assurance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
enum Couverture {
    RESPONSABILITE_CIVILE,
    COLLISION,
    VOL,
    INCENDIE,
    AUTRES
}

@Entity
public class Assurance implements Serializable {
    @Id
    @GeneratedValue
    private  int id;
    private  int user_id;
    private Couverture couverture;
    private String typeAssurance;
    private String description;
    private double prix;
    private Date dateDebut;
    private Date dateFin;

    public Assurance(int id, int user_id, Couverture couverture, String typeAssurance, String description, double prix, Date dateDebut, Date dateFin) {
        this.id = id;
        this.user_id = user_id;
        this.couverture = couverture;
        this.typeAssurance = typeAssurance;
        this.description = description;
        this.prix = prix;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Couverture getCouverture() {
        return couverture;
    }

    public void setCouverture(Couverture couverture) {
        this.couverture = couverture;
    }

    public String getTypeAssurance() {
        return typeAssurance;
    }

    public void setTypeAssurance(String typeAssurance) {
        this.typeAssurance = typeAssurance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    public Assurance() {
        super();
    }
}
