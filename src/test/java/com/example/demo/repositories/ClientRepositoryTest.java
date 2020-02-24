package com.example.demo.repositories;

import com.example.demo.models.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientRepositoryTest {
    @Autowired
    private ClientRepository clientRepository;
    @Before
    public void setUp() throws Exception {
        /*
        Client client = new Client("test", "best", "1010101", "email@email.net");
        //save user, verify has ID value after save
        assertNull(client.getId());
        assertNull(client.getId());//null before save
        this.clientRepository.save(client);
        assertNotNull(client.getId());*/
    }

    @Test
    public void testFetchData(){
        /*Test data retrieval
        Client client = clientRepository.findByName("abc");
        assertNotNull(client);
        assertEquals("0101010101", client.getTel());*/

        /*Get all products
        Iterable clients = clientRepository.findAll();
        int count = 0;
        for(Object c : clients){
            count++;
        }
        assertEquals(count, 1);*/
    }

    //('92063886-4e6e-4ebe-817f-6c0eb0117ed5'
    //           ,'myFirstName'
    //           ,'myLastName'
    //           ,'0101010101'
    //           ,'myEmail@email.com')
}