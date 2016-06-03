package hiber_test;  
  
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;  
  
public class StoreData {  
public static void main(String[] args) 
{        
    //creating configuration object  
    Configuration cfg=new Configuration();  
    cfg.configure("resources/hibernate.cfg.xml");//populates the data of the configuration file  
      
    //creating seession factory object  
    SessionFactory factory=cfg.buildSessionFactory();  
      
    //creating session object  
    Session session=factory.openSession();  
          
    emp1000 e1=new emp1000();  
    e1.setFirstName("Sam"); 
    e1.setLastName("Sharma");   
    
    Vehicle vehicle = new Vehicle() ;
    vehicle.setVehicleName("Car");
    
    Vehicle vehicle2 = new Vehicle() ;
    vehicle.setVehicleName("Jeep");
    
    e1.getVehicle().add(vehicle) ;
    e1.getVehicle().add(vehicle2) ;
    
    session.beginTransaction() ;
    session.save(e1);//persisting the object  
    session.save(vehicle) ;
    session.save(vehicle) ;
    session.getTransaction().commit();

    session.close();    
    factory.close();
      
    System.out.println("successfully saved");  
      
}  
}  