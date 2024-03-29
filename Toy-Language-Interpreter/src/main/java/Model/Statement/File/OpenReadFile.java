package Model.Statement.File;

import Exceptions.InterpreterException;
import Model.Expression.InterExpression;
import Model.ProgramState.ProgramState;
import Model.Statement.InterStatement;
import Model.Type.InterType;
import Model.Type.StringType;
import Model.Utilities.InterDictionary;
import Model.Value.InterValue;
import Model.Value.StringValue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

// Class that represents the statement that opens a file for reading
public class OpenReadFile implements InterStatement {
    private final InterExpression expression;

    public OpenReadFile(InterExpression expression) {
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState state) throws InterpreterException {
        InterValue value = this.expression.eval(state.getSymTable(), state.getHeap());

        if (value.getType().equals(new StringType())) {
            StringValue fileName = (StringValue) value;
            InterDictionary<String, BufferedReader> fileTable = state.getFileTable();

            if (!fileTable.containsKey(fileName.getValue())) {
                BufferedReader br;

                try {
                    br = new BufferedReader(new FileReader(fileName.getValue()));
                } catch (FileNotFoundException e) {
                    throw new InterpreterException(String.format("%s could not be opened", fileName.getValue()));
                }

                fileTable.put(fileName.getValue(), br);
                state.setFileTable(fileTable);
            } else {
                throw new InterpreterException(String.format("%s is already opened", fileName.getValue()));
            }
        } else {
            throw new InterpreterException(String.format("%s does not evaluate to StringType", expression.toString()));
        }
        return state;
    }

    @Override
    public InterDictionary<String, InterType> typeCheck(InterDictionary<String, InterType> typeEnv) throws InterpreterException {
        // check if the expression evaluates to a string
        if (expression.typeCheck(typeEnv).equals(new StringType()))
            return typeEnv;
        else
            throw new InterpreterException("OpenReadFile requires a string expression.");

    }

    @Override
    public String toString() {
        return String.format("OpenReadFile(%s)", expression.toString());
    }
}