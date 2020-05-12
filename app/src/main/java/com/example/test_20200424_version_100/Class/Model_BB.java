package com.example.test_20200424_version_100.Class;

public class Model_BB {
    private String Id;
    private String Name;
    private String Year;
    private String Code;
    private String Image;
    private String Detail;
    private String Id_kind;
    private String Kind;
    public String url = "http://192.168.49.2/Student/Bien_Bao_20200424/imagePHP/";

    public Model_BB(String id, String name, String year, String code, String image) {
        Id = id;
        Name = name;
        Year = year;
        Code = code;
        Image = image;
    }

    public Model_BB(String id, String name, String year, String code, String image, String detail, String id_kind, String kind) {
        Id      = id;
        Name    = name;
        Year    = year;
        Code    = code;
        Image   = image;
        Detail  = detail;
        Id_kind = id_kind;
        Kind    = kind;
    }

    public String getKind() {
        return Kind;
    }

    public void setKind(String kind) {
        Kind = kind;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getImage() {
        return url + Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public String getId_kind() {
        return Id_kind;
    }

    public void setId_kind(String id_kind) {
        Id_kind = id_kind;
    }
}
