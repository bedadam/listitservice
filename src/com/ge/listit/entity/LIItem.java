package com.ge.listit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity class representing listed item.
 * 
 */

@Entity
@Table(name="li_item")
public class LIItem implements Serializable {
	
	private static final long serialVersionUID = -4046169974877677630L;
	
	@Id
	@SequenceGenerator(name="FSE_CONCLUSIONS_ID_GENERATOR", sequenceName="SEQ_FSE_CONCLUSIONS_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FSE_CONCLUSIONS_ID_GENERATOR")
	private Long id;

	@Column(name="user")
	private String user;

	@Column(name="timestamp")
	private String timeStamp;
	
	@Column(name="category")
	private String category;
	
	@Column(name="descriptiontext")
	private String descriptionText;
	
	@Column(name="email")
	private String eMail;
	
	@Column(name="phonenumber")
	private String phoneNumber;
	
	@Column(name="price")
	private String price;
	
	@Column(name="title")
	private String title;
	
	@Lob
	@Column(name="attachment_file")
	private byte[] attachment_file;

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the timeStamp
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the description
	 */
	public String getDescriptionText() {
		return descriptionText;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescriptionText(String description) {
		this.descriptionText = description;
	}

	/**
	 * @return the eMail
	 */
	public String geteMail() {
		return eMail;
	}

	/**
	 * @param eMail the eMail to set
	 */
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the attachment_file
	 */
	public byte[] getAttachment_file() {
		return attachment_file;
	}

	/**
	 * @param attachment_file the attachment_file to set
	 */
	public void setAttachment_file(byte[] attachment_file) {
		this.attachment_file = attachment_file;
	}

}