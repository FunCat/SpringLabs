package lab.mvc.form.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class CountryFormBean {

	public CountryFormBean(){}

	@NotNull (message="{NotNull.countryFormBean.name}")
	@Size(min = 2, max = 20)
	private String name;
	
	@NotNull
	@Size(min = 2, max = 30)
	private String codename;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodename() {
		return codename;
	}

	public void setCodename(String codename) {
		this.codename = codename;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", codename=" + codename + "]";
	}
}
