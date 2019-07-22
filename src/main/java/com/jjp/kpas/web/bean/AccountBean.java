/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jjp.kpas.web.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.jjp.kpas.entity.Account;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author jin04038
 */
@Named
@RequestScoped
public class AccountBean {

    private Account account = new Account();

    
    @Size(max = 255)
    @NotNull
    private String userId;
    
    @Size(max = 255)
    @NotNull
    private String password;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String register(){


        //FacesContextを取得
        FacesContext facesContext = FacesContext.getCurrentInstance();
        // フラッシュスコープにメッセージを設定
        facesContext.getExternalContext().getFlash().put("notice", "ユーザを追加しました。");
        // ログイン画面にリダイレクト遷移
        return "/login?faces-redirect=true"; 
    }
}
