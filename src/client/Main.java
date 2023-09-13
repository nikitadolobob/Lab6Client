package client;

import Commands.Command;
import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    static ArrayList<String> fileNames = new ArrayList<>();
    public static ArrayList<Integer> countLines = new ArrayList<>();


    public static String[] ultyTrim(String line){
        String[] preTrim = line.split(" ");
        String[] trim = new String[0];
        for(String i : preTrim) if(!i.equals("")) {
            trim = Arrays.copyOf(trim, trim.length + 1);
            trim[trim.length - 1] = i;
        }
        return trim;
    }

    static Scanner scan = new Scanner(System.in);

    static boolean isScripted = false;

    static boolean cripledScript = false;

    static void printScript(String line){
        if(!isScripted) System.out.println(line);
    }

    static void printInvetation(){
        if(!isScripted) System.out.print("$ ");
    }

    public static model.Movie MovieGetter(){
        Movie movie = new Movie();

        movie.setId(0);


        try {
            String name = "";
            while (ultyTrim(name).length == 0) {
                printScript("Enter movie name");
                printInvetation();
                name = scan.nextLine();
                if(ultyTrim(name).length == 0) {
                    printScript("Name cannot be empty or consist of only spaces");

                }
            }
            movie.setName(name);

            Integer x = null;
            while (x == null) {
                printScript("Enter Integer x coordinate");
                printInvetation();

                try {
                    String s = scan.nextLine();
                    x = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    printScript("X coordinate must be integer number");

                }
            }
            Float y = null;
            while (y == null || y > 208) {
                if (y == null) {
                    printScript("Enter Float y coordinate that is not greater 208");
                    printInvetation();
                } else {
                    printScript("Enter float y coordinate no greater than 208");
                    printInvetation();
                }
                try {
                    String s = scan.nextLine();
                    y = Float.parseFloat(s);
                } catch (NumberFormatException e) {
                    y = null;
                    printScript("Y coordinate must be float number");
                }
            }
            Coordinates coordinates = new Coordinates(x, y);

            movie.setCoordinates(coordinates);
            movie.setCreationDate(ZonedDateTime.now());
            Integer oscarCount = null;
            while (oscarCount == null || oscarCount < 1) {
                if (oscarCount == null) {
                    printScript("Enter Integer amount of oscar nominations. Number must be above 0");
                    printInvetation();
                } else {
                    printScript("Integer number must be above 0");
                    printInvetation();
                }
                try {
                    String s = scan.nextLine();
                    oscarCount = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    oscarCount = null;
                    printScript("Enter integer amount of oscar nominations.");
                }
            }
            movie.setOscarsCount(oscarCount);

            String genre = "";
            while (genre.equals("")) {
                printScript("Choose one of the given genres and enter it (in caps)");

                for (MovieGenre gener : MovieGenre.values()) {
                    printScript(gener.name());
                }
                printInvetation();

                genre = scan.nextLine();
                boolean isAnAss = true;
                for (MovieGenre gener : MovieGenre.values()) {
                    if (gener.name().equals(genre)) {
                        movie.setGenre(gener);
                        isAnAss = false;
                    }
                }
                if (isAnAss) {
                    genre = "";
                    printScript("You ether made a typo or didn't write in caps or wrote something that was not an option. Please try again");
                }
            }

            String rating = null;
            boolean isAnAss = true;
            while (isAnAss && rating == null) {
                printScript("Choose one of the given ratings and enter it (in caps)");

                for (MpaaRating mpaaRating : MpaaRating.values()) {
                    printScript(mpaaRating.name());
                }
                printInvetation();

                rating = scan.nextLine();
                for (MpaaRating mpaaRating : MpaaRating.values()) {
                    if (mpaaRating.name().equals(rating)) {
                        movie.setMpaaRating(mpaaRating);
                        isAnAss = false;
                    }
                }
                if (isAnAss && !rating.equals("")) {
                    rating = null;
                    printScript("You ether made a typo or didn't write in caps or wrote something that was not an option. Please try again");

                }
            }

            Person director = new Person();
            String directorName = "";
            while (directorName.equals("")) {
                printScript("Enter director name");
                printInvetation();

                directorName = scan.nextLine();
            }
            director.setName(directorName);

            Float weight = null;
            printScript("Enter Float weight that is greater 0");
            printInvetation();

            while (weight == null || weight <= 0) {
                if(weight != null){
                    printScript("Weight must be greater than 0");
                    printInvetation();

                }
                try {
                    String s = scan.nextLine();
                    if (s.equals("")) break;
                    weight = Float.parseFloat(s);
                } catch (NumberFormatException e) {
                    weight = null;
                    printScript("Weight must be a float number");

                }
            }
            director.setWeight(weight);

            String eColour = null;
            boolean isIncorrect = true;
            while (isIncorrect && eColour == null){
                printScript("Choose one of the given eye colors for the director (in caps) or enter empty line to make it null");

                for (model.colorEyes.Color color : model.colorEyes.Color.values()) {
                    printScript(color.name());
                }
                printInvetation();

                eColour = scan.nextLine();
                for (model.colorEyes.Color color : model.colorEyes.Color.values()) {
                    if (color.name().equals(eColour)) {
                        isIncorrect = false;
                        director.setEyeColor(color);
                    }
                }
                if(isIncorrect && !eColour.equals("")){
                    printScript("No such eye color. Try again or enter empty line to keep it null");

                    eColour = null;
                }
            }

            String hColour;
            isIncorrect = true;
            while (isIncorrect){
                printScript("Choose one of the given hair colors for the director (in caps)");

                for (model.colorHair.Color color : model.colorHair.Color.values()) {
                    printScript(color.name());
                }
                printInvetation();


                hColour = scan.nextLine();
                for (model.colorHair.Color color : model.colorHair.Color.values()) {
                    if (color.name().equals(hColour)) {
                        director.setHairColor(color);
                        isIncorrect = false;
                    }
                }
                if(isIncorrect){
                    printScript("No such hair color!");

                }
            }


            String countryName;
            isIncorrect = true;
            while (isIncorrect){
                printScript("Choose one of the given origin countries for the director (in caps)");

                for (Country country : Country.values()) {
                    printScript(country.name());
                }
                printInvetation();

                countryName = scan.nextLine();
                for (Country country : Country.values()) {
                    if (country.name().equals(countryName)) {
                        director.setNationality(country);
                        isIncorrect = false;
                    }
                }
                if(isIncorrect){
                    printScript("No such country!");

                }
            }

            Double xl = null;
            while (xl == null) {
                printScript("Enter double x coordinate of directors location");
                printInvetation();

                try {
                    String s = scan.nextLine();
                    xl = Double.parseDouble(s);
                } catch (NumberFormatException e) {
                    printScript("You should enter double value");

                }
            }


            Integer yl = null;
            while (yl == null) {
                printScript("Enter int y coordinate of directors location");
                printInvetation();

                try {
                    String s = scan.nextLine();
                    yl = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    printScript("You should enter integer value");

                }
            }

            Float zl = null;
            while (zl == null) {
                printScript("Enter float z coordinate of directors location");
                printInvetation();

                try {
                    String s = scan.nextLine();
                    zl = Float.parseFloat(s);
                } catch (NumberFormatException e) {
                    printScript("You should enter float value");

                }
            }

            Location location = new Location(xl, yl, zl);
            director.setLocation(location);

            movie.setDirector(director);
            return movie;
        }
        catch(NoSuchElementException e){
            if(isScripted) printScript("File had unfinished data. Check you script again. No unfinished data made it to the collection");
            return null;
        }
    }

    public static void ScannerSkip(int val){
        for(int i = 0; i < val; i++) scan.nextLine();
    }

    public static void main(String[] args) {

        System.out.println("The client is running");
        String[] array;

        Command command;


        while(true){
            printInvetation();

            if(!scan.hasNext()){
                if(cripledScript) {
                    System.out.println("There were some arrors in the script, so not all the lines were executed");
                    cripledScript = false;
                }
                if(fileNames.size() > 1){
                    fileNames.remove(fileNames.size() - 1);
                    countLines.remove(countLines.size() - 1);
                    File file = new File(fileNames.get(fileNames.size() - 1));
                    try {
                        scan = new Scanner(file);
                        ScannerSkip(countLines.get(countLines.size() - 1));
                    } catch (FileNotFoundException e) {
                        System.out.println("Failed to move along the scripts");
                    }
                }
                else {
                    scan = new Scanner(System.in);
                    isScripted = false;
                    System.out.println("The script is finished");
                    printInvetation();
                }
            }
            String line = scan.nextLine();
            array = ultyTrim(line);
            boolean checker = true;

            for(CommandList i : CommandList.values()){
                if(i.validate(array)){
                    if(isScripted) countLines.set(countLines.size() - 1, countLines.get(countLines.size() - 1) + 1);
                    if(i.name().equals("EXIT")){
                        System.exit(0);
                    }
                    else {
                        if(i.name().equals("EXECUTE_SCRIPT")){
                            File file = new File(array[1]);
                            try {
                                if (fileNames.size() > 0){
                                    if(fileNames.get(fileNames.size() - 1).equals(array[1])){
                                        System.out.println("Cicled scripts are forbiden. Change your script to avoid the cicle");
                                    }
                                    else{
                                        scan = new Scanner(file);
                                        isScripted = true;
                                        fileNames.add(file.getAbsolutePath());
                                        countLines.add(0);
                                    }
                                }
                                else{
                                    scan = new Scanner(file);
                                    isScripted = true;
                                    fileNames.add(file.getAbsolutePath());
                                    countLines.add(0);
                                }
                            } catch (FileNotFoundException e) {
                                System.out.println("Script file wasn't found");
                            }

                        }


                        else{
                            command = i.createCommand(array);
                            ServerSender serverSender = new ServerSender(command);
                            serverSender.sendToServer();
                        }
                        checker = false;
                    }
                }
            }
            if(checker && array.length != 0){
                cripledScript = true;
                printScript("There is either no such command or command arguments were incorrect");
                printScript("If you don't know existing commands or their recuired arguments type Help");
            }
        }
    }
}