package com.nothrim.database.models.security;

import com.nothrim.database.models.images.Image;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Notrim on 24.04.2017.
 */
@Entity
@Table(name = "user_table")
public class User {
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    private Set<Role> roles;
    private Set<Image> images;
    private Set<Image> favImages;
    private com.nothrim.database.models.weather.Weather weather;
    private String token;
    private String city;
    private Float latitude;
    private Float longitude;
    private Image currentImage;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    @ManyToMany
    @JoinTable(name = "user_image", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "image_id"))
    public Set<Image> getImages() {
        return images;
    }

    @ManyToMany
    @JoinTable(name = "user_image_fav", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "image_id"))
    public Set<Image> getFavImages() {
        return favImages;
    }

    public void setFavImages(Set<Image> favImages) {
        this.favImages = favImages;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @ManyToOne
    @JoinColumn(name = "weather_id")
    public com.nothrim.database.models.weather.Weather getWeather() {
        return weather;
    }

    public void setWeather(com.nothrim.database.models.weather.Weather weather) {
        this.weather = weather;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @ManyToOne
    @JoinColumn(name = "image_id")
    public Image getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Image currentImage) {
        this.currentImage = currentImage;
    }
}
