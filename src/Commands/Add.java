package Commands;

import model.Movie;

import java.util.ArrayList;

public class Add extends Command{
    Movie movie = new Movie();

    public Add(Movie movie){
        this.movie = movie;
    }

    @Override
    public String runCommand(ArrayList<Movie> arrayList){
        /*int maxId = 0;
        for(Movie i : arrayList){
            if(i.getId() > maxId) maxId = i.getId();
        }*/
        int maxId = arrayList.stream().mapToInt(Movie::getId).max().orElse(0);
        movie.setId(maxId + 1);
        arrayList.add(movie);
        return "Element is added to the collection";
    }
}
