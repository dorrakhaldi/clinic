import { Injectable } from '@angular/core';
import { HttpClient ,HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable , throwError  } from 'rxjs';
import { baseUrl} from "../shared/baseinfo";
import { Formation } from '../shared/Formation';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'mon-jeton'
  })};
@Injectable({
  providedIn: 'root'
})
export class BackendApiFormationService {



  constructor( private  http :HttpClient) {

  }
  //create  formation
  public create(formation:Formation ) :any{
    if(formation ===null) return throwError("null data");
    else{
      this.http.post( baseUrl+"formation/create", {"nom":formation.nom ,"dateDebut":formation.dateDebut ,"dateFin":formation.dateFin ,
        "domaine":formation.domaine,"nbPlaceDisponible":formation.nbPlaceDisponible ,"nomSalle":formation.nomSalle , "etatFormation":formation.etatFormation})
        .subscribe(data => {
          console.log(data);
        });
    }
  }
  //get  formation
  public getallFormation() :Observable <Array<Formation>>{
    return this.http.get <Array <Formation>>("http://localhost:8080/rh-ms/api/formation/all");
  }
  //delete   formation
  public deleteFormation(formation:Formation)
  {
    const id=formation.id;
    this.http.delete(baseUrl+"formation/desactiver/"+id.toString())
      .subscribe(data =>{console.log(data);});
  }
  public updateFormation(formation:Formation ,id :any )
  {
    this.http.put(baseUrl+"formation/update/"+id.toString() ,{"nom":formation.nom ,"dateDebut":formation.dateDebut ,"dateFin":formation.dateFin ,
      "domaine":formation.domaine,"nbPlaceDisponible":formation.nbPlaceDisponible ,"nomSalle":formation.nomSalle,"etatFormation":formation.etatFormation})
      .subscribe(data=>{console.log(data);});
  }
  public getOne(id :any )
  {

  }
}
