package fr.huxor.service;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.huxor.dao.IBrandsRepository;
import fr.huxor.dao.ICategorysRepository;
import fr.huxor.dao.ILeaseAgreementsRepository;
import fr.huxor.dao.IModelsRepository;
import fr.huxor.entities.Brands;
import fr.huxor.entities.Categorys;
import fr.huxor.entities.Models;

public class ServiceUtility{
	
	@Autowired
	private IModelsRepository modelRepo;
	@Autowired
	private IBrandsRepository brandRepo;
	@Autowired
	private ICategorysRepository categoryRepo;
	@Autowired
	private ILeaseAgreementsRepository leaseRepo;
	
	/**
	 * avoid duplicating Models
	 * 
	 * @param modelName
	 * @return an existing Model or a new one
	 */
	protected Models checkAllModels(String modelName) {

		if (modelRepo.existsById(modelName)) {
			Optional<Models> mod = modelRepo.findById(modelName);
			Models m = mod.get();
			return m;
		} else {
			Models m = new Models(modelName);
			modelRepo.saveAndFlush(m);
			return m;
		}
	}

	/**
	 * avoid duplicating Brands
	 * 
	 * @param brandName
	 * @return an existing Brand or a new one
	 */
	protected Brands checkAllBrands(String brandName) {

		if (brandRepo.existsById(brandName)) {
			Optional<Brands> bra = brandRepo.findById(brandName);
			Brands b = bra.get();
			return b;
		} else {
			Brands b = new Brands(brandName);
			brandRepo.saveAndFlush(b);
			return b;
		}
	}

	/**
	 * avoid duplicating Categorys
	 * 
	 * @param categoryName
	 * @return an existing Category or a new one
	 */
	protected Categorys checkAllCategorys(String categoryName) {

		if (categoryRepo.existsById(categoryName)) {
			Optional<Categorys> cat = categoryRepo.findById(categoryName);
			Categorys c = cat.get();
			return c;
		} else {
			Categorys c = new Categorys(categoryName);
			categoryRepo.saveAndFlush(c);
			return c;
		}
	}

}
