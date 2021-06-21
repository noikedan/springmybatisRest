package dev.itboot.mb.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.itboot.mb.model.Staff;
import dev.itboot.mb.service.StaffService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class StaffController {
	// mapperをserviceに変更
	private final StaffService service;

	// mapperをserviceに変更
	@GetMapping("/")
	public List<Staff> getAllStaffs() {
		List<Staff> staff = service.selectAll();
		return staff;
	}

	@GetMapping("/edit/{id}")
	public Staff editStaff(@PathVariable Long id) {
		return service.selectByPrimaryKey(id);
	}

	@PostMapping("/add")
	public void create(@RequestBody Staff staff) {
		service.save(staff);
	}

	@PutMapping("/complete")
	public void put(@RequestBody Staff staff) {
		service.save(staff);
	}

	@GetMapping("/delete/{id}")
	public void deleteStaff(@PathVariable Long id) {
		service.deleteByPrimaryKey(id);
	}
}
