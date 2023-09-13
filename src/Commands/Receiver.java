package Commands;

import java.io.Serializable;

public class Receiver implements Serializable {
    private String line;
    private static final long serialVersionUID = 123456789L;
    public Receiver(String line){
        this.line = line;
    }

    public String getLine(){
        return this.line;
    }
}
