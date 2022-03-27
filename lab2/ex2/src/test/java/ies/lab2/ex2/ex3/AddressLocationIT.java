package ies.lab2.ex2.ex3;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ies.lab2.ex2.*;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddressLocationIT {

    private AddressResolver resolver;

    @BeforeEach
    public void init(){
        ISimpleHttpClient SimpleHttpClient = new TqsBasicHttpClient();
        resolver = new AddressResolver(SimpleHttpClient);
    }

    @Test
    public void whenGoodCoordidates_returnAddress() throws IOException, URISyntaxException, ParseException {
        
        Address result = resolver.findAddressForLocation(40.640661, -8.656688);
        assertEquals( result, new Address( "Cais do Alboi", "Glória e Vera Cruz", "Centro", "3800-246", null) );

    }

    @Test
    public void whenBadCoordidates_trhowBadArrayindex() throws IOException, URISyntaxException, ParseException {
        
        assertThrows( IndexOutOfBoundsException.class, ()->{resolver.findAddressForLocation(40.6318, -200.0);});
    }

}
