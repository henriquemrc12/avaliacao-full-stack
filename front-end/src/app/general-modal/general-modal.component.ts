import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-general-modal',
  templateUrl: './general-modal.component.html',
  styleUrls: ['./general-modal.component.css']
})
export class GeneralModalComponent implements OnInit {

  type: string = "";
  error: any;
  title: string = "";
  constructor(
    public dialogRef: MatDialogRef<GeneralModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) { }

  ngOnInit(): void {
    this.type = this.data.type;
    this.error = this.data.error;
    this.title = this.data?.title;
  }

  close(state: any): void {
    if(this.type == 'delete' || this.type == 'cancel') {
      this.dialogRef.close({
        data: {
          answer: state
        }
      });

    } else {
      this.dialogRef.close();
    }
  }
}
