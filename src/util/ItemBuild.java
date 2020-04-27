package util;

import entity.Item;
import entity.Room;

import java.util.List;

public class ItemBuild {
private StringBuilder itemStructure ;

    public StringBuilder ItemConstruct(List<Item> item, int containerID){
        int itemWidth = 0;
        int itemLength = 0;
        System.out.println("ItemConstructing!");
        item.forEach((s) -> {



        System.out.println("NAME:" + s.getName() + " type: " + s.getItemType().getTypeName() + " " + s.getItemType().getTypeDescription());
        });
        for (Item i : item) {
            if (i.getContainerId() == 0) {
                itemWidth = i.getWidth();
                itemLength = i.getLength();
            }
        }
        System.out.println("the room is: " + itemWidth +  " wide " + itemLength + " long");
//        for (int i = 0; i < ; i++) {
//
//        }

        return itemStructure;

      
}


}