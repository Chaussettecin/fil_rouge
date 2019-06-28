import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
 
import { Personnage } from '../personnage';
import { PersonnageService }  from '../personnage.service';


@Component({
  selector: 'app-personnage-detail',
  templateUrl: './personnage-detail.component.html',
  styleUrls: ['./personnage-detail.component.css']
})
export class PersonnageDetailComponent implements OnInit {
  @Input() personnage: Personnage;

  constructor( 
    private route: ActivatedRoute,
    private personnageService: PersonnageService,
    private location: Location
  ) {}
 
  ngOnInit(): void {
    this.getPersonnage();
  }
 
  getPersonnage(): void {
    const idPersonnage = +this.route.snapshot.paramMap.get('idPersonnage');
    this.personnageService.getPersonnage(idPersonnage)
      .subscribe(personnage => this.personnage = personnage);
  }
 
  goBack(): void {
    this.location.back();
  }
  
  save(): void {
    this.personnageService.updatePersonnage(this.personnage)
      .subscribe(() => this.goBack());
  }
}
