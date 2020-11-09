/**
 * 
 */
package br.tec.marco.housepricepredictionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.tec.marco.housepricepredictionservice.entity.House;

/**
 * @author marcoyf
 *
 */
public interface HouseRepository extends JpaRepository<House, Long> {

}
