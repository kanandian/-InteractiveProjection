package main;

import org.python.antlr.ast.Str;
import org.python.util.PythonInterpreter;

public class PythonCode {

    static PythonInterpreter interpreter = new PythonInterpreter();

    public static void main(String[] args) {
        interpreter.exec("");
    }

}
