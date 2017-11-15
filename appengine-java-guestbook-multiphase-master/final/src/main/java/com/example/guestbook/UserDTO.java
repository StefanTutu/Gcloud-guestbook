package com.example.guestbook;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

import java.lang.String;
import java.util.Date;
import java.util.List;

@Entity
public class UserDTO {

    @Parent Key<Guestbook> theBook;
    @Id public Long id;
    public String email;
    public String nickname;
    public String authdomain;
    @Index public Date lastMessageDate;
    public Long IdMessage;

    public UserDTO() {
        lastMessageDate = new Date();
    }

    public UserDTO(String book, String email, String nickname, String authdomain, Long idMessage) {
        this();
        this.email = email;
        this.nickname = nickname;
        this.authdomain = authdomain;
        this.IdMessage = idMessage;
        if( book != null ) {
            theBook = Key.create(Guestbook.class, book);  // Creating the Ancestor key
        }
    }
}