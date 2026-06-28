import java.util.HashMap;
import java.util.Map;

public class RemoteControl {
    private Map<String, Command> buttonCommands = new HashMap<>();

    public void setCommand(String buttonName, Command command) {
        buttonCommands.put(buttonName, command);
    }

    public void pressButton(String buttonName) {
        Command command = buttonCommands.get(buttonName);
        if (command != null) {
            System.out.print("Pressing '" + buttonName + "' -> ");
            command.execute();
        } else {
            System.out.println("No command assigned to '" + buttonName + "'");
        }
    }
}
