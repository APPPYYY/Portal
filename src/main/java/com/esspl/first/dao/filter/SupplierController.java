/*
 * package com.esspl.first.dao.filter;
 * 
 * import org.springframework.http.converter.json.MappingJacksonValue; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.fasterxml.jackson.databind.ser.FilterProvider; import
 * com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter; import
 * com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
 * 
 * @RestController public class SupplierController {
 * 
 * @GetMapping("/onlyname") public MappingJacksonValue getSupplier() {
 * 
 * 
 * Supplier s1 = new Supplier(1, "subham", "iamsubham"); return s1;
 * 
 * 
 * Supplier s1 = new Supplier(100, "subham", "iamsubham");
 * SimpleBeanPropertyFilter sbpf =
 * SimpleBeanPropertyFilter.filterOutAllExcept("name"); FilterProvider
 * filterProvider = new SimpleFilterProvider().addFilter("subham", sbpf);
 * 
 * MappingJacksonValue mapping = new MappingJacksonValue(s1);
 * mapping.setFilters(filterProvider); return mapping;
 * 
 * }
 * 
 * @GetMapping("/onlyidandpasword") public MappingJacksonValue getSuppliers() {
 * 
 * 
 * Supplier s1 = new Supplier(1, "subham", "iamsubham"); return s1;
 * 
 * 
 * Supplier s1 = new Supplier(100, "subham", "iamsubham");
 * SimpleBeanPropertyFilter sbpf =
 * SimpleBeanPropertyFilter.filterOutAllExcept("id", "password"); FilterProvider
 * filterProvider = new SimpleFilterProvider().addFilter("subham", sbpf);
 * 
 * MappingJacksonValue mapping = new MappingJacksonValue(s1);
 * mapping.setFilters(filterProvider); return mapping;
 * 
 * }
 * 
 * }
 */