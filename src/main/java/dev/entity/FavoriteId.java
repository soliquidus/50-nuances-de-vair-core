package dev.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FavoriteId implements Serializable {
    private static final long serialVersionUID = 111500458497055719L;
    @Column(name = "id_city_fav", nullable = false)
    private Long idCityFav;
    @Column(name = "id_user_fav", nullable = false)
    private Long idUserFav;

    public Long getIdUserFav() {
        return idUserFav;
    }

    public void setIdUserFav(Long idUserFav) {
        this.idUserFav = idUserFav;
    }

    public Long getIdCityFav() {
        return idCityFav;
    }

    public void setIdCityFav(Long idCityFav) {
        this.idCityFav = idCityFav;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCityFav, idUserFav);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FavoriteId entity = (FavoriteId) o;
        return Objects.equals(this.idCityFav, entity.idCityFav) &&
                Objects.equals(this.idUserFav, entity.idUserFav);
    }
}