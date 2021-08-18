package br.com.dio.citiesapi.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import br.com.dio.citiesapi.usertype.model.PointType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cidade")
@TypeDefs(value = {
	    @TypeDef(name = "point", typeClass = PointType.class)
	})
public class City {

	
	@Id
	private Long id;
	@Column(name = "nome")
	private String name;
	
	@Column(name = "uf")
	private Integer uf;
	
	@Column(name = "ibge")
	private Integer ibge;

	@Column(name = "geoLocation")
	private String geoLocation;
	
	@Type(type = "point")
	@Column(name = "lat_lon", updatable = false, insertable = false)
	private Point point;


}
