package ecse428.peaceOfMinde.utility;

import ecse428.peaceOfMinde.dto.*;
import ecse428.peaceOfMinde.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a helper class which contains static methods
 * i.e. the class is stateless and cannot be instantiated
 *
 * @author Gohar Saqib Fazal
 */
public class LibraryUtil {

    /**
     * This method coverts an iterable data type to a list
     *
     * @param iterable iterable data type
     * @return List<T> list data type returned
     */
    public static <T> List<T> toList(Iterable<T> iterable) {
        List<T> resultList = new ArrayList<T>();
        for (T t : iterable) {
            resultList.add(t);
        }
        return resultList;
    }

    /**
     * This method converts the buyer into a data transfer object
     *
     * @param buyer Buyer
     * @return BuyerDto Buyer Data Transfer Object
     */
    public static BuyerDto convertToDto(Buyer buyer) {
        if (buyer == null) {
            throw new IllegalArgumentException("There is no such Buyer!");
        }
        BuyerDto buyerDto = new BuyerDto(buyer.getFirstName(), buyer.getLastName(), buyer.getUsername(),
                buyer.getPassword(), buyer.getEmail(), buyer.getResidentialAddress(), buyer.getAboutme());
        buyerDto.setIsRegisteredOnline(buyer.getIsRegisteredOnline());
        buyerDto.setId(buyer.getId());
        return buyerDto;
    }

    /**
     * This method converts the worker into a data transfer object
     *
     * @param worker Worker
     * @return WorkerDto Worker Data Transfer Object
     */
    public static WorkerDto convertToDto(Worker worker) {
        if (worker == null) {
            throw new IllegalArgumentException("There is no such worker!");
        }
        WorkerDto workerDto = new WorkerDto(worker.getFirstName(), worker.getLastName(),
                worker.getUsername(), worker.getPassword(), worker.getEmail(),
                worker.getResidentialAddress(), worker.getAboutme());
        workerDto.setIsRegisteredOnline(worker.getIsRegisteredOnline());
        workerDto.setId(worker.getId());
        return workerDto;
    }

    /**
     * This method converts the admin into a data transfer object
     *
     * @param admin Admin
     * @return AdminDto Worker Data Transfer Object
     */
    public static AdminDto convertToDto(Admin admin) {
        if (admin == null) {
            throw new IllegalArgumentException("There is no such worker!");
        }
        AdminDto adminDto = new AdminDto(admin.getFirstName(), admin.getLastName(),
                admin.getUsername(), admin.getPassword(), admin.getEmail(),
                admin.getResidentialAddress(), admin.getAboutme());
        adminDto.setId(admin.getId());
        return adminDto;

    }

        /**
     * This method converts the serviceOffering into a data transfer object
     *
     * @param ServiceOffering serviceOffering
     * @return serviceOfferingDto Data Transfer Object
     */
    public static ServiceOfferingDto convertToDto(ServiceOffering serviceOffering) {
        if (serviceOffering == null) {
            throw new IllegalArgumentException("There is no such serviceOffering!");
        }

        ServiceOfferingDto serviceOfferingDto = new ServiceOfferingDto(serviceOffering.getWorkerId(), 
                                                    serviceOffering.getId(), serviceOffering.getTitle(), 
                                                    serviceOffering.getDescription(), serviceOffering.getHourlySalary(), 
                                                    serviceOffering.getDateCreated()); 
        serviceOfferingDto.setId(serviceOffering.getId());
        
        return serviceOfferingDto;

    }
}