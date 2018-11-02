package clone;

/**
 * Created by sc on 2018/11/2.
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Customer c1 = new Customer();
        c1.setId(1);
        c1.setName("张三");
        Address address1=new Address();
        address1.setCity("北京");
        address1.setCountry("中国");
        address1.setProvince("河北");
        c1.setAddress(address1);

        Customer c2=c1.clone();
        c2.setName("李四");
        c2.getAddress().setCity("上海");
        System.out.println(c1.getName());
        System.out.println(c1.getAddress().getCity());
        System.out.println(c2.getAddress().getCity());


    }
}
