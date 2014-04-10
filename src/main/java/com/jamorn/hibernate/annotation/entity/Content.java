package com.jamorn.hibernate.annotation.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sunyameng on 2014/4/9.
 */
@Entity
@Table(name="a_content")
public class Content  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String title;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    public Content(){}
    public Content(String title,Date createTime){
        this.title=title;
        this.createTime=createTime;
    }
    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
