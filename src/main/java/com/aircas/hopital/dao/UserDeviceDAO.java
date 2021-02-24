package com.aircas.hopital.dao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_user_device")
public class UserDeviceDAO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_device")
	private DeviceDAO id_device;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional=false)
	@JoinColumn(name = "id_user")
	private UserDAO id_user;
	
	private String bed_num;
	
	private String room;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DeviceDAO getId_device() {
		return id_device;
	}

	public void setId_device(DeviceDAO id_device) {
		this.id_device = id_device;
	}

	public UserDAO getId_user() {
		return id_user;
	}

	public void setId_user(UserDAO id_user) {
		this.id_user = id_user;
	}

	public String getBed_num() {
		return bed_num;
	}

	public void setBed_num(String bed_num) {
		this.bed_num = bed_num;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
	
	
}
