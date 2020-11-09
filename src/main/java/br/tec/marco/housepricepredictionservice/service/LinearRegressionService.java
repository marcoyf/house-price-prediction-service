/**
 * 
 */
package br.tec.marco.housepricepredictionservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.tec.marco.housepricepredictionservice.entity.House;
import br.tec.marco.housepricepredictionservice.repository.HouseRepository;
import weka.classifiers.Classifier;
import weka.classifiers.functions.LinearRegression;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

/**
 * @author marcoyf
 *
 */
@Service
public class LinearRegressionService {
	
	@Autowired
	private HouseRepository houseRepository;

	public double predictHousePrice(House housePriceToPredict) throws Exception {
		
		ArrayList<Attribute> attributes = new ArrayList<>();
		
		Attribute houseSizeAttribute = new Attribute("houseSize");
		attributes.add(houseSizeAttribute);
		Attribute lotSizeAttribute = new Attribute("lotSize");
		attributes.add(lotSizeAttribute);
		Attribute bedroomsAttribute = new Attribute("bedrooms");
		attributes.add(bedroomsAttribute);
		Attribute kitchenGraniteAttribute = new Attribute("kitchenGranite");
		attributes.add(kitchenGraniteAttribute);
		Attribute upgradedBathroomAttribute = new Attribute("upgradedBathroom");
		attributes.add(upgradedBathroomAttribute);
		Attribute sellingPriceAttribute = new Attribute("sellingPrice");
		attributes.add(sellingPriceAttribute);
		
		Instances trainingDataset = new Instances("trainingDataset", attributes, 7);
		trainingDataset.setClassIndex(trainingDataset.numAttributes() - 1);
		
		List<House> houses = houseRepository.findAll();
		
		for (House house : houses) {
			
			Instance instance = new DenseInstance(6);
			
			instance.setValue(houseSizeAttribute, house.getHouseSize().doubleValue());
			instance.setValue(lotSizeAttribute, house.getLotSize().doubleValue());
			instance.setValue(bedroomsAttribute, house.getBedrooms());
			instance.setValue(kitchenGraniteAttribute, house.getKitchenGranite());
			instance.setValue(upgradedBathroomAttribute, house.getUpgradedBathroom());
			instance.setValue(sellingPriceAttribute, house.getSellingPrice().doubleValue());
			
			trainingDataset.add(instance);
		}
		
		Classifier targetFunction = new LinearRegression();
		targetFunction.buildClassifier(trainingDataset);
		
		Instances predictionInstances = new Instances("predictionInstances", attributes, 1);
		predictionInstances.setClassIndex(trainingDataset.numAttributes() - 1);
		
		Instance instance = new DenseInstance(6);
		instance.setValue(houseSizeAttribute, housePriceToPredict.getHouseSize().doubleValue());
		instance.setValue(lotSizeAttribute, housePriceToPredict.getLotSize().doubleValue());
		instance.setValue(bedroomsAttribute, housePriceToPredict.getBedrooms());
		instance.setValue(kitchenGraniteAttribute, housePriceToPredict.getKitchenGranite());
		instance.setValue(upgradedBathroomAttribute, housePriceToPredict.getUpgradedBathroom());
		predictionInstances.add(instance);

		double predictedPrice  = targetFunction.classifyInstance(predictionInstances.get(0));
		
		return predictedPrice;
	}
}
