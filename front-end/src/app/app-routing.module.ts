import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountComponent } from './account/account.component';
import { TransfersComponent } from './transfers/transfers.component';

const routes: Routes = [
  {
    component: TransfersComponent,
    path: ""
  },
  {
    component: AccountComponent,
    path: "account"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
