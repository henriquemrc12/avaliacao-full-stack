import { Component, OnInit, ViewChild } from '@angular/core';

import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { GeneralModalComponent } from '../general-modal/general-modal.component';
import { AccountService } from './account.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  hasContent: boolean = false;
  isLoaded: boolean = false;
  
  displayedColumns: string[] = ['number'];
  datasource!: MatTableDataSource<any>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private modal: MatDialog,
    private service: AccountService
  ) { }

  ngOnInit(): void {
    this.getAllAccounts();
  }

  getAllAccounts(): void {

    const loading = this.modal.open(GeneralModalComponent, {
      data: {
        type: "loading"
      },
      disableClose: true
    });
    
    this.service.findAll().subscribe((data: any) => {
      if (data && data.length > 0) {
        this.datasource = new MatTableDataSource(data);
        setTimeout(() => this.datasource.paginator = this.paginator);
        this.hasContent = true;
        this.isLoaded = true;
      }
      loading.close();
    }, (error: any) => {
      loading.close();
      this.modal.open(GeneralModalComponent, {
        data: {
          type: "error",
          error: error.error.messages[0]
        },
        disableClose: true
      });
    });
  }

  createAccount(): void {
    const loading = this.modal.open(GeneralModalComponent, {
      data: {
        type: "loading"
      },
      disableClose: true
    });
    
    this.service.create().subscribe((data: any) => {
      loading.close();
      this.getAllAccounts();
    }, (error: any) => {
      loading.close();
      this.modal.open(GeneralModalComponent, {
        data: {
          type: "error",
          error: error.error.messages[0]
        },
        disableClose: true
      });
    });
  }
}
