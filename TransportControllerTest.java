import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

public class TransportControllerTest {

    @Mock
    private TransportService transportService;

    @InjectMocks
    private TransportController transportController;

    @Test
    void getTransportsByBrandTest() {
        String brand = "Tatra";
        Transport transport1 = new Transport();
        Transport transport2 = new Transport();
        when(transportService.getTransportsByBrand(brand)).thenReturn(Arrays.asList(transport1, transport2));
        ResponseEntity<List<Transport>> response = transportController.getTransportsByBrand(brand);
        assertSame(HttpStatus.OK, response.getStatusCode());
        assertSame(2, response.getBody().size());
        verify(transportService, times(1)).getTransportsByBrand(brand);
    }

    @Test
    void deleteTransportTest() {
        String registrationNumber = "3009";
        ResponseEntity<?> response = transportController.deleteTransport(registrationNumber);
        assertSame(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(transportService, times(1)).deleteTransport(registrationNumber);
    }
}
