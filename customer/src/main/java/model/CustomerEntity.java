package model;

public class CustomerEntity {
	protected int id;
	protected String name;
	protected String sname;
	protected String category;
	protected String country;
	

	public CustomerEntity() {
	}
	
	public CustomerEntity(String name, String sname, String category, String country) {
		this.name = name;
		this.sname = sname;
		this.category = category;
		this.country = country;
	}

	public CustomerEntity(int id, String name, String sname, String category, String country) {
		this.id = id;
		this.name = name;
		this.sname = sname;
		this.category = category;
		this.country = country;
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
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "CustomerEntity [id=" + id + ", name=" + name + ", sname=" + sname + ", category=" + category
				+ ", country=" + country + "]";
	}
	

}
