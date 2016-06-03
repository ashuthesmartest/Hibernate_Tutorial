/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiber_test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.* ;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 *
 * @author admin
 */
@Entity
public class emp1000 
{
    @Id @GeneratedValue
    private int id ;
    
    private String firstName ;    
    private String lastName; 
    @OneToMany
    private Collection<Vehicle> vehicle = new ArrayList<Vehicle>() ;

    public Collection<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Collection<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    @ElementCollection
    @JoinTable(name="user_address" ,
            joinColumns=@JoinColumn(name="user_id")
    )    
    @GenericGenerator(name="sequence-gen", strategy="sequence")
    @CollectionId(columns= { @Column(name="address_id") }, generator="sequence-gen", type=@Type(type="long"))
    private Collection<Address> listOfAddresses = new ArrayList<Address>() ;

    public Collection<Address> getListOfAddresses() {
        return listOfAddresses;
    }

    public void setListOfAddresses(Collection<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }
    
    
    @Embedded
    private Address address ;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
