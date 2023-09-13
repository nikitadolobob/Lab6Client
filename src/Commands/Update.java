package Commands;


import model.Movie;

import java.util.ArrayList;

public class Update extends Command {
    int id;

    Movie movie;

    public Update(int id, Movie movie){
        this.id = id;
        this.movie = movie;
    }

    @Override
    public String runCommand(ArrayList<Movie> arrayList){

        if(arrayList.isEmpty()) return "Suggested ID is out range. There is no element with such ID in the collection yet";
        else{
            /*int true_id = -1;
            for(Movie movie : arrayList){
                if(movie.getId() == id) true_id = movie.getId();
            }*/
            int true_id = arrayList.stream().filter(m -> m.getId() == id).mapToInt(Movie::getId).findFirst().orElse(-1);
            if(true_id == -1){
                return "There is no element with such ID in the collection.";
            }
            arrayList.set(true_id, movie);
            return "The element is updated";
        }
    }
}
