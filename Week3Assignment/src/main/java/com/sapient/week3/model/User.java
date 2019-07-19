package com.sapient.week3.model;

import java.io.Serializable;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "User")
@JsonIgnoreProperties(ignoreUnknown = true)


public class User implements Serializable {
	
	
	
	 public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @JsonProperty
	    private  int id;

	    @NotEmpty
	    @XmlElement(name = "NAME")
	    @Column(name="name")
	    private  String name;
	    

	    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	    @JoinColumn(name="post")
	    @XmlElement
	    private List<Post> posts;

	    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	    private Address address;

	    public User(){

	    }

	    public User(int id, String name) {
	        this.id = id;
	        this.name = name;
	    }

	    @Override
	    public String toString() {
	        return "User{" +
	                "id=" + id +
	                ", name='" + name + '\'' +'}';
	    }

	
	
	

	
	
	
	
	
}