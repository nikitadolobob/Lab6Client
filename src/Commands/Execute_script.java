package Commands;


import model.Movie;

import java.util.ArrayList;

public class Execute_script extends Command {
    String fileName;

    public Execute_script(String fileName){
        this.fileName = fileName;
    }

    @Override
    public String runCommand(ArrayList<Movie> arrayList){return null;}
}
