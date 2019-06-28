import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
 
import { Compte } from '../compte';
import { CompteService }  from '../compte.service';

// Liste des comptes utilisateurs

@Component({
  selector: 'app-liste-compte',
  templateUrl: './liste-compte.component.html',
  styleUrls: ['./liste-compte.component.css']
})
export class ListeCompteComponent implements OnInit {
  @Input() comptes: Compte[];

  constructor(
    private route: ActivatedRoute,
    private compteService: CompteService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.getComptes();
  }

  getComptes(): void {
   
    this.compteService.getComptes()
      .subscribe(comptes => this.comptes = comptes);
  }

  goBack(): void {
    this.location.back();
  }
}

