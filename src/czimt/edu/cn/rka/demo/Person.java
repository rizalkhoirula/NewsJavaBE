package czimt.edu.cn.rka.demo;

public class Person {
	private String name;
	private String sex;
	private String fimallyAddress;
	private String tel;
	private String id;
	//get/set method 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getFimallyAddress() {
		return fimallyAddress;
	}
	public void setFimallyAddress(String fimallyAddress) {
		this.fimallyAddress = fimallyAddress;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	//
	public void eat()
	{
		System.out.println(" I am " + this.getName()+ ", I like noodles" );
		
	}
	public void sleep()
	{
		System.out.println(" I am " + this.getName()+ ", I like sleep" );
	}
	

}
