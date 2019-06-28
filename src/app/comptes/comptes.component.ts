import { Component, OnInit } from '@angular/core';
import {Compte} from '../compte';
import { CompteService } from '../compte.service';

@Component({
  selector: 'app-comptes',
  templateUrl: './comptes.component.html',
  styleUrls: ['./comptes.component.css']
})
export class ComptesComponent implements OnInit {
  comptes: Compte[];
 
  constructor(private compteService: CompteService) { }
 
  ngOnInit() {
    this.getComptes();
  }
 
  getComptes(): void {
    this.compteService.getComptes()
        .subscribe(comptes => this.comptes = comptes);
  }

  
  add(nameCompte: string): void {
    nameCompte = nameCompte.trim();
    if (!nameCompte) { return; }
    this.compteService.addCompte({ nameCompte } as Compte)
      .subscribe(compte => {
        this.comptes.push(compte);
      });
  }
 
  delete(compte: Compte): void {
    this.comptes = this.comptes.filter(h => h !== compte);
    this.compteService.deleteCompte(compte).subscribe();
  }
}

