package Model.Statement;

import Exceptions.InterpreterException;
import Model.ProgramState.ProgramState;
import Model.Type.InterType;
import Model.Utilities.InterDictionary;

// Class that represents a statement that does nothing
public class NopStatement implements InterStatement {
    @Override
    public String toString() {
        return "NopStatement";
    }

    @Override
    public ProgramState execute(ProgramState state) {
        return null;
    }

    @Override
    public InterDictionary<String, InterType> typeCheck(InterDictionary<String, InterType> typeEnv) throws InterpreterException {
        // return the same type environment
        return typeEnv;
    }
}
