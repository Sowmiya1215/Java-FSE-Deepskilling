public class Main {
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        Command livingRoomOn = new LightOnCommand(livingRoomLight);
        Command livingRoomOff = new LightOffCommand(livingRoomLight);
        Command kitchenOn = new LightOnCommand(kitchenLight);
        Command kitchenOff = new LightOffCommand(kitchenLight);
        RemoteControl remote = new RemoteControl();
        remote.setCommand("A", livingRoomOn);
        remote.setCommand("B", livingRoomOff);
        remote.setCommand("C", kitchenOn);
        remote.setCommand("D", kitchenOff);
        remote.pressButton("A");
        remote.pressButton("C");
        remote.pressButton("B");
        remote.pressButton("D");
        remote.pressButton("E"); // No command assigned
    }
}
