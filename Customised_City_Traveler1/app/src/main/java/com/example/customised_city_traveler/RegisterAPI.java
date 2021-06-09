package com.example.customised_city_traveler;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Belal on 11/5/2015.
 */
public interface RegisterAPI {
    @FormUrlEncoded
    @POST("/register.php")
    public void insertUser(
            @Field("uname") String name,
            @Field("email") String email,
            @Field("upass") String pass,


            Callback<Response> callback);

    @FormUrlEncoded
    @POST("/login.php")
    public void loginUser(
            @Field("email") String email,
            @Field("upass") String pass,


            Callback<Response> callback);

    @FormUrlEncoded
    @POST("/Admin/show_hotel.php")
    public void selecthotels(
            @Field("uname") String name,

            Callback<Response> callback);

    @FormUrlEncoded
    @POST("/Admin/show_rest.php")
    public void selectrest(
            @Field("uname") String name,
            Callback<Response> callback);

    @FormUrlEncoded
    @POST("/Admin/show_temp.php")
    public void selecttemples(
            @Field("uname") String name,
            Callback<Response> callback);

    @FormUrlEncoded
    @POST("/Admin/show_malls.php")
    public void selectmalls(
            @Field("uname") String name,
            Callback<Response> callback);

    @FormUrlEncoded
    @POST("/Admin/show_musiam.php")
    public void selectmusiams(
            @Field("uname") String name,
            Callback<Response> callback);



    @FormUrlEncoded
    @POST("/Admin/show_parks.php")
    public void selectparks(
            @Field("uname") String name,
            Callback<Response> callback);



    @FormUrlEncoded
    @POST("/Admin/viewhotel.php")
    public void selecthotelsdetails(
            @Field("hid") String name,
            Callback<Response> callback);

    @FormUrlEncoded
    @POST("/Admin/viewrest.php")
    public void selectrestdetails(
            @Field("rid") String name,
            Callback<Response> callback);



    @FormUrlEncoded
    @POST("/Admin/viewTemple.php")
    public void selecttempledetails(
            @Field("tid") String name,
            Callback<Response> callback);

    @FormUrlEncoded
    @POST("/Admin/view_mall.php")
    public void selectmalldetails(
            @Field("mid") String name,
            Callback<Response> callback);

    @FormUrlEncoded
    @POST("/Admin/view_park.php")
    public void selectparkdetails(
            @Field("pid") String name,
            Callback<Response> callback);

    @FormUrlEncoded
    @POST("/Admin/view_musiam.php")
    public void selectmusiamdetails(
            @Field("musiam_id") String name,
            Callback<Response> callback);




    @FormUrlEncoded
    @POST("/Admin/bookroom.php")
    public void bookroom(
            @Field("hid") String hid,
            @Field("uid") String uid,
            @Field("rqty") String rqty,
            @Field("datep") String datep,
            @Field("time") String time,

            Callback<Response> callback);

    @FormUrlEncoded
    @POST("/Admin/viewRoom.php")
    public void viewRoom(
            @Field("uid") String hid,
            Callback<Response> callback);






    }
