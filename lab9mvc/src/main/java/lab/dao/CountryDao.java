package lab.dao;

import lab.domain.Country;

import java.util.List;


public interface CountryDao {
	
	void insert(Country country);
	
	Country select(int id);
	
	List<Country> selectAll();
	
}
