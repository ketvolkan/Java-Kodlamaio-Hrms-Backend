package com.kodlamaio.hrms.business.concretes;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.EmployeeCheckService;
import com.kodlamaio.hrms.core.adapter.abstracts.MernisAdapterService;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import com.kodlamaio.hrms.entities.concretes.Employee;

@Service
public class EmployeeCheckManager implements EmployeeCheckService {

	private EmployeeDao employeeDao;
	private MernisAdapterService mernisAdapterService;
	@Autowired
	public EmployeeCheckManager(EmployeeDao employeeDao,MernisAdapterService mernisAdapterService) {
		super();
		this.employeeDao = employeeDao;
		this.mernisAdapterService = mernisAdapterService;
	}
	@Override
	public boolean allFieldsAreRequired(Employee employee) {
		if (employee.getMail().strip().isEmpty()
                || employee.getPassword().strip().isEmpty()
                || employee.getFirst_name().strip().isEmpty()
                || employee.getLast_name().strip().isEmpty()
                || employee.getNationality_id().strip().isEmpty()
				|| employee.getDate_year().strip().isEmpty())
        {
            return false;
        }
        else {
        return true;
        }
	}

	@Override
	public boolean findByMailAndNId(Employee employee) {
		if(this.employeeDao.findByEmailandNid(employee.getMail(),employee.getNationality_id())!=null) {
			return false;
		}
		else {
			return true;
		}	
	}

	@Override
	public boolean checkMernis(Employee employee) {
		

			return this.mernisAdapterService.CheckIfRealPerson(employee);

	}

	@Override
	public String allMatch(Employee employee) {
		String errorMessage = "";
		boolean checkmernis= checkMernis(employee);
		boolean checkFields = allFieldsAreRequired(employee);
		boolean checkEmailandNid = findByMailAndNId(employee);
		if (!checkmernis || !checkFields || !checkEmailandNid) {

            if (!checkmernis) {
                errorMessage += "Tc'niz Hatalı Lütfen Tc'nizi kontrol edin. ";
            }

            if (!checkFields) {
                errorMessage += "Tüm alanlar dolu olmak zorunda. ";
            }

            if (!checkEmailandNid){
                errorMessage += "Email veya Tc daha önceden kaydedilmiş. ";
            }        
        }
		return errorMessage;
	}

}
