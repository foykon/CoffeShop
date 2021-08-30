package Adapters;

import Abstract.CustomerCheckService;
import Entities.Customer;
import MernisService.IQKKPSPublicSoap;

public class MernisServiceAdapter implements CustomerCheckService {

    IQKKPSPublicSoap iqkkpsPublicSoap=new IQKKPSPublicSoap();
    @Override
    public boolean isreal(Customer customer) {
        try {
            return iqkkpsPublicSoap.TCKimlikNoDogrula(
                    Long.valueOf(customer.getNationalityId()),
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getDateOfBirth().getYear());
        } catch (Exception e) {
            e.printStackTrace();
        }return false;
    }
}
