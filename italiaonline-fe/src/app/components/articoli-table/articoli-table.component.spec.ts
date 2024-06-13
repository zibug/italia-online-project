import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticoliTableComponent } from './articoli-table.component';

describe('ArticoliTableComponent', () => {
  let component: ArticoliTableComponent;
  let fixture: ComponentFixture<ArticoliTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ArticoliTableComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ArticoliTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
