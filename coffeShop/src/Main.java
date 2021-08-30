import Abstract.BaseCustomerManager;
import Adapters.MernisServiceAdapter;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        BaseCustomerManager neroCustomerManager=new NeroCustomerManager();
        BaseCustomerManager starbucksCustomerManager=new StarbucksCustomerManager(new MernisServiceAdapter());
        Customer engin=new Customer();
        engin.setFirstName("Engin");
        engin.setLastName("Demiroğ");
        engin.setDateOfBirth(LocalDate.of(1985,2,6));
        engin.setNationalityId("1232132");
        engin.setId(3);
        Customer furkan=new Customer(1,"furkan","Yıldız",
                LocalDate.of(2002,11,13),
                "12809486862"
                );
        neroCustomerManager.save(engin);
        starbucksCustomerManager.save(furkan);
        neroCustomerManager.save(furkan);
        starbucksCustomerManager.save(engin);
    }
}
