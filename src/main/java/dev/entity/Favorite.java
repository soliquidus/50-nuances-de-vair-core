package dev.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Table(name = "favorite", indexes = {
        @Index(name = "id_user_fav", columnList = "id_user_fav")
})
@Entity
public class Favorite {
    @EmbeddedId
    private FavoriteId id;

    public FavoriteId getId() {
        return id;
    }

    public void setId(FavoriteId id) {
        this.id = id;
    }
}