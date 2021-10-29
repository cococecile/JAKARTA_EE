package poei;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.junit.jupiter.api.Test;

import poei.persistance.factory.HibernateFactory;

class HibernateFactoryTest {
	 public static SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

	@Test
	void test() {
		try (final Session session = HibernateFactory.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            // on lit le fichier
            try (final Scanner scanner = new Scanner(new FileReader("test/java/poei/dataSet/pharma_DML.sql"))) {
                while (scanner.hasNext()) {
                    final String sql = scanner.nextLine();
                    // pour chaque ligne non vide
                    if (!sql.isEmpty()) {
                        // on l'exécute en tant que query native (sql natif)
                        final NativeQuery<?> query = session.createNativeQuery(sql);
                        query.executeUpdate();
                    }
                }
            } catch (final FileNotFoundException e) {
                e.printStackTrace();
            }
            transaction.commit();
        }
	}

}
