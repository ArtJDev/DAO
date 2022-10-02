package ru.netology.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;
import ru.netology.entities.CustomersEntity;
import ru.netology.entities.OrdersEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Repository
public class DaoRepository implements CommandLineRunner {
    @PersistenceContext
    EntityManager em;

    public List<String> getProductNames(String name) {
        Query query = em.createQuery("select o.productName from OrdersEntity o " +
                " join CustomersEntity c on c.id = o.customersEntity.id " +
                " where c.name like :name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        List<CustomersEntity> customersEntityList = Arrays.asList(
                new CustomersEntity().builder()
                        .name("Linda")
                        .surname("Williams")
                        .age(23)
                        .phoneNumber("+7-965-869-11-32")
                        .build(),
                new CustomersEntity().builder()
                        .name("Sean")
                        .surname("Duouglass")
                        .age(37)
                        .phoneNumber("+7-916-384-77-99")
                        .build(),
                new CustomersEntity().builder()
                        .name("Jay")
                        .surname("Rob")
                        .age(42)
                        .phoneNumber("+7-977-732-29-92")
                        .build()
        );

        List<OrdersEntity> ordersEntityList = Arrays.asList(
                new OrdersEntity().builder()
                        .date("2022-07-14")
                        .customersEntity(customersEntityList.get(0))
                        .productName("Блузка")
                        .amount(899.0)
                        .build(),
                new OrdersEntity().builder()
                        .date("2022-07-14")
                        .customersEntity(customersEntityList.get(0))
                        .productName("Брюки")
                        .amount(1099.0)
                        .build(),
                new OrdersEntity().builder()
                        .date("2022-08-16")
                        .customersEntity(customersEntityList.get(0))
                        .productName("Юбка")
                        .amount(999.0)
                        .build(),
                new OrdersEntity().builder()
                        .date("2022-04-20")
                        .customersEntity(customersEntityList.get(1))
                        .productName("Дезодорант")
                        .amount(360.0)
                        .build(),
                new OrdersEntity().builder()
                        .date("2022-05-02")
                        .customersEntity(customersEntityList.get(1))
                        .productName("Ноутбук")
                        .amount(78000.0)
                        .build(),
                new OrdersEntity().builder()
                        .date("2022-06-17")
                        .customersEntity(customersEntityList.get(1))
                        .productName("Инструменты")
                        .amount(6500.0)
                        .build(),
                new OrdersEntity().builder()
                        .date("2022-06-04")
                        .customersEntity(customersEntityList.get(2))
                        .productName("Книга")
                        .amount(1900.0)
                        .build(),
                new OrdersEntity().builder()
                        .date("2022-09-05")
                        .customersEntity(customersEntityList.get(2))
                        .productName("Кроссовки")
                        .amount(7300.0)
                        .build(),
                new OrdersEntity().builder()
                        .date("2022-09-05")
                        .customersEntity(customersEntityList.get(2))
                        .productName("Футболка")
                        .amount(1200.0)
                        .build()
        );

        customersEntityList.forEach(customersEntity -> {
            em.persist(customersEntity);
        });

        ordersEntityList.forEach(ordersEntity -> {
            em.persist(ordersEntity);
        });
    }
}