import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
 
import { DashboardComponent }   from './dashboard/dashboard.component';
import { ComptesComponent }      from './comptes/comptes.component';
import { CompteDetailComponent }  from './compte-detail/compte-detail.component';
import { PersonnagesComponent }      from './personnages/personnages.component';
import { PersonnageDetailComponent }  from './personnage-detail/personnage-detail.component';
import { EnnemisComponent }      from './ennemis/ennemis.component';
import { EnnemiDetailComponent }  from './ennemi-detail/ennemi-detail.component';
import { EquipementsComponent }      from './equipements/equipements.component';
import { EquipementDetailComponent }  from './equipement-detail/equipement-detail.component';
import { QuetesComponent }      from './quetes/quetes.component';
import { QueteDetailComponent }  from './quete-detail/quete-detail.component';


const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'detail/:idCompte', component: CompteDetailComponent },
  { path: 'comptes', component: ComptesComponent },
  { path: 'detail/:idPersonnage', component: PersonnageDetailComponent },
  { path: 'personnages', component: PersonnagesComponent },
  { path: 'detail/:idEnnemi', component: EnnemiDetailComponent },
  { path: 'ennemis', component: EnnemisComponent },
  { path: 'detail/:idEquipement', component: EquipementDetailComponent },
  { path: 'equipements', component: EquipementsComponent },
  { path: 'detail/:idQuete', component: QueteDetailComponent },
  { path: 'quetes', component: QuetesComponent }
];
 
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
