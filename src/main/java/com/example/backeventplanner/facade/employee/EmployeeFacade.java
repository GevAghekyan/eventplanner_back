package com.example.backeventplanner.facade.employee;

import com.example.backeventplanner.annotation.Facade;
import com.example.backeventplanner.controller.employee.models.EmployeeRequestModel;
import com.example.backeventplanner.controller.employee.models.EmployeeResponseModel;
import com.example.backeventplanner.controller.employee.models.EmployeeShortResponse;
import com.example.backeventplanner.converter.EmployeeConverter;
import com.example.backeventplanner.facade.portfolio.PortfolioDTO;
import com.example.backeventplanner.service.employee.EmployeeService;
import com.example.backeventplanner.service.portfolio.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Facade
public class EmployeeFacade {

    private final EmployeeConverter employeeConverter;
    private final EmployeeService employeeService;
    private final PortfolioService portfolioService;

    @Autowired
    public EmployeeFacade(EmployeeConverter employeeConverter, EmployeeService employeeService, PortfolioService portfolioService) {
        this.employeeConverter = employeeConverter;
        this.employeeService = employeeService;
        this.portfolioService = portfolioService;
    }

    public Boolean create(EmployeeRequestModel requestModel, MultipartFile logo, MultipartFile image1) {
        EmployeeDTO dto = employeeConverter.dtoFromRequest(requestModel);
        EmployeeDTO saved = employeeService.create(dto);
        boolean check = saved.getId() != null;
        if (check){
            try {
                String logoUrl = portfolioService.uploadPictureToAWS(logo);
                PortfolioDTO portfolioDTO = new PortfolioDTO();
                portfolioDTO.setName("logo");
                portfolioDTO.setUrl(logoUrl);
                portfolioDTO.setEmployeeId(saved.getId());
                portfolioService.savePicture(portfolioDTO);
                String imageUrl = portfolioService.uploadPictureToAWS(image1);
                PortfolioDTO portfolioDTO1 = new PortfolioDTO();
                portfolioDTO1.setName("image");
                portfolioDTO1.setUrl(imageUrl);
                portfolioDTO1.setEmployeeId(saved.getId());
                portfolioService.savePicture(portfolioDTO1);
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
        return check;
    }

    public EmployeeResponseModel getById(Long id) {
        EmployeeDTO byId = employeeService.getById(id);
        return employeeConverter.responseFromDto(byId);
    }

    public List<EmployeeShortResponse> getEmployeesByType(String type) {
        List<EmployeeShortResponse> allBySpecialist = employeeService.findAllBySpecialist(type);
        return allBySpecialist;
    }

    public ArrayList<EmployeeResponseModel> getAll() {
        ArrayList<EmployeeDTO> all = employeeService.getAll();
        List<EmployeeResponseModel> collect = all.stream()
                .map(each -> employeeConverter.responseFromDto(each))
                .collect(Collectors.toList());
        return (ArrayList<EmployeeResponseModel>) collect;
    }

//    /*This method updates only info about employee
//     * its not update username, password & role*/

    public EmployeeResponseModel updateById(Long id, EmployeeRequestModel requestModel) {
        EmployeeDTO saved = employeeService.updateById(id, employeeConverter.dtoFromRequest(requestModel));
        return employeeConverter.responseFromDto(saved);
    }

    public void deleteById(Long id) {
        employeeService.deleteById(id);
    }
}
