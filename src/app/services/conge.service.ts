import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Employee} from "../employee/employee.component";
import {Conge} from "../shared/Conge";
import {NgForm} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class CongeService {

  constructor(private httpClient: HttpClient) { }
  getConges(){
    return this.httpClient.get<Conge [] >('http://localhost:8086/rh-ms/api/conge')
  }
  createConge(f:NgForm){
    return this.httpClient.post('http://localhost:8080/rh-ms/api/conge',f.value)
  }
  deleteConge(congeId: number){
    return this.httpClient.delete('http://localhost:8086/rh-ms/api/conge'+congeId)
  }
  updateConge(congeId: number,f:NgForm){
    return this.httpClient.put('http://localhost:8080/rh-ms/api/conge'+congeId,f.value)
  }
  getCongeById(congeId: number){
    return this.httpClient.get('http://localhost:8086/rh-ms/api/conge'+congeId)
  }
  acceptConge(congeId: number){
    return this.httpClient.get('http://localhost:8086/rh-ms/api/conge'+'/acceptConge/'+congeId)
  }
  refuseConge(congeId: number){
    return this.httpClient.get('http://localhost:8086/rh-ms/api/conge'+'/refuseConge/'+congeId)
  }
}
