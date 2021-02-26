package com.aircas.hopital.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_device")
public class DeviceDAO {
	@Id
	@Column(name="id", nullable=false)
	private String id;
	private Integer frequency;
	private Integer power;
	private Integer progress;
	private String ip_router;
	private String ip_device;
	private boolean alarm;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getFrequency() {
		return frequency;
	}
	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
	public Integer getPower() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
	}
	public Integer getProgress() {
		return progress;
	}
	public void setProgress(Integer progress) {
		this.progress = progress;
	}
	public String getIp_router() {
		return ip_router;
	}
	public void setIp_router(String ip_router) {
		this.ip_router = ip_router;
	}
	public String getIp_device() {
		return ip_device;
	}
	public void setIp_device(String ip_device) {
		this.ip_device = ip_device;
	}
	public boolean isAlarm() {
		return alarm;
	}
	public void setAlarm(boolean alarm) {
		this.alarm = alarm;
	}
	@Override
	public String toString() {
		return "DeviceDAO [id=" + id + ", frequency=" + frequency + ", power=" + power + ", progress=" + progress + ", ip_router=" + ip_router + ", ip_device=" + ip_device + ", alarm=" + alarm + "]";
	}
	
}
