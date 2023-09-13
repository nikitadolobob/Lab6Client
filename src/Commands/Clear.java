package Commands;

import model.Movie;

import java.util.ArrayList;

public class Clear extends Command{
    @Override
    public String runCommand(ArrayList<Movie> arrayList){
        arrayList.clear();
        return "collection is empty";
    }
}
