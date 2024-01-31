import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class TransportServiceTest {

    @Mock
    private TransportRepository transportRepository;

    @InjectMocks
    private TransportService transportService;

    @Test
    void getTransportsByBrandTest() {
        String brand = "Tatra";
        Transport transport1 = new Transport();
        Transport transport2 = new Transport();
        when(transportRepository.findByBrand(brand)).thenReturn(Arrays.asList(transport1, transport2));
        List<Transport> result = transportService.getTransportsByBrand(brand);
        assertSame(2, result.size());
        verify(transportRepository, times(1)).findByBrand(brand);
    }

    @Test
    void deleteTransportTest() {
        String registrationNumber = "3009";
        transportService.deleteTransport(registrationNumber);
        verify(transportRepository, times(1)).deleteByRegistrationNumber(registrationNumber);
    }
}
