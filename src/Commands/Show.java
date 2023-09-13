package Commands;


import model.Movie;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Show extends Command {
    @Override
    public String runCommand(ArrayList<Movie> arrayList){
        /*if(arrayList.isEmpty()) return "The collection is curently empty";
        else{
            String message = "";
            for(Movie i : arrayList){
                message += i.toString() + "\n";
            }
            return message;
        }*/
        return arrayList.isEmpty() ? "The collection is currently empty" : arrayList.stream().map(Movie::toString).collect(Collectors.joining("\n"));
    }
}
