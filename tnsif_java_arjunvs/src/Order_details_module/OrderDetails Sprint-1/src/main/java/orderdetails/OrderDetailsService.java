package orderdetails;
import java.util.List; 


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderDetailsService {
    
	@Autowired
	private OrderDetailsRepository repo;
	public List<Order> listAll()
	{
		return repo.findAll();
	}
	 public void save(Order orderdetails) 
 {
 repo.save(orderdetails);
 }
 
 public Order get(Integer id) 
 {
 return repo.findById(id).get();
 }
 
 public void delete(Integer id) 
 {
 repo.deleteById(id);
 }
public static List<Order> getAllOrders() {
	// TODO Auto-generated method stub
	return null;
}
	
	
}
