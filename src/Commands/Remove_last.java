package Commands;


import model.Movie;

import java.util.ArrayList;

public class Remove_last extends Command {
    @Override
    public String runCommand(ArrayList<Movie> arrayList){
        if(arrayList.isEmpty()) {return "The collection does not have elements to remove";}
        else{
            arrayList.remove(arrayList.size() - 1);
            return "The last element is removed";
        }
    }
}
