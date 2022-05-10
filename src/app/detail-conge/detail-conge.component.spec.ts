import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailCongeComponent } from './detail-conge.component';

describe('DetailCongeComponent', () => {
  let component: DetailCongeComponent;
  let fixture: ComponentFixture<DetailCongeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailCongeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailCongeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
