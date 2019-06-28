import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
 
import { Ennemi } from '../ennemi';
import { EnnemiService }  from '../ennemi.service';
 
@Component({
  selector: 'app-ennemi-detail',
  templateUrl: './ennemi-detail.component.html',
  styleUrls: ['./ennemi-detail.component.css']
})
export class EnnemiDetailComponent implements OnInit {
  @Input() ennemi: Ennemi;

  constructor(
    private route: ActivatedRoute,
    private ennemiService: EnnemiService,
    private location: Location
  ) {}
 
  ngOnInit(): void {
    this.getEnnemi();
  }
 
  getEnnemi(): void {
    const idEnnemi = +this.route.snapshot.paramMap.get('idEnnemi');
    this.ennemiService.getEnnemi(idEnnemi)
      .subscribe(ennemi => this.ennemi = ennemi);
  }
 
  goBack(): void {
    this.location.back();
  }
 
 save(): void {
    this.ennemiService.updateEnnemi(this.ennemi)
      .subscribe(() => this.goBack());
  }
}

