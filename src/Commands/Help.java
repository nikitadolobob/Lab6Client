package Commands;


import client.CommandList;
import model.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class Help extends Command {

    @Override
    public String runCommand(ArrayList<Movie> arrayList){
        /*String message = "";
        for(CommandList i : CommandList.values()){
            message += i.name().toLowerCase(Locale.ROOT) + ": " ;
            message += i.printPrescription() + "\n";
        }*/
        String message = Arrays.stream(CommandList.values()).map(i -> i.name().toLowerCase() + ": " + i.printPrescription()).collect(Collectors.joining("\n"));
        return message;
    }
}
