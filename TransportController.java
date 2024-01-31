import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transports")
public class TransportController {

    @Autowired
    private TransportService transportService;

    @PostMapping
    public ResponseEntity<Transport> addTransport(@RequestBody Transport transport) {
        Transport newTransport = transportService.addTransport(transport);
        return new ResponseEntity<>(newTransport, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Transport>> getAllTransports() {
        List<Transport> transports = transportService.getAllTransports();
        return new ResponseEntity<>(transports, HttpStatus.OK);
    }

    @GetMapping("/{brand}")
    public ResponseEntity<List<Transport>> getTransportsByBrand(@PathVariable String brand) {
        List<Transport> transports = transportService.getTransportsByBrand(brand);
        return new ResponseEntity<>(transports, HttpStatus.OK);
    }

    @DeleteMapping("/{registrationNumber}")
    public ResponseEntity<?> deleteTransport(@PathVariable String registrationNumber) {
        transportService.deleteTransport(registrationNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
