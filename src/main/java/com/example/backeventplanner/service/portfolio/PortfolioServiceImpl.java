package com.example.backeventplanner.service.portfolio;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.example.backeventplanner.facade.portfolio.PortfolioDTO;
import com.example.backeventplanner.persistence.employee.Employee;
import com.example.backeventplanner.persistence.employee.EmployeeRepo;
import com.example.backeventplanner.persistence.portfolio.Portfolio;
import com.example.backeventplanner.persistence.portfolio.PortfolioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class PortfolioServiceImpl implements PortfolioService{

    private final PortfolioRepo portfolioRepo;
    private final EmployeeRepo employeeRepo;

    @Autowired
    public PortfolioServiceImpl(PortfolioRepo portfolioRepo, EmployeeRepo employeeRepo) {
        this.portfolioRepo = portfolioRepo;
        this.employeeRepo = employeeRepo;
    }

    @Override
    //    @PostMapping(value = "/uploadProfilePicture", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String uploadPictureToAWS(MultipartFile file) throws IOException {

        InputStream inputStream = file.getInputStream();

        AWSCredentials credentials = new BasicAWSCredentials(
                "AKIAV2R7TZQJJ7Z2P6HC",
                "2AfiaAcxwgVD+EcKbJ4ykjHAYDp591X8GAsO8CB6"
        );

        AWSStaticCredentialsProvider awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(credentials);

        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(awsStaticCredentialsProvider)
                .withRegion(Regions.US_EAST_1)
                .build();

        ObjectMetadata objectMetadata = new ObjectMetadata();

        String filename = UUID.randomUUID().toString() + file.getOriginalFilename();

        PutObjectRequest requestFile = new PutObjectRequest("eventplanners3", filename, inputStream, objectMetadata);
        requestFile.withCannedAcl(CannedAccessControlList.PublicRead);
        PutObjectResult putObjectResult = s3Client.putObject(requestFile);

        String pictureURL = s3Client.getUrl("eventplanners3", filename).toExternalForm();
        return pictureURL;
    }

    @Override
    public PortfolioDTO savePicture(PortfolioDTO dto) {
        Portfolio saved = portfolioRepo.save(portfolioFromDto(dto));
        return dtoFromPortfolio(saved);
    }

    @Override
    public String logoUrlByEmpId(Long employeeId) {
        String logoUrl = portfolioRepo.findLogoByEmployeeId(employeeId);
        return logoUrl;
    }

    @Override
    public String imageUrlByEmpId(Long employeeId) {
        return null;
    }

    private Portfolio portfolioFromDto(PortfolioDTO dto){
        Portfolio portfolio = new Portfolio();
        portfolio.setId(dto.getId());
        portfolio.setName(dto.getName());
        portfolio.setUrl(dto.getUrl());
        Employee employee = employeeRepo.getById(dto.getEmployeeId());
        portfolio.setEmployee(employee);
        return portfolio;
    }

    private PortfolioDTO dtoFromPortfolio(Portfolio portfolio){
        PortfolioDTO portfolioDTO = new PortfolioDTO();
        portfolioDTO.setId(portfolio.getId());
        portfolioDTO.setName(portfolio.getName());
        portfolioDTO.setUrl(portfolio.getUrl());
        portfolioDTO.setEmployeeId(portfolio.getEmployee().getId());
        return portfolioDTO;
    }
}
