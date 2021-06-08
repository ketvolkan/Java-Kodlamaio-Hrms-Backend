package com.kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.EmployerCheckService;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import com.kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerCheckManager implements EmployerCheckService {
	
	private EmployerDao employerDao;
	@Autowired
	public EmployerCheckManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	public EmployerCheckManager() {}
	
	public boolean allFieldsAreRequired(Employer employer){
        if (employer.getMail().strip().isEmpty()
                || employer.getPassword().strip().isEmpty()
                || employer.getCompany_name().strip().isEmpty()
                || employer.getPhone_number().strip().isEmpty()
                || employer.getWebsite().strip().isEmpty())
        {
            return false;
        }
        else {
        return true;
        }
    }

	@Override
	public boolean findByMail(Employer employer) {
		if(this.employerDao.findByEmail(employer.getMail())!=null) {
			return false;
		}
		else {
			return true;
		}	
	}
	@Override
	public boolean checkMailOnSite(Employer employer) {
		if(employer.getMail().contains(employer.getWebsite()) == true)
		{
			return true;
		}
		else {
			return false;
		}
		
	}
	public String allMatch(Employer employer) {
		String errorMessage = "";
		boolean checkEmailonsite = checkMailOnSite(employer);
		boolean checkFields = allFieldsAreRequired(employer);
		boolean checkEmail = findByMail(employer);
		if (!checkEmail || !checkFields || !checkEmailonsite) {

            if (!checkEmail) {
                errorMessage += "Email Kullanımda ";
            }

            if (!checkFields) {
                errorMessage += "Lütfen Tüm Alanları Doldurunuz ";
            }

            if (!checkEmailonsite){
                errorMessage += "Mail ile Website Domaini Uyuşmamakta ";
            }        
        }
		return errorMessage;
	}
}
