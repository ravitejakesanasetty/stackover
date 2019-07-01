package com.pawana.stack.post.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="POSTTYPE")
public class PostType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="POST_TYPE_ID")
	private Integer postTypeId;
	@Column(name="POST_TYPE")
	private String postType;
	
	/*@OneToMany(mappedBy="postTypeId")
	private Set<PostTable> postData;*/
	
	public Integer getPostTypeId() {
		return postTypeId;
	}
	public void setPostTypeId(Integer postTypeId) {
		this.postTypeId = postTypeId;
	}
	public String getPostType() {
		return postType;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	
	

}
