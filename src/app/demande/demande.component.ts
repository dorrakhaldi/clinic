import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {CongeService} from "../services/conge.service";
export class Conge{
  constructor(
    public id:number=1,
  public dateDebut:any,
  public dateFin:any,
  public typeConge:String="",
  public raison:String="",
  public confirmationChefService:Boolean=false,
  public confirmationRh:Boolean=false
  ) {
  }
}
@Component({
  selector: 'app-demande',
  templateUrl: './demande.component.html',
  styleUrls: ['./demande.component.scss']
})
export class DemandeComponent implements OnInit {
  dateDebut!: any;
  dateFin!: any;
  raison!: string;
  conges:Conge[]=[];


  constructor(private httpClient: HttpClient, private router: Router, private congeService: CongeService) { }

  ngOnInit(): void {
    this.getCongesFromserv();
  }
  onSubmit(f: NgForm) {
    const url = 'http://localhost:8002/SpringMVC/servlet/api/conge';
    this.httpClient.post(url, f.value)
      .subscribe(() => {
        this.ngOnInit(); //reload table
      });
    this.router.navigate(['conge']);
  }

  vider(f:NgForm) {

    f.reset()
  }
  getCongesFromserv(){
    this.congeService.getConges().subscribe(
      response => {
        console.log(response);
        this.conges = response;
      }
    );
  }

}
