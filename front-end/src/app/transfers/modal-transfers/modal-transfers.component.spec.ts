import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalTransfersComponent } from './modal-transfers.component';

describe('ModalTransfersComponent', () => {
  let component: ModalTransfersComponent;
  let fixture: ComponentFixture<ModalTransfersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModalTransfersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalTransfersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
