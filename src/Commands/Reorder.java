package Commands;


import model.Movie;

import java.util.ArrayList;
import java.util.Collections;

public class Reorder extends Command {
    @Override
    public String runCommand(ArrayList<Movie> arrayList){
        Collections.reverse(arrayList);
        return "Collection is reversed";
    }
}
