package dev.kiser.servicetests;

import dev.kiser.daos.ClientDaoLocal;
import dev.kiser.daos.ClientDaoPostgres;
import dev.kiser.entities.Client;
import dev.kiser.services.ClientService;
import org.junit.jupiter.api.*;

import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientServiceTests {
//
//
//    private static ClientService cserv = new ClientService(new ClientDaoPostgres());
//    private static Client testClient = null;
//
//    @Test
//    @Order(1)
//    void register_client(){
//        Client client = new Client(0, "Brooke", "Kiser", 0, false, 0);
//        cserv.registerClient(client);
//
//        System.out.println("\nregister_client: assertNotEquals" +
//                "\n\tUnexpected: 0" +
//                "\n\tActual: " + client.getId());
//        Assertions.assertNotEquals(0, client.getId());
//
//        testClient = client;
//    }
//
//    @Test
//    @Order(2)
//    void get_all_clients(){
//        Set<Client> clients =  cserv.getAllClients();
//
//        System.out.println("\nget_all_clients: assertEquals" +
//                "\n\tExpected size: 4" +
//                "\n\tActual size: " + clients.size());
//        Assertions.assertEquals(4, clients.size());
//    }
//
//    @Test
//    @Order(3)
//    void get_client_by_id(){
//        Client client = cserv.getClientById(testClient.getId());
//
//        System.out.println("\nget_client_by_id: assertEquals" +
//                "\n\tExpected: " + testClient.getId() +
//                "\n\tActual: " + client.getId());
//        Assertions.assertEquals(testClient.getId(), client.getId());
//    }
//
//    @Test
//    @Order(4)
//    void update_client(){
//        Client client = new Client(1, "Brooke", "Kiser", 0, false, 0);
//        client.setMaritalStatus(1);
//        Client uClient = cserv.updateClientById(client);
//
//        System.out.println("\nupdate_client: assertEquals" +
//                "\n\tExpected: 1" +
//                "\n\tActual: " + uClient.getMaritalStatus());
//        Assertions.assertEquals(1, uClient.getMaritalStatus());
//    }
//
//    @Test
//    @Order(5)
//    void delete_client(){
//        boolean result = cserv.deleteClientById(testClient.getId());
//
//        System.out.println("\ndelete_client: assertTrue" +
//                "\n\tExpected: True" +
//                "\n\tActual: " + result);
//        Assertions.assertTrue(result);
//    }
}
