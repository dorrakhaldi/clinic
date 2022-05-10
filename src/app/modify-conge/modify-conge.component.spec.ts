import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyCongeComponent } from './modify-conge.component';

describe('ModifyCongeComponent', () => {
  let component: ModifyCongeComponent;
  let fixture: ComponentFixture<ModifyCongeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifyCongeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyCongeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
