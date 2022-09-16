import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { GeneralModalComponent } from '../general-modal/general-modal.component';
import { ModalTransfersComponent } from './modal-transfers/modal-transfers.component';
import { TransfersService } from './transfers.service';

@Component({
  selector: 'app-transfers',
  templateUrl: './transfers.component.html',
  styleUrls: ['./transfers.component.css']
})
export class TransfersComponent implements OnInit {

  hasContent: boolean = false;
  isLoaded: boolean = false;
  
  displayedColumns: string[] = ['origin', 'destination', 'amount', 'amountFee', 'status', 'transferEffectiveDate', 'scheduleDate'];
  datasource!: MatTableDataSource<any>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private modal: MatDialog,
    private service: TransfersService
    ) { }

  ngOnInit(): void {
    this.getAllTransfers();
  }


  getAllTransfers(): void {

    this.hasContent = false;
    this.isLoaded = false;

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

  createTransfer(): void {
    const modal = this.modal.open(ModalTransfersComponent);
    modal.afterClosed().subscribe(()=> this.getAllTransfers());
  }
}
