package com.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.service.BuildingService;

@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;

	@GetMapping(value = "/api/building/")
	public List<BuildingDTO> getBuilding(@RequestParam(name = "name",required = false) String name,
										@RequestParam(name = "districtId",required = false) Long districtId,
										@RequestParam(name = "typeCode",required = false) List <String>typeCode){
		List<BuildingDTO> result = buildingService.findAll(name,districtId);

		return result;

	}

	/*
	 * @GetMapping(value = "/api/building/") public BuildingDTO
	 * getBuilding(@RequestParam(value = "name", required = false) String
	 * nameBuilding,
	 * 
	 * @RequestParam(value = "numberOfBasement", required = false) Integer
	 * numberOfBasement,
	 * 
	 * @RequestParam(value = "ward", required = false) String ward) { BuildingDTO
	 * result = new BuildingDTO(); result.setName(nameBuilding);
	 * result.setNumberOfBasement(numberOfBasement); result.setWard(ward); return
	 * result; }
	 */
	/*
	 * @PostMapping(value = "/api/building/") public BuildingDTO
	 * getBuilding2(@RequestBody BuildingDTO building) { // sau khi xử lí dưới DB
	 * return building; }
	 */

	@DeleteMapping(value = "/api/building/{id}/{name}/")
	public void deleteBuilding(@PathVariable Integer id, @PathVariable String name,
			@RequestParam(value = "ward", required = false) String ward) {
		System.out.print("Da xoa toa nha co id la  " + id + name + ward);
	}

	/*
	 * @GetMapping(value = "/api/building/") public List<BuildingDTO>
	 * getBuilding(@RequestParam(value = "name", required = false) String
	 * nameBuilding,
	 * 
	 * @RequestParam(value = "numberOfBasement", required = false) Integer
	 * numberOfBasement,
	 * 
	 * @RequestParam(value = "ward", required = false) String ward) {
	 * List<BuildingDTO> listBuildings = new ArrayList<>(); BuildingDTO buildingDT01
	 * = new BuildingDTO(); buildingDT01.setName("ABC Building");
	 * buildingDT01.setNumberOfBasement(3); buildingDT01.setWard("Tan Phu");
	 * BuildingDTO buildingDT02 = new BuildingDTO();
	 * buildingDT02.setName("ACM Building"); buildingDT02.setNumberOfBasement(4);
	 * buildingDT02.setWard("Binh Tan"); listBuildings.add(buildingDT02);
	 * listBuildings.add(buildingDT01); return listBuildings;
	 * 
	 * 
	 * }
	 */

}