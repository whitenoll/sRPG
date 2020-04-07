package util;

import entity.Room;

import java.util.List;

public class RoomBuild {
private StringBuilder roomStructure ;

    public StringBuilder RoomConstruct(List<Room> room, int containerID){
        int roomWidth = 0;
        int roomLength = 0;
        System.out.println("RoomConstructing!");
        room.forEach((s) -> {



        System.out.println("NAME:" + s.getName() + " type: " + s.getRoomType().getTypeName() + " " + s.getRoomType().getTypeDescription());
        });
        for (Room r : room) {
            if (r.getContainerId() == 0) {
                roomWidth = r.getWidth();
                roomLength = r.getLength();
            }
        }
        System.out.println("the room is: " + roomWidth +  " wide " + roomLength + " long");
//        for (int i = 0; i < ; i++) {
//
//        }

        return roomStructure;

      
}


}