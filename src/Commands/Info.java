package Commands;


import model.Movie;

import java.util.ArrayList;

public class Info extends Command {
    @Override
    public String runCommand(ArrayList<Movie> arrayList){
        return "Collection type is Movie" + "\n" + "There are " + arrayList.size() + " elements in the collection currently";
    }
}
