import entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.ItemBuild;

import java.util.List;

public class HibDBSaveTester {
    public HibDBSaveTester() {
    }

    public static void main(String[] args) {
        Object transaction = null;
        ItemBuild ib = new ItemBuild();

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Throwable var3 = null;

            try {
                List<Item> items = session.createQuery("from Item", Item.class).list();
                ib.ItemConstruct(items, 0);
                items.forEach((s) -> {
                    System.out.println("NAME:" + s.getName() + " type: " + s.getItemType().getTypeName() + " " + s.getItemType().getTypeDescription());
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
