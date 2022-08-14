package com.kk.rest.webservices.springbootworkshop.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.kk.rest.webservices.springbootworkshop.model.DynamicFilteredBean;
import com.kk.rest.webservices.springbootworkshop.model.FilteredBean;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1. Response'da bazi fieldlari filtrelemek isteyebiliriz, bu ornekte de oldugu gibi
 *  FilteredBean classinda age'i @JsonIgnore ile response'tan cikarmis olduk (static filtering)
 * 2. Bazi callarda ise o calla ozel filtreleme yapilmasi gerekecektir, ornekteki gibi MappingJacksonValue tanimlayip, 
 *  filtreyi eklemek yeterli olacaktir, burada kritik konu 
 *  DynamicFilteredBeanFilter ile tanimladigimiz filterin Beande @JsonFilter annotationu ile verilmesi gerekmektedir
 * @author korayk
 */
@RestController
public class Controller05FilterController {

	@GetMapping("/get-filter")
	public FilteredBean getFilter() {
		return new FilteredBean("Koray", "Kocakaya", 30);
	}
	
	@GetMapping("/get-filter-dynamic")
	public MappingJacksonValue getFilterDynamic() {
		DynamicFilteredBean filteredBean = new DynamicFilteredBean("Koray", "Kocakaya", 30);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("age", "surname");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicFilteredBeanFilter", filter);
		MappingJacksonValue value = new MappingJacksonValue(filteredBean);
		value.setFilters(filters);
		
		return value;
	}
}
