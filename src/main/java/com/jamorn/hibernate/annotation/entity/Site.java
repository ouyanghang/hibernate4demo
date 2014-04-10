package com.jamorn.hibernate.annotation.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sunyameng on 2014/4/9.
 */
@Entity
@Table(name="a_site")
public class Site implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @OneToMany(mappedBy = "site",cascade =CascadeType.ALL )
    private List<Channel> channels=new ArrayList<>();

    public Site(){}

    public Site(String name,Date createTime){
        this.name=name;
        this.createTime=createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public void addChannel(Channel channel){
        if(channel==null) {
            throw new RuntimeException("Channel can't be null!");
        }
        this.getChannels().add(channel);
        channel.setSite(this);
    }
    public String toString(){
        return String.format("id=%s,name=%s,createTime=%s",String.valueOf(id.longValue()),name,createTime.toString());
    }
}
