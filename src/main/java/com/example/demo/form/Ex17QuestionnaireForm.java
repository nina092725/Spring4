package com.example.demo.form;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Ex17QuestionnaireForm {

    @NotBlank(message = "名前は必須です")
    @Size(min = 1, max = 127, message = "名前は１文字以上１２７文字以内で入力してください")
    private String name;

    @Size(min = 1, max = 127, message = "メールアドレスは１文字以上１２７文字以内で入力してください")
    @Email(message = "メールアドレスの形式が正しくありません")
    private String email;

    @NotBlank(message = "性別を選択してください")
    private String gender;

    @NotEmpty(message = "趣味を少なくとも１つ選択してください")
    private List<Integer> hobbyList;
    
    @NotNull(message = "好きな言語を選択してください")
    private Integer lang;

    @Size(min = 1, max = 2000, message = "その他は１文字以上２０００文字以内で入力してください")
    private String other;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Integer> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<Integer> hobbyList) {
        this.hobbyList = hobbyList;
    }

    public Integer getLang() {
        return lang;
    }

    public void setLang(Integer lang) {
        this.lang = lang;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }



}