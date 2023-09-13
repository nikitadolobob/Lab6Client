package Commands;

import model.Movie;

import java.util.ArrayList;

public class Add_if_min extends Command{
    Movie movie = new Movie();

    public Add_if_min(Movie movie){
        this.movie = movie;
    }

    boolean checker = true;
    @Override
    public String runCommand(ArrayList<Movie> arrayList){
        /*for(Movie i : arrayList){
            if(movie.compareTo(i) > 0){
                checker = false;
            }
        }*/
        boolean checker = arrayList.stream().allMatch(i -> movie.compareTo(i) <= 0);
        if(checker) {
            /*int maxId = 0;
            for(Movie i : arrayList){
                if(i.getId() > maxId) maxId = i.getId();
            }*/
            int maxId = arrayList.stream().mapToInt(Movie::getId).max().orElse(0);
            movie.setId(maxId + 1);
            arrayList.add(movie);
            return "Element is successfully added to the collection";
        }
        else return "Your element is not small enough to enter collection";
    }
}
