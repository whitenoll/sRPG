import entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.RoomBuild;

import java.util.List;

public class HibDBSaveTester {
    public HibDBSaveTester() {
    }

    public static void main(String[] args) {
        Object transaction = null;
        RoomBuild rb = new RoomBuild();

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Throwable var3 = null;

            try {
                List<Room> rooms = session.createQuery("from Room", Room.class).list();
                rb.RoomConstruct(rooms, 0);
                rooms.forEach((s) -> {
                    System.out.println("NAME:" + s.getName() + " type: " + s.getRoomType().getTypeName() + " " + s.getRoomType().getTypeDescription());
                });
            } catch (Throwable var13) {
                var3 = var13;
                throw var13;
            } finally {
                if (session != null) {
                    if (var3 != null) {
                        try {
                            session.close();
                        } catch (Throwable var12) {
                            var3.addSuppressed(var12);
                        }
                    } else {
                        session.close();
                    }
                }

            }
        } catch (Exception var15) {
            if (transaction != null) {
                ((Transaction)transaction).rollback();
            }

            var15.printStackTrace();
        }

    }
}
