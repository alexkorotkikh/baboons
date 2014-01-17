package ua.com.sourceit.secretsanta;

import java.util.ArrayList;
import java.util.List;

/**
 * User: alexkorotkikh
 * Date: 1/17/14
 * Time: 6:52 PM
 */
public interface SecretSantaCommand {
    boolean isExit();

    List<String> getInputDescriptions();

    void addInput(String s);

    void executeCommand();

    String getSuccessDescription();
}

abstract class AbstractSecretSantaCommand implements SecretSantaCommand {

    protected List<String> inputList = new ArrayList<String>();

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void addInput(String s) {
        inputList.add(s);
    }

    @Override
    public String getSuccessDescription() {
        return "Success!";
    }
}

class AddGroupCommand extends AbstractSecretSantaCommand {

    SecretSantaDao dao;

    AddGroupCommand(SecretSantaDao dao) {
        this.dao = dao;
    }

    @Override
    public List<String> getInputDescriptions() {
        List<String> inputDesc = new ArrayList<String>();
        inputDesc.add("Please enter group name");
        return inputDesc;
    }

    @Override
    public void executeCommand() {
        dao.createGroup(inputList.get(0));
    }
}

class AddUserCommand extends AbstractSecretSantaCommand {
    SecretSantaDao dao;

    AddUserCommand(SecretSantaDao dao) {
        this.dao = dao;
    }

    @Override
    public List<String> getInputDescriptions() {
        List<String> inputDesc = new ArrayList<String>();
        inputDesc.add("Please enter user name");
        inputDesc.add("Please enter group name");
        return inputDesc;
    }

    @Override
    public void executeCommand() {
        dao.createUser(inputList.get(0), inputList.get(1));
    }
}

class ExitCommand extends AbstractSecretSantaCommand {
    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public List<String> getInputDescriptions() {
        return null;
    }

    @Override
    public void executeCommand() {
    }
}
