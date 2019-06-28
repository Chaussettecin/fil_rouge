import { Component, OnInit } from '@angular/core';
import {Personnage} from '../personnage';
import { PersonnageService } from '../personnage.service';

@Component({
  selector: 'app-personnages',
  templateUrl: './personnages.component.html',
  styleUrls: ['./personnages.component.css']
})
export class PersonnagesComponent implements OnInit {
  personnages: Personnage[];
 
  constructor(private personnageService: PersonnageService) { }
 
  ngOnInit() {
    this.getPersonnages();
  }
  
  getPersonnages(): void {
    this.personnageService.getPersonnages()
        .subscribe(personnages => this.personnages = personnages);
  }
  
  add(namePersonnage: string): void {
    namePersonnage = namePersonnage.trim();
    if (!namePersonnage) { return; }
    this.personnageService.addPersonnage({ namePersonnage } as Personnage)
      .subscribe(personnage => {
        this.personnages.push(personnage);
      });
  }
 
  delete(personnage: Personnage): void {
    this.personnages = this.personnages.filter(h => h !== personnage);
    this.personnageService.deletePersonnage(personnage).subscribe();
  }
}

