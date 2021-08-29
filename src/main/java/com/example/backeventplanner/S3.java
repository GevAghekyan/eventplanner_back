package com.example.backeventplanner;

public class S3 {
//
//    @PostMapping(value = "/ձեր URL/uploadProfilePicture", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//    public ResponseEntity<UserResponse> uploadProfPic(@AuthenticationPrincipal UserPrincipal user, @RequestPart MultipartFile file) throws IOException {
//        InputStream inputStream = file.getInputStream();
//
//        AWSCredentials credentials = new BasicAWSCredentials(
//                "ձեր կոդերը",
//                "ձեր կոդերը"
//        );
//
//        AWSStaticCredentialsProvider awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(credentials);
//
//        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//                .withCredentials(awsStaticCredentialsProvider)
//                .withRegion(Regions.EU_CENTRAL_1)
//                .build();
//
//        ObjectMetadata objectMetadata = new ObjectMetadata();
//
//        PutObjectRequest requestFile = new PutObjectRequest("ձեր պռոեկտի անունը", file.getOriginalFilename(), inputStream, objectMetadata);
//        requestFile.withCannedAcl(CannedAccessControlList.PublicRead);
//        PutObjectResult putObjectResult = s3Client.putObject(requestFile);
//
//        String pictureURL = s3Client.getUrl("ձեր պռոեկտի անունը", file.getOriginalFilename()).toExternalForm();
//
//        ResponseEntity<UserResponse> body = ResponseEntity.status(HttpStatus.CREATED).body(userFacade.uploadPicture(user.getId(), pictureURL));
//        return body;
//    }
}
