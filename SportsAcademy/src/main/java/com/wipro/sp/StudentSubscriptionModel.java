package com.wipro.sp;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentSubscriptionModel {
	
	@Id
	private int id;
	private String name;
	@ElementCollection(targetClass=String.class)
	private List<String> sports;
	
	public StudentSubscriptionModel() {
		super();
	}

	public StudentSubscriptionModel(int id, String name, List<String> sports) {
		super();
		this.id = id;
		this.name = name;
		this.sports = sports;
	}

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

	public List<String> getSports() {
		return sports;
	}

	public void setSports(List<String> sports) {
		this.sports = sports;
	}

	@Override
	public String toString() {
		return "StudentSubscription [id=" + id + ", name=" + name + ", sports=" + sports + "]";
	}

}
