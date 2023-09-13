package Commands;


import model.Movie;

import java.util.ArrayList;

public class Remove_by_id extends Command {
    int id;

    public Remove_by_id(int id){
        this.id = id;
    }

    @Override
    public String runCommand(ArrayList<Movie> arrayList){
        if (id >= arrayList.size()) return "Your suggested ID is out of range. There is no element with such ID in the collection yet";
        else {
            arrayList.remove(id);
            return "The element is successfully removed";
        }
    }
}
