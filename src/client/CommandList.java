package client;

import Commands.Command;
import Commands.*;
import model.MovieGenre;

import java.io.File;

import static client.Main.MovieGetter;

public enum CommandList {
    HELP("help", "Help") {
        @Override
        public boolean validate(String[] array) {
            return array.length == 1 && (array[0].equals(getName1()) || array[0].equals(getName2()));
        }

        @Override
        public Command createCommand(String[] arrayer) {
            return new Help();
        }

        @Override
        public String printPrescription(){
            return "Gives you this priceless information. Requires no argument";
        }
    }
    ,
    INFO("info", "Info"){
        @Override
        public boolean validate(String[] array){
            return array.length == 1 && (array[0].equals(getName1()) || array[0].equals(getName2()));
        }

    @Override
    public Command createCommand(String[] arrayer){
        return new Info();
    }

        @Override
        public String printPrescription(){
            return "Gives data about the collection. Requires no argument";
        }
    },
    SHOW("show", "Show") {
        @Override
        public boolean validate(String[] array) {
            return array.length == 1 && (array[0].equals(getName1()) || array[0].equals(getName2()));        }

        @Override
        public Command createCommand(String[] arrayer) {
            return new Show();
        }

        @Override
        public String printPrescription(){
            return "Gives data on the elements of the collection. Requires no argument";
        }
    },
    ADD("add", "Add") {
        @Override
        public boolean validate(String[] array) {
            return array.length == 1 && (array[0].equals(getName1()) || array[0].equals(getName2()));        }

        @Override
        public Command createCommand(String[] arrayer) {
            return new Add(MovieGetter());
        }

        @Override
        public String printPrescription(){
            return "Adds new element to the collection. Requires no argument. Data required for forming an element will be asked after typing the command";
        }
    },
    UPDATE("update", "Update") {
        @Override
        public boolean validate(String[] array) {
            if (array.length == 2 && (array[0].equals(getName1()) || array[0].equals(getName2()))) {
                try {
                    int num = Integer.parseInt(array[1]);
                    return num >= 0;
                } catch (NumberFormatException e) {
                    return false;
                }
            } else return false;
        }

        @Override
        public Command createCommand(String[] arrayer) {
            return new Update(Integer.parseInt(arrayer[1]), MovieGetter());
        }

        @Override
        public String printPrescription(){
            return "Updates element of the collection with the given ID. Requires int argument - element ID. Updation detailes will be asked later";
        }
    },
    REMOVE_BY_ID("remove_by_id", "Remove_by_id") {
        @Override
        public boolean validate(String[] array) {
            if (array.length == 2 && (array[0].equals(getName1()) || array[0].equals(getName2()))) {
                try {
                    int num = Integer.parseInt(array[1]);
                    return num >= 0;
                } catch (NumberFormatException e) {
                    return false;
                }
            } else return false;
        }

        @Override
        public Command createCommand(String[] arrayer) {
            return new Remove_by_id(Integer.parseInt(arrayer[1]));
        }

        @Override
        public String printPrescription(){
            return "Deletes element with given ID. Requires int arguement - element ID";
        }
    },
    CLEAR("clear", "Clear") {
        @Override
        public boolean validate(String[] array) {
            return array.length == 1 && (array[0].equals(getName1()) || array[0].equals(getName2()));
        }

        @Override
        public Command createCommand(String[] arrayer) {
            return new Clear();
        }

        @Override
        public String printPrescription(){
            return "Deletes all elements of the collection. Requires no argument";
        }
    },
    EXECUTE_SCRIPT("execute_script", "Execute_script") {
        @Override
        public boolean validate(String[] array) {
            if(array.length == 2 && (array[0].equals(getName1()) || array[0].equals(getName2()))){
                File file = new File(array[1]);
                return file.exists();
            }
            return false;
        }

        @Override
        public String printPrescription(){
            return "Executes you script. Requires String name of the file";
        }
    },
    EXIT("exit", "Exit") {
        @Override
        public boolean validate(String[] array) {
            return array.length == 1 && (array[0].equals(getName1()) || array[0].equals(getName2()));
        }

        @Override
        public String printPrescription(){
            return "Stops clients app. Requires no argument";
        }
        },
    REMOVE_LAST("remove_last", "Remove_last") {
        @Override
        public boolean validate(String[] array) {
            return array.length == 1 && (array[0].equals(getName1()) || array[0].equals(getName2()));
        }

        @Override
        public Command createCommand(String[] arrayer) {
            return new Remove_last();
        }

        @Override
        public String printPrescription(){
            return "Deletes last element of the collection. Requires no argument";
        }
    },
    ADD_IF_MIN("add_if_min", "Add_if_min") {
        @Override
        public boolean validate(String[] array) {
            return array.length == 1 && (array[0].equals(getName1()) || array[0].equals(getName2()));
        }

        @Override
        public Command createCommand(String[] arrayer) {
            return new Add_if_min(MovieGetter());
        }

        @Override
        public String printPrescription(){
            return "Adds a given element if it is less then all the elements already placed in collection. Requires no argument. Required data gets asked later";
        }
    },
    REORDER("reorder", "Reorder") {
        @Override
        public boolean validate(String[] array) {
            return array.length == 1 && (array[0].equals(getName1()) || array[0].equals(getName2()));
        }

        @Override
        public Command createCommand(String[] arrayer) {
            return new Reorder();
        }

        @Override
        public String printPrescription(){
            return "Reverses the order of the elements in the collection. Requires no argument";
        }
    },
    COUNT_GREATER_THAN_GENRE("count_greater_than_genre", "Count_greater_than_genre") {
        @Override
        public boolean validate(String[] array) {
            boolean checker = false;
            if (array.length == 2 && (array[0].equals(getName1()) || array[0].equals(getName2()))) {
                for (MovieGenre i : MovieGenre.values()) {
                    if (i.name().equals(array[1])) checker = true;
                }
            }
            return checker;
        }

        @Override
        public Command createCommand(String[] arrayer) {
            for(MovieGenre i : MovieGenre.values()){
                if(i.name().equals(arrayer[1])) return new Count_greater_than_genre(i);
            }
            return null;
        }

        @Override
        public String printPrescription(){
            return "Gives amount of elements with genres greater than given. Requires a genre argument";
        }
    },
    FILTER_GREATER_THAN_GENRE("filter_greater_than_genre", "Filter_greater_than_genre") {
        @Override
        public boolean validate(String[] array) {
            boolean checker = false;
            if (array.length == 2 && (array[0].equals(getName1()) || array[0].equals(getName2()))) {
                for (MovieGenre i : MovieGenre.values()) {
                    if (i.name().equals(array[1])) checker = true;
                }
            }
            return checker;
        }

        @Override
        public Command createCommand(String[] arrayer) {
            for(MovieGenre i : MovieGenre.values()){
                if(i.name().equals(arrayer[1])) return new Filter_greater_than_genre(i);
            }
            return null;
        }

        @Override
        public String printPrescription(){
            return "Gives elements with genres greater than given. Requires a genre argument";
        }
    },
    COUNT_LESS_THAN_GENRE("count_less_than_genre", "Count_less_than_genre") {
        @Override
        public boolean validate(String[] array) {
            boolean checker = false;
            if (array.length == 2 && (array[0].equals(getName1()) || array[0].equals(getName2()))) {
                for (MovieGenre i : MovieGenre.values()) {
                    if (i.name().equals(array[1])) checker = true;
                }
            }
            return checker;
        }

        @Override
        public Command createCommand(String[] arrayer) {
            for(MovieGenre i : MovieGenre.values()){
                if(i.name().equals(arrayer[1])) return new Count_less_than_genre(i);
            }
            return null;
        }

        @Override
        public String printPrescription(){
            return "Gives amount of elements with genres lesser than given. Requires a genre argument";
        }
    };

    private final String name1;
    private final String name2;

    CommandList(String name1, String name2){
        this.name1 = name1;
        this.name2 = name2;
    }

    public String getName1(){
        return name1;
    }

    public String getName2(){
        return name2;
    }

    public boolean validate(String[] array){
        return true;
    }

    public Command createCommand(String[] arrayer){
        return new Command();
    }

    public String printPrescription(){return null;}

}
