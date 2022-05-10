import { Injectable } from '@angular/core';
import {Employee} from "../employee/employee.component";
import {HttpClient} from "@angular/common/http";
import {FormGroup, NgForm} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private httpClient: HttpClient) {

  }
  getEmployes(){
    return this.httpClient.get<Employee [] >('http://localhost:8080/user-ms/api/users/user/getuser')

  }

  createemployee(f:NgForm){
    return this.httpClient.post('http://localhost:8080/user-ms/api/users/createuser',f.value)
  }
  editemployee(editForm:FormGroup ,id:number ){
    return this.httpClient.put('http://localhost:8080/user-ms/api/users/modifuser/' + id , editForm.value);
  }
  deleteemployee(id:number){
    return this.httpClient.delete('http://localhost:8080/user-ms/api/users/user/' + id);
  }

}
