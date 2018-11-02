package clone;

/**
 * Created by sc on 2018/11/2.
 */
public class Customer implements Cloneable{
    private int id;
    private String name;
    private Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    protected Customer clone() throws CloneNotSupportedException {
        Customer customer=(Customer) super.clone();
        //address=address.clone();
        address=customer.getAddress().clone();
        return customer;
    }
}
