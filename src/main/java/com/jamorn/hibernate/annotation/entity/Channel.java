package com.jamorn.hibernate.annotation.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sunyameng on 2014/4/9.
 */
@Entity
@Table(name="a_channel")
public class Channel {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @ManyToOne
    @JoinColumn(name="site_id",unique = true,nullable = false)
    private Site site;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "channel")
    private List<Content> contents=new ArrayList<>();

    public Channel(){}
    public Channel(String name,Date createTime,Site site){
        this.name=name;
        this.createTime=createTime;
        this.site=site;
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
}
