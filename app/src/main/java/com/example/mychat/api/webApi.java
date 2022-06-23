package com.example.mychat.api;


import com.example.mychat.Contact;
import com.example.mychat.Login;
import com.example.mychat.MessageToSend;
import com.example.mychat.Register;
import com.example.mychat.Transfer;
import com.example.mychat.invitations;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface webApi {
    @GET("Contacts")
    Call<List<Contact>> getContacts(@Query("userId") String userId);

    @POST("Contacts")
    Call<Void> createContact(@Body Contact contact, @Query("userId") String userId);

    @GET("Contacts/{id}")
    Call <Contact> getContact( @Path("id") String id ,@Query("userId") String userId);

    @PUT("Contacts/{id}")
    Call <Void> updateContact(@Path("id") String id,@Body Contact contact,
                                            @Query("userId") String userId );

    @DELETE("Contacts/{id}")
    Call <Void> removeContact(@Path("id") String id,@Query("userId") String userId );

    @GET("Contacts/{id}/messages")
    Call <List<MessageToSend>> getMsg(@Path("id") String id, @Query("userId") String userId );

    @POST("Contacts/{id}/messages")
    Call<Void> newMsg( @Path("id") String id ,@Query("userId") String userId,
                                                 @Query("content") String content);

    @GET("Contacts/{id}/messages/{id2}")
    Call <MessageToSend> getSMsg(@Path("id") String id,@Path("id2") String id2
                                        ,@Query("userId") String userId );

    @PUT("Contacts/{id}/messages/{id2}")
    Call <Void> updateSMsg(@Path("id") String id,@Path("id2") String id2,
                                @Query("userId") String userId,@Path("content") String content );

    @DELETE("Contacts/{id}/messages/{id2}")
    Call <Void> deleteSMsg(@Path("id") String id,@Path("id2") String id2,
                                            @Query("userId") String userId );

    @POST("invitations")
    Call <Void>  invite(@Body invitations invitations);

    @POST("transfer")
    Call <Void> send(@Body Transfer transfer);

    @POST("Register")
    Call <Void> Register(@Body Register register);

    @POST("Login")
    Call <Void> Login(@Body Login login);




}
