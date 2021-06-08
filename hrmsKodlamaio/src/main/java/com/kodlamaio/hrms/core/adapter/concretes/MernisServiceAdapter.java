package com.kodlamaio.hrms.core.adapter.concretes;



import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.core.adapter.abstracts.MernisAdapterService;
import com.kodlamaio.hrms.entities.concretes.Employee;


@Service
public class MernisServiceAdapter implements MernisAdapterService {
	  public boolean CheckIfRealPerson(Employee employee)
	  {
		  //Mernis Ekleyemediğim için tc kimlik numarasının algoritmasını kontrol eden methodu yaptım
		  boolean kontrol = true;
		  int[] rakamlar = new int[11];  
		  int toplam =0;
		  int rakam13579=0;
		  int rakam2468=0;
		  if(employee.getNationality_id().length() !=11) {
			  kontrol = false;
		  }
		  if(employee.getNationality_id().substring(0,1)=="0") {
			  kontrol=false;
		  }
		  for(int i =0;i<employee.getNationality_id().length();i++) {
			  rakamlar[i] = Integer.parseInt(employee.getNationality_id().substring(i,i+1));
		  }
		  for(int i =0;i<employee.getNationality_id().length();i++) {
			  if(i<10) {
				  toplam += rakamlar[i];
			  }
			  else {
				  if(toplam%10!=rakamlar[i]) {
					  kontrol = false;  
				  }
			  }  
		  }
		  rakam13579+=rakamlar[0]+rakamlar[2]+rakamlar[4]+rakamlar[6]+rakamlar[8];
		  rakam2468+=rakamlar[1]+rakamlar[3]+rakamlar[5]+rakamlar[7];
		  if(((rakam13579*7)+(rakam2468*9))%10!=rakamlar[9]) {
			  kontrol = false;  
		  }
		  if((rakam13579*8)%10!=rakamlar[10]) {
			  kontrol = false;
		  }
          return kontrol;
	  }
}

