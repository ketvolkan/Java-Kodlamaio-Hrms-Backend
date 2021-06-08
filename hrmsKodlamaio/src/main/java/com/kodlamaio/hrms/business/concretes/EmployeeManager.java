package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.EmployeeCheckService;
import com.kodlamaio.hrms.business.abstracts.EmployeeService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import com.kodlamaio.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{
private EmployeeDao employeeDao;
private EmployeeCheckService employeeCheckService;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao,EmployeeCheckService employeeCheckService) {
		super();
		this.employeeDao = employeeDao;
		this.employeeCheckService = employeeCheckService;
	}
	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Employee'lar Listelendi");
	}
	@Override
	public Result add(Employee employee) {
		if(employeeCheckService.allMatch(employee)!="")
		{
			return new ErrorResult(employeeCheckService.allMatch(employee));
		}else {
			this.employeeDao.save(employee);
			return new SuccessResult(employee.getFirst_name()+" "+employee.getLast_name()+" Eklendi");
		}
	}
	@Override
	public Result delete(int id) {
		this.employeeDao.deleteById(id);
		return new SuccessResult("ID:"+id+" Başarıyla Silindi");
	}

}
