package model;

import java.io.Serializable;

public enum MovieGenre implements Serializable {
    DRAMA(4),
    HORROR(1),
    SCIENCE_FICTION(5);

    private int genreRating;
    MovieGenre(int genreRating){
        this.genreRating = genreRating;
    }

    public int getGenreRating(){
        return this.genreRating;
    }
}
