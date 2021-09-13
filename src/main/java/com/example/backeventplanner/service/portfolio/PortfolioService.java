package com.example.backeventplanner.service.portfolio;


import com.example.backeventplanner.facade.portfolio.PortfolioDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PortfolioService {

    String uploadPictureToAWS(MultipartFile file) throws IOException;

    PortfolioDTO savePicture(PortfolioDTO dto);

    String logoUrlByEmpId(Long employeeId);

    String imageUrlByEmpId(Long employeeId);
}
