package Commands;

import model.Movie;
import model.MovieGenre;

import java.util.ArrayList;

public class Count_less_than_genre extends Command {
    MovieGenre genre;

    public Count_less_than_genre(MovieGenre genre){
        this.genre = genre;
    }

    @Override
    public String runCommand(ArrayList<Movie> arrayList){
        /*int counter = 0;
        for(Movie i : arrayList){
            if(i.getGenre().getGenreRating() < genre.getGenreRating()) counter ++;
        }*/
        long counter = arrayList.stream().filter(i -> i.getGenre().getGenreRating() < genre.getGenreRating()).count();

        return "There are " + counter + " elements with genre lesser than suggested";
    }
}
