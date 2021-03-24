
package com.example.assignment3.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Result implements Serializable {

    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("name")
    @Expose
    private com.example.assignment3.models.Name name;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("login")
    @Expose
    private com.example.assignment3.models.Login login;
    @SerializedName("dob")
    @Expose
    private com.example.assignment3.models.Dob dob;
    @SerializedName("registered")
    @Expose
    private Registered registered;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("cell")
    @Expose
    private String cell;
    @SerializedName("id")
    @Expose
    private com.example.assignment3.models.Id id;
    @SerializedName("picture")
    @Expose
    private com.example.assignment3.models.Picture picture;
    @SerializedName("nat")
    @Expose
    private String nat;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public com.example.assignment3.models.Name getName() {
        return name;
    }

    public void setName(com.example.assignment3.models.Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public com.example.assignment3.models.Login getLogin() {
        return login;
    }

    public void setLogin(com.example.assignment3.models.Login login) {
        this.login = login;
    }

    public com.example.assignment3.models.Dob getDob() {
        return dob;
    }

    public void setDob(com.example.assignment3.models.Dob dob) {
        this.dob = dob;
    }

    public Registered getRegistered() {
        return registered;
    }

    public void setRegistered(Registered registered) {
        this.registered = registered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public com.example.assignment3.models.Id getId() {
        return id;
    }

    public void setId(com.example.assignment3.models.Id id) {
        this.id = id;
    }

    public com.example.assignment3.models.Picture getPicture() {
        return picture;
    }

    public void setPicture(com.example.assignment3.models.Picture picture) {
        this.picture = picture;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

}
