package com.jamorn.hibernate.annotation.entity;

import org.omg.SendingContext.RunTime;

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
@Table(name="a_channel")
public class Channel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @ManyToOne
    @JoinColumn(name="site_id",unique = true)
    private Site site;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "channel")
    private List<Content> contents=new ArrayList<>();

    public Channel(){}
    public Channel(String name,Date createTime){
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

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    public void addContent(Content content){
        if(content==null) {
            throw new RuntimeException("Content can't be null!");
        }
        this.getContents().add(content);
        content.setChannel(this);
    }
}
