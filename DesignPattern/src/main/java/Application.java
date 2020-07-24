package com.designpatterns.DesignPattern;

import java.util.logging.Logger;
import java.util.logging.Level;
interface dress {
    public void assemble();
}
class model implements dress {
    public void assemble() {
        System.out.print("Jeans");
    }
}
class Decorator implements dress{
    protected dress jeans;
    public Decorator(dress c){
        this.jeans=c;
    }
    public void assemble() {
        this.jeans.assemble();
    }
}
class tops extends Decorator {

    public tops(dress c) {
        super(c);
    }
    public void assemble(){
        super.assemble();
        System.out.print(" Adding features of dress.");
    }
}
class Luxury extends Decorator {
    public Luxury(dress c) {
        super(c);
    }
    public void assemble(){
        super.assemble();
        System.out.print(" Adding features of Luxury dress.");
    }
}


public class Application
{
    private static final Logger l=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main( String[] args )
    {
        l.log(Level.INFO,"use of memento behaviour pattern and decorate structural pattern");
        dress tops = new tops(new model());
        dress lC=new Luxury(new model());
        tops.assemble();
        lC.assemble();
        System.out.println("\n*****");

        dress Luxury = new tops(new Luxury(new model()));
        Luxury.assemble();
        l.log(Level.INFO,"program terminated");

    }
}
