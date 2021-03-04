package dev.kiser.DAOtests;

import dev.kiser.daos.ClientDAO;
import dev.kiser.daos.ClientDaoLocal;
import dev.kiser.daos.ClientDaoPostgres;
import dev.kiser.entities.Client;
import org.junit.jupiter.api.*;

import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientDaoTest {

//    private static ClientDAO cdao = new ClientDaoPostgres();
//
//    @BeforeEach
//    void make_new_client_dao(){
//        cdao = new ClientDaoPostgres();
//    }
//
//    @Test
//    @Order(1)
//    void create_client(){
//        Client client = new Client(0, "Brooke", "Kiser", 0, false, 0);
//        cdao.createClient(client);
//        System.out.println("\ncreate_client: assertNotEquals" +
//                            "\n\tUnexpected: 0" +
//                            "\n\tActual: " + client.getId());
//        Assertions.assertNotEquals(0, client.getId());
//    }
//
//    @Test
//    @Order(2)
//    void get_all_client_good_input(){
//
//        //Client client0 = new Client(0, "Brooke", "Kiser", 0, false);
//        Client client1 = new Client(0, "Brian", "Hady", 0, true,0);
//        Client client2 = new Client(0, "Rhonda", "Henderson", 0, false, 0);
//        Client client3 = new Client(0, "BoBo", "Owens", 0, true, 0);
//
//        //cdao.createClient(client0);
//        cdao.createClient(client1);
//        cdao.createClient(client2);
//        cdao.createClient(client3);
//
//        Set<Client> clients = cdao.getAllClients();
//
//        System.out.println("\nget_all_client: assertEquals" +
//                            "\n\tExpected: 4" +
//                            "\n\tActual: " + clients.size());
//        Assertions.assertEquals(clients.size(),4);
//
//    }
//
//    @Test
//    @Order(3)
//    void get_client_by_id_good_input(){
//
//        Client idClient = cdao.getClientById(2);
//
//        System.out.println("\nget_client_by_id: assertEquals" +
//                            "\n\tExpected: " + 2 +
//                            "\n\tActual: " + idClient.getId());
//        Assertions.assertEquals(2, idClient.getId());
//    }
//
//    @Test
//    @Order(4)
//    void update_client_by_id_good_input(){
//        Client client0 = new Client(3, "Rhonda", "MacGregor", 1, false, 0);
//
//        cdao.updateClientById(client0);
//
//        System.out.println("\nupdate_client_by_id_good_input: assertEquals" +
//                "\n\tExpected: 1" +
//                "\n\tActual: " + cdao.getClientById(client0.getId()).getMaritalStatus());
//        Assertions.assertEquals(1, cdao.getClientById(client0.getId()).getMaritalStatus());
//    }
//
//    @Test
//    @Order(5)
//    void delete_client_by_id_good_input(){
//
//        boolean result = cdao.deleteClientById(4);
//
//        System.out.println("\ndelete_client_by_id_good_input: assertEquals" +
//                            "\n\tExpected: true \tSize: 3" +
//                            "\n\tActual: " + result + "\tSize: " + cdao.getAllClients().size());
//        Assertions.assertTrue(result);
//    }

}
