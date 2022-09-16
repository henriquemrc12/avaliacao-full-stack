import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccountComponent } from './account.component';

import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';

import { MatPaginatorModule } from '@angular/material/paginator';
import { MatIconModule } from '@angular/material/icon';
import { AccountService } from './account.service';

import { MatButtonModule } from '@angular/material/button';

@NgModule({
  declarations: [
    AccountComponent
  ],
  imports: [
    CommonModule,
    MatCardModule,
    MatTableModule,
    MatPaginatorModule,
    MatIconModule,
    MatButtonModule,
  ],
  providers: [
    AccountService
  ]
})
export class AccountModule { }
