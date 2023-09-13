package Commands;

import model.Movie;
import model.MovieGenre;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Filter_greater_than_genre extends Command {
    MovieGenre genre;

    public Filter_greater_than_genre(MovieGenre genre){
        this.genre = genre;
    }

    @Override
    public String runCommand(ArrayList<Movie> arrayList){
        /*String message = "";
        for(Movie i : arrayList){
            if(i.getGenre().getGenreRating() > genre.getGenreRating()) {
                message += i.toString() + "\n";
            }
        }
        if(message.isEmpty()) return "There are no movies complimenting your requirements";
        else return message;*/
        String message = arrayList.stream().filter(i -> i.getGenre().getGenreRating() > genre.getGenreRating()).map(Movie::toString).collect(Collectors.joining("\n"));
        return message.isEmpty() ? "There are no movies complimenting your requirements" : message;
    }
}
