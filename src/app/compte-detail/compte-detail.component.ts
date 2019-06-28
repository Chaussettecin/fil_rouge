import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
 
import { Compte } from '../compte';
import { CompteService }  from '../compte.service';


@Component({
  selector: 'app-compte-detail',
  templateUrl: './compte-detail.component.html',
  styleUrls: ['./compte-detail.component.css']
})
export class CompteDetailComponent implements OnInit {
  @Input() compte: Compte;

  constructor(
    private route: ActivatedRoute,
    private compteService: CompteService,
    private location: Location
  ) {}
 
  ngOnInit(): void {
    this.getCompte();
  }
 
  getCompte(): void {
    const idCompte = +this.route.snapshot.paramMap.get('idCompte');
    this.compteService.getCompte(idCompte)
      .subscribe(compte => this.compte = compte);
  }
 
  goBack(): void {
    this.location.back();
  }
 
 save(): void {
    this.compteService.updateCompte(this.compte)
      .subscribe(() => this.goBack());
  }
}

