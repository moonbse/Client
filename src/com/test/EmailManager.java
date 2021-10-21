package com.test;

import com.test.model.EmailAccount;
import javafx.scene.control.TreeItem;
import com.test.controller.services.FetchFoldersService;
import com.test.model.EmailTreeItem;

public class EmailManager {

    //Folder handling:
//    private TreeItem<String> foldersRoot = new TreeItem<String>("");
    private EmailTreeItem<String> foldersRoot = new EmailTreeItem<String>("");

    public EmailTreeItem<String> getFoldersRoot(){
        return foldersRoot;
    }


    public void addEmailAccount(EmailAccount emailAccount){
        EmailTreeItem<String> treeItem = new EmailTreeItem<String>(emailAccount.getAddress());
        FetchFoldersService fetchFoldersService = new FetchFoldersService(emailAccount.getStore(), treeItem);
        fetchFoldersService.start();
        foldersRoot.getChildren().add(treeItem);
    }
}