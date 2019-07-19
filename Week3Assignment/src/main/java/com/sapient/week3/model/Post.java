package com.sapient.week3.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;


@Entity
@Table(name = "Post")
@Data

public class Post implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    
    private String body;
    
    public Post() {
		// TODO Auto-generated constructor stub
	}

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", name='" + title + '\'' + body +
                '}';
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
