import { Component, OnInit } from '@angular/core';
import { Compte } from '../compte';
import { CompteService } from '../compte.service';
import { Personnage } from '../personnage';
import { PersonnageService } from '../personnage.service';
import { Ennemi } from '../ennemi';
import { EnnemiService } from '../ennemi.service'; 
import { Equipement } from '../equipement';
import { EquipementService } from '../equipement.service';
import { Quete } from '../quete';
import { QueteService } from '../quete.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: [ './dashboard.component.css' ]
})
export class DashboardComponent implements OnInit {
  comptes: Compte[] = [];
  personnages: Personnage[] = [];
  ennemis: Ennemi[] = [];
  equipements: Equipement[] = [];
  quetes: Quete[] = [];
 
  constructor(private compteService: CompteService,private personnageService: PersonnageService,private ennemiService: EnnemiService, private equipementService: EquipementService, private queteService: QueteService) { }
 
  ngOnInit() {
    this.getComptes();
  }
 
  getComptes(): void {
    this.compteService.getComptes()
      .subscribe(comptes => this.comptes = comptes.slice(1, 5));
  }

  getPersonnages(): void {
    this.personnageService.getPersonnages()
      .subscribe(personnages => this.personnages = personnages.slice(1, 5));
  }

  getEnnemis(): void {
    this.ennemiService.getEnnemis()
      .subscribe(ennemis => this.ennemis = ennemis.slice(1, 5));
  }

  getEquipements(): void {
    this.equipementService.getEquipements()
      .subscribe(equipements => this.equipements = equipements.slice(1, 5));
  }

  getQuetes(): void {
    this.queteService.getQuetes()
      .subscribe(quetes => this.quetes = quetes.slice(1, 5));
  }

}
