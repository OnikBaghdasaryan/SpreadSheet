package Classes;

import enums.Color;
import enums.Type;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Cell {
    private Color color;
    private Object value;
    private Type type;

    public Color getColor() {
        return color;
    }

    public Object getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setValue(Object value){
        this.value = value;



        try { // Check if Date
            value = LocalDate.parse((CharSequence) value);
            type = Type.DATE;
        }catch (Throwable ignored){ // Ignoring Exception to check if its Number
                try {
                    if (Pattern.matches("-?\\d+(\\.\\d+)?", (CharSequence) value)) {
                        type = Type.NUMBER;
                    }
                    else {// Else check if its String or Other Class instance
                        if (value instanceof String) {
                            type = Type.STRING;
                        } else {
                            type = Type.OTHER;
                        }
                    }
                }catch (Throwable ignored1){ // Ignoring Exception to check if its String or Other Class instance

                    if (value instanceof String) {
                        type = Type.STRING;
                    } else {
                        type = Type.OTHER;
                    }
                }
        }



    }

    public void reset() {
        color = null;
        type = null;
        value = null;
    }

}
