import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { GeneralModalComponent } from 'src/app/general-modal/general-modal.component';
import { TransfersService } from '../transfers.service';

@Component({
  selector: 'app-modal-transfers',
  templateUrl: './modal-transfers.component.html',
  styleUrls: ['./modal-transfers.component.css']
})
export class ModalTransfersComponent implements OnInit {

  form: FormGroup = this.fb.group({
    origin: [null, [Validators.required]],
    destination: [null, [Validators.required]],
    amount: [null, [Validators.required]],
    scheduleDate: [null, [Validators.required]]
  });

  minDate: Date = new Date;
  
  constructor(
    private fb: FormBuilder,
    private modalRef: MatDialogRef<ModalTransfersComponent>,
    private service: TransfersService,
    private modal: MatDialog
  ) { }

  ngOnInit(): void {
  }


  submit(): void {
    const loading = this.modal.open(GeneralModalComponent, {
      data: {
        type: "loading"
      },
      disableClose: true
    });
    
    let body = this.form.value;

    this.service.create(body).subscribe((data: any) => {
      loading.close();
      this.close();
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

  close(): void {
    this.modalRef.close();
  }
}
