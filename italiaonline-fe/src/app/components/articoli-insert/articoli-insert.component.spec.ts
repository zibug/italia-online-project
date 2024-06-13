import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticoliInsertComponent } from './articoli-insert.component';

describe('ArticoliInsertComponent', () => {
  let component: ArticoliInsertComponent;
  let fixture: ComponentFixture<ArticoliInsertComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ArticoliInsertComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ArticoliInsertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
