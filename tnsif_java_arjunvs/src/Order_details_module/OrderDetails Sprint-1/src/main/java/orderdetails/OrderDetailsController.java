package orderdetails;

import java.util.List; 
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/orders") 
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService service;

    // Retrieve all orders
    @GetMapping
    public List<Order> listAll() {
        return service.listAll();
    }

    // Retrieve an order by ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> get(@PathVariable Integer id) {
        try {
            Order order = service.get(id);
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    // Create a new order
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Order order) {
        service.save(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Update an existing order
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Order order, @PathVariable Integer id) {
        try {
            service.get(id); // Ensure the order exists
            service.save(order);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    // Delete an order by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
}
