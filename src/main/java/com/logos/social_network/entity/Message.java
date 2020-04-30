package com.logos.social_network.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private LocalDateTime createdOn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recipient_id")
    private User recipient;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    public Message(String text, LocalDateTime createdOn, User author, User recipient) {
        this.text = text;
        this.createdOn = createdOn;
        this.author = author;
        this.recipient = recipient;
    }

    public Message() {
    }
}
