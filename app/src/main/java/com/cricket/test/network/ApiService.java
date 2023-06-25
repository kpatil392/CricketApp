package com.cricket.test.network;



public interface ApiService {

//        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), getCreateJson());
    @GET("/location/{pincode}")
    Call<PincodeResp> getPinCode(@Path("pincode") String pin);



    @POST("/ahh")
    Call<ForgetVerifyOtpResp> getVerifyUserOtpForPassword(@Body RequestBody requestBody);

    @Headers({"Content-Type: application/json"})
    @PUT("/hggh/{id}")
    Call<ResetPasswordResp> getResetPassword(@Path("id") String id, @Body RequestBody requestBody);



    @Multipart
    @POST("/abjh")
    Call<UploadResp> getAddGSTFiles(@Header("Authorization") String Auth,
                                    @Part MultipartBody.Part filePart,
                                    @Part("jhh") RequestBody filePath,
                                    @Part("sf") RequestBody id_,
                                    @Part("fdf") RequestBody mTyp,
                                    @Part("fmsnfm") RequestBody mGstNo);

    @GET("/nnn/{id}")
    Call<BasicDetailInformationResp> getMerchantInfo(@Header("Authorization") String Auth,
                                                     @Path("id") String id);

    @POST("/bhh")
    Call<UploadResp> getOrderCreate(@Header("Authorization") String Auth,
                                    @Body RequestBody requestBody);



    @POST("/mnkjkjk")
    Call<VerifyPANResp> getPANVerify(@Body RequestBody requestBody);

;

}
