import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportService {

    @Autowired
    private TransportRepository transportRepository;

    public Transport addTransport(Transport transport) {
        return transportRepository.save(transport);
    }

    public List<Transport> getAllTransports() {
        return transportRepository.findAll();
    }

    public List<Transport> getTransportsByBrand(String brand) {
        return transportRepository.findByBrand(brand);
    }

    public void deleteTransport(String registrationNumber) {
        transportRepository.deleteByRegistrationNumber(registrationNumber);
    }
}
