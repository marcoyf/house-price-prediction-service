/**
 * 
 */
package br.tec.marco.housepricepredictionservice.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.tec.marco.housepricepredictionservice.entity.House;

/**
 * @author marcoyf
 *
 */
@RestController
public class HousePricePredictionController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private LinearRegressionService lrService;
	
	// http://localhost:8000/house-price-prediction/houseSize/3198/lotSize/9669/bedrooms/5/granite/1/upgdBathroom/1
	@GetMapping("/house-price-prediction/houseSize/{houseSize}/lotSize/{lotSize}/bedrooms/{bedrooms}/granite/{granite}/upgdBathroom/{upgdBathroom}")
	public House retrieveHousePrice(
			@PathVariable BigDecimal houseSize, 
			@PathVariable BigDecimal lotSize,
			@PathVariable Integer bedrooms, 
			@PathVariable Short granite, 
			@PathVariable Short upgdBathroom) {

		House house = new House(houseSize, lotSize, bedrooms, granite, upgdBathroom);
		house.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		
		try {
			
			double prediction = lrService.predictHousePrice(house);
			house.setSellingPrice(BigDecimal.valueOf(prediction));
			
		} catch (Exception e) {
			logger.error("Failed to predict house price.");
		}
		
		return house;
	}
	
	

}
